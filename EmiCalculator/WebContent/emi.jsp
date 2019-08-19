<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.util.EMI"
    import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Calculator</title>
</head>
<body>
	<h1>EMI Per Month</h1>
	<% 
		ArrayList<EMI> data = (ArrayList)request.getAttribute("data");
		double emi = (double)request.getAttribute("emi");
	%>
	<table border="1">
		<tr>
			<th>Month</th>
			<th>Principal Amount</th>
			<th>EMI</th>
			<th>Interest Rate</th>
		</tr>
		<c:forEach items="${data}" var="list">
			<tr>
				<td>${list.getMonth()}</td>
				<td>${list.getAmount()}</td>
				<td>${emi}</td>
				<td>${list.getIntererstRate()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>