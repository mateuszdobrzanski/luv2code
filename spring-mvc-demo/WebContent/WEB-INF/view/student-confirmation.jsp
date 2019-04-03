<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student confirmation</title>
	</head>
	
	<body>
		The student is confirmed: ${student.firstName } ${student.lastName }
		<br>
		Country: ${student.country }
		<br>
		Programming language: ${student.favoriteProgrammingLangue }
		<br>
		Operating systems: 
		<ul>
			<c:forEach var="i" items="${student.operatingSystem}">
				<li> ${i} </li>
			</c:forEach>
		</ul>
 	</body>
</html>