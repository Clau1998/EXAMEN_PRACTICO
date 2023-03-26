<%-- 
    Document   : index.jsp
    Created on : 22/03/2023, 03:59:10 PM
    Author     : claug
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Login</title>
  </head>
  <body>

    <div class="vh-100 d-flex justify-content-center align-items-center">
      <div class="col-md-4 p-5 shadow-sm border rounded-3">
        <h2 class="text-center mb-4 text-primary">Login</h2>
        <form action="Login?accion=login" method="POST">
          <div class="form-group">
            <label for="login" class="form-label">Login</label>
            <input type="text" class="form-control border border-primary" id="login" name="login" placeholder="Introduce login">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password" class="form-control border border-primary" id="password" name="password" placeholder="Introduce contraseña">
          </div>

          <c:if test="${invalid != null}">
            <div class="p-3 text-center bg-primary-subtle border border-primary-subtle rounded-3 mb-3">
              ${invalid}
            </div>
          </c:if>

          <div class="d-grid">
            <input class="btn btn-primary" type="submit" value="Iniciar sesion"/>
          </div> 
          <div class="d-grid mt-4">
            <a class="nav-link" href="agregarUsuario.jsp">Registrar usuario</a>
          </div> 

        </form>

      </div>
    </div>

  </div>

</body>
</html>
