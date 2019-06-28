<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo</title>
</head>
<body>

<h1>Catalogo peliculas</h1>

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

	<button	onclick="location.href='${pageContext.request.contextPath}/reservaCliente'">
	Reserva</button>
	<br>

</body>
</html>