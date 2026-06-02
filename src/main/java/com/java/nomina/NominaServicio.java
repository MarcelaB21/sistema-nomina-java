/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.nomina;

import com.java.nomina.Gerente;
import com.java.nomina.Empleado;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 * @author Usuario
 */
public class NominaServicio {
    
    
    public double calculaSalarioNeto(Empleado emp) {
         
         double salarioNeto ;
         
         
        // Al usar solo 'else', cubrimos el caso de que sea exactamente 2000
        if (emp.getSalarioBruto()> 2000) {
            salarioNeto = emp.getSalarioBruto() * 0.90; 
        } else {
             salarioNeto = emp.getSalarioBruto() * 0.95;
        }
        
        if(emp.isEsRemoto()){
             salarioNeto=  salarioNeto -(emp.getSalarioBruto() *0.02);
            
        }
       return salarioNeto;
        
    }
    
    
    public double calcularSalarioGerente(Gerente ger){
        
        
        double baseNeto= calculaSalarioNeto(ger);
        
        baseNeto =  baseNeto + ger.getBonoGeneral();
        
        return baseNeto;
         
         
    }
    
    
    public void generarRecibo(Empleado emp, double neto) {
        // Unos espacios extra para que el texto respire
        System.out.println("Recibo de: " + emp.getNombre() + " | Total a pagar: $" + neto);
    }
    
    public void procesarAccion(Empleado emp, Consumer<Empleado> accion){
          accion.accept(emp);
    }
    
    public Optional <Empleado>obtenerEmpleadoMasRico(List<Empleado> emps){
        
        return emps.stream()
                   .max(Comparator.comparingDouble(Empleado:: getSalarioBruto));
    
    }
    
}
