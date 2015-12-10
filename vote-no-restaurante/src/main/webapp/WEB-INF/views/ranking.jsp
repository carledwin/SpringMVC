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
<title>Ranking</title>

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
		<div class="jumbotron" style="background-color: #FEFEFE">
			<div class="container">
				<h2 align="center">${titulo}</h2>

				<form:form action="/vote-no-restaurante" method="GET">

					<table
						class="table table-hover table-condensed table-striped table-bordered">
						<thead>
							<tr>
								<td
									style="text-weight: bold; font-size: 20px; text-align: center">Restaurante</td>
								<td
									style="text-weight: bold; font-size: 20px; text-align: center">Score</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${todosRestaurantes}" var="restaurante">
								<tr>
									<td style="text-align: center"><img
										src="${path}/resources/imgs/${restaurante.logo}" height="50"
										width="100" class="img-circle" /></td>
									<td
										style="text-weight: bold; font-size: 30px; text-align: center">${restaurante.score}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="3">Total: ${todosRestaurantes.size()}</td>
							</tr>
						</tfoot>
					</table>
					<button type="submit" class="btn btn-large btn-primary ">Inicio</button>
				</form:form>
			</div>
		</div>

		<c:if test="${usuario != null}">
			<div class="jumbotron" style="background-color: #FEFEFE">
				<div class="container">
					<h2 align="center">${usuario.nome}, você votou nos
						restaurantes abaixo:</h2>

					<table
						class="table table-hover table-condensed table-striped table-bordered">
						<thead>
							<tr>
								<td
									style="text-weight: bold; font-size: 20px; text-align: center">Restaurante
									Preferido</td>
								<td
									style="text-weight: bold; font-size: 20px; text-align: center">Score</td>
								<td
									style="text-weight: bold; font-size: 20px; text-align: center">Outro
									Restaurante</td>
								<td
									style="text-weight: bold; font-size: 20px; text-align: center">Score</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="text-align: center"><img
									src="${path}/resources/imgs/${restaurantePreferido.logo}"
									height="50" width="100" class="img-circle" /></td>
								<td
									style="text-weight: bold; font-size: 30px; text-align: center">${usuario.preferidoScore}</td>
								<td style="text-align: center"><img
									src="${path}/resources/imgs/${outroRestaurante.logo}"
									height="50" width="100" class="img-circle" /></td>
								<td
									style="text-weight: bold; font-size: 30px; text-align: center">${usuario.outroScore}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</section>

	<script type="text/javascript"
		src="${path}/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
