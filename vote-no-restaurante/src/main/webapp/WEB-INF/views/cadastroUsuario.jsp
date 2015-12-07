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
<title>Receba promoções e novidades</title>

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
	<div align="center">
		<h1>Receba promoções e descontos do seu restaurante preferido.</h1>
		<form:form action="finalizarVotacao" method="POST">
		<input type="hidden" value=" ${idUsuario}" name="idUsuario">
			<table class="table table-hover table-condensed table-striped table-bordered" style="width: 500px">
				<tr>
					<td><form:label path="id">Email: </form:label></td>
					<td><form:input path="id" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email: </form:label></td>
					<td><form:input path="email" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="nome">Nome: </form:label></td>
					<td><form:input path="nome" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-primary">Enviar</button>
					</td>
				</tr>
			</table>
		</form:form>
		</div>
	</section>
	<script type="text/javascript"
		src="${path}/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
