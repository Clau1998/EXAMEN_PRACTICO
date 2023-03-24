/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datos.Encriptado;
import datos.UsuarioDao;
import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author claug
 */
@WebServlet(urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String accion = request.getParameter("accion");
    if (accion != null) {
      switch (accion) {
        case "login":
          this.accionDefault(request, response);

          break;
        case "tablero":
          this.tableroUsuario(request, response);
          break;

        case "agregarU":
          this.agregarUsuario(request, response);
          break;

        case "modificar":
          this.modificar(request, response);
          break;

        case "bajaUsuario":
          this.bajaUsuario(request, response);
          break;
        case "altaUsuario":
          this.alta_Usuario(request, response);
          break;

        case "buscarNombre":
          this.busquedaPorNombre(request, response);
          break;

        case "buscarFecha":
          this.busquedaPorFecha(request, response);
          break;

      }
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String accion = request.getParameter("accion");
    if (accion != null) {
      switch (accion) {
        case "tablero":
          this.tableroUsuario(request, response);
          break;
        case "inativo":
          this.tableroUsuarioI(request, response);
          break;

        case "revocado":
          this.tableroUsuarioR(request, response);
          break;

        case "bajaU":
          this.dar_Baja_U(request, response);
          break;

        case "altaU":
          this.dar_Alta_U(request, response);
          break;

        case "editarU":
          this.editarUsuario(request, response);
          break;

      }
    }
  }

  public void accionDefault(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    response.sendRedirect("bienvenida.jsp");
  }

  private void tableroUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Usuario> usuarios = new UsuarioDao().listar("A");
    System.out.println("Usuarios: " + usuarios);
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuarios", usuarios);
    //request.setAttribute("usuarios", usuarios);
    response.sendRedirect("tablero.jsp");

    System.out.println("ServletControlador.tableroUsuario()");

  }

  private void tableroUsuarioI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Usuario> usuarios = new UsuarioDao().listar("B");
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuarios", usuarios);
    response.sendRedirect("tablero.jsp");
  }

  private void tableroUsuarioR(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Usuario> usuarios = new UsuarioDao().listar("R");
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuarios", usuarios);
    response.sendRedirect("tablero.jsp");
  }

  private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String login = request.getParameter("login");
    String nombre = request.getParameter("nombre");
    String apPaterno = request.getParameter("apellidoPaterno");
    String apMaterno = request.getParameter("apellidoMaterno");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    float cliente = Float.parseFloat(request.getParameter("cliente"));
    int area = Integer.parseInt(request.getParameter("area"));

    try {
      Encriptado encriptado = new Encriptado();
      password = encriptado.encrypt(password);

    } catch (Exception e) {
      e.printStackTrace(System.out);
    }

    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    usuario.setNombre(nombre);
    usuario.setApellidoPaterno(apPaterno);
    usuario.setApellidoMaterno(apMaterno);
    usuario.setEmail(email);
    usuario.setPassword(password);
    usuario.setCliente(cliente);
    usuario.setArea(area);

    int registroinsertado = new UsuarioDao().insertar(usuario);
    System.out.println("registroinsertado: " + registroinsertado);
    this.tableroUsuario(request, response);

  }

  private void dar_Baja_U(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    System.out.println(login);
    new UsuarioDao().buscar(usuario);
    request.setAttribute("usuario", usuario);
    String jspEditar = "/WEB-INF/bajaUsuario.jsp";
    request.getRequestDispatcher(jspEditar).forward(request, response);

  }

  private void bajaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    int registrosModificados = new UsuarioDao().bajaUsuario(usuario);
    System.out.println("registrosModificados: " + registrosModificados);
    //Redirigimos hacia al tableroUsuarioI
    this.tableroUsuarioI(request, response);

  }
  
   private void dar_Alta_U(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    System.out.println(login);
    new UsuarioDao().buscar(usuario);
    request.setAttribute("usuario", usuario);
    String jspEditar = "/WEB-INF/altaUsuario.jsp";
    request.getRequestDispatcher(jspEditar).forward(request, response);

  }
   private void alta_Usuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    new UsuarioDao().altaUsuario(usuario);
    
    this.tableroUsuario(request, response);
  }

  private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    String nombre = request.getParameter("nombre");
    String apPaterno = request.getParameter("apellidoPaterno");
    String apMaterno = request.getParameter("apellidoMaterno");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    float cliente = Float.parseFloat(request.getParameter("cliente"));
    int area = Integer.parseInt(request.getParameter("area"));

    try {
      Encriptado encriptado = new Encriptado();
      password = encriptado.encrypt(password);

    } catch (Exception e) {
      System.out.println(e);
    }

    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    usuario.setNombre(nombre);
    usuario.setApellidoPaterno(apPaterno);
    usuario.setApellidoMaterno(apMaterno);
    usuario.setEmail(email);
    usuario.setPassword(password);
    usuario.setCliente(cliente);
    usuario.setArea(area);

    int registromodificado = new UsuarioDao().actualizar(usuario);
    System.out.println("registroinsertado: " + registromodificado);
    this.tableroUsuario(request, response);
  }

  private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    Usuario usuario = new Usuario();
    usuario.setLogin(login);
    new UsuarioDao().encontrarUsuario(usuario);
    request.setAttribute("usuario", usuario);
    String jspEditar = "/WEB-INF/editarU.jsp";
    request.getRequestDispatcher(jspEditar).forward(request, response);

  }

  public void busquedaPorNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    List<Usuario> usuarios = new UsuarioDao().buscarPorNombre(nombre);
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuarios", usuarios);
    response.sendRedirect("tablero.jsp");

  }

  public void busquedaPorFecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String fechaAlta = request.getParameter("fechaAlta");
    String fechaFinal = request.getParameter("fechaFinal");
    List<Usuario> usuarios = new UsuarioDao().buscar_por_fecha(fechaAlta, fechaFinal);
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuarios", usuarios);
    response.sendRedirect("tablero.jsp");

  }

 

}
