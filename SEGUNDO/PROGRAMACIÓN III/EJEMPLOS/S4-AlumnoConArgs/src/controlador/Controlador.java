//afdasfdasf¡'09
package controlador;
import datos.Alumno;
import datos.Modelo;
import java.util.List;


public class Controlador {
  private final Modelo m = new Modelo();
  

    
  
  public String preguntarSiSalimos() {
    
    // Este método siempre devuelve salir
    return "salir";
    
    // Podría preguntar "¿Desea realmente salir de la aplicación?"
    // Podría guardar en disco los cambios que haya en el modelo
    // (Desea guardar lso cambios?)
  }
  public Modelo getModelo() {
    return m;
  }

    public Alumno[] getListaConDatos() {
        return m.getListaConDatos();
    }

    public Alumno[] getListaSinDatos() {
        return m.getListaSinDatos();
    }
}
