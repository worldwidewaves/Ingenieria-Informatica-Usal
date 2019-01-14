/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicionyherencia;

/**
 *
 * @author bruegel
 */
public class Corruto extends Comercial {
  float tresPorCiento;
  
  public Corruto(String nombre, String direccion, float ventas, float comision, float tresPorCiento) {
      super(nombre, direccion, ventas, comision);
      this.tresPorCiento = tresPorCiento;
  }
  
  @Override
  public String toString() {
      return super.toString()
              + String.format("\ttresPorCiento: %8.2f", this.tresPorCiento);
  }
}
