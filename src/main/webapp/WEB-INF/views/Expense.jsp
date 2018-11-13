<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Todo - Expenses</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<style>
.list {
	width: 100%;
	padding: 10px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<hr>
	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active" href="#">Filter</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="#">Reset</a></li>
		<li class="nav-item"><a class="nav-link" href="/addExpense.htm">Add</a></li>
	</ul>
	<hr>
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive list">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Description</th>
								<th>Amount</th>
								<th>On Date</th>
								<th>Category</th>
								<th>User</th>
								<th>Actions</th>
							</tr>
						</thead>
						<c:forEach items="${list}" var="detail">
							<tr>
								<td>${detail.description}</td>
								<td>${detail.amount}</td>
								<td>${detail.createDate}</td>
								<td><c:forEach items="${subCategoryList}" var="subCategory">
										<c:if test="${subCategory.id eq detail.subCategoryId}">
											<c:out value="${subCategory.description}"></c:out>
										</c:if>
									</c:forEach></td>
								<td>${detail.userId}</td>
								<td><a class="link" href="/editExpense.htm">Edit</a><a class="link" href="/deleteExpense.htm">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>