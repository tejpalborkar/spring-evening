<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<form action="" method="POST">
		<table width="50%" bgcolor="cyan" align="center">

			<tr>
				<td colspan=2><center>
						<font size=4><b>Welcome to Xcaliber</b></font>
						<h5>Total Amount</h5>
					</center></td>
			</tr>

			<tr>
				<td>Total Amount:</td>
				<td><input type="text" size=25 name="userName"></td>
			</tr>


			<tr align="center">
				<td>
					<h4>Payment Mode</h4> <input type="radio">Credit Card <br>
					<br> <input type="radio">Debit Card <br> <br>

					<input type="radio">Cash On Delivery <br> <br>

				</td>
			</tr>


			<tr>
				<td><a href="menu.jsp">Reset</a></td>
				<td><a href="thanks.jsp">proceed for payment</a></td>
			</tr>
		</table>
	</form>
</body>
</html>