/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.nomina;

import com.java.nomina.Empleado;
import com.java.nomina.Bonificable;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
import java.util.Scanner;

public class Gerente extends Empleado implements Bonificable {
    private double bonoGeneral;

    // CORREGIDO: "throws" con 's' y con 'a'
    public Gerente(String nombre, double salarioBruto, boolean esRemoto, double bonoGeneral) throws SalarioInvalidoException {
        super(nombre, salarioBruto, esRemoto);
        this.bonoGeneral = bonoGeneral;
    }

    public double getBonoGeneral() { return bonoGeneral; }
    
    public void calcularBonoAnual(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa un numero: "); 
            int valor = scanner.nextInt();

            if (valor == 0) {
                throw new ArithmeticException(); 
            }

            double Total = getSalarioBruto() / valor;
            System.out.println("El resultado de la división es: " + Total);
    
        } catch(ArithmeticException e ){
             System.out.println("El resultado no se puede dividir por cero");
        }
    } 
}