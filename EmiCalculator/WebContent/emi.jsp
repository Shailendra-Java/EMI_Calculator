<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="org.util.EMI"
	import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Calculator</title>
</head>
<body>
	<h1>EMI Per Month</h1>
	<%
		ArrayList<EMI> data = (ArrayList) request.getAttribute("data");
		EMI emi = (EMI) request.getAttribute("totalPlan");
	%>
	<table>
		<tr>
			<td>Principal Amount</td>
			<td>Rs. <%=emi.getAmount() %></td>
		</tr>
		<tr>
			<td>Rate of Interest</td>
			<td><%= emi.getIntererstRate()%>%</td>
		</tr>
		<tr>
			<td>Total Months</td>
			<td><%=emi.getNoOfMonths() %></td>
		</tr>
		<tr>
			<td>Total Interest</td>
			<td>Rs. <%=emi.getTotalInterest() %></td>
		</tr>
		<tr>
			<td>Total Amount</td>
			<td>Rs <%=emi.getTotalAmount() %></td>
		</tr>
	</table>
	<table border="1">
		<tr>
			<th>Month</th>
			<th>Interest/Month</th>
			<th>Principal/Month</th>
			<th>EMI</th>
			<th>Balance Principal</th>
		</tr>
		<c:forEach items="${data}" var="list">
			<tr>
				<td>${list.getMonth()}</td>
				<td>${list.getInterestPerMonth()}</td>
				<td>${list.getPrincipalPerMonth()}</td>
				<td>${list.getEmi()}</td>
				<td>${list.getBalancePrincipal()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>