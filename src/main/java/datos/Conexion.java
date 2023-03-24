/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author claug
 */
public class Conexion {

  private static Connection conn = null;
  private static String usuario = "IMAX";
  private static String password = "maxx2022";
  private static String url = "jdbc:oracle:thin:@localhost:1521:DIGBDDES";

  public static Connection conectar() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection(url, usuario, password);

      if (conn != null) {
        System.out.println("Conexion Exitosa");
      } else {
        System.out.println("Conexion es erronea");
      }

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace(System.out);
    }

    return conn;
  }

  public static void close(ResultSet rs) {
    try {
      rs.close();
    } catch (SQLException ex) {
      ex.printStackTrace(System.out);
    }
  }

  public static void close(PreparedStatement stmt) {
    try {
      stmt.close();
    } catch (SQLException ex) {
      ex.printStackTrace(System.out);
    }
  }

  public static void close(Connection conn) {
    try {
      conn.close();
    } catch (SQLException ex) {
      ex.printStackTrace(System.out);
    }
  }
}
