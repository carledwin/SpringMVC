<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Qual restaurante você mais gosta?</title>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<section class="container">
		<h1>Qual é o seu restaurante preferido?</h1>
		<form:form action="" method="POST">
			<table
				class="table table-hover table-condensed table-striped table-bordered">
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-primary">
							Restaurante 1</button> <br /> <br />
						<button type="submit" class="btn btn-primary">
							Restaurante 2</button>
					</td>
				</tr>
			</table>
		</form:form>
	</section>
	<script type="text/javascript"
		src="${path}/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
