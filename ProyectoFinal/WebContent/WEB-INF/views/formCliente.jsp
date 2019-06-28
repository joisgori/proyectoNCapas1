<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Ingreso Usuario </h1>

<form:form id="form2" method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/guardarUsuario">
				
				<form:input type="hidden" id="idUsuario" path="cUsuario"/> <br>
				
				<label><b>Nombre Usuario: </b></label> <br>
				<form:input class="inputs" type="text" id="aUsuario" path="aUsuario" placeholder="Nombre Usuario" /> <br>
				
				<label><b>Apellido Usuario: </b></label> <br>
				<form:input class="inputs" type="text" id="aApellido" path="aApellido" placeholder="Apellido Usuario" /> <br> 
				
				<label><b>Fecha de Nacimiento:</b></label> <br>
				<form:input class="inputs" type="date" id="fNacimiento" path="fNacimiento" placeholder="Fecha de nacimiento" /> <br>

				<label><b>Dirección de Residencia:</b></label> <br>
				<form:input class="inputs" type="text" id="resUsuario" path="resUsuario" placeholder="Residencial" /> <br>
					
				<label>Estado Usuario: </label><br>		
				<form:radiobutton name="status" path="estadoUsuario" value="true"/><label>Activo</label><br>
				<form:radiobutton name="status" path="estadoUsuario" value="false"/><label>Inactivo</label><br>
				
				<label><b>Usuario: </b></label> <br>
				<form:input class="inputs" type="text" id="user" path="user" placeholder="User" /> <br>
			
				<label><b>Contraseña: </b></label> <br>
				<form:input class="inputs" type="text" id="pass" path="pass" placeholder="Password" /> <br>
			
				<label><b>Tipo Usuario: </b></label> <br>
				<form:input class="inputs" type="text" id="nUsuario" path="nUsuario" placeholder="Administrador/Cliente" /> <br>
			
				<label><b>Saldo: </b></label> <br>
				<form:input class="inputs" type="number" id="saldoCuenta" path="saldoCuenta" placeholder="Saldo" /> <br>
			
				<label><b>Departamento: </b></label> <br>
				<form:input class="inputs" type="text" id="uDepartamento" path="uDepartamento" placeholder="Departamento" /> <br>
				
				<input id="save" class="myButton" type="submit" value="Guardar la sucursal" /> <br>
		
	</form:form>

</body>
</html>