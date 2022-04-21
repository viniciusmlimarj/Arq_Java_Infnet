<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h2>Cadastramento de Pedidos</h2>
	  <form action="/pedido/incluir" method="post">

	    <div class="mb-3 mt-3">
	      <label>Descrição:</label>
	      <input type="text" class="form-control" placeholder="Descrição" name="descricao">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Solicitante:</label>
	      <select name="solicitante.id" class="form-control">
	      		<c:forEach var="s" items="${solicitantes}">
	      			<option value="${s.id}">${s.nome}</option>
	      		</c:forEach>
	      </select>
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Produtos:</label>
			<div class="checkbox">
				<c:forEach var="p" items="${produtos}">
      			<label><input type="checkbox" value="${p.id}" name="idsProdutos" checked> ${p.nome}</label>
      			</c:forEach>
    		</div>
	    </div>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
</body>
</html>