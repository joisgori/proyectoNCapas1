<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- *************** ACÁ, ESTO SE IMPORTA *************** -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista de administrador</title>
</head>
<body>

	<h1>Tabla de clientes</h1>
	
	<label>Nuevo cliente</label>
	<button onclick="location.href='${pageContext.request.contextPath}/insertCliente'"> Nuevo cliente </button> <br>

<table>
		<tr>
			<th> Nombre de usuario </th>
			<th> Apellido de usuario </th>
			<th> User login </th>
			<th> Saldo de cuenta </th>
		</tr>
		<c:forEach items="${DatosCliente}" var="DatosCliente">
			<tr> 
			<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
				<td> ${DatosCliente.aUsuario} </td>
				<td> ${DatosCliente.aApellido} </td>
				<td> ${DatosCliente.user} </td>
				<td> ${DatosCliente.saldoCuenta} </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/ElimUsu?cUsuario=${DatosCliente.cUsuario}'"
				> Eliminar Cliente</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarUsu?id_usuario=${DatosCliente.cUsuario}'" 
				> Editar Cliente</button> </td>
			</tr>
	</c:forEach>
</table>
		<br>
		<h2>Tabla de películas:</h2>
		
		<label>Agregar nuevo película</label>
		<button onclick="location.href='${pageContext.request.contextPath}/insertPeli'">Nueva película</button> <br> 
		
		<table>
			<tr>
			<th> ID película </th>
			<th> Nombre de película </th>
			<th> Imagen de película </th>
			<th> Duración </th>
			<!-- Creo que necesitaré hacer un DTO -->
		</tr>
		<c:forEach items="${DatosPelicula}" var="DatosPelicula">
			<tr> 
			<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
				<td> ${DatosPelicula.cMovie} </td>
				<td> ${DatosPelicula.pName} </td>
				<td><img src="${DatosPelicula.pImage}" style="width:300px;height:300px"/></td>
				<td> ${DatosPelicula.pDuration} </td>
				<td> <button onClick = "location.href='${pageContext.request.contextPath}/ElimPeli?id_pelicula=${DatosPelicula.cMovie}'"
				> Eliminar Película</button> </td>
				<td> <button onclick = "location.href='${pageContext.request.contextPath}/EditarPeli?id_pelicula=${DatosPelicula.cMovie}'" 
				> Editar Película</button> </td>
			</tr>
		</c:forEach>
</table>

</body>
</html>
