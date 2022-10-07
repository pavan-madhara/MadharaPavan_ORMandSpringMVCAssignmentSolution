<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<title>Add Customer</title>
</head>

<body>
	<div class="container">
		<h3>Customer Directory</h3>
		<hr>
		<p class="h4 mb-4">Save Customer</p>
		<form action="/CustomerRelationshipManagement/customer/save" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

		<p>FirstName:</p><div class="form-inline"><input type="text" name="firstname" value="${Customer.firstname}" class="form-control mb-4 col-4" placeholder="FirstName">

			</div>
			<p>LastName:</p><div class="form-inline"><input type="text" name="lastname" value="${Customer.lastname}" class="form-control mb-4 col-4" placeholder="Lastname">
			</div>

			<p>Email:</p><div class="form-inline"><input type="text" name="email" value="${Customer.email}" class="form-control mb-4 col-4" placeholder="Email">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>

		</form>

		<hr>

		<a href="/CustomerRelationshipManagement/customer/list">Back to list</a>

	</div>
</body>

</html>
