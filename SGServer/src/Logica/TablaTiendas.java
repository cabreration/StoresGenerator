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
        
        if (tienda.getImagen() == null) {} //asignarle una imagen por defecto
        
        if (tienda.getCodigo() < 0) throw new Exception("Debe ingresar un codigo para registrar la tienda");
        if (tienda.getDireccion() == null) throw new Exception("Debe ingresar una direccion");
        if (tienda.getNombre() == null) throw new Exception("Debe ingresar un nombre");
        if (tienda.getUsuario_propietario() < 0) throw new Exception("Debe ingresar un codigo de propietario");
        if (tienda.getTelefono() < 0) throw new Exception("Debe ingresar un numero telefonico");
        
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
            aux.setUsuario_propietario(datos.getUsuario_propietario());
        
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
            if (this.tiendas.get(llave).getUsuario_propietario() == usuario)
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
            escritura += "{ \n \"codigo\": " + aux.getCodigo() + ", \n"
                    + "\"usuario_propietario\": " + aux.getUsuario_propietario() + ", \n"
                    + "\"nombre\": " + "\"" + aux.getNombre() + "\", \n"
                    + "\"direccion\": " + "\"" + aux.getDireccion() + "\", \n"
                    + "\"telefono\": " + aux.getTelefono() + ", \n"
                    + "\"imagen\": " + "\"" + aux.getImagen() + "\" \n }, \n";     
        }
        
        Tienda nu = escritor.get(i);
        escritura += "{ \n \"codigo\": " + nu.getCodigo() + ", \n"
                    + "\"usuario_propietario\": " + nu.getUsuario_propietario() + ", \n"
                    + "\"nombre\": " + "\"" + nu.getNombre() + "\", \n"
                    + "\"direccion\": " + "\"" + nu.getDireccion() + "\", \n"
                    + "\"telefono\": " + nu.getTelefono() + ", \n"
                    + "\"imagen\": " + "\"" + nu.getImagen() + "\" \n } \n"; 
        
        escritura += "]";
        
        Path path = Paths.get("Tiendas.txt");
        byte[] strToBytes = escritura.getBytes();
 
        Files.write(path, strToBytes);
    }
    
    public ArrayList<Tienda> modoLista() {
        ArrayList<Tienda> satisfactorios = new ArrayList<>();
        
        Set<String> llaves = this.tiendas.keySet();
        for (String llave : llaves) {
            satisfactorios.add(this.tiendas.get(String.valueOf(llave)));
        }
        return satisfactorios;
    }
    
    public String consultar(Condicion condicion) throws Exception {
    
        ArrayList<Tienda> total = consultar(condicion, this.modoLista());
        
        String respuesta = "";
        for (Tienda st: total) {
            respuesta += ">> Codigo: " + st.getCodigo() + " - Propietario: " + st.getUsuario_propietario()
                    + " - Nombre: " + st.getNombre() + " - Direccion: " + st.getDireccion() 
                    + " - Telefono: " + st.getTelefono() + " - Imagen: " + st.getImagen() + "\n";
        }
        respuesta += "\n";
        return respuesta;
    }
    
    public String extraerCompleta() {
        ArrayList<Tienda> todas = this.modoLista();
        String respuesta = "";
        for (Tienda st: todas) {
            respuesta += ">> Codigo: " + st.getCodigo() + " - Propietario: " + st.getUsuario_propietario()
                    + " - Nombre: " + st.getNombre() + " - Direccion: " + st.getDireccion() 
                    + " - Telefono: " + st.getTelefono() + " - Imagen: " + st.getImagen() + "\n";
        }
        return respuesta;
    }
    
    public ArrayList<Tienda> consultar(Condicion condicion, ArrayList<Tienda> actuales) throws Exception {
        if ((condicion.tipo == 1 || condicion.tipo == 3 || condicion.tipo == 4 || condicion.tipo == 7 || condicion.tipo == 10
                || condicion.tipo == 12 || condicion.tipo == 14) && condicion.valor != null)
                condicion.valor = (String.valueOf(condicion.valor)).substring(1, (String.valueOf(condicion.valor)).length()-1);
        
        ArrayList<Tienda> resultado = new ArrayList<>();
        
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
            for (Tienda store: actuales) {
                //si se cumple la condicion entonces lo agrego a la lista que voy a devolver;
                switch(condicion.tipo) {
                    case 1:
                        if (condicion.valor == null) throw new Exception("Los nombres nunca seran vacios");
                        if (store.getNombre().equals(String.valueOf(condicion.valor)))
                            resultado.add(store);
                        break;
                    case 8:
                        if (condicion.valor == null) throw new Exception ("Los identificadores nunca seran nulos");
                        if (store.getCodigo() == (int)condicion.valor)
                            resultado.add(store);
                        break;
                    case 9:
                        if (condicion.valor == null) throw new Exception("Las propietarios nunca seran vacias");
                        if (store.getUsuario_propietario() == (int)condicion.valor)
                            resultado.add(store);
                        break;
                    case 7:
                        if (condicion.valor == null) throw new Exception("Las direcciones de las tiendas nunca seran vacios");
                        if (store.getDireccion().equals(String.valueOf(condicion.valor)))
                            resultado.add(store);
                        break;
                    case 5:
                        if (condicion.valor == null && store.getTelefono() == -1)
                            resultado.add(store);
                        else if (store.getTelefono() == (int)condicion.valor)
                            resultado.add(store);
                        break;
                    case 6:
                        if (condicion.valor == null) throw new Exception("Las imagenes nunca seran vacias");
                        if (store.getImagen().equals((String.valueOf(condicion.valor))))
                            resultado.add(store);
                        break;
                    default:
                        throw new Exception("El atributo no pertenece a la tabla \"Tiendas\"");
                }
            }
        }
        
        return resultado;
    }
    
    public ArrayList<Tienda> negacion(Condicion condicion, ArrayList<Tienda> actuales) throws Exception {
        ArrayList<Tienda> base = consultar(condicion.hijo, actuales);
        ArrayList<Tienda> respuesta = new ArrayList<>();
        boolean flag = false;
        
        for (Tienda store: actuales) {
            for (Tienda store2: base) {
                if (store.getCodigo() == store2.getCodigo())
                    flag = true;
            }
            if (!flag) respuesta.add(store);
            else flag = false;
        }
        
        return respuesta;
    }
    
    public ArrayList<Tienda> conjuncion(Condicion condicion, ArrayList<Tienda> actuales) throws Exception {
        ArrayList<Tienda> base = consultar(condicion.hijo, actuales);
        ArrayList<Tienda> base2 = consultar(condicion.hijo.hermano, base);
        return base2;
    }
    
    public ArrayList<Tienda> disyuncion(Condicion condicion, ArrayList<Tienda> actuales) throws Exception {
        ArrayList<Tienda> base = consultar(condicion.hijo, actuales);
        ArrayList<Tienda> complemento = new ArrayList<>();
        
        boolean flag = false;
        for (Tienda st: actuales) {
            for (Tienda st2: base) {
                if (st.getCodigo() == st2.getCodigo())
                    flag = true;
            }
            if (!flag) complemento.add(st);
            else flag = false;
        }
        
        ArrayList<Tienda> semi_respuesta = consultar(condicion.hijo.hermano, complemento);
        ArrayList<Tienda> respuesta = new ArrayList<>();
        
        for (Tienda us: base) {
            respuesta.add(us);
        }
        
        for (Tienda us: semi_respuesta)
            respuesta.add(us);
        
        return respuesta;
    }
    
    
}
