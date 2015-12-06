<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="modal fade" id="modal-restaurante" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <form:form action="Restaurante" method="POST">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Cadastro de Restaurante</h4>
      </div>
      <div class="modal-body">
        <table class="table table-hover table-condensed table-striped table-bordered">
			<tr>
				<td><form:label path="id">Id: </form:label> </td>
				<td><form:input path="id" class="form-control"/> </td>
			</tr>
			<tr>
				<td><form:label path="nome">Nome: </form:label></td>
				<td><form:input path="nome" class="form-control" /></td>
			</tr>
		</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
      </div>
      </form:form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
