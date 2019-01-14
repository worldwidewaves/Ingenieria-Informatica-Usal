/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
package paqueteparaclasesdedatos;

/**
 *
 * @author coti
 */
public class Persona {
    String nombre;
    int edad;
    float talla;
    
    public Persona(String _nombre, int _edad, float _talla) {
        this.edad = _edad;
        this.nombre = _nombre;
        this.talla = _talla;
    }
    
    @Override
    public String toString() {
        return String.format("%20s%4d%5.2f", this.nombre, this.edad,this.talla);
    }
}
