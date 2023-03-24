/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datos.Encriptado;
import datos.LoginDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String accion = request.getParameter("accion");
    if (accion != null) {
      switch (accion) {
        case "logout":
          this.logout(request, response);
          break;

      }
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String accion = request.getParameter("accion");
    if (accion != null) {
      switch (accion) {
        case "login":
          LoginDao loginDao = new LoginDao();
          String login = request.getParameter("login");
          String password = request.getParameter("password");

          //consultar y retornar el password
          String passEncriptada = loginDao.obtenerPassword(login);
          System.out.println("Login.doPost(): ---------- " + passEncriptada);
          Encriptado encriptado = new Encriptado();
          
           {
            try {
              password = encriptado.encrypt(password);
            } catch (Exception ex) {
              ex.printStackTrace(System.out);
            }
          }
          if (login == null || password == null || !loginDao.autenticacion(login, password)) {
            response.sendRedirect("index.jsp");
          } else {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("nombre", login);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bienvenida.jsp");
            dispatcher.forward(request, response);
          }
          break;

        case "logout":
          this.logout(request, response);
          break;

      }
    }

  }

  private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession sesion = request.getSession(true);
    //Cerrar sesion
    sesion.invalidate();
    //Redirecciono a index.jsp -->login
    response.sendRedirect("index.jsp");

  }

}
