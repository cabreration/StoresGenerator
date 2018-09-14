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
public class Peticiones {
    
    
    public static String logIn(String codigo, String password) {
        
        return "$request$ $inicioUsuario$ $id$ " + codigo + " $id-$ $password$ " + password + " $password-$ "
                + " $inicioUsuario-$ $request-$";
    }
    
    public static String crearTienda( String codigo, String propietario,
        String nombre, String direccion, String telefono, String imagen) {
        
        return "$request$ $tienda tipo = \"crear\"$ $codigo$ " + codigo + " $codigo-$ $propietario$ " + propietario + " $propietario-$"
                + " $nombre$ \"" + nombre + "\" $nombre-$ $direccion$ \"" + direccion + "\" $direccion-$ $telefono$ " + telefono
                + " $telefono-$ $img$ \"" + imagen + "\" $img-$ $tienda-$ $request-$";
    }
    
    public static String modificarTienda(String codigo, String propietario,
            String nombre, String direccion, String telefono) {
        
        return "$request$ $tienda tipo = \"modificacion\", codigo = " + codigo + ", propietario = " + propietario 
                + ", nombre = \"" + nombre + "\", direccion = \"" + direccion + "\", telefono = " + telefono
                + " -$ $request-$";
    }
    
    public static String eliminarTienda(String codigo, String propietario) {
        
        return "$request$ $tienda tipo = \"eliminar\", codigo = " + codigo + ", propietario = " + propietario + "-$ $request-$";
    }
    
    public static String registrarProducto(String codigo, String nombre, String cantidad,
            String marca, String color, String tamanio, String imagen, String sucursal) {
        
        return "$request$ $producto tipo = \"crear\"$ $codigo$ " + codigo + "codigo-$ $nombre$ \"" + nombre + "\" $nombre-$ "
                + "$marca$ \"" + marca + "\" $marca-$ $color$ \"" + color  + "\" $color-$ $tamaño$ " + tamanio + " $tamaño-$"
                + " $img$ \"" + imagen + "\" $img-$ $sucursal$ " + sucursal + "$sucursal-$ $producto-$ $request-$";
    }
    
    public static String modificarProducto(String codigo, String nombre, String cantidad,
            String marca, String color, String tamanio, String sucursal) {
        
        return "$request$ $producto = \"modificar\", codigo = " + codigo + ", nombre = \"" + nombre + "\", cantidad = "
            + cantidad + ", marca = \"" + marca + "\", tamaño = " + tamanio + ", sucursal = " + sucursal + "-$ $request-$";
    }
    
    public static String eliminarProducto(String codigo, String sucursal) {
        
        return "$request$ $producto = \"eliminar\", codigo = " + codigo + ", sucursal = " + sucursal + "-$ $request-$";
    }
    
    
}
