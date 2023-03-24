<%-- 
    Document   : formUsuario
    Created on : 22/03/2023, 04:30:27 PM
    Author     : claug
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <jsp:include page="WEB-INF/menu.jsp" />
    <div class="container mt-4">

      <div class="card"> 
        <div class="card-header">
          <h2 class="subheader">Guardar Usuario</h2>          
        </div>

        <div class="card-body">
          <form action="ServletControlador?accion=agregarU" method="POST" class="was-validated">  
            <div class="row g-3">
              <div class="col">
                <div class="form-group">
                  <label for="login">Login</label> 
                  <input type="text" class="form-control" name="login" placeholder="login" required>
                </div>
              </div>
              <div class="col">
                <div class="form-group">
                  <label for="nombre">Nombre</label>
                  <input type="text" class="form-control" name="nombre" placeholder="Nombre" required>
                </div>
              </div>

            </div>

            <div class="row g-3">

              <div class="col">
                <div class="form-group">
                  <label for="apellidoPaterno">Apellido Paterno</label>
                  <input type="text" class="form-control" name="apellidoPaterno" placeholder="Apellido Paterno" required>
                </div>
              </div>

              <div class="col">
                <div class="form-group">
                  <label for="apellidoMaterno">Apellido Materno</label>
                  <input type="text" class="form-control" name="apellidoMaterno" placeholder="Apellido Materno" required>
                </div>
              </div>
            </div>
            <div class="row g-3">
              <div class="col">
                <div class="form-group">
                  <label for="email">Correo Electrónico</label> 
                  <input type="text" class="form-control" name="email" placeholder="email" required>
                </div>
              </div>
              <div class="col">
                <div class="form-group">
                  <label for="password">Contraseña</label> 
                  <input type="text" class="form-control" name="password" placeholder="Contraseña" required>
                </div>
              </div>
            </div>

            <div class="row g-3">
              <div class="col">
                <div class="form-group">
                  <label for="cliente">Cliente</label>
                  <input type="number" class="form-control" name="cliente" placeholder="cliente" step="any" required>
                </div>
              </div>
              <div class="col">
                <div class="form-group">
                  <label for="area">Area</label>
                  <input type="number" class="form-control" name="area" required>
                </div> 
              </div>
            </div>

            <div>
              <input class="btn btn-primary" type="submit" value="Guardar"/>
            </div> 
          </form>
        </div>

      </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
