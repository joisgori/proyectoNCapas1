<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Tipo pelicula</title>
</head>
<body>

<h1> Ingreso Tipo Pelicula - Administrador</h1>

<form:form id="form7" method="post" modelAttribute="tipopelicula" action="${pageContext.request.contextPath}/guardarTP">
				
				<form:input type="hidden" id="cTipoP" path="cTipoP"/> <br>
				
				<label><b>Tipo Pelicula: </b></label> <br>
				<form:input class="inputs" type="text" id="aTpeli" path="aTpeli" placeholder="Tipo Pelicula" /> <br>
	
				<input id="save" class="myButton" type="submit" value="Guardar tipo pelicula" /> <br>
		
	</form:form>

</body>
</html>