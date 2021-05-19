<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>aplicacion gestion de proyectos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">Gestión de Proyectos</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Proyectos</a></li>
			</ul>
		</nav>
	</header>
	<br />
	<div class="row">
		<div class="contaier">
			<h3 class="text-center">Listado de Proyectos</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar
					Nuevo Proyecto</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>resumen</th>
						<th>video</th>
						<th>tipo</th>
						<th>categoria</th>
						<th>asignatura</th>
						<th>evento</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach var="proyecto" items="${listProyectos}">
						<tr>
							<td><c:out value="${proyecto.id}" /></td>
							<td><c:out value="${proyecto.nombre}" /></td>
							<td><c:out value="${proyecto.resumen}" /></td>
							<td><c:out value="${proyecto.video}" /></td>
							<td><c:out value="${proyecto.tipo}" /></td>
							<td><c:out value="${proyecto.cat}" /></td>
							<td><c:out value="${proyecto.asig}" /></td>
							<td><c:out value="${proyecto.evento}" /></td>
							<td><a href="edit?id=<c:out value='${proyecto.id}'/>">Editar</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="delete?id=<c:out value='${proyecto.id}'/>">eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>