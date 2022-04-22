<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>

		<li><p>
				<b>AccName:</b>
				<%=request.getParameter("acc_name")%>
			</p></li>
		<li><p>
				<b>AccNumber:</b>
				<%=request.getParameter("acc_number")%>
			</p></li>
		<li><p>
				<b>Balance:</b>
				<%=request.getParameter("balance")%>
			</p></li>
	</ul>

</body>
</html>