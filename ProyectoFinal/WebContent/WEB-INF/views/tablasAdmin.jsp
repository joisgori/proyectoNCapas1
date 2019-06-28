<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- *************** ACÃ, ESTO SE IMPORTA *************** -->
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
			<th>Fecha Nacimiento</th>
			<th>Direcci�n de residencia</th>
			<th>Estado</th>
			<th>Departamento</th>
			<th>Motivo</th>
			
		</tr>
		<c:forEach items="${DatosCliente}" var="DatosCliente">
			<tr>
				<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
				<td>${DatosCliente.aUsuario}</td>
				<td>${DatosCliente.aApellido}</td>
				<td>${DatosCliente.user}</td>
				<td>${DatosCliente.saldoCuenta}</td>
				<td>${DatosCliente.fNacimiento}</td>
				<td>${DatosCliente.resUsuario}</td>
				<td>${DatosCliente.estadoUsuario}</td>
				<td>${DatosCliente.uDepartamento}</td>
				<td>${DatosCliente.uMotivo}</td>
				<td>
					<button
						onclick="location.href='${pageContext.request.contextPath}/ElimUsu?cUsuario=${DatosCliente.cUsuario}'">
						Eliminar Cliente</button>
				</td>
				<td>
					<button
						onclick="location.href='${pageContext.request.contextPath}/EditarUsu?cUsuario=${DatosCliente.cUsuario}'">
						Editar Cliente</button>
				</td>

				<td>
					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModal">Inactivar</button> 
						<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">Comentario Inactivación</h4>
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
	<h2>Tabla de peliculas:</h2>

	<label>Agregar nuevo pelicula</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertPeli'">Nueva
		pelicula</button>
	<br>

	<table>
		<tr>
			<th>ID pelicula</th>
			<th>Nombre de pelicula</th>
			<th>Imagen de pelicula</th>
			<th>Duracion</th>
		</tr>
		<c:forEach items="${DatosPelicula}" var="DatosPelicula"> 
			<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
			<tr>
				<td> ${DatosPelicula.cMovie} </td>
				<td> ${DatosPelicula.pName} </td>
				<td><img src="resources/imagenes/${DatosPelicula.pImage}.png" style="width:300px;height:300px"/></td>
				<td> ${DatosPelicula.pDuration} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimPeli?cMovie=${DatosPelicula.cMovie}'"
				> Eliminar PelÃ­cula</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarPeli?cMovie=${DatosPelicula.cMovie}'" 
				> Editar PelÃ­cula</button> </td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- actores, género, horario, idioma -->
	
	</table>
	<br>
	<h2>Tabla de actores:</h2>

	<label>Agregar nuevo actor</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertActo'">Nuevo actor</button>
	<br>

	<table>
		<tr>
			<th>ID actor</th>
			<th>Nombre de actor</th>
			<th>Apellido de actor</th>
		</tr>
		<c:forEach items="${DatosActor}" var="DatosActor"> 
			<tr>
				<td> ${DatosActor.cActores} </td>
				<td> ${DatosActor.aName} </td>
				<td> ${DatosActor.aApellido}</td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimActo?cActores=${DatosActor.cActores}'"
				> Eliminar actor</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarActo?cActores=${DatosActor.cActores}'" 
				> Editar actor</button> </td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- género, horario, idioma -->
		</table>
	<br>
	<h2>Tabla de genero:</h2>

	<label>Agregar nuevo genero</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertGen'">Nuevo genero</button>
	<br>

	<table>
		<tr>
			<th>ID genero</th>
			<th>Genero pelicula</th>
		</tr>
		<c:forEach items="${DatosGenero}" var="DatosGenero">
			<tr>
				<td> ${DatosGenero.cGenero} </td>
				<td> ${DatosGenero.aGpeli} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimGen?cGenero=${DatosGenero.cGenero}'"
				> Eliminar Genero</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarGen?cGenero=${DatosGenero.cGenero}'" 
				> Editar Genero</button> </td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- horario, idioma -->
	
		<br>
	<h2>Tabla de horario:</h2>

	<label>Agregar nuevo horario</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertHor'">Nuevo Horario</button>
	<br>

	<table>
		<tr>
			<th>ID horario</th>
			<th>Horario pelicula</th>
		</tr>
		<c:forEach items="${DatosHorario}" var="DatosHorario"> 
			<tr>
				<td> ${DatosHorario.cHorario} </td>
				<td> ${DatosHorario.aHpeli} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimHor?cHorario=${DatosHorario.cHorario}'"
				> Eliminar horario</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarHor?cHorario=${DatosHorario.cHorario}'" 
				> Editar horario</button> </td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- idioma -->
	<br>
	<h2>Tabla de idioma:</h2>

	<label>Agregar nuevo idioma</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertIdiom'">Nuevo idioma</button>
	<br>

	<table>
		<tr>
			<th>ID idioma</th>
			<th>Idioma pelicula</th>
		</tr>
		<c:forEach items="${DatosIdioma}" var="DatosIdioma"> 
			<tr>
				<td> ${DatosIdioma.cIdioma} </td>
				<td> ${DatosIdioma.aIpeli} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimIdio?cIdioma=${DatosIdioma.cIdioma}'"
				> Eliminar Idioma</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarIdio?cIdioma=${DatosIdioma.cIdioma}'" 
				> Editar Idioma</button> </td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- tipo pelicula-->
	<br>
	<h2>Tabla de tipos de pelicula:</h2>

	<label>Agregar nuevo tipo de pelicula</label>
	<button
		onclick="location.href='${pageContext.request.contextPath}/insertTipoPel'">Nuevo tipo de pelicula</button>
	<br>

	<table>
		<tr>
			<th>ID tipo pelicula</th>
			<th>tipo pelicula</th>
		</tr>
		<c:forEach items="${DatosTipoPeli}" var="DatosTipoPeli"> 
			<tr>
				<td> ${DatosTipoPeli.cTipoP} </td>
				<td> ${DatosTipoPeli.aTpeli} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimTipoPel?cTipoP=${DatosTipoPeli.cTipoP}'"
				> Eliminar tipo peli</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarTipoPel?cTipoP=${DatosTiposPeli.cTipoP}'" 
				> Editar tipo peli</button> </td>
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
