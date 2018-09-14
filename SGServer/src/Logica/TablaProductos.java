/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author Javier A. Cabrera
 */
public class TablaProductos {
    
    public Hashtable<String, Producto> productos;
    
    public TablaProductos() 
    {
        productos = new Hashtable<>();
    }
    
    public boolean insertarProducto(Producto producto) throws Exception 
    {
        if (productos == null) productos = new Hashtable<>();
        
        if (productos.get(String.valueOf(producto.getCodigo()) + "-" + String.valueOf(producto.getSucursal_tienda())) != null)
            throw new Exception("Un producto ya fue registrado con ese codigo en esa sucursal");
        
        //validar imagen aqui
        if (producto.getImagen() ==  null) {}
        
        if (producto.getCantidad() < 0) throw new Exception("Debe ingresar una cantidad");
        if (producto.getCodigo() < 0) throw new Exception("Debe ingresar un codigo");
        if (producto.getColor() == null) throw new Exception("Debe ingresar un color");
        if (producto.getMarca() == null) throw new Exception("Debe ingresar una marca");
        if (producto.getNombre() == null) throw new Exception("Debe ingresar un nombre");
        if (producto.getPrecio() < 0) throw new Exception("Debe ingresar un precio");
        if (producto.getSize() < 0) throw new Exception("Debe ingresar un tamanio");
        if (producto.getSucursal_tienda() < 0) throw new Exception("Debe ingresar una sucursal");
        
        productos.put(String.valueOf(producto.getCodigo()) + "-" + String.valueOf(producto.getSucursal_tienda()),
                producto);
        
        return true;
    }
    
    public boolean modificarProducto(Producto producto) throws Exception 
    {
        //Verificar si la tienda pertenece al usuario que esta realizando la peticion
        Producto aux = null;
        if ((aux = productos.get(String.valueOf(producto.getCodigo()) + "-" + String.valueOf(producto.getSucursal_tienda()))) == null)
            throw new Exception("Tal producto no ha sido registrado");
        
        if (producto.getImagen() != null) throw new Exception("Imposible modificar la imagen");
        
        if (producto.getCantidad() > -1)
            aux.setCantidad(producto.getCantidad());
        if (producto.getColor() != null)
            aux.setColor(producto.getColor());
        if (producto.getMarca() != null)
            aux.setMarca(producto.getMarca());
        if (producto.getNombre() != null)
            aux.setNombre(producto.getNombre());
        if (producto.getSize() > -1)
            aux.setSize(producto.getSize());
        if (producto.getPrecio() > -1)
            aux.setPrecio(producto.getPrecio());
        
        
        return true;
    }
    
    public boolean eliminarProducto(int codigo, int sucursal) throws Exception 
    {
        if (productos.get(String.valueOf(codigo) + "-" + String.valueOf(sucursal)) ==  null)
            throw new Exception("No existe ningun producto con codigo " + codigo + "en la sucursal " + sucursal);
        
        productos.remove(String.valueOf(codigo) + "-" + String.valueOf(sucursal));
        return true;
    }
    
    public String obtenerProductos(int tienda) throws Exception 
    {
        if (this.productos.isEmpty()) throw new Exception("No hay tiendas registradas");
        
        ArrayList<Producto> aux = new ArrayList<>();
  
        Set<String> llaves = this.productos.keySet();
        for (String llave : llaves) {
            if (this.productos.get(llave).getSucursal_tienda() == tienda)
                aux.add(this.productos.get(llave));
        }
        
        String respuesta = " $reply$ $lista$ ";
        for (Producto prod : aux) {
            respuesta += "$producto$ $codigo$ " + prod.getCodigo() + " $codigo-$ $nombre$ \"" + prod.getNombre() + "\" $nombre-$"
                    + " $cantidad$ " + prod.getCantidad() + " $cantidad-$ $marca$ \"" + prod.getMarca() + "\" $marca-$ $color$ \""
                    + prod.getColor() + "\" $color-$ $tamaño$ " + prod.getSize() + "$tamaño-$ $sucursal " + prod.getSucursal_tienda()
                    + " $sucursal-$ $producto-$"; 
        }
        respuesta += " $lista-$ $reply-$";
        return null;
    }
    
    public void escribirArchivo() throws IOException {
        if (this.productos.size() == 0) return;
        
        String escritura = " [ \n\t";
        
        ArrayList<Producto> escritor = new ArrayList<>();
        
        Set<String> llaves = this.productos.keySet();
        for (String llave : llaves) {
            escritor.add(this.productos.get(String.valueOf(llave)));
        }
        
        int i;
        for (i = 0; i < escritor.size() - 1; i++) {
            Producto aux = escritor.get(i);
            escritura += "{ \n \"codigo\": " + aux.getCodigo() + ", \n"
                    + "\"nombre\": " + "\"" + aux.getNombre() + "\", \n"
                    + "\"cantidad\": " + aux.getCantidad() + ", \n"
                    + "\"marca\": " + "\"" + aux.getMarca() + "\", \n"
                    + "\"color\": " + "\"" + aux.getColor() + "\", \n"
                    + "\"size\": " +  aux.getSize() + ", \n"
                    + "\"imagen\": " + "\"" + aux.getImagen() + "\",  \n"
                    + "\"sucursal_tienda\": " + aux.getSucursal_tienda() + ", \n"
                    + "\"producto\": " + aux.getPrecio() + " \n }, \n";
        }
        
        Producto nu = escritor.get(i);
        escritura += "{ \n \"codigo\": " + nu.getCodigo() + ", \n"
                    + "\"nombre\": " + "\"" + nu.getNombre() + "\", \n"
                    + "\"cantidad\": " + nu.getCantidad() + ", \n"
                    + "\"marca\": " + "\"" + nu.getMarca() + "\", \n"
                    + "\"color\": " + "\"" + nu.getColor() + "\", \n"
                    + "\"size\": " + + nu.getSize() + ", \n"
                    + "\"imagen\": " + "\"" + nu.getImagen() + "\",  \n"
                    + "\"sucursal_tienda\": " + nu.getSucursal_tienda() + ", \n"
                    + "\"precio\": " + nu.getPrecio() + " \n } \n";
        
        escritura += "]";
        
        Path path = Paths.get("Productos.txt");
        byte[] strToBytes = escritura.getBytes();
 
        Files.write(path, strToBytes);
    }
}
