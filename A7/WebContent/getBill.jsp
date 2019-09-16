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
		String name = request.getParameter("cust_name");
		String phone = request.getParameter("cust_phone");
		String address = request.getParameter("cust_addr");
		
		String[] items = request.getParameterValues("food_item");
		
		int bill_amount = 0;
		
		for(int i = 0; i < items.length; i++) {
			if(items[i].equals("Pizza")) {
				bill_amount += 300;
			}
			else if(items[i].equals("Burger")) {
				bill_amount += 80;
			}
			else if(items[i].equals("Dosa")) {
				bill_amount += 90;
			}
			else if(items[i].equals("Paratha")) {
				bill_amount += 75;
			}
		}
		
		out.println("<h2>Dear " + name + ", your order has been placed successfully.</h2>");
		out.println("<h3>Billing amount is " + bill_amount + "</h3>");
	%>

</body>
</html>