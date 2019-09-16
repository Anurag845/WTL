<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.*,java.io.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Processing</title>
</head>
<body>

	<%
		try {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Expires", "0");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anurag","root","dell");
		
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			PreparedStatement ps = conn.prepareStatement("select * from Users where username = ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				String pass = rs.getString(2);
				if(pass.equals(password)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				out.println("<h1>Login Successful</h1>");
				session.setAttribute("Username",name);
				out.println("Welcome " + session.getAttribute("Username"));
			}
			else {
				out.println("<h1>Login Unsuccessful</h1>");
				response.sendRedirect("login.html");
			}
			out.println("<form action='login.html'><input type='submit' value='Logout'></form>");
			session.invalidate();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		out.close();
	%>
	
	<form action="index.html"><input type="submit" value="Logout"></form>

</body>
</html>