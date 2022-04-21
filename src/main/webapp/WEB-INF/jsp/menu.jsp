<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Pedidos</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>

		  <c:if test="${not empty usuarioLogado}">	
		      <li><a href="/usuarios">Usuário</a></li>
		      <li><a href="/solicitantes">Solicitante</a></li>
		      <li><a href="/produtos">Produto</a></li>
		      <li><a href="/bebidas">Bebida</a></li>
		      <li><a href="/comidas">Comida</a></li>
		      <li><a href="/sobremesas">Sobremesa</a></li>
		      <li><a href="/pedidos">Pedido</a></li>
	      </c:if>
	      
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      
	      <c:if test="${empty usuarioLogado}">
		      <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      </c:if>

	      <c:if test="${not empty usuarioLogado}">
	      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${usuarioLogado.nome}</a></li>
	      </c:if>
	    </ul>
	  </div>
	</nav>