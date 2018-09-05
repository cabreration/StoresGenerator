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
    int llave;
    int codigo;
    String nombre;
    int cantidad;
    String marca;
    String color;
    int size;
    String imagen;
    int sucursal_tienda;
    
    //los productos pueden repetir su codigo si el codigo de sucursal es diferente

    public Producto(int llave, int codigo, String nombre, int cantidad, String marca, String color, int size, String imagen, int sucursal_tienda) {
        this.llave = llave;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.marca = marca;
        this.color = color;
        this.size = size;
        this.imagen = imagen;
        this.sucursal_tienda = sucursal_tienda;
    }
    

    public int getLlave() {
        return llave;
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

    public int getSize() {
        return size;
    }

    public String getImagen() {
        return imagen;
    }

    public int getSucursal_tienda() {
        return sucursal_tienda;
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

    public void setSize(int size) {
        this.size = size;
    }
}
