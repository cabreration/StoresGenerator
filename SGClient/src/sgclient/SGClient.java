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
        try 
        {
            Socket socket = new Socket("localhost", 8889);
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );
            
            salida.println("Hola mundo");
            salida.println("fin");
            String uno = entrada.readLine();
            System.out.println(uno);
            socket.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
