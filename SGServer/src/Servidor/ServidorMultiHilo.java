/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Javier A. Cabrera
 */
public class ServidorMultiHilo extends Thread {
    private Socket socket = null;
    
    public ServidorMultiHilo(Socket socket) 
    {
        super("Servidor Multi-Hilo");
        this.socket = socket;
    }
    
    public void correr() 
    {
        try 
        {
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(),
                    true);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(
                    socket.getInputStream())
            );
            
            //Procesamos la entrada 
            String entradaCompleta = "";
            String aux = "";
            try {
            while (!(aux = entrada.readLine()).equals("fin")) 
            {
                entradaCompleta += aux;
            }
            }
            catch(Exception e) {System.out.println(e);}
            
            System.out.println(entradaCompleta);
            //aqui tenemos la cadena enviada ya toda junta y lista para ser analizada por el compilador
            if (entradaCompleta.equals("Hola mundo")) 
            {
                salida.println("Si llego!");
            }
            else salida.println("No llego :c");
            //vamos a enviar esa cadena por medio de la variable salida
            socket.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
