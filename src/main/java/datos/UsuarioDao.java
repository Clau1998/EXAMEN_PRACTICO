/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claug
 */
public class UsuarioDao {

  static Conexion conexion = new Conexion();

  public List<Usuario> listar(String status) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Usuario> usuarios = new ArrayList<>();

    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement("SELECT u.nombre || ' ' || u.apellido_paterno AS nombre, u.login, TO_CHAR(u.fecha_alta, 'DD/MM/YYYY') AS fecha_alta, status FROM USUARIO u WHERE u.status='" + status + "'");
      rs = stmt.executeQuery();

      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setNombre(rs.getString("nombre"));
        usuario.setLogin(rs.getString("login"));
        usuario.setStatus(rs.getString("status"));
        usuario.setFechaAlta(rs.getString("fecha_alta"));
        usuarios.add(usuario);
      }

    } catch (SQLException e) {
      e.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(rs);
      conexion.close(conn);

    }

    return usuarios;
  }

  public int insertar(Usuario usuario) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    String cadena_sql = "INSERT INTO USUARIO  VALUES(?,?,?,?,?,SYSDATE,NULL,'A',0,NULL,SYSDATE +7,0,?,?,?,SYSDATE)";

    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);

      stmt.setString(1, usuario.getLogin());
      stmt.setString(2, usuario.getPassword());
      stmt.setString(3, usuario.getNombre());
      stmt.setFloat(4, usuario.getCliente());
      stmt.setString(5, usuario.getEmail());
      stmt.setString(6, usuario.getApellidoPaterno());
      stmt.setString(7, usuario.getApellidoMaterno());
      stmt.setInt(8, usuario.getArea());

      rows = stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(conn);
    }
    return rows;
  }

  public String isExist(String login) {
    String cadena_sql = "SELECT LOGIN FROM USUARIO WHERE LOGIN=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, login);
      rs = stmt.executeQuery();
      
      if (rs.next()) {
        return rs.getString(1);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());

    } finally {
      conexion.close(stmt);
      conexion.close(rs);
    }

    return null;
  }

  public Usuario buscar(Usuario usuario) {
    String cadena_sql = "SELECT login,nombre,apellido_paterno,apellido_materno,fecha_baja FROM USUARIO WHERE login=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, usuario.getLogin());
      rs = stmt.executeQuery();
      while (rs.next()) {
        usuario.setLogin(rs.getString("login"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellidoPaterno(rs.getString("apellido_paterno"));
        usuario.setApellidoMaterno(rs.getString("apellido_materno"));
        usuario.setFechaBaja(rs.getDate("fecha_Baja"));

      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(rs);
      conexion.close(conn);

    }
    return usuario;
  }

  public int bajaUsuario(Usuario usuario) {

    String cadena_sql = "UPDATE USUARIO SET status='B',fecha_modificacion=SYSDATE, fecha_baja=SYSDATE WHERE login=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, usuario.getLogin());
      rows = stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(conn);
    }
    return rows;

  }

  public int altaUsuario(Usuario usuario) {
    String cadena_sql = "UPDATE USUARIO SET status='A',fecha_modificacion=SYSDATE, fecha_baja=SYSDATE WHERE login=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, usuario.getLogin());
      rows = stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(conn);
    }
    return rows;

  }

  public Usuario encontrarUsuario(Usuario usuario) {
    String cadena_sql = "SELECT login,nombre,apellido_paterno,apellido_materno,email,password,fecha_baja,cliente, area FROM USUARIO WHERE login=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, usuario.getLogin());
      rs = stmt.executeQuery();
      while (rs.next()) {
        usuario.setLogin(rs.getString("login"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellidoPaterno(rs.getString("apellido_paterno"));
        usuario.setApellidoMaterno(rs.getString("apellido_materno"));
        usuario.setEmail(rs.getString("email"));
        usuario.setPassword(rs.getString("password"));
        usuario.setFechaBaja(rs.getDate("fecha_Baja"));
        usuario.setCliente(rs.getFloat("cliente"));
        usuario.setArea(rs.getInt("area"));

      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(rs);
      conexion.close(conn);

    }
    return usuario;
  }

  public int actualizar(Usuario usuario) {
    String cadena_sql = "UPDATE USUARIO u SET u.nombre=?, u.apellido_paterno=?, u.apellido_materno=?, u.password=?,u.email=?, u.cliente=?,u.area=? WHERE u.login=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
      conn = Conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      stmt.setString(1, usuario.getNombre());
      stmt.setString(2, usuario.getApellidoPaterno());
      stmt.setString(3, usuario.getApellidoMaterno());
      stmt.setString(4, usuario.getPassword());
      stmt.setString(5, usuario.getEmail());
      stmt.setFloat(6, usuario.getCliente());
      stmt.setInt(7, usuario.getArea());
      stmt.setString(8, usuario.getLogin());

      rows = stmt.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace(System.out);
    } finally {
      conexion.close(stmt);
      conexion.close(conn);

    }
    return rows;

  }

  public List<Usuario> buscarPorNombre(String nombre) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Usuario> usuarios = new ArrayList<>();
    String cadena_sql = "SELECT nombre, login, TO_CHAR(fecha_alta, 'DD/MM/YYYY') AS fecha_alta, status FROM USUARIO WHERE LOWER(nombre) LIKE LOWER('%" + nombre + "%')";
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      rs = stmt.executeQuery();

      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setNombre(rs.getString("nombre"));
        usuario.setLogin(rs.getString("login"));
        usuario.setFechaAlta(rs.getString("fecha_alta"));
        usuario.setStatus(rs.getString("status"));
        usuarios.add(usuario);
      }

    } catch (SQLException e) {
      e.printStackTrace(System.out);

    } finally {
      conexion.close(stmt);
      conexion.close(rs);
      conexion.close(conn);

    }
    return usuarios;
  }

  public List<Usuario> buscar_por_fecha(String fechaAlta, String fechaFinal) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Usuario> usuarios = new ArrayList<>();
    String cadena_sql = "SELECT nombre || ' ' || apellido_paterno AS nombre, login, TO_CHAR(fecha_alta, 'DD/MM/YYYY') AS fecha_alta,status FROM USUARIO WHERE FECHA_ALTA BETWEEN to_date('" + fechaAlta.trim() + "', 'YYYY-MM-DD') AND to_date('" + fechaFinal.trim() + "', 'YYYY-MM-DD')+1";
    try {
      conn = conexion.conectar();
      stmt = conn.prepareStatement(cadena_sql);
      rs = stmt.executeQuery();

      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setNombre(rs.getString("nombre"));
        usuario.setLogin(rs.getString("login"));
        usuario.setFechaAlta(rs.getString("fecha_alta"));
        usuario.setStatus(rs.getString("status"));
        usuarios.add(usuario);
      }

    } catch (SQLException e) {
      e.printStackTrace(System.out);

    } finally {
      conexion.close(stmt);
      conexion.close(rs);
      conexion.close(conn);
    }

    return usuarios;
  }

}
