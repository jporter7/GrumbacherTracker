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
					<td class="label">Username: </td>
					<td><input type="text" name="username" size="12" value="${user.userName}" /></td>
				</tr>
				<tr>
					<td class="label">First Name: </td>
					<td><input type="text" name="firstName" size="12" value="${user.firstName}" /></td>
				</tr>
				<tr>
					<td class="label">Last Name: </td>
					<td><input type="text" name="lastName" size="12" value="${user.lastName}" /></td>
				</tr>
				<tr>
					<td class="label">Password: </td>
					<td><input type="password" name="password" size="12" value="${user.password}" /></td>
				</tr>
				<tr>
					<td class="label">Email: </td>
					<td><input type="text" name="email" size="12" value="${user.email}" /></td>
				</tr>
				<tr>
					<td class="label">I.D. Number: </td>
					<td><input type="text" name="id" size="12" value="${user.id}" /></td>
				</tr>
			</table>
			<tr>
					<input type="Submit" name="Create Account" value="Create Account!">
			</tr>
		</form>
		
	</body>
</html>