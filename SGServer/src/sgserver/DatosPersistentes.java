/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgserver;

import Logica.TablaProductos;
import Logica.TablaTiendas;
import Logica.TablaUsuarios;
import Logica.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Javier A. Cabrera
 */
public class DatosPersistentes {
    public static ArrayList<Usuario> usuariosLoggueados;
    public static TablaUsuarios usuarios;
    public static TablaTiendas tiendas;
    public static TablaProductos productos;
    public static GUI interfaz;
}
