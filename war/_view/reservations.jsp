<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
		<title>Make A reservation</title>
    </head>

	<body>
        <h1>Reservation</h1>
		
		<form action="${pageContext.servletContext.contextPath}/reservations" method="post">
			<table align="center">
				<tr>
					<td>
                    <select id="reservations">
            		<option value="">Choose A Reservations</option>
            		<option value="830am">8:30am</option>
            		<option value="9am">9:00am</option>
            		<option value="930am">9:30am</option>
            		<option value="10am">10:00am</option>
            		<option value="1030am">10:30am</option>
            		<option value="11am">11:00am</option>
            		<option value="1130am">11:30am</option>
            		<option value="12pm">12:00pm</option>
            		<option value="1230pm">12:30pm</option>
        			</select>
        			</td>
				</tr>

					
				<tr><td><input type="Submit" name="make reservation" value="Make Reservation"></td></tr>
			</table>
		</form>
		
		<table>
		
		</table>
		
	</body>
</html>