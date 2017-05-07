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
    
    <div>
		<table align="center" id="hoursTable">
		  <tr id="hoursRow">
		    <th>Company</th>
		    <th>Contact</th>
		    <th>Hours of Operation</th>
		  </tr>
		  <tr id="hoursRow">
		    <td>Business Office</td>
		    <td>businessoffice@ycp.edu
		    <br>717-815-1470</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Campus Safety</td>
		    <td>campussafety@ycp.edu
		    <br>717-815-1403</td>
		    <td>8am-5pm M-F (During Semester)</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Grumbacher Sports and Fitness Center</td>
		    <td>717-815-6600</td>
		    <td>6am-11pm M-TR
		    <br>6am-9pm F
		    <br>9am-9pm Sat
		    <br>9am-11pm Sun</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Academic Advising</td>
		    <td>academicadvising@ycp.edu
		    <br>717-815-1531</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Academic Support Center</td>
		    <td>bzmolek@ycp.edu
		    <br>717-815-6598</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>YCP Bookstore</td>
		    <td>bookstore@ycp.edu
		    <br>717-849-1699</td>
		    <td>8am-4:30pm M-TR
		    <br>8am-11am F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Career Development Center</td>
		    <td>careerdevelopment@ycp.edu
		    <br>717-815-1452</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Counseling Services</td>
		    <td>717-815-6437</td>
		    <td>8am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Facility Services</td>
		    <td>facilityservices@ycp.edu
		    <br>717-815-2213</td>
		    <td>7:30am-4pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Financial Aid</td>
		    <td>financialaid@ycp.edu
		    <br>717-815-1226</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Health Services</td>
		    <td>healthcenter@ycp.edu
		    <br>717-849-1615</td>
		    <td>8:30am-4:30pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Human Resources</td>
		    <td>employment@ycp.edu
		    <br>717-815-1320</td>
		    <td>8am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Schmidt Library</td>
		    <td>infoservices@ycp.edu
		    <br>717-815-1304</td>
		    <td>8am-2am M-TR
		    <br>8am-8pm F
		    <br>10am-6pm Sat
		    <br>12pm-2am Sun</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>IT Help Desk</td>
		    <td>ithelp@ycp.edu
		    <br>717-815-1559</td>
		    <td>7:30am-10pm M-TR
		    <br>7:30am-6pm F
		    <br>8am-1pm Sat
		    <br>5pm-9pm Sun</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Records</td>
		    <td>records@ycp.edu
		    <br>717-815-1233</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Business Office</td>
		    <td>businessoffice@ycp.edu
		    <br>717-815-1470</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Registrar</td>
		    <td>registar@ycp.edu
		    <br>717-815-1273</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Residence Life</td>
		    <td>residencelife@ycp.edu
		    <br>717-815-1281</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Spiritual Life</td>
		    <td>lworley@ycp.edu
		    <br>717-815-1446</td>
		    <td>8am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Student Accessibility Services</td>
		    <td>lmille18@ycp.edu
		    <br>717-815-1785</td>
		    <td>8:30am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Student Activites</td>
		    <td>sgoodwi@ycp.edu
		    <br>717-815-1239</td>
		    <td>8am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Student Affairs</td>
		    <td>jmerkle@ycp.edu
		    <br>717-815-1460</td>
		    <td>8am-5pm M-F</td>
		  </tr>
		  <tr id="hoursRow">
		    <td>Writing Center</td>
		    <td>jfollett@ycp.edu
		    <br>717-815-1470</td>
		    <td>9am-9pm M-TR
		    <br>9am-4pm F</td>
		  </tr>
		
		</table>
    
    </div>
</div>
 

</body>
</html>