/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
            throw new Exception("Un producto ya fue registrado con ese codigo");
        
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
        return true;
    }
    
    public boolean eliminarProducto(int codigo, int sucursal) throws Exception 
    {
        if (productos.get(String.valueOf(codigo) + "-" + String.valueOf(sucursal)) ==  null)
            throw new Exception("No existe ningun producto con codigo " + codigo + "en la sucursal " + sucursal);
        
        productos.remove(String.valueOf(codigo) + "-" + String.valueOf(sucursal));
        return true;
    }
    
    public ArrayList<Producto> obtenerProductos(int tienda) throws Exception 
    {
        if (this.productos.isEmpty()) throw new Exception("No hay tiendas registradas");
        
        ArrayList<Producto> aux = new ArrayList<>();
  
        Set<String> llaves = this.productos.keySet();
        for (String llave : llaves) {
            if (this.productos.get(llave).getSucursal_tienda() == tienda)
                aux.add(this.productos.get(llave));
        }
        
        return aux;
    }
}
