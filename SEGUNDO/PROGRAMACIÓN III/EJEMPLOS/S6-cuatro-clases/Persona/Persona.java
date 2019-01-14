/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg500_a60;

import static coti.esdia.Esdia.*;

/**
 *
 * @author coti
 */
public class Persona {

    private String nombre;
    private String direccion;
    private int telefono;
    private float talla;
    private String DNI;

    public Persona(String nombre, String direccion, int telefono, float talla, String DNI) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.talla = talla;
        this.DNI = DNI;
    }

    public Persona() {
        nombre = "<áéíóú>";
        direccion = "<áéíóú>";
        telefono = 5551234;
        talla = 1.75f; // Por qué hay que poner la f?
        DNI = "12345678X";
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the talla
     */
    public float getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(float talla) {
        this.talla = talla;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    void leerDeTeclado() {
        nombre = readString_ne("Por favor, escriba el nombre      : ");
        direccion = readString("Por favor, escriba la dirección   : ");
        telefono = readInt("Por favor, escriba el teléfono    : ");
        talla = readFloat("Por favor, escriba la talla       : ");
        DNI = readString("Por favor, escriba el DNI:        : ");

    }

    void escribirEnPantalla() {
        System.out.printf("Nombre       : %20s%n", nombre);
        System.out.printf("Dirección    : %20s%n", direccion);
        System.out.printf("Teléfono     : %20d%n", telefono);
        System.out.printf("Talla        : %20.2f%n", talla);
        System.out.printf("DNI          : %20s%n", DNI);
    }
}
