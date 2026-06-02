/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.nomina;

/**
 *
 * @author Usuario
 */
public class Desarrollador extends Empleado {
    private String lenguajePrincipal; 

    public Desarrollador(String nombre, double salarioBruto, boolean esRemoto, String lenguajePrincipal)throws SalarioInvalidoException {
        super(nombre, salarioBruto, esRemoto);
        this.lenguajePrincipal = lenguajePrincipal;
    }
    
    public String getLenguajePrincipal(){
       return lenguajePrincipal;
    }
    
    
}
