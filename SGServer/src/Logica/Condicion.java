/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Javier A. Cabrera
 */
public class Condicion {
    int tipo;
    Object valor;
    Condicion hijo;
    Condicion hermano;
    int operacion;
    
    public Condicion(int tipo, Object valor, Condicion hijo) {
        this.tipo = tipo;
        this.valor = valor;
        this.hijo = hijo;
    }
    
    public Condicion(int tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.operacion = 0;
    }
    
    public Condicion(int operacion, Condicion hijo) {
        this.operacion = operacion;
        this.hijo = hijo;
    }
}
