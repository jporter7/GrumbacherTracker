<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="Resume_CSS.css">

     
</head>
<body>
    
<div>
    <h2>Ycp Grumbacher Facility</h2> 
    
    <div>
   This is the login page
		
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table>
				<tr>
					<td class="label">Name:</td>
					<td><input type="text" name="name" size="12" value="${model.first}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="12" value="${model.second}" /></td>
				</tr>
				<tr>
					<td>${model.result}</td>
				</tr>
			</table>
			<input type="Submit" name="index" value="login">
			<input type="Submit" name="Create Account" value="Create Account">
		</form>
    </div>
</div>
 

</body>
</html>