<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva</title>
</head>
<body>

<h1>Reserva</h1>

<form:form id="form8" method="post" modelAttribute="pelicula" action="${pageContext.request.contextPath}/Reserva">
				
				<label>Seleccione Pelicula</label>
				<form:select path="cMovie" items="${DatosPelicula}" />
		
				<input id="save" class="myButton" type="submit" value="Guardar pelicula" /> <br>
</form:form>

</body>
</html>