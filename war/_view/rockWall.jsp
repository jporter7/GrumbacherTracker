<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
		<title>Make A reservation</title>
    </head>

	<body>
        <h1>Rock Wall</h1>
		
		<form action="${pageContext.servletContext.contextPath}/rockWall" method="post">
			<label class="logout">
		  		<input id="logout" name="logout" type="submit" value="Log Out">
		  	</label>
		  	
			<table align="center">
				<tr>
					<td>
                    <select id="reservations" name="time">
            		<option value="">Choose A Reservation</option>
            		<option value="8:00am">8:00am</option>
            		<option value="8:30am">8:30am</option>
            		<option value="9:00am">9:00am</option>
            		<option value="9:30am">9:30am</option>
            		<option value="10:00am">10:00am</option>
            		<option value="10:30am">10:30am</option>
            		<option value="11:00am">11:00am</option>
            		<option value="11:30am">11:30am</option>
            		<option value="12:00pm">12:00pm</option>
            		<option value="12:30pm">12:30pm</option>
            		<option value="1:00pm">1:00pm</option>
            		<option value="1:30pm">1:30pm</option>
            		<option value="2:00pm">2:00pm</option>
            		<option value="2:30pm">2:30pm</option>
            		<option value="3:00pm">2:00pm</option>
            		<option value="3:30pm">3:30pm</option>
            		<option value="4:00pm">4:00pm</option>
            		<option value="4:30pm">4:30pm</option>
            		<option value="5:00pm">5:00pm</option>
            		<option value="5:30pm">5:30pm</option>
            		<option value="6:00pm">6:00pm</option>
            		<option value="6:30pm">6:30pm</option>
            		<option value="7:00pm">7:00pm</option>
            		<option value="7:30pm">7:30pm</option>
            		<option value="8:00pm">8:00pm</option>
            		<option value="8:30pm">8:30pm</option>
            		<option value="9:00pm">9:00pm</option>
            		<option value="9:30pm">9:30pm</option>
        			</select>
        			</td>
				</tr>

				<tr><td><input type="Submit" name="make reservation" value="Make Reservation"></td></tr>
				
				
				
			</table>
		</form>

		
		<table class="reserved" align="left">
				<tr>
					<th>Reserved Times</th>
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
        				<td>
        					<c:if test="${user.isFaculty}">
        						Faculty Member
        					</c:if>
        					<c:if test="${!user.isFaculty}">
        						Student
        					</c:if>
        				</td>
        				
    				</tr>
			</c:forEach>
				
		</table>
		
	</body>
</html>