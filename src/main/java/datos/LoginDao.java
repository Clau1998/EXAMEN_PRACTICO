/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author claug
 */
public class LoginDao {

  static Conexion conexion = new Conexion();

  public boolean autenticacion(String login, String password) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String cadena_sql = "SELECT * FROM USUARIO U WHERE U.LOGIN=? AND PASSWORD=?";
    try {
      conn = Conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, login);
      stmt.setString(2, password);
      rs = stmt.executeQuery();

      if (rs.next()) {
        return true;
      }

    } catch (SQLException e) {
      e.printStackTrace(System.out);
    } finally {
      Conexion.close(rs);
      Conexion.close(stmt);
      Conexion.close(conn);
    }
    return false;
  }

  public String obtenerPassword(String login) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String cadena_sql = "SELECT PASSWORD FROM USUARIO WHERE LOGIN=?";
    try {
      conn = Conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, login);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.out);
    }

    return login;
  }

}
