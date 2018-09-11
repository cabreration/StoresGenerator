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
import sgserver.DatosPersistentes;

/**
 *
 * @author Javier A. Cabrera
 */
public class TablaTiendas {
    
    public Hashtable<String, Tienda> tiendas;
    
    public TablaTiendas() 
    {
        tiendas = new Hashtable<>();
    }
    
    public boolean registrarTienda(Tienda tienda) throws Exception 
    {
        if (tiendas.get(String.valueOf(tienda.getCodigo())) != null)
            throw new Exception("Una tienda fue registrada ya con ese codigo");
        
        //chequear si el usuario propietario existe
        if (DatosPersistentes.usuarios.usuarios.get(String.valueOf(tienda.getUsuario_propietario())) == null)
            throw new Exception("No existe ningun usuario con el codigo de propietario especificado");
        
        tiendas.put(String.valueOf(tienda.getCodigo()), tienda);
        return true;
    }
    
    public boolean modificarTienda(Tienda datos) throws Exception 
    {
        Tienda aux = null;
        if ((aux = tiendas.get(String.valueOf(datos.getCodigo()))) == null)
            throw new Exception("No existe ninguna tienda con codigo " + datos.getCodigo());
       
        //if (ejecutor != datos.usuario_propietario) 
          //  throw new Exception("No puede realizar las modificaciones porque la tienda no le pertenece");
        
        if (datos.getDireccion() != null)
            aux.setDireccion(datos.getDireccion());
        if (datos.getNombre() != null)
            aux.setNombre(datos.getNombre());
        if (datos.getTelefono() >  -1)
            aux.setTelefono(datos.getTelefono());
        if (datos.getUsuario_propietario() > -1)
            aux.setUsuario(datos.getUsuario_propietario());
        
        return true;
    }
    
    public boolean eliminarTienda(int propietario, int codigo) throws Exception 
    {
        if (tiendas.get(String.valueOf(codigo)) ==  null)
            throw new Exception("No existe ninguna tienda con codigo " + codigo);
        
        if (DatosPersistentes.usuarios.usuarios.get(String.valueOf(propietario)) == null) 
            throw new Exception("No existe ningun usuario codigo " + propietario);
        
        if (tiendas.get(String.valueOf(codigo)).getUsuario_propietario() != propietario)
            throw new Exception("No puede eliminar esa tienda porque no es el propietario");
        
        tiendas.remove(String.valueOf(codigo));
        return true;
    }
    
    public String obtenerTiendas(int usuario) throws Exception 
    {
        if (this.tiendas.isEmpty()) throw new Exception("No hay tiendas registradas");
        
        ArrayList<Tienda> aux = new ArrayList<>();
  
        Set<String> llaves = this.tiendas.keySet();
        for (String llave : llaves) {
            if (this.tiendas.get(llave).getCodigo() == usuario)
                aux.add(this.tiendas.get(llave));
        }
        
        String respuesta = "$reply$ $lista$ ";
        for (Tienda store : aux) {
            respuesta += "$tienda$ $codigo$ " + store.getCodigo() + " $codigo-$" + " $propietario$ " + store.getUsuario_propietario() 
                    + " $propietario-$ $nombre$ \"" + store.getNombre() + "\" $nombre-$ $direccion$ \"" +store.getDireccion() + "\" $direccion-$"
                    + " $telefono$ " + store.getTelefono() + " $telefono-$ $tienda-$ ";
        }
        respuesta += " $lista-$ $reply-$"; 
        return respuesta;
    }
    
    public void escribirArchivo() throws IOException {
        if (this.tiendas.size() == 0) return;
        
        String escritura = " [ \n\t";
        
        ArrayList<Tienda> escritor = new ArrayList<>();
        
        Set<String> llaves = this.tiendas.keySet();
        for (String llave : llaves) {
            escritor.add(this.tiendas.get(String.valueOf(llave)));
        }
        
        int i;
        for (i = 0; i < escritor.size() - 1; i++) {
            Tienda aux = escritor.get(i);
            escritura += "{ \n \"codigo\": " + "\"" + aux.getCodigo() + "\", \n"
                    + "\"usuario_propietario\": " + "\"" + aux.getUsuario_propietario() + "\", \n"
                    + "\"nombre\": " + "\"" + aux.getNombre() + "\", \n"
                    + "\"direccion\": " + "\"" + aux.getDireccion() + "\", \n"
                    + "\"telefono\": " + "\"" + aux.getTelefono() + "\", \n"
                    + "\"imagen\": " + "\"" + aux.getImagen() + "\" \n }, \n";     
        }
        
        Tienda nu = escritor.get(i);
        escritura += "{ \n \"codigo\": " + "\"" + nu.getCodigo() + "\", \n"
                    + "\"usuario_propietario\": " + "\"" + nu.getUsuario_propietario() + "\", \n"
                    + "\"nombre\": " + "\"" + nu.getNombre() + "\", \n"
                    + "\"direccion\": " + "\"" + nu.getDireccion() + "\", \n"
                    + "\"telefono\": " + "\"" + nu.getTelefono() + "\", \n"
                    + "\"imagen\": " + "\"" + nu.getImagen() + "\" \n } \n"; 
        
        escritura += "]";
        
        Path path = Paths.get("Tiendas.txt");
        byte[] strToBytes = escritura.getBytes();
 
        Files.write(path, strToBytes);
    }
}
