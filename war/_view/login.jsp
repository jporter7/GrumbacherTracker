<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>

	<title>YCP Grumbacher Tracker</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_css.css" />
	
</head>

<body>
    
<div>
    <h1 align="center">YCP Grumbacher Facility</h1> 
    
    <div>
		
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table align="center">
				<tr>
					<td class="label">Username: </td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password: </td>
					<td><input type="password" name="password" size="12" value="${password}" /></td>
				</tr>
				<tr>
					<td><input type="Submit" name="index" value="Login"></td>
					<td><input type="Submit" name="Create Account" value="Create Account"></td>
				</tr>
			</table>
		</form>
    </div>
</div>
 

</body>
</html>