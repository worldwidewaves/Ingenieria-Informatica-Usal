/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package composicionyherencia;

/**
 *
 * @author Tests by coti
 *
 * La clase Comercial se deriva de la clase Empleado; esto se denota mediante la
 * palabra reservada extends.
 *
 */
public class Comercial extends Empleado {

    /**
     * @return the ventas
     */
    public float getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(float ventas) {
        this.ventas = ventas;
    }

    private float ventas;
    public float comision;

    public Comercial(String nombre, String direccion, float ventas, float comision) {
        super(nombre, direccion);
        this.comision = comision;
        this.ventas = ventas;
    }

    @Override
   public String toString() {
       return super.toString() + String.format("Ventas: %6.2f\tComision: %6.2f",
               this.ventas,
               this.comision);
   }


}
