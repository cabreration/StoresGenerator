/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Javier A. Cabrera
 */
public class SGClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //LogIn log = new LogIn();
        //log.setVisible(true);
        
        Inicio init = new Inicio();
        init.setVisible(true);
        
        MarcoTiendas marc = new MarcoTiendas();
        marc.setVisible(true);
    }
    
}
