/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Javier A. Cabrera
 */
public class ServidorN {
    ServerSocket servidor;
    
    public void iniciarServidor() throws IOException 
    {
        try 
        {
            servidor = new ServerSocket(8889);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println("No ha sido posible escuchar en ese puerto");
            return;
        }
        
        while(true) 
        {
            Socket socket = servidor.accept();
            System.out.println("Se encontro una conexion");
            new ServidorMultiHilo(socket).correr();
        }
    }
}
