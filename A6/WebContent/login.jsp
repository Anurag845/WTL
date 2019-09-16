<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0);
		String user = request.getParameter("username");
		if(user == null)
			response.sendRedirect("login.html");
		session.setAttribute("user", user);
	%>
	<h1><%=session.getAttribute("user")%></h1>
	<form action="login.html">
		<input type="submit" value="Logout">
	</form>
</body>
</html>