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
public class ErrorC {
    public String tipo;
    public String descripcion;
    public String lexema;
    public int fila;
    public int columna;
    
    public ErrorC(String tipo, String lexema, int fila, int columna, String descripcion) 
    {
        this.tipo = tipo;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }
}
