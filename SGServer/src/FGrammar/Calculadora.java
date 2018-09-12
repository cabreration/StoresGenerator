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
public class Calculadora {
    
    
    public static double sumar(Object num1, Object num2) throws Exception {
        
        if ((num1 instanceof Integer || num1 instanceof Double) &&
                (num2 instanceof Integer || num2 instanceof Double)) {
            return (double)num1 + (double)num2;
        }
        else 
            throw new Exception("Los argumentos de la operacion no son numeros");
    }
    
    public static double restar(Object num1, Object num2) throws Exception {
        
        if ((num1 instanceof Integer || num1 instanceof Double) &&
                (num2 instanceof Integer || num2 instanceof Double)) {
            return (double)num1 - (double)num2;
        }
        else 
            throw new Exception("Los argumentos de la operacion no son numeros");
    }
    
    public static double multiplicar(Object num1, Object num2) throws Exception {
        
        if ((num1 instanceof Integer || num1 instanceof Double) &&
                (num2 instanceof Integer || num2 instanceof Double)) {
            return (double)num1 * (double)num2;
        }
        else 
            throw new Exception("Los argumentos de la operacion no son numeros");
    }
    
    public static double dividir(Object num1, Object num2) throws Exception {
        
        if ((num1 instanceof Integer || num1 instanceof Double) &&
                (num2 instanceof Integer || num2 instanceof Double)) {
            return (double)num1 / (double)num2;
        }
        else 
            throw new Exception("Los argumentos de la operacion no son numeros");
    }
    
    public static double raiz(Object num1) throws Exception {
        
        if (num1 instanceof Integer || num1 instanceof Double) {
            return Math.sqrt((double)num1);
        }
        else 
            throw new Exception("El argumento no es un numero");
    }
    
    public static double potencia(Object num1) throws Exception {
        
        if ((num1 instanceof Integer || num1 instanceof Double)) {
            return (double)num1*(double)num1;
        }
        else 
            throw new Exception("El argumento no es un numero");
    }
}
