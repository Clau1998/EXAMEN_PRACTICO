/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author claug
 */
public class Usuario {

  private String login;
  private String password;
  private String nombre;
  private float cliente;
  private String email;
  private String fechaAlta;
  private Date fechaBaja;
  private String status;
  private float intentos;
  private String fechaRevocado;
  private String fechaVigencia;
  private float noAcceso;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private int area;
  private String fechaModificacion;

  public Usuario() {

  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public float getCliente() {
    return cliente;
  }

  public void setCliente(float cliente) {
    this.cliente = cliente;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  

  public float getIntentos() {
    return intentos;
  }

  public void setIntentos(float intentos) {
    this.intentos = intentos;
  }

  public String getFechaAlta() {
    return fechaAlta;
  }

  public void setFechaAlta(String fechaAlta) {
    this.fechaAlta = fechaAlta;
  }

  public Date getFechaBaja() {
    return fechaBaja;
  }

  public void setFechaBaja(Date fechaBaja) {
    this.fechaBaja = fechaBaja;
  }

  public String getFechaRevocado() {
    return fechaRevocado;
  }

  public void setFechaRevocado(String fechaRevocado) {
    this.fechaRevocado = fechaRevocado;
  }

  public String getFechaVigencia() {
    return fechaVigencia;
  }

  public void setFechaVigencia(String fechaVigencia) {
    this.fechaVigencia = fechaVigencia;
  }

  public float getNoAcceso() {
    return noAcceso;
  }

  public void setNoAcceso(float noAcceso) {
    this.noAcceso = noAcceso;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public String getFechaModificacion() {
    return fechaModificacion;
  }

  public void setFechaModificacion(String fechaModificacion) {
    this.fechaModificacion = fechaModificacion;
  }

  @Override
  public String toString() {
    return "Usuario{" + "login=" + login + ", password=" + password + ", nombre=" + nombre + ", cliente=" + cliente + ", email=" + email + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", status=" + status + ", intentos=" + intentos + ", fechaRevocado=" + fechaRevocado + ", fechaVigencia=" + fechaVigencia + ", noAcceso=" + noAcceso + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", area=" + area + ", fechaModificacion=" + fechaModificacion + '}';
  }

}
