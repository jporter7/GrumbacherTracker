<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>YCP Grumbacher Tracker</title>
<style type = "text/css">
<link rel="stylesheet" type="text/css" href="Resume_CSS.css">
.error {
			color: red;
		}

</style>
</head>
<body>

<c:if test="${! empty errorMessage}">
	<div class="error">${errorMessage}</div>
</c:if>
    
<div>
    <h2>YCP Grumbacher Facility</h2> 
    
    <div>
   This is the login page
		
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table>
				<tr>
					<td class="label">Username: </td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password: </td>
					<td><input type="password" name="password" size="12" value="${password}" /></td>
				</tr>
			</table>
			<input type="Submit" name="index" value="Login">
			<input type="Submit" name="Create Account" value="Create Account">
		</form>
    </div>
</div>
 

</body>
</html>