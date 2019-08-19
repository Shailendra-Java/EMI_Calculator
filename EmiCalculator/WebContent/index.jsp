<%@page import="org.util.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Calculator</title>
</head>
<body>
	<h1>VHBC Bank</h1>
	<hr>

	<form action="CalculateEmi" method="post">
		<table>
			<tr>
				<td>Principal Amount</td>
				<td><input type="text" name="pAmount" /></td>
			</tr>
			<tr>
				<td>Months</td>
				<td><input type="text" name="month" /></td>
			</tr>
			<tr>
				<td>Loan Type</td>
				<td><select name="rate">
						<%
							try {
								Statement stmt = DBConnect.getConnection().createStatement();
								ResultSet rs = stmt.executeQuery("Select rate, loantype from loans");
								while (rs.next()) {
						%>
						<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
						<%
							}
							} catch (Exception exp) {
							}
						%>
				</select></td>
			</tr>
			<tr colspan="2">
				<td><input type="submit" value="Calculate EMI"></td>
			</tr>
		</table>
	</form>
</body>
</html>