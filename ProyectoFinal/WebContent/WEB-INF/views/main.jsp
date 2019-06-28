<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cinemark</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,700,300'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="resources/css/style.css">

</head>
<body style="background:#7D808B">

  <div class="signup__container">
  <div class="container__child signup__thumbnail">

    <div class="thumbnail__content text-center">
      <h1 class="heading--primary"></h1>
      <br>
      <h2 class="heading--secondary"></h2>
    </div>

    <div class="signup__overlay"></div>
  </div>
  <div class="container__child signup__form" style="background:#022397      ">
    <form method="post" action="${pageContext.request.contextPath}/verifyLogin">
      <div class="form-group">
        <br>
        <label for="username">Users</label>
        <input class="form-control" type="text" name="username" id="username" placeholder="@uca" required style="background:white"/>
      </div>
      <br>
      <div class="form-group">
        <label for="password">Password</label>
        <input class="form-control" type="password" name="pass" id="pass" placeholder="********" required style="background:white"/>
      </div>
      <div class="m-t-lg">
        <ul class="list-inline">
          <li>
            <input class="btn btn--form" type="submit" value="LOGIN" />
          </li>
          <li>
            <a class="signup__link" href="file:///C:/Users/kevin/OneDrive/Escritorio/views/Log%20up/logoup.html">logup</a>
          </li>
        </ul>
      </div>
    </form>
    <c:if test="${resultado eq 1}">
    	<h2>USUARIO INACTIVO!!!</h2>
    </c:if>
    <c:if test="${resultado eq 0}">
    	<h2>YA ESTAS LOGGEADO!!!</h2>
    </c:if>
  </div>
</div>


</body>
</html>