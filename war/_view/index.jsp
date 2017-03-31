<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		Index Page
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input type="Submit" name="Grumbacher" value="Grumbacher">
			<input type="Submit" name="WeightRoom" value="Weight Room">
			<input type="Submit" name="RacquetBall" value="Racquet Ball">
			<input type="Submit" name="Reservations" value="Make Reservation">
		</form>
		
	</body>
</html>
