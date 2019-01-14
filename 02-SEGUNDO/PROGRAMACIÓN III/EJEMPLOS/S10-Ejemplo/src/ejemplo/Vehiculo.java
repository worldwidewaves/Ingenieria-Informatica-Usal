/*
 * Grado en Ingeniería Informática - Universidad de Salamanca
 * Asignatura : Programación III
 * Tema       : Interfaces
 */

package ejemplo;

/**
 *
 * @author bruegel
 */
public class Vehiculo {
    float peso;
    float longitud, anchura, altura;
    
    public Vehiculo(float peso, float longitud, float anchura, float altura) {
        this.altura = altura;
        this.anchura = anchura;
        this.longitud = longitud;
        this.peso = peso;
    }
    
    @Override
    public String toString() {
        return String.format("%6.2f\t%6.2f\t%6.2f\t%6.2f", this. peso, this.altura, this.anchura, this.longitud);
    }
}
