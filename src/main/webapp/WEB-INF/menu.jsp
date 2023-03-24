<%-- 
    Document   : menu
    Created on : 22/03/2023, 06:29:02 PM
    Author     : claug
--%>

<div class="container">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="formUsuario.jsp">Gestión de Usuarios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ServletControlador?accion=tablero&valor=A">Tablero de Usuarios</a>
          </li>

          <ul class="navbar-nav navbar-right btn-outline-primary">     
            <li  class="dropdown">
              <a class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${sessionScope.nombre}
              </a>
              <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="Login?accion=logout">Cerrar sesión</a>
              </div>
            </li>

          </ul>
        </ul>
      </div>
    </div>
  </nav>
</div>


