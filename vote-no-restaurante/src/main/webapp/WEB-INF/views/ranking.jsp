<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h1>Restaurante Manager</h1>
		
		
		<br />
		<br />  	
		<h3>Você, votou no restaurante   a nota 10.</h3>
		
		<br />
		<br />
		<form:form action="Restaurante" method="POST">
		
			<table
				class="table table-hover table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<td>Restaurante</td>
						<td>Score</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todosRestaurantes}" var="restaurante">
							<tr>
								<td><img src="${path}/resources/imgs/${restaurante.logo}" height="50" width="100"/></td>
								<td>${restaurante.score}</td>
							</tr>
					</c:forEach>		
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3">Total: ${todosRestaurantes.size()}</td>
					</tr>
				</tfoot>
			</table>
		</form:form>
	</section>
	<script type="text/javascript"
		src="${path}/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
