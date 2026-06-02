/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.nomina;

/**
 *
 * @author Usuario
 */
public class SalarioInvalidoException extends Exception {
    public SalarioInvalidoException(String mensaje) {
        super(mensaje); // Le pasa el texto de error a la clase padre Exception
    }
    
}
