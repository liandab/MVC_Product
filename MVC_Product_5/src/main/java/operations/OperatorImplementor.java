package operations;

import jakarta.servlet.ServletContext;
import model.Product_pojo;
import db.GetConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OperatorImplementor implements Operations {
    private Properties sqlProps = new Properties();
    private ServletContext context;  // Add this to hold the ServletContext

    public OperatorImplementor(ServletContext context) {
        this.context = context;  // Initialize ServletContext
        try {
            String sqlQueriesFilePath = context.getInitParameter("sqlQueriesFilePath");
            try (InputStream input = context.getResourceAsStream(sqlQueriesFilePath)) {
                if (input == null) {
                    throw new IOException("SQL Queries file not found");
                }
                sqlProps.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Product_pojo pojo) {
        try (PreparedStatement preparedStatement = GetConnection.getConnection(context)
                .prepareStatement(sqlProps.getProperty("insert.product"))) {
            preparedStatement.setInt(1, pojo.getPid());
            preparedStatement.setString(2, pojo.getPname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product_pojo pojo) {
        try (PreparedStatement preparedStatement = GetConnection.getConnection(context)
                .prepareStatement(sqlProps.getProperty("update.product"))) {
            preparedStatement.setString(1, pojo.getPname());
            preparedStatement.setInt(2, pojo.getPid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product_pojo pojo) {
        try (PreparedStatement preparedStatement = GetConnection.getConnection(context)
                .prepareStatement(sqlProps.getProperty("delete.product"))) {
            preparedStatement.setInt(1, pojo.getPid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product_pojo> show() {
        List<Product_pojo> list = new ArrayList<>();
        try (ResultSet resultSet = GetConnection.getConnection(context)
                .prepareStatement(sqlProps.getProperty("select.products")).executeQuery()) {
            while (resultSet.next()) {
                Product_pojo pojo = new Product_pojo();
                pojo.setPid(resultSet.getInt(1));
                pojo.setPname(resultSet.getString(2));
                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
