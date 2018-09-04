/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGrammar;

/**
 *
 * @author Javier A. Cabrera
 */
public class Generador {
    public static void main(String[] args) 
    {
        generarAnalizadores();
    }
    
    public static void generarAnalizadores() 
    {
        try 
        {
            String route = "src/AGrammar/";
            String oflex[] = {route + "Lexico.jflex", "-d", route};
            
            String ocup[] = {"-destdir", route, "-symbols", "SimbolosA", "-parser", "Sintactico", route + "Sintactico.cup"};
            java_cup.Main.main(ocup);
            jflex.Main.generate(oflex);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
