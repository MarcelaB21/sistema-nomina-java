/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.nomina;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


/**
 *
 * @author Usuario
 */


public class Main {

    public static void main(String[] args) {
        NominaServicio miNomina = new NominaServicio();
        ArrayList<Empleado> lista = new ArrayList<>();
        
        
        
        
        // Declaramos a ger1 aquí afuera para poder usarlo al final del main
        Gerente ger1 = null;
        Gerente ger2 = null;

        try {
            Empleado emp1 = new Empleado("Juan", 600, true); 
            Empleado emp2 = new Empleado("Maria", 2800, false);
            ger1 = new Gerente("Luis", 3500, true, 100);
            ger2 = new Gerente("Anabel", 4500, false, 100);

            lista.add(emp1);
            lista.add(emp2);
            lista.add(ger1); 
            lista.add(ger2);
       
        } catch (SalarioInvalidoException e) {
            System.out.println("Error al registrar empleado: " + e.getMessage());
        }
        
        // 2.  Usamos el Stream y guardamos el resultado en una variable 'long'
        long cantidadRemotos = lista.stream()
                                .filter(e -> e.isEsRemoto())
                                .count();

        // 3. Imprimimos el resultado para verlo en la consola
        System.out.println("Cantidad de empleados trabajando desde casa: " + cantidadRemotos);

        // El bucle procesa a todos los que se agregaron con éxito
        for (Empleado actual : lista) {
            miNomina.procesarAccion(actual, e -> System.out.println("Procesando a: " + e.getNombre()));
            
            
            double neto = miNomina.calculaSalarioNeto(actual);
            miNomina.generarRecibo(actual, neto);
            
        }
        
        
        if (ger1 != null) {
            ger1.calcularBonoAnual();
        }
        
        // >>>  REPORTE  <<<
        // 1. Filtro de Gerentes...
        List<Empleado> cantidadGerentes = lista.stream()
                                       .filter(e -> e instanceof Gerente)
                                       .collect(Collectors.toList());    
        
           // CORREGIDO: Añadido el ) al final para cerrar el println
            System.out.println("Gerentes de la empresa: " + 
                               cantidadGerentes.stream().map(Empleado::getNombre).collect(Collectors.joining(", ")));
      
        // 2. Promedio de salarios...
        double promedioSalarios = lista.stream()
                                        .mapToDouble(e -> e.getSalarioBruto()) //se encarga de extraer solo los salarios brutos de la banda transportadora.
                                        .average().orElse(0.0);   //para calcular el promedio.
        
        System.out.println("Promedio de salario de empelados : " + promedioSalarios);
        
        // 3. Nombres en mayúsculas...
              /*.collect(Collectors.joining(", ")):para transformar una colección de elementos 
              (como una lista o un conjunto) 
              en una única cadena de texto concatenada, 
              donde cada elemento está separado por una coma y un espacio*/
              
        String nombresEmpleados = lista.stream()
                                               .map(e -> e.getNombre().toUpperCase())
                                               .collect(Collectors.joining(", "));
        
        System.out.println("Nombres de los empelados en masyusculas : " + nombresEmpleados);
        
        
        // 1. LA LISTA LLENA: Buscará entre tus 4 empleados y te dirá quién gana más
            System.out.print("El empleado más rico es: ");
                System.out.println(miNomina.obtenerEmpleadoMasRico(lista)
                                    .map(Empleado::getNombre)
                                      .orElse("Nadie")
                );

         // 2. LA LISTA VACÍA: Simulamos un fallo en la base de datos o que la empresa es nueva
            ArrayList<Empleado> listaVacia = new ArrayList<>();

            System.out.print("El más rico en una lista vacía es: ");
                System.out.println(miNomina.obtenerEmpleadoMasRico(listaVacia)
                                   .map(Empleado::getNombre)
                                   .orElse("Nadie")
                );
        
        
        
        
    }
}