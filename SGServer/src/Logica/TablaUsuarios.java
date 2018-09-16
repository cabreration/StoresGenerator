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
public class TablaUsuarios {
    
    public Hashtable<String, Usuario> usuarios;
    
    public TablaUsuarios() 
    {
        usuarios = new Hashtable<>();
    }
    
    public boolean agregarUsuario(Usuario usuario) throws Exception 
    {
        if (usuarios.get(String.valueOf(usuario.getIdentificador())) !=  null)
            throw new Exception("El usuario ya existe");
        
        if (usuario.getNombre() == null) throw new Exception("Debe ingresar un nombre");
        if (usuario.getApellido() == null) throw new Exception("Debe ingresar un apellido");
        if (usuario.getEmail() == null) throw new Exception("Debe ingresar un email");
        if (usuario.getPassword() == null) throw new Exception("Debe ingresar una clave");
        
        usuarios.put(String.valueOf(usuario.getIdentificador()), usuario);
        return true;
    }
    
    public String logIn(int id, String password) throws Exception 
    {
        Usuario aux = null;
        
        if ((aux = usuarios.get(String.valueOf(id))) == null) 
            throw new Exception("No existe ningun usuario con codigo" + id);
        
        if (!aux.getPassword().equals(password))
            throw new Exception("El usuario y la clave no concuerdan");
        
        return aux.getNombre();
    }
    
    public void escribirArchivo() throws IOException {
        if (this.usuarios.size() == 0) return;
        
        String escritura = " [ \n\t";
        
        ArrayList<Usuario> escritor = new ArrayList<>();
        
        Set<String> llaves = this.usuarios.keySet();
        for (String llave : llaves) {
            escritor.add(this.usuarios.get(String.valueOf(llave)));
        }
        
        int i;
        for (i = 0; i < escritor.size() - 1; i++) {
            Usuario aux = escritor.get(i);
            escritura += "{ \n \"identificador\": "  + aux.getIdentificador() + ", \n"
                    + "\"nombre\": " + "\"" + aux.getNombre() + "\", \n"
                    + "\"apellido\": " + "\"" + aux.getApellido() + "\", \n"
                    + "\"password\": " + "\"" + aux.getPassword() + "\", \n"
                    + "\"telefono\": " + aux.getTelefono() + ", \n"
                    + "\"email\": " + "\"" + aux.getEmail() + "\", \n";
                    if (aux.getDireccion() != null)
                        escritura += "\"direccion\": " + "\"" + aux.getDireccion() + "\" \n }, \n";
                    else 
                        escritura += "\"direccion\": null \n }, \n";
        }
        
        Usuario nu = escritor.get(i);
        escritura += "{ \n \"identificador\": " + nu.getIdentificador() + ", \n"
                    + "\"nombre\": " + "\"" + nu.getNombre() + "\", \n"
                    + "\"apellido\": " + "\"" + nu.getApellido() + "\", \n"
                    + "\"password\": " + "\"" + nu.getPassword() + "\", \n"
                    + "\"telefono\": " + nu.getTelefono() + ", \n"
                    + "\"email\": " + "\"" + nu.getEmail() + "\", \n";
                    if (nu.getDireccion() != null)
                        escritura += "\"direccion\": " + "\"" + nu.getDireccion() + "\" \n } \n";
                    else 
                        escritura += "\"direccion\": null \n } \n";
        
        escritura += "]";
        
        Path path = Paths.get("Usuarios.txt");
        byte[] strToBytes = escritura.getBytes();
 
        Files.write(path, strToBytes);
    }
    
    public ArrayList<Usuario> modoLista() {
        ArrayList<Usuario> satisfactorios = new ArrayList<>();
        
        Set<String> llaves = this.usuarios.keySet();
        for (String llave : llaves) {
            satisfactorios.add(this.usuarios.get(String.valueOf(llave)));
        }
        return satisfactorios;
    }
    
