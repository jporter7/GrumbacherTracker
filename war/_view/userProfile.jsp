<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
		<title>Your Profile</title>
    </head>
    <body>
    	<h1>Your Reservations</h1>
    	
    	<table class="reserved" align="center">
    		<c:forEach items="${reservations}" varStatus="i">
    			<c:set var="time" value="${reservations[i.index].startTime}"/>
    					
    				<tr class="reservedTimes">
        				<td>${time}</td>
        				<c:if test="${i.index == 0}">
        					<td>${name0}</td> 
        				</c:if>
        				<c:if test="${i.index == 1}">
        					<td>${name1}</td>
        				</c:if>	
    				</tr>
			</c:forEach>
    	</table>
    
    
    
    
    
    
    
    </body>