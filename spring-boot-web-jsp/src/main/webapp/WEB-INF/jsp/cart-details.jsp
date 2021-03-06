<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Create an account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h3 align="right">
				Welcome ${pageContext.request.userPrincipal.name} | <a
					onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h3>

		</c:if>

<h3 align="center">Cart Items</h3>

		<form:form method="GET" modelAttribute="menuForm" action="checkout">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table align="center" border="" style="width:200px">
				<tr>
					<th>Sr No.</th>
					<th>Item Name</th>
					<th>Quantity</th>
					<th>Item price</th>
				</tr>
				<c:forEach var="item" items="${cart.items}">
					<tr>
						<td>${item.itemId}</td>
						<td>${item.itemName}</td>
						<td>1</td>
						<td align="center">${item.price}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" align="right">Total </td>
					<td  align="center">${total}</td>
				</tr>
				<tr>
					<td colspan="4" align="right"><input type="submit" value="Checkout"> </input> </a></td>
				</tr>
			</table>
		</form:form>
	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
