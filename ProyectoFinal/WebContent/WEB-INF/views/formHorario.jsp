<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Horario</title>
</head>
<body>

<h1> Ingreso Horario - Administrador</h1>

<form:form id="form6" method="post" modelAttribute="horario" action="${pageContext.request.contextPath}/guardarHorario">
				
				<form:input type="hidden" id="cHorario" path="cHorario"/> <br>
				
				<label><b>Horario: </b></label> <br>
				<form:input class="inputs" type="text" id="aHpeli" path="aHpeli" placeholder="Horario" /> <br>
	
				<input id="save" class="myButton" type="submit" value="Guardar Horario" /> <br>
		
	</form:form>

</body>
</html>