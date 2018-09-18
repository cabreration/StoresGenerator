/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import FGrammar.ErrorC;
import FGrammar.Lexico;
import FGrammar.Sintactico;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.Socket;
import sgserver.DatosPersistentes;

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
            Reader lector = new StringReader(entradaCompleta);
            Lexico scanner = new Lexico(lector);
            Sintactico parser = new Sintactico(scanner);
            try 
            {
                parser.parse();
                for (ErrorC er : scanner.errores) 
                    DatosPersistentes.lexicos.add(er);
                for (ErrorC er2: parser.errores)
                    DatosPersistentes.sintacticos.add(er2);
                for (ErrorC er3: parser.semanticos)
                    DatosPersistentes.semanticos.add(er3);
                salida.println(parser.respuesta);
                salida.println("fin");
            }
            catch(Exception e) 
            {
                salida.println(" $reply$ $Usuario$ $id$ 0 $id-$ $access$ False $access-$ $Usuario-$ $reply-$");
                salida.println("fin");
                System.out.println(e);
                e.printStackTrace();
            }
            //vamos a enviar esa cadena por medio de la variable salida
            socket.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
