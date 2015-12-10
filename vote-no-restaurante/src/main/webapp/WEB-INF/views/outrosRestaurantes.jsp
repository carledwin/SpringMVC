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
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
	<section class="container">
	<br />
		<div class="jumbotron" style="background-color: #FEFEFE">
			<div class="container">
				<h2 align="center">Qual outro restaurante que você também gosta?</h2>
				<form action="usuario" method="POST" data-toggle="validator" role="form">
					<input type="hidden" name="idUsuario" value="${idUsuario}">
						<table style="width: 800px;" align="center">
								<tr>
									<td align="center">
											<div class="form-group">
												<div class="radio-inline">
												<label>
													<img src="${path}/resources/imgs/${restauranteNaoSelecionado.logo}" height="150" width="200" class="img-thumbnail"> 
													<input type="radio" id="rtNS" name="idRestaurante" value="${restauranteNaoSelecionado.id}" required /> 
												</label>
												<label>
													<img src="${path}/resources/imgs/${restaurante2.logo}" height="150" width="200" class="img-thumbnail"> 
													<input type="radio"	id="rt2" name="idRestaurante" value="${restaurante2.id}" required /> 
												</label>
												<label>
													<img src="${path}/resources/imgs/${restaurante3.logo}" height="150" width="200" class="img-thumbnail" /> 
													<input type="radio"	id="rt3" name="idRestaurante" value="${restaurante3.id}" required />
												</label>
												<label>	
													<img src="${path}/resources/imgs/${restaurante5.logo}" height="150" width="200" class="img-thumbnail" /> 
													<input type="radio" id="rt5" name="idRestaurante"	value="${restaurante5.id}" required />
												</label>
												</div>
											</div>
									</td>
								</tr>
								<tr>
									<td  align="center">
									<br />
									<br />
										<div class="form-group">
										<button type="submit" class="btn btn-primary">Enviar voto</button>
									</div>
									</td>
								</tr>
						</table>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${path}/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
