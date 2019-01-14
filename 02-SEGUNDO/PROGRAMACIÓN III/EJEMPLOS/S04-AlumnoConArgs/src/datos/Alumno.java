//afdasfdasf¡'09
package datos;

public class Alumno {
  String nombre;
  String primerApellido;
  String segundoApellido;
  long telefono;
  final static String DESCONOCIDO = "desconocido";
  
  boolean[] asistencia;
  // Ctor sin argumentos
  public Alumno() {
    this.nombre = DESCONOCIDO;
    this.primerApellido = DESCONOCIDO;
    this.segundoApellido = DESCONOCIDO;
    this.telefono = 0;
    this.asistencia = new boolean[15];
    for(int i=0; i<asistencia.length; i++) {
      asistencia[i] = false;
    }
  } // Fin de ctor sin argumentos
  // Ctor con argumentos
  
  public Alumno(String nombre, String primerApellido, String segundoApellido, long telefono, boolean[] asistencia) {
    this.nombre = nombre;
    this.primerApellido = primerApellido;
    this.segundoApellido = segundoApellido;
    this.telefono = telefono;
    this.asistencia = asistencia;
  }
  
  public String toString() {
    String s1 = String.format("%15s%15s%15s%12d",this.nombre, this.primerApellido, this.segundoApellido, this.telefono);
    String s2 = "  ";
    for(boolean b : this.asistencia) {
      s2 +=  String.format("%2s", b ? "P" : "F");
    }
    return s1+s2;
  }
} // Fin de Alumno
