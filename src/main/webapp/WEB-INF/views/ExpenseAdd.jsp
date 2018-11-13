<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="../../static/style/form.css">
<title>Expense Management - Add New Expense</title>
</head>
<body class="text-center1">
	<form class="form-add" action="/addExpense.htm" method="post">
		<!-- <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72"
			height="72">-->

		<h1 class="h3 mb-3 col-sm-6 font-weight-normal mx-auto">Add Expense</h1>
		<div class="form-group row">
			<label for="description" class="col-sm-6 sr-only col-form-label">Description</label>
			<div class="col-sm-12">
				<input type="text" class="form-control" required autofocus name="description" placeholder="Enter Description">
			</div>
		</div>
		<div class="form-group row">
			<label for="amount" class="col-sm-6 sr-only col-form-label">Amount</label>
			<div class="col-sm-12">
				<input type="text" class="form-control" required name="amount" placeholder="Enter Amount">
			</div>
		</div>
		<div class="form-group row">
			<label for="date" class="col-sm-6 sr-only col-form-label">On Date</label>
			<div class="col-sm-12">
				<input type="date" class="form-control" required name="createDate" placeholder="On Date">
			</div>
		</div>
		<div class="form-group row">
			<label for="subCategoryId" class="col-sm-6 sr-only col-form-label">Category</label>
			<div class="col-sm-12">
				<select class="form-control" name="subCategoryId">
					<option value="">Select Category</option>
					<c:forEach items="${subCategoryList}" var="subCategory">
						<option value="${subCategory.id}"><c:out value="${subCategory.description}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<button class="btn btn-lg btn-primary col-lg-5" type="submit" onclick="submitForm('add')">Add</button>
			<span class="my-auto"></span>
			<button class="btn btn-lg btn-secondary col-lg-5" type="submit" onclick="submitForm('cancel')">Cancel</button>
		</div>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function submitForm(type){
			if(type==='add'){
				$('.form-add').attr('method','POST');
				$('.form-add').attr('action','/addExpense.htm');
			}else if(type==='cancel'){
				$('input[text]').removeAttr('required');
				$('.form-add').attr('method','GET');
				$('.form-add').attr('action','/home.htm');
			}
		}
	</script>
</body>
</html>