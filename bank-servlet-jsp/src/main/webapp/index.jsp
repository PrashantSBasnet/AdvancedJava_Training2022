<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action"<%= request.getContextPath() %>/register" method = "post">

<table>
<tr>
<td>AccName</td>
<td><input type="text" name="acc_name"></td>
</tr>

<tr>
<td>AccNumber</td>
<td><input type="text" name="acc_number"></td>
</tr>

<tr>
<td>Balance</td>
<td><input type="number" name="balance"></td>
</tr>

<tr>
<td>Register</td>
<td><input type="submit" name="register"></td>

</table>
</form>

</body>
</html>