<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Genero</title>
</head>
<body>

<h1> Ingreso Genero - Administrador</h1>

<form:form id="form4" method="post" modelAttribute="genero" action="${pageContext.request.contextPath}/guardarGenero">
				
				<form:input type="hidden" id="cGenero" path="cGenero"/> <br>
				
				<label><b>Genero: </b></label> <br>
				<form:input class="inputs" type="text" id="aGpeli" path="aGpeli" placeholder="Genero" /> <br>
	
				<input id="save" class="myButton" type="submit" value="Guardar Genero" /> <br>
		
	</form:form>

</body>
</html>