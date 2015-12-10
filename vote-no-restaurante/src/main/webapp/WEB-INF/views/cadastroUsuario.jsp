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
		<br />
		<div class="jumbotron" style="background-color: #FEFEFE; width:980px;">
			<div class="container">
				<h2 align="center">Receba promoções e descontos dos restaurantes escolhidos!</h2>
				<form action="finalizarVotacao" method="POST" data-toggle="validator" role="form">
					<div class="form-group">
						<input type="hidden" value="${idUsuario}" name="idUsuario">
						<label for="nome" class="control-label">Nome </label> 
						<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo" required style="width:500px;">
					</div>

					<div class="form-group">
						<label for="email" class="control-label">Email </label> <input
							type="email" class="form-control" id="email" name="email" placeholder="Email válido" data-error="Bruh, that email address is invalid" required style="width:400px;">
						<div class="help-block with-errors"></div>
					</div>
					<div class="form-group" align="center">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</form>
			</div>
		</div>

	</section>
	<script type="text/javascript"
		src="${path}/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
