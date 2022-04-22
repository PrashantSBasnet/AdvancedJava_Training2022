<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
		</tr>

		<c:forEach items="${list}" var="item">    <!-- list is model and we bind it here to iterate and display data -->
			<tr>
				<td>${item.name}</td>
				<td>${item.address}</td>
				<td>${item.email}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>