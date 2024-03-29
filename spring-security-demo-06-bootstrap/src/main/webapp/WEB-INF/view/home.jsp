<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
			integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
			crossorigin="anonymous">
		
		
		<link rel="stylesheet"
			href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
			integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
			crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  <div class="container">
    <h1>Hello, world!</h1>
    
    
    <!-- add a logout button -->
    	<p>
		<form:form action="${pageContext.request.contextPath}/logout" 
					method="POST">
			<input type="submit" value="Logout" class="btn btn-outline-primary" />
		</form:form>
		</p>
		
		<div>
			<div class="alert alert-primary" role="alert">
			  A simple primary alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-secondary" role="alert">
			  A simple secondary alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-success" role="alert">
			  A simple success alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-danger" role="alert">
			  A simple danger alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-warning" role="alert">
			  A simple warning alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-info" role="alert">
			  A simple info alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-light" role="alert">
			  A simple light alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
			<div class="alert alert-dark" role="alert">
			  A simple dark alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
			</div>
		</div>
	</div>	
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

	
 </body>
</html>







