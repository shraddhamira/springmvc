<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="../../static/style/register.css">
<title>Expense Management - Register</title>
</head>
<body class="text-center1">
	<form class="form-signin" action="/register" method="post">
		<!-- <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72"
			height="72">-->
			
		<h1 class="h3 mb-3 col-sm-6 font-weight-normal mx-auto">Registration</h1>
		<div class="form-group row">
			<label for="userName" class="col-sm-6 sr-only col-form-label">User Name</label>
			<div class="col-sm-12">
				<input type="text" class="form-control" required autofocus name="userName" placeholder="Enter Username">
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-6 sr-only col-form-label">Password</label>
			<div class="col-sm-12">
				<input type="password" class="form-control" required name="password" placeholder="Enter Password">
			</div>
		</div>
		<div class="form-group row">
			<label for="confirmPassword" class="col-sm-6 sr-only col-form-label">Confirm Password</label>
			<div class="col-sm-12">
				<input type="password" class="form-control" required name="confirmPassword" placeholder="Retype Password">
			</div>
		</div>
		<div class="form-group row">
			<button class="btn btn-lg btn-primary btn-block col-sm-8 mx-auto" type="submit" >Register</button>
		</div>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>