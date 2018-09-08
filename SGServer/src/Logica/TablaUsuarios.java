/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Hashtable;
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
        
        DatosPersistentes.usuariosLoggueados.add(aux);
        return aux.getNombre();
    }
    
}
