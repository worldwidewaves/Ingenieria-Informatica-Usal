//afdasfdasf¡'09
public class Alumno {
  String nombre;
  String primerApellido;
  String segundoApellido;
  String DNI;
  final static String DESCONOCIDO = "desconocido";
  
  boolean[] asistencia;
  // Ctor sin argumentos
  public Alumno() {
    this.nombre = DESCONOCIDO;
    this.primerApellido = DESCONOCIDO;
    this. segundoApellido = DESCONOCIDO;
    this.DNI = DESCONOCIDO;
    this.asistencia = new boolean[15];
    for(int i=0; i<asistencia.length; i++) {
      asistencia[i] = false;
    }
  } // Fin de ctor sin argumentos
  // Ctor con argumentos
  
  public Alumno(String nombre, String primerApellido, String segundoApellido, String DNI, boolean[] asistencia) {
    this.nombre = nombre;
    this.primerApellido = primerApellido;
    this.segundoApellido = segundoApellido;
    this.DNI = DNI;
    this.asistencia = asistencia;
  }
  public String toString() {
    String s1 = String.format("%15s%15s%15s%12s",this.nombre, this.primerApellido, this.segundoApellido, this.DNI);
    String s2 = "  ";
    for(boolean b : this.asistencia) {
      s2 +=  String.format("%2s", b ? "P" : "F");
    }
    return s1+s2;
  }
} // Fin de Alumno
