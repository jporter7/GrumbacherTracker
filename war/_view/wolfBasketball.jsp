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
		
		<form action="${pageContext.servletContext.contextPath}/grumbacher" method="post">
			<table>
				<tr>
                    <td><textarea name="text" cols="25" rows="5"> Calendar Data filled throughout here</textarea></td>
				</tr>

					

			</table>
            <input type="Submit" name="make reservation" value="Make Reservation">
		</form>
		
	</body>
</html>