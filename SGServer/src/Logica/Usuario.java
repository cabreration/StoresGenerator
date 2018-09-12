/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Javier A. Cabrera
 */
public class Usuario {
    private int identificador;
    private String nombre;
    private String apellido;
    private String password;
    private int telefono;
    private String email;
    private String direccion;

    public Usuario(int identificador, String nombre, String apellido, String password, int telefono, String email, String direccion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }
    
    public Usuario() 
    {
        identificador = -1;
        nombre = null;
        apellido = null;
        password = null;
        telefono = -1;
        email = null;
        direccion = null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    public void arreglar() 
    {
        this.nombre = this.nombre.substring(1, this.nombre.length()-1);
        this.apellido = this.apellido.substring(1, this.apellido.length()-1);
        this.direccion = this.direccion.substring(1, this.direccion.length()-1);
        this.password = this.password.substring(1, this.password.length()-1);
    }
    
}
