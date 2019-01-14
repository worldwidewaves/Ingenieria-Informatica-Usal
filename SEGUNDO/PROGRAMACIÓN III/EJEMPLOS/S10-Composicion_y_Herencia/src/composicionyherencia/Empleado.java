/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package composicionyherencia;

/**
 *
 * @author Tests by coti
 */
public class Empleado {

    public String nombre;
    public String direccion;

    public Empleado(String nombre, String direccion) {

        this.nombre = nombre.isEmpty() ? "desconocido" : nombre;
        this.direccion = direccion.isEmpty() ? "desconocida" : direccion;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\tDirección: %s",
                this.nombre,
                this.direccion);
    }
}
