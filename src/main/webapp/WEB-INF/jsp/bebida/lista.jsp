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
	  <h2>Cadastramento de Bebidas</h2>
	  <form action="/bebida" method="get">
	    <button type="submit" class="btn btn-primary">Nova bebida</button>
	  </form>
	  
	  <c:if test="${not empty listagem}">
	 	  <p>Listagem de bebidas (${listagem.size()}):</p>            
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		        <th>Valor</th>
		        <th>Código</th>
		        <th>Gelada</th>
		        <th>Tamanho</th>
		        <th>Marca</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="o" items="${listagem}">	
			      <tr>
			      	<td>${o.id}</td>
			        <td>${o.nome}</td>
			        <td>${o.valor}</td>
			        <td>${o.codigo}</td>
			        <td>${o.gelada}</td>
			        <td>${o.tamanho}</td>
			        <td>${o.marca}</td>
			        <td><a href="/bebida/${o.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
	  </c:if>
	  	
 	  <c:if test="${empty listagem}">
 	  	<p>Nenhum registro encontrado.</p>
 	  </c:if> 	              
	</div>
</body>
</html>