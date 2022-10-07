<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Customer Table</title>
</head>

<body>

	<div class="container">

		<div class="card text-center text-white bg-success mb-3">
         <div class="card-header">
         <h2>Customer Relationship Management</h2>
         </div>
        </div>
            
		<a href="/CustomerRelationshipManagement/customer/showFormForAdd"
			class="btn btn-outline-info btn-sm mb-3"> Add Customer </a>

		<table class="table table-info table-hover">
			<thead class="thead-light">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customer}" var="tempcustomer">
					<tr>
						<td><c:out value="${tempcustomer.firstname}" /></td>
						<td><c:out value="${tempcustomer.lastname}" /></td>
						<td><c:out value="${tempcustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationshipManagement/customer/showFormForUpdate?CustomerId=${tempcustomer.id}"
							class="btn btn-outline-success btn-sm">Update</a> <!-- Add "delete" button/link -->
							<a href="/CustomerRelationshipManagement/customer/delete?CustomerId=${tempcustomer.id}"
							class="btn btn-outline-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>





