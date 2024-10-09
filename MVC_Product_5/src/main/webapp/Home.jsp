<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home - Product Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="card shadow-lg">
					<div class="card-header text-center bg-primary text-white">
						<h3>Manage Products</h3>
					</div>
					<div class="card-body">
						<form method="post" action="Product_Controller">
							<div class="mb-3">
								<label for="pid" class="form-label">Product ID</label> <input
									type="text" class="form-control" id="pid" name="pid"
									placeholder="Enter Product ID">
							</div>
							<div class="mb-3">
								<label for="pname" class="form-label">Product Name</label> <input
									type="text" class="form-control" id="pname" name="pname"
									placeholder="Enter Product Name">
							</div>
							<!-- Buttons in the same row -->
							<div class="d-flex justify-content-between">
								<button type="submit" name="insert" class="btn btn-success me-2">Insert</button>
								<button type="submit" name="update" class="btn btn-warning me-2">Update</button>
								<button type="submit" name="delete" class="btn btn-danger me-2">Delete</button>
								<button type="submit" name="show" class="btn btn-info">Show</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
