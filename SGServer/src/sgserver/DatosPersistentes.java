/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgserver;

import FGrammar.ErrorC;
import Logica.Producto;
import Logica.TablaProductos;
import Logica.TablaTiendas;
import Logica.TablaUsuarios;
import Logica.Tienda;
import Logica.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Javier A. Cabrera
 */
public class DatosPersistentes {
    public static TablaUsuarios usuarios;
    public static TablaTiendas tiendas;
    public static TablaProductos productos;
    public static GUI interfaz;
    public static ArrayList<ErrorC> lexicos;
    public static ArrayList<ErrorC> semanticos;
    public static ArrayList<ErrorC> sintacticos;
    
    public static void cargarUsuarios() {  
        DatosPersistentes.usuarios = new TablaUsuarios();
        String json = "";
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Usuarios.txt"));
            StringBuilder builder = new StringBuilder();
            String currentLine = lector.readLine();
            while (currentLine != null) {
                builder.append(currentLine);
                currentLine = lector.readLine();
            }
            lector.close();
            
            json = builder.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
            return;
        }
        
        try {
            if (json.equals("") || json == null) return;
            
            JSONArray arregloUsuarios = new JSONArray(json);
            for (int i = 0; i < arregloUsuarios.length(); i++) {
                JSONObject obj = arregloUsuarios.getJSONObject(i);
                Usuario temp = new Usuario();
                temp.setIdentificador(obj.getInt("identificador"));
                temp.setNombre(obj.getString("nombre"));
                temp.setApellido(obj.getString("apellido"));
                temp.setPassword(obj.getString("password"));
                temp.setTelefono(obj.getInt("telefono"));
                temp.setEmail(obj.getString("email"));
                if (obj.get("direccion") != JSONObject.NULL)
                    temp.setDireccion(obj.getString("direccion"));
                
                DatosPersistentes.usuarios.agregarUsuario(temp);
            }
        }
        catch(Exception e) 
        {
            System.out.println("Imposible realizar la carga de usuarios");
            e.printStackTrace();
        }
    }
    
    public static void cargarTiendas() {
        DatosPersistentes.tiendas = new TablaTiendas();
        String json = "";
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Tiendas.txt"));
            StringBuilder builder = new StringBuilder();
            String currentLine = lector.readLine();
            while (currentLine != null) {
                builder.append(currentLine);
                currentLine = lector.readLine();
            }
            lector.close();
            
            json = builder.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
            return;
        }
        
        try {
            if (json.equals("") || json == null) return;
            
            JSONArray arregloTiendas = new JSONArray(json);
            for (int i = 0; i < arregloTiendas.length(); i++) {
                JSONObject obj = arregloTiendas.getJSONObject(i);
                Tienda temp = new Tienda();
                temp.setCodigo(obj.getInt("codigo"));
                temp.setUsuario_propietario(obj.getInt("usuario_propietario"));
                temp.setDireccion(obj.getString("direccion"));
                temp.setNombre(obj.getString("nombre"));
                temp.setTelefono(obj.getInt("telefono"));
                temp.setImagen(obj.getString("imagen"));
                
                DatosPersistentes.tiendas.registrarTienda(temp);
            }
        }
        catch(Exception e) 
        {
            System.out.println("Imposible realizar la carga de tiendas");
            e.printStackTrace();
        }
    }
    
    public static void cargarProductos() {
        DatosPersistentes.productos = new TablaProductos();
        String json = "";
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Productos.txt"));
            StringBuilder builder = new StringBuilder();
            String currentLine = lector.readLine();
            while (currentLine != null) {
                builder.append(currentLine);
                currentLine = lector.readLine();
            }
            lector.close();
            
            json = builder.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
            return;
        }
        
        try {
            if (json.equals("") || json == null) return;
            
            JSONArray arregloProductos = new JSONArray(json);
            for (int i = 0; i < arregloProductos.length(); i++) {
                JSONObject obj = arregloProductos.getJSONObject(i);
                Producto temp = new Producto();
                temp.setCodigo(obj.getInt("codigo"));
                temp.setNombre(obj.getString("nombre"));
                temp.setCantidad(obj.getInt("cantidad"));
                temp.setColor(obj.getString("color"));
                temp.setImagen(obj.getString("imagen"));
                temp.setMarca(obj.getString("marca"));
                temp.setSize(obj.getDouble("size"));
                temp.setSucursal_tienda(obj.getInt("sucursal_tienda"));
                temp.setPrecio(obj.getDouble("precio"));
                
                DatosPersistentes.productos.insertarProducto(temp);
            }
        }
        catch(Exception e) 
        {
            System.out.println("Imposible realizar la carga de productos");
            e.printStackTrace();
        }
    }
}
