/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package composicionyherencia;

/**
 *
 * @author bruegel
 */
public class Administrativo extends Empleado {
    String servicio;
    
    public Administrativo(String nombre, String direccion, String servicio) {
     super(nombre,direccion);
     this.servicio = servicio;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t" + this.servicio;
    }
}
