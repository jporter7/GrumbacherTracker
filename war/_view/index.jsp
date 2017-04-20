<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

	<head>
		<title>Index view</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
	</head>
	
	<body>
		<h1>Index Page</h1>
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<table>
				<tr>
					<td><input type="Submit" name="Grumbacher" value="Grumbacher"></td>
					<td>${model.popTotal}</td>
				</tr>
				
				<tr>
					<td><input type="Submit" name="WeightRoom" value="Weight Room"></td>
					<td>${model.weightRoom}</td>
				</tr>
				
				<tr>
					<td><input type="Submit" name="RacquetBall" value="Racquet Ball"></td>
					<td>${model.racquet}</td>
				</tr>
			</table>
			
		</form>
		
	</body>
</html>
