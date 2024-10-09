<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Result</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5">
		<div class="card shadow-lg">
			<div class="card-header bg-success text-white text-center">
				<h2>Action Result</h2>
			</div>
			<div class="card-body">
				<p class="alert alert-info">
					<%= request.getAttribute("resultMessage") %>
				</p>
				<div class="d-flex justify-content-between">
					<a href="Home.jsp" class="btn btn-primary">Go Back to Home</a> <a
						href="Product_Controller?show=true" class="btn btn-info">View
						Products</a>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
