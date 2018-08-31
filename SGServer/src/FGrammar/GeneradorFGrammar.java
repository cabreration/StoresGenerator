/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FGrammar;

/**
 *
 * @author Javier A. Cabrera
 */
public class GeneradorFGrammar {
    
    public static void main(String[] args) 
    {
        generarAnalizadores();
    }
    
    public static void generarAnalizadores() 
    {
        try 
        {
            String route = "src/FGrammar/";
            String oflex[] = {route + "Lexico.jflex", "-d", route};
            
            String ocup[] = {"-destdir", route, "-symbols", "SimbolosF", "-parser", "Sintactico", route + "Sintactico.cup"};
            java_cup.Main.main(ocup);
            jflex.Main.generate(oflex);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
