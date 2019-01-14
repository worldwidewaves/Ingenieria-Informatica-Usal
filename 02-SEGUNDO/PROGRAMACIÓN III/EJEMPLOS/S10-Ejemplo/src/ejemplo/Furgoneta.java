package ejemplo;

/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */

/**
 *
 * @author bruegel
 */
public class Furgoneta extends VehiculoAMotor {
    
    float capacidad;
    
    public Furgoneta(float peso, float longitud, float anchura, float altura, String tipoDeMotor, float capacidad) {
        super(peso, longitud, anchura, altura, tipoDeMotor);
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("\t%6.2f", this.capacidad);
    }
}
