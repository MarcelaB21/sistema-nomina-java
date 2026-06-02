/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.nomina;

/**
 *
 * @author Usuario
 */
public class Empleado {
    private String nombre ; 
    private double salarioBruto;
    private boolean esRemoto;

    public Empleado(String nombre, double salarioBruto, boolean esRemoto)throws SalarioInvalidoException {
        this.nombre = nombre;
        setSalarioBruto(salarioBruto);
        this.esRemoto = esRemoto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }
    
    
    public void setSalarioBruto(double salarioBruto)throws SalarioInvalidoException {
        if(salarioBruto >=500){
            this.salarioBruto = salarioBruto;
        }else{
            // Aquí se lanza  excepción personalizada con el mensaje
        throw new SalarioInvalidoException("El salario de " + this.nombre + " no puede ser menor a 500. Se ingresó: " + salarioBruto);
        }
    }

    public boolean isEsRemoto() {
        return esRemoto;
    }
   
}
