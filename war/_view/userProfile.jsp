<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
		<title>Your Profile</title>
    </head>
    <body>
    	<table align="center">
    		<c:forEach items="${reservations}" varStatus="i">
    			<c:set var="time" value="${reservations[i.index].startTime}"/>
    				<tr class="reservedTimes">      
        				<td>${time}</td>
        				<td>${name0}</td>
    				</tr>
			</c:forEach>
    	</table>
    
    
    
    
    
    
    
    </body>