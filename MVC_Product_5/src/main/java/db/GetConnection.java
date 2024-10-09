package db;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {
    public static Connection getConnection(ServletContext context) {
        Connection connection = null;
        Properties properties = new Properties();

        try {
            // Load properties file from servlet context
            String configFilePath = context.getInitParameter("configFilePath");
            try (InputStream input = context.getResourceAsStream(configFilePath)) {
                if (input == null) {
                    throw new IOException("Config file not found");
                }
                properties.load(input);
            }

            // Retrieve database connection info
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
