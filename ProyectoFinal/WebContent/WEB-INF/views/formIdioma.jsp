<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Idioma</title>
</head>
<body>

<h1> Ingreso Idioma - Administrador</h1>

<form:form id="form3" method="post" modelAttribute="idioma" action="${pageContext.request.contextPath}/guardarIdioma">
				
				<form:input type="hidden" id="cIdioma" path="cIdioma"/> <br>
				
				<label><b>Idioma: </b></label> <br>
				<form:input class="inputs" type="text" id="aIpeli" path="aIpeli" placeholder="Idioma" /> <br>
	
				<input id="save" class="myButton" type="submit" value="Guardar Idioma" /> <br>
		
	</form:form>

</body>
</html>