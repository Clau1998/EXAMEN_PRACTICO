<%-- 
    Document   : editarU
    Created on : 23/03/2023, 12:16:35 PM
    Author     : claug
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Editar usuario</title>
  </head>
  <body>
    <div class="container mt-4">
      <div class="card"> 
        <div class="card-header">
          <h2 class="subheader">Modificar Usuario</h2>          
        </div>

        <div class="card-body">
          <form action="ServletControlador?accion=modificar&login=${usuario.login}" method="POST" class="was-validated">  
            <div class="row g-3">
              <div class="col">
                <div class="form-group">
                  <label for="login">Login</label> 
                  <input type="text" class="form-control" name="login" value="${usuario.login}" disabled="true"  required>
                </div>
              </div>
              <div class="col">
                <div class="form-group">
                  <label for="nombre">Nombre</label>
                  <input type="text" class="form-control" name="nombre" value="${usuario.nombre}"  required>
                </div>
              </div>

            </div>

            <div class="row g-3">

              <div class="col">
                <div class="form-group">
                  <label for="apellidoPaterno">Apellido Paterno</label>
                  <input type="text" class="form-control" name="apellidoPaterno" placeholder="Apellido Paterno" value="${usuario.apellidoPaterno}" required>
                </div>
              </div>

              <div class="col">
                <div class="form-group">
                  <label for="apellidoMaterno">Apellido Materno</label>
                  <input type="text" class="form-control" name="apellidoMaterno" placeholder="Apellido Materno" value="${usuario.apellidoMaterno}" required>
                </div>
              </div>
            </div>
            <div class="row g-3">
              <div class="col">
                <div class="form-group">
                  <label for="email">Correo Electrónico</label> 
                  <input type="text" class="form-control" name="email" placeholder="email" value="${usuario.email}" required>
                </div>
              </div>
              <!--si va a modificar que introduzca una nueva contraseña-->
              <div class="col">
                <div class="form-group">
                  <label for="password">Contraseña</label> 
                  <input type="text" class="form-control" name="password" placeholder="Introduce una nueva contraseña" required>
                </div>
              </div>
            </div>

            <div class="row g-3">
              <div class="col">
                <div class="form-group">
                  <label for="cliente">Cliente</label>
                  <input type="number" class="form-control" name="cliente" placeholder="cliente" step="any" value="${usuario.cliente}" required>
                </div>
              </div>
              <div class="col">
                <div class="form-group">
                  <label for="area">Area</label>
                  <input type="number" class="form-control" name="area" value="${usuario.area}">
                </div> 
              </div>
            </div>
                
            <div class="row g-3" style="margin-left: 10px;">
              <input class="btn btn-primary" type="submit" value="Modificar"/>
              <a class="nav-link" href="ServletControlador?accion=tablero">Cancelar</a>
            </div> 

          </form>
        </div>

      </div>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </body>
</html>