    public String consultar(Condicion condicion) throws Exception {
    
        ArrayList<Usuario> actuales = this.modoLista();
        ArrayList<Usuario> total = consultar(condicion, actuales);
        
        String respuesta = "";
        for (Usuario us: total) {
            respuesta += "Identificador: " + us.getIdentificador() + " - Nombre: " + us.getNombre() + " - Apellido: " + us.getApellido()
                    + " - Password: " + us.getPassword() + " - Email: " + us.getEmail();
            if (us.getTelefono() != -1)
                respuesta += " - Telefono: " + us.getTelefono();
            if (us.getDireccion() != null)
                respuesta += " - Direccion: " + us.getDireccion();
            respuesta += "\n";
        }
        return respuesta;
    }
    
    public ArrayList<Usuario> consultar(Condicion condicion, ArrayList<Usuario> actuales) throws Exception {
        ArrayList<Usuario> resultado = new ArrayList<>();
        
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
            for (Usuario us: actuales) {
                //si se cumple la condicion entonces lo agrego a la lista que voy a devolver;
                switch(condicion.tipo) {
                    case 1:
                        if (condicion.valor == null) throw new Exception("Los nombres nunca seran vacios");
                        if (us.getNombre().equals(String.valueOf(condicion.valor)))
                            resultado.add(us);
                        break;
                    case 2:
                        if (condicion.valor == null) throw new Exception ("Los identificadores nunca seran nulos");
                        if (us.getIdentificador() == (int)condicion.valor)
                            resultado.add(us);
                        break;
                    case 3:
                        if (condicion.valor == null) throw new Exception("Las password nunca seran vacias");
                        if (us.getPassword().equals(String.valueOf(condicion.valor)))
                            resultado.add(us);
                        break;
                    case 4:
                        if (condicion.valor == null) throw new Exception("Los apellidos nunca seran vacios");
                        if (us.getApellido().equals(String.valueOf(condicion.valor)))
                            resultado.add(us);
                        break;
                    case 5:
                        if (condicion.valor == null && us.getTelefono() == -1)
                            resultado.add(us);
                        else if (us.getTelefono() == (int)condicion.valor)
                            resultado.add(us);
                        break;
                    case 6:
                        if (condicion.valor == null) throw new Exception("Los emails nunca seran vacios");
                        if (us.getEmail().equals((String.valueOf(condicion.valor))))
                            resultado.add(us);
                        break;
                    case 7:
                        if (condicion.valor == null && us.getDireccion() == null)
                            resultado.add(us);
                        else if (us.getDireccion().equals(String.valueOf(condicion.valor)))
                            resultado.add(us);
                        break;
                    default:
                        throw new Exception("El atributo no pertenece a la tabla \"Usuarios\"");
                }
            }
        }
        
        return resultado;
    }
    
    public ArrayList<Usuario> negacion(Condicion condicion, ArrayList<Usuario> actuales) throws Exception {
        
        ArrayList<Usuario> base = consultar(condicion.hijo, actuales);
        ArrayList<Usuario> respuesta = new ArrayList<>();
        boolean flag = false;
        
        for (Usuario us: actuales) {
            for (Usuario us2: base) {
                if (us.getIdentificador() == us2.getIdentificador())
                    flag = true;
            }
            if (!flag) respuesta.add(us);
            else flag = false;
        }
        
        return respuesta;
    }
    
    public ArrayList<Usuario> conjuncion(Condicion condicion, ArrayList<Usuario> actuales) throws Exception {
        
        ArrayList<Usuario> base = consultar(condicion.hijo, actuales);
        ArrayList<Usuario> base2 = consultar(condicion.hijo.hermano, base);
        return base2;
    }
    
    public ArrayList<Usuario> disyuncion(Condicion condicion, ArrayList<Usuario> actuales) throws Exception {
        
        ArrayList<Usuario> base = consultar(condicion.hijo, actuales);
        ArrayList<Usuario> complemento = new ArrayList<>();
        
        boolean flag = false;
        for (Usuario us: actuales) {
            for (Usuario us2: base) {
                if (us.getIdentificador() == us2.getIdentificador())
                    flag = true;
            }
            if (!flag) complemento.add(us);
            else flag = false;
        }
        
        ArrayList<Usuario> semi_respuesta = consultar(condicion.hermano, complemento);
        ArrayList<Usuario> respuesta = new ArrayList<>();
        
        for (Usuario us: base) {
            respuesta.add(us);
        }
        
        for (Usuario us: semi_respuesta)
            respuesta.add(us);
        
        return respuesta;
    }
}
