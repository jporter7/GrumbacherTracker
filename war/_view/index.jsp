<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

	<head>
		<title>GSFC Populations</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
	</head>
	
	<body>
		<h1>Populations</h1>
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<table align="center">
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
				
				<tr>
					<td><input type="Submit" name="Pool" value="Pool"></td>
					<td>${model.pool}</td>
				</tr>
				
				<tr>
					<td><input type="Submit" name="FieldHouse" value="Field House"></td>
					<td>${model.fieldHouse}</td>
				</tr>
				
				<tr>
					<td><input type="Submit" name="WolfBasketball" value="Wolf Basketball"></td>
					<td>${model.wolfBasketball}</td>
				</tr>
				
				<tr>
					<td><input type="Submit" name="RockWall" value="Rock Wall"></td>
					<td>${model.rockWall}</td>
				</tr>
				
				<tr>
					<td><input type="Submit" name="DanceRoom" value="Dance Room"></td>
					<td>${model.danceRoom}</td>
				</tr>
			</table>
			
		</form>
		
	</body>
</html>
