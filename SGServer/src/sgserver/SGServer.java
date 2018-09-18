/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgserver;

import Logica.TablaProductos;
import Logica.TablaTiendas;
import Logica.TablaUsuarios;
import Servidor.ServidorN;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Javier A. Cabrera
 */
public class SGServer {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        DatosPersistentes.cargarUsuarios();
        DatosPersistentes.cargarTiendas();
        DatosPersistentes.cargarProductos();
        DatosPersistentes.lexicos = new ArrayList<>();
        DatosPersistentes.sintacticos = new ArrayList<>();
        DatosPersistentes.semanticos = new ArrayList<>();
        
        DatosPersistentes.interfaz = new GUI();
        DatosPersistentes.interfaz.setVisible(true);
    } 
}
