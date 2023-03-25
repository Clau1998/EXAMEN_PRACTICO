/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author claug
 */
public class Encriptado {

  public String encrypt(String password) throws Exception {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hash = md.digest(password.getBytes("UTF-8"));
    String encodedHash = Base64.getEncoder().encodeToString(hash);
    return encodedHash;
  }

  /**
   * 
   * @param password contraseña que se usa para loguearse
   * @param hash contraseña hass guardada en la bd
   * @return 
   */
  public boolean verify(String password, String hash) {
    try {
      String passwordHash = encrypt(password);
      return passwordHash.equals(hash);
    } catch (Exception e) {
      System.out.println(e.getMessage());

    }
    return false;

  }

}
