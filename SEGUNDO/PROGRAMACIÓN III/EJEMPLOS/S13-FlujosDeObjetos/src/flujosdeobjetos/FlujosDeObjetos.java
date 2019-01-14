/*
 * Este ejercicio muestra la forma de almacenar en disco tanto objetos como
 * valores de tipos primitivos, empleando un mismo archivo. Todos los valores
 * se leen después de haber creado el archivo correspondiente.
 */
package flujosdeobjetos;

/**
 *
 * @author Tests by coti
 */
import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class FlujosDeObjetos {

  static final String ARCHIVO_DE_DATOS = "datosDeFacturacion.bin";
  static final BigDecimal[] PRECIOS_UNITARIOS = {
    new BigDecimal("19.99"),
    new BigDecimal("9.99"),
    new BigDecimal("15.99"),
    new BigDecimal("3.99"),
    new BigDecimal("4.99")};
  static final int[] NUMEROS_DE_UNIDADES = {12, 8, 13, 29, 50};
  static final String[] DESCRIPCIONES = {"Miriñaque",
    "Ménsula",
    "Laúd",
    "Túmulo",
    "Fosfatina"};

  public static void main(String[] args)
          throws IOException, ClassNotFoundException {

    TimeZone tz = TimeZone.getTimeZone("Europe/Madrid");
    Locale loc = new Locale("ES");
    Calendar cal = Calendar.getInstance(tz, loc);

    try (ObjectOutputStream archivo_salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ARCHIVO_DE_DATOS)))) {

      archivo_salida.writeObject(cal);
      for (int i = 0; i < PRECIOS_UNITARIOS.length; i++) {
        archivo_salida.writeObject(PRECIOS_UNITARIOS[i]);
        archivo_salida.writeInt(NUMEROS_DE_UNIDADES[i]);
        archivo_salida.writeUTF(DESCRIPCIONES[i]);
      }
    }

    try (ObjectInputStream archivo_entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ARCHIVO_DE_DATOS)))) {

      Calendar fecha;
      BigDecimal precio;
      int unidades;
      String descripcion;
      BigDecimal total = new BigDecimal(0);

      fecha = (Calendar) archivo_entrada.readObject();
      System.out.format("Hoy es %tA, %<te de %<tB de %<tY:%n%n", fecha);

      try {
        while (true) {
          precio = (BigDecimal) archivo_entrada.readObject();
          unidades = archivo_entrada.readInt();
          descripcion = archivo_entrada.readUTF();
          System.out.format("Ha solicitado %2d unidades de %10s a %.2f€%n",
                  unidades, descripcion, precio);
          total = total.add(precio.multiply(new BigDecimal(unidades)));
        }
      } catch (EOFException e) {
      }
      System.out.format("%nEl importe total es de: %.2f€%n", total);
    }
  }
}
