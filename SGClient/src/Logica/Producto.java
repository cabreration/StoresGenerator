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
public class Producto {
    int codigo;
    String nombre;
    int cantidad;
    String marca;
    String color;
    double size;
    String imagen;
    int sucursal_tienda;
    double precio;
    
    public Producto() 
    {
        codigo = -1;
        nombre = null;
        cantidad = -1;
        marca = null;
        color = null;
        size = -1;
        imagen = null;
        sucursal_tienda = -1;
        precio = -1;
    }

    public Producto(int codigo, String nombre, int cantidad, String marca, String color, double size, String imagen, int sucursal_tienda, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.marca = marca;
        this.color = color;
        this.size = size;
        this.imagen = imagen;
        this.sucursal_tienda = sucursal_tienda;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }

    public String getImagen() {
        return imagen;
    }

    public int getSucursal_tienda() {
        return sucursal_tienda;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setSucursal_tienda(int sucursal_tienda) {
        this.sucursal_tienda = sucursal_tienda;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
