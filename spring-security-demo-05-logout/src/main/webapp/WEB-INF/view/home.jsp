<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Company Home Page</title>
	</head>
	<body>
		<h2>Company home page</h2>
		<hr>
		<p>Welcome our home page</p>
		<!-- add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" 
					method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>