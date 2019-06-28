<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catálogo</title>
</head>
<body>

<h3>Mis datos personales</h3>
<table>
		<tr>
			<th>Usuario</th>
			<th>Salgo</th>
		</tr>
		<tr>
				<td> ${MisDatos.user} </td>
				<td> ${MisDatos.saldoCuenta} </td>
		</tr>
</table>

<h1>Catálogo peliculas</h1>

	<table>
		<tr>
			<th>NOMBRE</th>
			<th>CARTELERA</th>
			<th>DURACION</th>
		</tr>
		<c:forEach items="${DatosPelicula}" var="DatosPelicula"> 
			<!-- mando a llamar los nombres que le puse en domain, para llenar esos campos... -->
			<tr>
				<td> ${DatosPelicula.cMovie} </td>
				<td> ${DatosPelicula.pName} </td>
				<td><img src="resources/imagenes/${DatosPelicula.pImage}.png" style="width:75px;height:75px"/></td>
				<td> ${DatosPelicula.pDuration} </td>
			</tr>
		</c:forEach>
	</table>

	<button	onclick="location.href='${pageContext.request.contextPath}/reservaCliente'">
	Comprar tickets</button>
	<br>

</body>
</html>