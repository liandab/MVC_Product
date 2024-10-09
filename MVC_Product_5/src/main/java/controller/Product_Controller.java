package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product_pojo;
import operations.OperatorImplementor;

import java.io.IOException;
import java.util.List;

@WebServlet("/Product_Controller")
public class Product_Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String insertAction = request.getParameter("insert");
        String updateAction = request.getParameter("update");
        String deleteAction = request.getParameter("delete");
           String showAction = request.getParameter("show");

        // Pass ServletContext to OperatorImplementor
        OperatorImplementor operator = new OperatorImplementor(getServletContext());

        Product_pojo pojo = new Product_pojo();
        String resultMessage = "";  // Variable to store result messages

        // Insert action
        if (insertAction != null) {
            pojo.setPid(Integer.parseInt(request.getParameter("pid")));
            pojo.setPname(request.getParameter("pname"));

            operator.save(pojo);
            resultMessage = "Product inserted successfully.";
        } 
        // Update action
        else if (updateAction != null) {
            pojo.setPid(Integer.parseInt(request.getParameter("pid")));
            pojo.setPname(request.getParameter("pname"));

            operator.update(pojo);
            resultMessage = "Product updated successfully.";
        } 
        // Delete action
        else if (deleteAction != null) {
            pojo.setPid(Integer.parseInt(request.getParameter("pid")));

            operator.delete(pojo);
            resultMessage = "Product deleted successfully.";
        } 
        // Show action
        else if (showAction != null) {
            List<Product_pojo> productList = operator.show();
            request.setAttribute("productList", productList);

            // Forward to showProducts.jsp to display the list of products
            request.getRequestDispatcher("showProducts.jsp").forward(request, response);
            return;  // Exit after forwarding
        }

        // Set the result message and forward to result.jsp
        request.setAttribute("resultMessage", resultMessage);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
