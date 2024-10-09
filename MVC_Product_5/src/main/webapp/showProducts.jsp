<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="model.Product_pojo"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>Products List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5">
		<div class="card shadow-lg">
			<div class="card-header bg-info text-white text-center">
				<h2>Product List</h2>
			</div>
			<div class="card-body">
				<table class="table table-hover table-striped">
					<thead class="table-dark">
						<tr>
							<th>Product ID</th>
							<th>Product Name</th>
						</tr>
					</thead>
					<tbody>
						<%
                            List<Product_pojo> productList = (List<Product_pojo>) request.getAttribute("productList");
                            if (productList != null && !productList.isEmpty()) {
                                for (Product_pojo product : productList) {
                        %>
						<tr>
							<td><%= product.getPid() %></td>
							<td><%= product.getPname() %></td>
						</tr>
						<%
                                }
                            } else {
                        %>
						<tr>
							<td colspan="2" class="text-center">No products available</td>
						</tr>
						<%
                            }
                        %>
					</tbody>
				</table>
			</div>
			<div class="card-footer text-center">
				<a href="Home.jsp" class="btn btn-primary">Back to Home</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
