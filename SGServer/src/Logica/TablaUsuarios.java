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
    
    public String consulta(ArrayList<Consulta> condiciones) {
        ArrayList<Usuario> satisfactorios = new ArrayList<>();
        
        Set<String> llaves = this.usuarios.keySet();
        for (String llave : llaves) {
            satisfactorios.add(this.usuarios.get(String.valueOf(llave)));
        }
        
        ArrayList<Usuario> resultado = consulta(condiciones, satisfactorios);
        return null;
    }
    
    public ArrayList<Usuario> consulta(ArrayList<Consulta> condiciones, ArrayList<Usuario> usuarios) {
        
        ArrayList<Usuario> done = new ArrayList<>();
        return null;
    } 
}
