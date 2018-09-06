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
public class Tienda {
    int codigo;
    int usuario_propietario;
    String nombre;
    String direccion;
    int telefono;
    String imagen;

    public Tienda(int codigo, int usuario_propietario, String nombre, String direccion, int telefono, String imagen) {
        this.codigo = codigo;
        this.usuario_propietario = usuario_propietario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }
    
    public Tienda() {
        this.codigo = -1;
        this.usuario_propietario = -1;
        this.nombre = null;
        this.direccion = null;
        this.telefono = -1;
        this.imagen = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getUsuario_propietario() {
        return usuario_propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    } 
    
    public void setUsuario(int usuario) {
        this.usuario_propietario = usuario;
    }
}
