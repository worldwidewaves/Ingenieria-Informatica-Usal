/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipaquete;

import java.util.Random;

/**
 *
 * @author bruegel
 */
public class MiniPersona {

    private String nombre;
    private int edad;

    public void miniSetRandomAttributes() {
        String[] nombres_aleatorios = {
            "María", "José"
        };
        Random r = new Random();
        this.nombre = nombres_aleatorios[r.nextInt(nombres_aleatorios.length)];
        this.edad = 18 + r.nextInt(81);
    }

    public static void mostrarListaDeMiniPersonas(MiniPersona[] lista) {
        String separador = "+------------"
                + "+-----+";
        for (MiniPersona miniPersona : lista) {
            System.out.println(separador);
            System.out.printf("| %-10s | %3d |%n", miniPersona.getNombre(), miniPersona.getEdad());
        }
        System.out.println(separador);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
