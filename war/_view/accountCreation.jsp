<!DOCTYPE html>

<html>
	<head>
		<title>Create an Account</title>
		
	</head>

	<body>
		Create an Account
		
		<form action="${pageContext.servletContext.contextPath}/accountCreation" method="post">
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
					<td class="label">Email:</td>
					<td><input type="text" name="email" size="12" value="${model.third}" /></td>
				</tr>
				<tr>
					<input type="Submit" name="Create Account" value="Create Account!">
					<td>${model.result}</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>