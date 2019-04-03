<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<title>Company Home Page</title>
	</head>
	<body>
		<h2>Company home page</h2>
		<hr>
		<p>Welcome our home page</p>
		
		<hr>
		<!-- Display username and role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			<!-- authorities = user roles -->
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		
		<hr>
		
		<!-- Add a link to point to /leaders.. this is for the managers -->
		<!-- Show content ONLY for managers -->
		<security:authorize access="hasRole('MANAGER')">
			<p>
				<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
				(Only for manager peeps)
			</p>
		</security:authorize>
		
		<!-- Add a link to point to /systems.. this is for the admins -->
		<!-- Show content ONLY for admins -->
		<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin Controll Panel</a>
			(Only for Admins peeps)
		</p>
		</security:authorize>
		<hr>
		
		<!-- add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" 
					method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>