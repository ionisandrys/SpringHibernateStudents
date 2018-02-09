<% response.sendRedirect("students/list"); %>

<!-- In web.xml, we have some welcome files. 
	Server will look for these files, top-down, and will
	execute what it will find first. In web.xml, first file is
	index.jsp. So, we create a JSP file called index.jsp,
	in which we redirect to students/list, described in CustomerController  -->