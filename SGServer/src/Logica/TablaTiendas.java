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
public class TablaTiendas {
    
    public Hashtable<String, Tienda> tiendas;
    
    public TablaTiendas() 
    {
        tiendas = new Hashtable<>();
    }
    
    public boolean registrarTienda(Tienda tienda) throws Exception 
    {
        if (tiendas.get(String.valueOf(tienda.getCodigo())) != null)
            throw new Exception("La tienda ya existe");
        
        tiendas.put(String.valueOf(tienda.getCodigo()), tienda);
        return true;
    }
    
    public boolean modificarTienda(Tienda datos, int ejecutor) throws Exception 
    {
        Tienda aux = null;
        if ((aux = tiendas.get(String.valueOf(datos.getCodigo()))) == null)
            throw new Exception("No existe ninguna tienda con codigo " + datos.getCodigo());
       
        if (ejecutor != datos.usuario_propietario) 
            throw new Exception("No puede realizar las modificaciones porque la tienda no le pertenece");
        
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
        
        if (tiendas.get(String.valueOf(codigo)).getUsuario_propietario() != propietario)
            throw new Exception("No puede eliminar esa tienda porque no es el propietario");
        
        tiendas.remove(String.valueOf(codigo));
        return true;
    }
    
    public ArrayList<Tienda> obtenerTiendas(int usuario) throws Exception 
    {
        if (this.tiendas.isEmpty()) throw new Exception("No hay tiendas registradas");
        
        ArrayList<Tienda> aux = new ArrayList<>();
  
        Set<String> llaves = this.tiendas.keySet();
        for (String llave : llaves) {
            if (this.tiendas.get(llave).getCodigo() == usuario)
                aux.add(this.tiendas.get(llave));
        }
        
        return aux;
    }
}
