<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Save the students!</title>


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-students-style.css">

</head>


<body>
	<div id="wrapper">
	
	<div id="header">
		<h2 align="center">Caltech Students - Physics department</h2>
	</div>
	
	</div>
	
	<div id="container">
	
		<h3>Save student</h3>
		<img src="${pageContext.request.contextPath}/resources/images/caltech5.PNG" width="150" height="110">
	<img src="${pageContext.request.contextPath}/resources/images/caltech6.jpg" width="150" height="110">
	<img src="${pageContext.request.contextPath}/resources/images/caltech7.jpg" width="150" height="110">
	
	<form:form action = "saveStudents" modelAttribute="students" method="POST">
					<!-- prepopulate fields using modelAttribute calling getter methods -->
	
		<!--  associate this data with customer id. When we hit submit button after update,
		it;s like student.setId, we don't want to loose the id of the original student -->
		
		<form:hidden path="id"/>
	<table>
		<tbody>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName"/></td> <!-- prepopulate fields -->
				</tr>
				
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName"/></td>  <!-- prepopulate fields -->
				</tr>
				
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>  <!-- prepopulate fields -->
				</tr>
		
			<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
		
		
		
		
		</tbody>
	</table>
	
	</form:form>
	
	<div style = "clear; both;"></div>
	
	<p>
		<a href = "${pageContext.request.contextPath}/students/list">Back to list</a>
	</p>
	
	</div>
	






</body>
</html>