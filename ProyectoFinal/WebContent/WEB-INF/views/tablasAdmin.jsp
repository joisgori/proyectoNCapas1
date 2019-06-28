<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- *************** ACÁ, ESTO SE IMPORTA *************** -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista de administrador</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<h1>Tabla de clientes</h1>

	<label>Nuevo cliente</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertCliente'">
		Nuevo cliente</button>
	<br>

	<table>
		<tr>
			<th>Nombre de usuario</th>
			<th>Apellido de usuario</th>
			<th>User login</th>
			<th>Saldo de cuenta</th>
		</tr>
		<c:forEach items="${DatosCliente}" var="DatosCliente">
			<tr>
				<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
				<td>${DatosCliente.aUsuario}</td>
				<td>${DatosCliente.aApellido}</td>
				<td>${DatosCliente.user}</td>
				<td>${DatosCliente.saldoCuenta}</td>
				<td>
					<button
						onclick="location.href='${pageContext.request.contextPath}/ElimUsu?cUsuario=${DatosCliente.cUsuario}'">
						Eliminar Cliente</button>
				</td>
				<td>
					<button
						onclick="location.href='${pageContext.request.contextPath}/EditarUsu?id_usuario=${DatosCliente.cUsuario}'">
						Editar Cliente</button>
				</td>

				<td>
					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModal">Inactivar</button> 
						<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">Comentario Inactivaci�n</h4>
								</div>
								<div class="modal-body">
									<input/>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cerrar</button>
								</div>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<h2>Tabla de películas:</h2>

	<label>Agregar nuevo película</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertPeli'">Nueva
		película</button>
	<br>

	<table>
		<tr>
			<th>ID película</th>
			<th>Nombre de película</th>
			<th>Imagen de película</th>
			<th>Duración</th>
			<!-- Creo que necesitaré hacer un DTO -->
		</tr>
		<c:forEach items="${DatosPelicula}" var="DatosPelicula">

			<tr>
				<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
				<td>${DatosPelicula.cMovie}</td>
				<td>${DatosPelicula.pName}</td>
				<td><img src="${DatosPelicula.pImage}"
					style="width: 300px; height: 300px" /></td>
				<td>${DatosPelicula.pDuration}</td>
				<td>
					<button
						onClick="location.href='${pageContext.request.contextPath}/ElimPeli?id_pelicula=${DatosPelicula.cMovie}'">
						Eliminar Película</button>
				</td>
				<td>
					<button
						onclick="location.href='${pageContext.request.contextPath}/EditarPeli?id_pelicula=${DatosPelicula.cMovie}'">
						Editar Película</button>
				</td>

			<tr> 
			<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
				<td> ${DatosPelicula.cMovie} </td>
				<td> ${DatosPelicula.pName} </td>
				<td><img src="resources/imagenes/${DatosPelicula.pImage}.png" style="width:300px;height:300px"/></td>
				<td> ${DatosPelicula.pDuration} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimPeli?id_pelicula=${DatosPelicula.cMovie}'"
				> Eliminar Película</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarPeli?id_pelicula=${DatosPelicula.cMovie}'" 
				> Editar Película</button> </td>

			</tr>
		</c:forEach>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>
