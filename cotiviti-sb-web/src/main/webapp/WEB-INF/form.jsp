<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="/student-1" method="post">

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
		</form:form>
</body>
</html>