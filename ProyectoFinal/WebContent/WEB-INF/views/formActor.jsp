<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Actor</title>
</head>
<body>

<h1> Ingreso Actor - Administrador</h1>

<form:form id="form5" method="post" modelAttribute="actor" action="${pageContext.request.contextPath}/guardarActor">
				
				<form:input type="hidden" id="cActor" path="cActores"/> <br>
				
				<label><b>Nombre: </b></label> <br>
				<form:input class="inputs" type="text" id="aName" path="aName" placeholder="Nombre" /> <br>

				<label><b>Apellido: </b></label> <br>
				<form:input class="inputs" type="text" id="aApellido" path="aApellido" placeholder="Apellido" /> <br>
	
				<input id="save" class="myButton" type="submit" value="Guardar Actor" /> <br>
		
	</form:form>

</body>
</html>