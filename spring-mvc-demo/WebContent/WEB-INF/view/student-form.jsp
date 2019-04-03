<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student registration form</title>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName"/>
			<br>
			Last name: <form:input path="lastName"/>
			<br>
			Country:
			<form:select path="country">
				<form:options items="${student.countryOptions}"/>
			</form:select>
			<br>
			Favorite programming language:
			<br>
			Java <form:radiobutton path="favoriteProgrammingLangue" value="Java"/>
			C# <form:radiobutton path="favoriteProgrammingLangue" value="C#"/>
			PHP <form:radiobutton path="favoriteProgrammingLangue" value="PHP"/>
			Ruby <form:radiobutton path="favoriteProgrammingLangue" value="Ruby"/>
			<br>
			Operating system:
			Linux <form:checkbox path="operatingSystem" value="Linux"/>
			Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
			MS Windows <form:checkbox path="operatingSystem" value="MS WIndows"/>
			<br>
			<input type="submit" value="Click me!">
		</form:form>
	</body>
</html>