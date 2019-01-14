/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodeclaseabstracta;

/**
 *
 * @author Tests by coti
 */
public abstract class ClaseAbstracta {
 
   String s;
  
  public ClaseAbstracta() {
    s = "Hola";
  }
    public void metodoConcreto() {
        System.out.println("Esto es un método concreto");
    }
    
    public abstract void metodoAbstracto();
}
