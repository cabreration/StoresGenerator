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
                    + prod.getColor() + "\" $color-$ $tamaño$ " + prod.getSize() + " $tamaño-$ $sucursal$ " + prod.getSucursal_tienda()
                    + " $sucursal-$ $precio$ " + prod.getPrecio() + " $precio-$ $producto-$ \n"; 
        }
        respuesta += " $lista-$ $reply-$";
        return respuesta;
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
                    + "\"precio\": " + aux.getPrecio() + " \n }, \n";
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
    
    public ArrayList<Producto> modoLista() {
        ArrayList<Producto> satisfactorios = new ArrayList<>();
        
        Set<String> llaves = this.productos.keySet();
        for (String llave : llaves) {
            satisfactorios.add(this.productos.get(String.valueOf(llave)));
        }
        return satisfactorios;
    }
    
    public String consultar(Condicion condicion) throws Exception {
    
        ArrayList<Producto> total = consultar(condicion, this.modoLista());
        
        String respuesta = "";
        for (Producto prod: total) {
            respuesta += ">> Codigo: " + prod.getCodigo() + " - Nombre: " + prod.getNombre() 
                    + " - Cantidad: " + prod.getCantidad() + " - Marca: " + prod.getMarca()
                    + " - Color: " + prod.getColor() + " - Tamanio: " + String.valueOf(prod.getSize())
                    + " - Sucursal: " + prod.getSucursal_tienda() + " - Precio: " + String.valueOf(prod.getPrecio())
                    + " - Imagen: " + prod.getImagen() + "\n";
        }
        return respuesta;
    }
    
    public String extraerCompleta() {
        ArrayList<Producto> todos = this.modoLista();
        String respuesta = "";
        for (Producto prod: todos) {
            respuesta += ">> Codigo: " + prod.getCodigo() + " - Nombre: " + prod.getNombre() 
                    + " - Cantidad: " + prod.getCantidad() + " - Marca: " + prod.getMarca()
                    + " - Color: " + prod.getColor() + " - Tamanio: " + String.valueOf(prod.getSize())
                    + " - Sucursal: " + prod.getSucursal_tienda() + " - Precio: " + String.valueOf(prod.getPrecio())
                    + " - Imagen: " + prod.getImagen() + "\n";
        }
        return respuesta;
    }
    
    public ArrayList<Producto> consultar(Condicion condicion, ArrayList<Producto> actuales) throws Exception {
        if ((condicion.tipo == 1 || condicion.tipo == 3 || condicion.tipo == 4 || condicion.tipo == 7 || condicion.tipo == 10
                || condicion.tipo == 12 || condicion.tipo == 14) && condicion.valor != null)
                condicion.valor = (String.valueOf(condicion.valor)).substring(1, (String.valueOf(condicion.valor)).length()-1);
        ArrayList<Producto> resultado = new ArrayList<>();
        
        if (condicion.operacion == 1) {
            return conjuncion(condicion, actuales);
        }
        else if (condicion.operacion == 2) {
            return disyuncion(condicion, actuales);
        }
        else if (condicion.operacion == 3) {
            return negacion(condicion, actuales);
        }
        else {
            for (Producto prod: actuales) {
                //si se cumple la condicion entonces lo agrego a la lista que voy a devolver;
                switch(condicion.tipo) {
                    case 1:
                        if (condicion.valor == null) throw new Exception("Los nombres nunca seran vacios");
                        if (prod.getNombre().equals(String.valueOf(condicion.valor)))
                            resultado.add(prod);
                        break;
                    case 8:
                        if (condicion.valor == null) throw new Exception ("Los codigos nunca seran nulos");
                        if (prod.getCodigo() == (int)condicion.valor)
                            resultado.add(prod);
                        break;
                    case 11:
                        if (condicion.valor == null) throw new Exception("Las cantidades nunca seran vacias");
                        if (prod.getCantidad() == (int)condicion.valor)
                            resultado.add(prod);
                        break;
                    case 12:
                        if (condicion.valor == null) throw new Exception("Las marcas nunca seran vacias");
                        if (prod.getMarca().equals(String.valueOf(condicion.valor)))
                            resultado.add(prod);
                        break;
                    case 14:
                        if (condicion.valor == null) throw new Exception("Los colores nunca seran vacios");
                        else if (prod.getColor().equals(String.valueOf(condicion.valor)))
                            resultado.add(prod);
                        break;
                    case 13:
                        if (condicion.valor == null) throw new Exception("Los tamanios nunca seran vacios");
                        if (prod.getSize() == (double)condicion.valor);
                            resultado.add(prod);
                        break;
                    case 15:
                        if (condicion.valor == null) throw new Exception("Las sucursales nunca seran vacias");
                        else if (prod.getSucursal_tienda() == (int)condicion.valor)
                            resultado.add(prod);
                        break;
                    case 16:
                        if (condicion.valor == null) throw new Exception("Los precios nunca seran vacios");
                        else if (prod.getPrecio() == (double)condicion.valor);
                            resultado.add(prod);
                    default:
                        throw new Exception("El atributo no pertenece a la tabla \"Usuarios\"");
                }
            }
        }
        
        return resultado;
    }
    
    public ArrayList<Producto> negacion(Condicion condicion, ArrayList<Producto> actuales) throws Exception {
        
        ArrayList<Producto> base = consultar(condicion.hijo, actuales);
        ArrayList<Producto> respuesta = new ArrayList<>();
        boolean flag = false;
        
        for (Producto prod: actuales) {
            for (Producto prod2: base) {
                if (prod.getCodigo() == prod2.getCodigo() 
                        && prod.getSucursal_tienda() == prod2.getSucursal_tienda())
                    flag = true;
            }
            if (!flag) respuesta.add(prod);
            else flag = false;
        }
        
        return respuesta;
    }
    
    public ArrayList<Producto> conjuncion(Condicion condicion, ArrayList<Producto> actuales) throws Exception {
        
        ArrayList<Producto> base = consultar(condicion.hijo, actuales);
        ArrayList<Producto> base2 = consultar(condicion.hijo.hermano, base);
        return base2;
    }
    
    public ArrayList<Producto> disyuncion(Condicion condicion, ArrayList<Producto> actuales) throws Exception {
        
        ArrayList<Producto> base = consultar(condicion.hijo, actuales);
        ArrayList<Producto> complemento = new ArrayList<>();
        
        boolean flag = false;
        for (Producto us: actuales) {
            for (Producto us2: base) {
                if (us.getCodigo() == us2.getCodigo()
                        && us.getSucursal_tienda() == us2.getSucursal_tienda())
                    flag = true;
            }
            if (!flag) complemento.add(us);
            else flag = false;
        }
        
        ArrayList<Producto> semi_respuesta = consultar(condicion.hijo.hermano, complemento);
        ArrayList<Producto> respuesta = new ArrayList<>();
        
        for (Producto us: base) {
            respuesta.add(us);
        }
        
        for (Producto us: semi_respuesta)
            respuesta.add(us);
        
        return respuesta;
    }
}
