<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%@page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Update</title>
</head>
<body>


	<div class="container mt-3">

		<h1 class="text-center">UPDATE TODO</h1>

		<c:if test="${not empty msg }">

			<div class="alert alert-success">
				<b> <c:out value="${msg }"></c:out>
				</b>

			</div>

		</c:if>
		<div class="row mt-4">

			<div class="col-md-2">


				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active">
						Menu</button>
					<a href='<c:url value='/add'></c:url>'
						class="list-group-item list-group-item-action">Add Todo</a> <a
						href='<c:url value='/'></c:url>'
						class="list-group-item list-group-item-action">View Todo</a>
				</div>

			</div>






			<h1 class="text-center">Update Todos</h1>

			<form action="${pageContext.request.contextPath }/updateTodo" method="POST" modelAttribute="todo">

				<div class="form-group">
					<input type="hidden" name="todoId" cssClass="form-control"
						placeholder="Enter your todo Id" value="${t.todoId }" />
				</div>

				<div class="form-group">
					<input name="todoTitle" cssClass="form-control"
						placeholder="Enter your todo title" value="${t.todoTitle }" />
				</div>


			

				<div class="form-group">
					<input name="todoContent" cssClass="form-control"
						placeholder="Enter your todo title" value="${t.todoContent}" />
				</div>


				<div class="container text-center">
					<button class="btn btn-outline-success">Update Todo</button>

				</div>
			</form>


		</div>
	</div>





	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>