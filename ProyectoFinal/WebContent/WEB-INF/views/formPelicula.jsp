<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Pelicula</title>
</head>
<body>

<h1> Ingreso Pelicula </h1>

<form:form id="form2" method="post" modelAttribute="pelicula" action="${pageContext.request.contextPath}/guardarPelicula">
				
				<form:input type="hidden" id="cMovie" path="cMovie"/> <br>
				
				<label><b>Nombre Pelicula: </b></label> <br>
				<form:input class="inputs" type="text" id="pName" path="pName" placeholder="Nombre Pelicula" /> <br>
				
				<label><b>Poster: </b></label> <br>
				<form:input class="inputs" type="text" id="pImage" path="pImage" placeholder="Poster" /> <br> 
				
				<label><b>Duración</b></label> <br>
				<form:input class="inputs" type="date" id="pDuration" path="pDuration" placeholder="Duración" /> <br>
				
				<input id="save" class="myButton" type="submit" value="Guardar pelicula" /> <br>
		
	</form:form>

</body>
</html>