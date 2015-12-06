<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Restaurante</title>
</head>
<body>
	<h1>Restaurante Manager</h1>
	<form:form action="Restaurante" method="POST">
		<table>
			<tr>
				<td><form:label path="id">Id: </form:label> </td>
				<td><form:input path="id"/> </td>
			</tr>
			<tr>
				<td><form:label path="nome">Nome: </form:label></td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Cadastrar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
