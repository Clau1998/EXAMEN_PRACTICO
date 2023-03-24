<%-- 
    Document   : Tablero
    Created on : 22/03/2023, 04:06:55 PM
    Author     : claug
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>JSP Page</title>
  </head>
  <body>
    <jsp:include page="WEB-INF/menu.jsp" />

    <div class="container mt-3">

      <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group me-2">
          <a type="button" class="btn btn-success" href="ServletControlador?accion=tablero">ACTIVOS</a>
        </div>
        <div class="btn-group me-2">
          <a type="button" class="btn btn-secondary" href="ServletControlador?accion=inativo">INACTIVOS</a>
        </div>
        <div class="btn-group">
          <a type="button" class="btn btn-warning" href="ServletControlador?accion=revocado">REVOCADOS</a>
        </div>
      </div>

      <div class="row g-3 mt-3">
        <div class="col">
          <div class="form-group d-flex">
            <form action="ServletControlador?accion=buscarNombre" method="POST">
              <div class="form-group d-flex">
                <label for="nombre">NOMBRE:</label>
                <input type="text" class="form-control" name="nombre" maxlength="50" required>
                <input class="btn btn-primary" type="submit" value="Buscar" style="margin-left: 4px"/>
              </div>               
            </form>
          </div>
        </div>

        <div class="col">
          <form action="ServletControlador?accion=buscarFecha" method="POST">
            <div class="form-group d-flex">
              <label for="fechaAlta">FECHA ALTA INICIAL:</label>
              <input type="date" class="form-control" name="fechaAlta" required>
            </div>
            <div class="form-group d-flex mt-2">
              <label for="fechaFinal">FECHA ALTA FINAL:</label>
              <input type="date" class="form-control" name="fechaFinal" required>
            </div>
            <input class="btn btn-primary mt-2" type="submit" value="Buscar"/>
          </form>
        </div>
      </div>

      <div class="card mt-3">
        <div class="card-header">
          <h4>Lista de Usuarios</h4>
        </div>

        <div class="card-body">
          <table class="table table-striped">
            <thead>
              <tr>               
                <th>NOMBRE</th>
                <th>LOGIN</th>
                <th>FECHA ALTA</th>
                <th>ESTATUS</th>
                <th>ACCION</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach  items="${usuarios}" var="usuario">
                <tr>               
                  <td>${usuario.nombre}</td>
                  <td>${usuario.login}</td>
                  <td>${usuario.fechaAlta}</td>  
                  <td>${usuario.status}</td> 
                  <td>
                    <a href="ServletControlador?accion=editarU&login=${usuario.login}"  class="btn btn-secondary">Editar</a>
                    <c:set var="estatus" value="${usuario.status}" />
                    <c:if test="${estatus eq 'B' || estatus eq 'R'}">
                      <a href="ServletControlador?accion=altaU&login=${usuario.login}"  class="btn btn-danger">Alta</a>
                    </c:if>
                     
                    <c:if test="${estatus eq 'A'}">
                      <a href="ServletControlador?accion=bajaU&login=${usuario.login}"  class="btn btn-danger">Baja</a>
                    </c:if>

                  </td>

                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
