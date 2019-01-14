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
public class VehiculoAMotor extends Vehiculo {

    String tipoDeMotor;

    public VehiculoAMotor(float peso, float longitud, float anchura, float altura, String tipoDeMotor) {
        super(peso, longitud, anchura, altura);
        this.tipoDeMotor = tipoDeMotor;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\t%s", this.tipoDeMotor);
    }

}
