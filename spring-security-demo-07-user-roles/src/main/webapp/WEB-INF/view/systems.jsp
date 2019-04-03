<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>LEADERS Home Page</title>
</head>
<body>
	<h2>ADMIN Home Page</h2>
	<hr>
	<p>
		ADMIN CONTROLL PANEL
		<br>
		<br>
		Hello Master, <b><security:authentication property="principal.username"/></b>
		<div>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vitae metus vitae dolor consequat vestibulum. Curabitur scelerisque sapien ac leo laoreet, et blandit ligula efficitur.
		</div>
	</p>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>
</html>