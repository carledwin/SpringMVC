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
	<br />
		<h1>Qual outro restaurante que você também gosta?</h1>
		<br />
		<br />
		<form:form action="outros" method="POST">
			<table
				class="table table-hover table-condensed table-striped table-bordered">
				<tr>
					<td align="center">
						<img src="${path}/resources/imgs/${restauranteNaoSelecionado.logo}" height="200" width="250" class="img-thumbnail">
						<input type="radio"	name="restaurante" value="${restauranteNaoSelecionado.selecionado}" />
						
						<img src="${path}/resources/imgs/${restaurante3.logo}" height="200" width="250" class="img-thumbnail"/> 
						<input type="radio"	name="restaurante" value="${restaurante3.selecionado}"> 
					</td>
					
					<td align="center">
						<img src="${path}/resources/imgs/${restaurante4.logo}" height="200" width="250" class="img-thumbnail">
						<input type="radio"	name="restaurante" value="${restaurante4.selecionado}" />
						
						<img src="${path}/resources/imgs/${restaurante5.logo}" height="200" width="250" class="img-thumbnail"/> 
						<input type="radio"	name="restaurante" value="${restaurante5.selecionado}"> 
						
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<br />
					<button type="submit" class="btn btn-large btn-primary ">Votar</button>
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
