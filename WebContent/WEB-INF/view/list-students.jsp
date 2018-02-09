<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head><title>List students</title></head>

<!--  add css files -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css"/>

<body>

<div id="wrapper">
	<div id="header">
	
	<h2 align="center">Caltech Physics Department</h2>
	
 </div>
 <img src="${pageContext.request.contextPath}/resources/images/caltech.png" width="220" height="130">
	<img src="${pageContext.request.contextPath}/resources/images/caltech2.jpg" width="220" height="130">
	<img src="${pageContext.request.contextPath}/resources/images/calt.jpg" width="220" height="130">
</div>

<div id="container">

	<div id="content">
	
	<!-- put new Add button here -->
	<input type = "button" value="Add Student"
			onclick = "window.location.href='showFormForAdd'; return false;"
			class="add-button"/>
	 <img src="${pageContext.request.contextPath}/resources/images/add.PNG" width="100" height="50">
	
			
	<!-- 'showFormForAdd' calls Spring controller mapping and "add-button" is the css style file -->
	
	<!--  add a search box -->
            <form:form action="search" method="POST">
                <p><font color="red">Search student:</font> <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
                <img src="${pageContext.request.contextPath}/resources/images/search.PNG" width="80" height="20">
                <img src="${pageContext.request.contextPath}/resources/images/search2.jpg" width="140" height="30"></p>
            </form:form>
	
	
	
	<!--  add html table -->
	
		<table>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
				<th>Action</th>
			<tr>
			<!--  loop over and print students -->
			
		<c:forEach var="tempStudent" items ="${students }">
		
		<!--  construct an update link with student id -->
		<c:url var = "updateLink" value ="/students/showFormForUpdate">
		
		<c:param name="studentId" value = "${tempStudent.id }"/>
		</c:url>
		
		<!--  construct a delete link with student id -->
		<c:url var = "deleteLink" value ="/students/delete">
		
		<c:param name="studentsId" value = "${tempStudent.id }"/>
		</c:url>
		
		
			<tr>
				<td>${tempStudent.firstName }</td>
				<td>${tempStudent.lastName }</td>
				<td>${tempStudent.email }</td>
				
				<td>
				    <a href = "${updateLink }">Update</a>
				    ||
				   <a href="${deleteLink }"
				   onclick="if (!(confirm('Are you sure?')))return false">Delete</a>
				</td>
				
			</tr>
		
		</c:forEach>
		
		</table>
		
			</div>


</div>

</body>

</html>