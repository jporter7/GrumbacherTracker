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
                    <select id="reservations" name="time">
            		<option value="">Choose A Reservations</option>
            		<option value="8:30am">8:30am</option>
            		<option value="9:00am">9:00am</option>
            		<option value="9:30am">9:30am</option>
            		<option value="10:00am">10:00am</option>
            		<option value="10:30am">10:30am</option>
            		<option value="11:00am">11:00am</option>
            		<option value="11:30am">11:30am</option>
            		<option value="12:00pm">12:00pm</option>
            		<option value="12:30pm">12:30pm</option>
        			</select>
        			</td>
				</tr>

				<tr><td><input type="Submit" name="make reservation" value="Make Reservation"></td></tr>
				
				
				
			</table>
		</form>

		
		<table class="reserved" align="left">
				<tr>
					<th>Reserved Time</th>
				</tr>
				
				<c:forEach items="${test.reservations}" var="reservation">
    				<tr class="reservedTimes">      
        				<td>${reservation.startTime}</td>
    				</tr>
				</c:forEach>
		</table>
		<table class="reserved" align="right">
			<tr>
				<th>Reserved By</th>
			</tr>
			
			<c:forEach items="${test.usersWithReservations}" var="user">
    				<tr class="reservedTimes">      
        				<td>${user.isFaculty}</td>
    				</tr>
			</c:forEach>
				
		</table>
		
	</body>
</html>