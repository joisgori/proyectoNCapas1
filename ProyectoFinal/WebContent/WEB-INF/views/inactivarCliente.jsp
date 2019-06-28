<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inactivación</title>
</head>

<style>
body{
	 text-align: center;
}
</style>
<body>
		<h2>MOTIVO INACTIVACIÓN MOVIE</h2>
		<form action="${pageContext.request.contextPath}/inactivarUser" method="post">
				<input type="hidden" value="${usuario}" name="cUsuario" id="cUsuario">
				<input type="text" name="motivo" id="motivo">
				<input  type="submit">
		</form>
</body>
</html>