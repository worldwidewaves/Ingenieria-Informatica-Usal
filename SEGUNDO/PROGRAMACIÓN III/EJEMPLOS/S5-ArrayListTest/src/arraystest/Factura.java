/*
 * No todos los métodos hacen falta para ArraysTest
 * He añadido el método showListAsTable()
 */
package arraystest;

/**
 *
 * @author bruegel
 */
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;
/*
 * Ojo a la siguiente sentencia de importación
 */
import static com.coti.esdia.Esdia.*;
import java.util.ArrayList;

/**
 *
 * @author bruegel
 */
public class Factura {

    private String nombre;
    private String razon_social;
    private String NIF;
    private float importe;
    private float tipo_de_IVA;
    private String fecha;
    private String concepto;

    public static void showListAsTable(Factura[] lista) {
        String separador = "+-----------------"
                + "+------------------------"
                + "+-----------------"
                + "+----------"
                + "+-------"
                + "+-------------"
                + "+-----------------+";
        String formato = "| %-15s | %-22s | %15s | %8.2f | %5.2f | %10s | %-15s |%n";
        for (Factura f : lista) {
            System.out.println(separador);
            System.out.printf(formato,
                    f.nombre, f.razon_social, f.NIF, f.importe,
                    f.tipo_de_IVA, f.fecha, f.concepto);
        } // fin for
        System.out.println(separador);
    } // fin showListAsTable

    public static void showListAsTable(ArrayList<Factura> lista) {
        String separador = "+-----------------"
                + "+------------------------"
                + "+-----------------"
                + "+----------"
                + "+-------"
                + "+-------------"
                + "+-----------------+";
        String formato = "| %-15s | %-22s | %15s | %8.2f | %5.2f | %10s | %-15s |%n";
        for (Factura f : lista) {
            System.out.println(separador);
            System.out.printf(formato,
                    f.nombre, f.razon_social, f.NIF, f.importe,
                    f.tipo_de_IVA, f.fecha, f.concepto);
        } // fin for
        System.out.println(separador);
    } // fin showListAsTable

    public void setRandomAttributes() {
        String[] nifs = {"12345678A", "23456789B", "34567890C", "222b"};
        String[] conceptos = {"Recambios", "Fungibles", "Adquisiciones"};
        String[] razonesSociales = {
            "Calle del Pez, 13", "Rue du Percebe, 14", "Roßauer Lände, 1",
            "Rebengasse, 3", "Krankenhausstraße, 1"};
        String[] fechas = {"23/Nov/1989", "12/Oct/1492", "20/Feb/2038"};
        float[] importes = {12.25f, 120.35f, 1234.23f, 9999.99f};
        String[] nombres = {"John Doe", "Richard Roe", "Hans Wurst", "Juan Palomo"};
        float ivas[] = {10f, 22f, 6f};
        Random r = new Random();
        this.NIF = nifs[r.nextInt(nifs.length)];
        this.concepto = conceptos[r.nextInt(conceptos.length)];
        this.fecha = fechas[r.nextInt(fechas.length)];
        this.importe = importes[r.nextInt(importes.length)];
        this.nombre = nombres[r.nextInt(nombres.length)];
        this.razon_social = razonesSociales[r.nextInt(razonesSociales.length)];
        this.tipo_de_IVA = ivas[r.nextInt(ivas.length)];
    }
    /*
     * A continuación se incluyen los métodos necesarios para leer de
     * teclado y escribir en pantalla el estado de una clase.
     */

    public void leerDeTeclado() {
        this.NIF = readString("Por favor, escriba el NIF             : ");
        this.concepto = readString("Por favor, escriba el concepto        : ");
        this.fecha = readString("Por favor, escriba la fecha           : ");
        this.importe = readFloat("Por favor, escriba el importe         : ");
        this.nombre = readString("Por favor, escriba el nombre          : ");
        this.razon_social = readString("Por favor, escriba la razón social    : ");
        this.tipo_de_IVA = readFloat("Por favor, escriba el tipo de IVA     : ");
    }

    public void escribirEnPantalla() {
        System.out.printf("+-----------------------------------------------+%n");
        System.out.printf("| NIF                       : %17s |%n", this.NIF);
        System.out.printf("| Concepto                  : %17s |%n", this.concepto);
        System.out.printf("| Fecha                     : %17s |%n", this.fecha);
        System.out.printf("| Importe                   : %17s |%n", this.importe);
        System.out.printf("| Nombre                    : %17s |%n", this.nombre);
        System.out.printf("| Razón social              : %17s |%n", this.razon_social);
        System.out.printf("| Tipo de IVA               : %17s |%n", this.tipo_de_IVA);
        System.out.printf("+-----------------------------------------------+%n");

    }
    /*
     * Estos son los métodos de escritura y lectura disco
     */

    // El delimitador es una cadena con una sola restricción: no puede formar
    // parte de los campos que separa
    public String exportWithDelimiter(String _delimitador) {
        String resultado;
        resultado = String.format(
                "%s" // NIF
                + "%s" // Delimitador
                + "%s" // concepto
                + "%s" // Delimitador
                + "%s" // fecha
                + "%s" // Delimitador
                + "%f" // importe
                + "%s" // Delimitador
                + "%d" // nombre
                + "%s" // Delimitador
                + "%d" // razon_social
                + "%s" // Delimitador
                + "%f",// tipo_de_IVA
                this.NIF,
                _delimitador,
                this.concepto,
                _delimitador,
                this.fecha,
                _delimitador,
                this.importe,
                _delimitador,
                this.nombre,
                _delimitador,
                this.razon_social,
                _delimitador,
                this.tipo_de_IVA);

        return resultado;
    }

    public static Factura importFromDelimitedString(String _delimitedText,
            String _delimiter) throws ParseException {
        Factura fac;
        String[] f = _delimitedText.split(_delimiter);
        fac = new Factura();
        fac.NIF = f[0];
        fac.concepto = f[1];
        fac.fecha = f[2];
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        fac.importe = nf.parse(f[3]).floatValue();
        fac.razon_social = f[4];
        fac.tipo_de_IVA = nf.parse(f[5]).floatValue();

        return fac;
    }

    public String asTableRow() {
        String resultado = null;
        resultado = String.format("<TR><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%f</TD><TD>%s</TD><TD>%s</TD><TD>%f</TD><TR>",
                this.NIF,
                this.concepto,
                this.fecha,
                this.importe,
                this.nombre,
                this.razon_social,
                this.tipo_de_IVA);
        return resultado;
    }

    public static Factura fromTabeddDescription(String tabDesc) throws ParseException {
        Factura fac;
        String[] f = tabDesc.split("\t");
        fac = new Factura();
        fac.NIF = f[0];
        fac.concepto = f[1];
        fac.fecha = f[2];
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        fac.importe = nf.parse(f[3]).floatValue();
        fac.razon_social = f[4];
        fac.tipo_de_IVA = nf.parse(f[5]).floatValue();

        return fac;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the razon_social
     */
    public String getDomicilio_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setDomicilio_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

    /**
     * @return the tipo_de_IVA
     */
    public float getTipo_de_IVA() {
        return tipo_de_IVA;
    }

    /**
     * @param tipo_de_IVA the tipo_de_IVA to set
     */
    public void setTipo_de_IVA(float tipo_de_IVA) {
        this.tipo_de_IVA = tipo_de_IVA;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
