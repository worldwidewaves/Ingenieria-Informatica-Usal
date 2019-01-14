/*
 * No todos los métodos hacen falta para ArraysTest
 * He añadido el método showListAsTable()
 */
package arraystest;

/**
 *
 * @author bruegel
 */
/*
 * Ojo a la siguiente sentencia de importación
 */
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;
import static com.coti.esdia.Esdia.*;
import java.util.Arrays;

/**
 *
 * @author bruegel
 */
public class Factura {

    private String nombreReceptor;
    private String direccionDelReceptor;
    private String NIFdelReceptor;
    private float importe;
    private float tipo_de_IVA;
    private String fecha;
    private String concepto;

    @Override
    public String toString() {
        return "{" + this.nombreReceptor
                + ","
                + this.direccionDelReceptor
                + ", "
                + this.NIFdelReceptor
                + ", "
                + this.importe
                + ", "
                + this.tipo_de_IVA
                + ", "
                + this.fecha
                + ", "
                + this.concepto
                + "}\n";
    }

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
                    f.nombreReceptor, f.direccionDelReceptor, f.NIFdelReceptor, f.importe,
                    f.tipo_de_IVA, f.fecha, f.concepto);
        } // fin for
        System.out.println(separador);
    } // fin showListAsTable

       public static void showList(String[] _lista) {
        if (_lista == null) {
            System.err.println("Lista null!!!");
            return;
        }
        if (_lista.length == 0) {
            System.err.println("Lista vacía!!!");
            return;
        }
        System.out.printf("{ %s", _lista[0]);
        for (int i = 1; i < _lista.length; i++) {
            System.out.printf(", %s", _lista[i]);
        }
        System.out.printf(" }%n");
    }

    public static void showList2(String[] _lista) {
        if (_lista == null) {
            System.err.println("Lista null!!!");
            return;
        }
        if (_lista.length == 0) {
            System.err.println("Lista vacía!!!");
            return;
        }
        System.out.println(Arrays.toString(_lista));
    }

    
    public void setRandomAttributes() {
        String[] nifs = {"12345678A", "23456789B",
            "34567890C", "222b"};
        String[] conceptos = {"Recambios", "Fungibles",
            "Adquisiciones"};
        String[] razonesSociales = {
            "Calle del Pez, 13", "Rue du Percebe, 14",
            "Roßauer Lände, 1",
            "Rebengasse, 3", "Krankenhausstraße, 1"};
        String[] fechas = {"23/Nov/1989", "12/Oct/1492",
            "20/Feb/2038"};
        float[] importes = {12.25f, 120.35f, 1234.23f,
            9999.99f};
        String[] nombres = {"John Doe", "Richard Roe",
            "Hans Wurst", "Juan Palomo"};
        float ivas[] = {10f, 22f, 6f};
        Random r = new Random();
        this.NIFdelReceptor = nifs[r.nextInt(nifs.length)];
        this.concepto = conceptos[r.nextInt(conceptos.length)];
        this.fecha = fechas[r.nextInt(fechas.length)];
        this.importe = importes[r.nextInt(importes.length)];
        this.nombreReceptor = nombres[r.nextInt(nombres.length)];
        this.direccionDelReceptor = razonesSociales[r.nextInt(razonesSociales.length)];
        this.tipo_de_IVA = ivas[r.nextInt(ivas.length)];
    }

    /*
   * A continuación se incluyen los métodos necesarios para leer de
   * teclado y escribir en pantalla el estado de una clase.
     */

    public void leerDeTeclado() {
        this.NIFdelReceptor = readString("Por favor, escriba el NIF             : ");
        this.concepto = readString("Por favor, escriba el concepto        : ");
        this.fecha = readString("Por favor, escriba la fecha           : ");
        this.importe = readFloat("Por favor, escriba el importe         : ");
        this.nombreReceptor = readString("Por favor, escriba el nombre          : ");
        this.direccionDelReceptor = readString("Por favor, escriba la razón social    : ");
        this.tipo_de_IVA = readFloat("Por favor, escriba el tipo de IVA     : ");
    }

    public void escribirEnPantalla() {
        System.out.printf("+-----------------------------------------------+%n");
        System.out.printf("| NIF                       : %17s |%n", this.NIFdelReceptor);
        System.out.printf("| Concepto                  : %17s |%n", this.concepto);
        System.out.printf("| Fecha                     : %17s |%n", this.fecha);
        System.out.printf("| Importe                   : %17s |%n",
                this.importe);
        System.out.printf("| Nombre                    : %17s |%n", this.nombreReceptor);
        System.out.printf("| Razón social              : %17s |%n", this.direccionDelReceptor);
        System.out.printf("| Tipo de IVA               : %17s |%n",
                this.tipo_de_IVA);
        System.out.printf("+-----------------------------------------------+%n");

    }

    /*
   * Estos son los métodos de escritura y lectura disco
     */

    // El delimitador es una cadena con una sola restricción: no puede formar
    // parte de los campos que separa
    public String exportWithDelimiter(String _delimitador) {
        String resultado;
        resultado = String.format("%s" // NIFdelReceptor
                + "%s" // Delimitador
                + "%s" // concepto
                + "%s" // Delimitador
                + "%s" // fecha
                + "%s" // Delimitador
                + "%f" // importe
                + "%s" // Delimitador
                + "%d" // nombreReceptor
                + "%s" // Delimitador
                + "%d" // razon_social
                + "%s" // Delimitador
                + "%f",// tipo_de_IVA
                this.NIFdelReceptor,
                _delimitador,
                this.concepto,
                _delimitador,
                this.fecha,
                _delimitador,
                this.importe,
                _delimitador,
                this.nombreReceptor,
                _delimitador,
                this.direccionDelReceptor,
                _delimitador,
                this.tipo_de_IVA);

        return resultado;
    }

    public static Factura importFromDelimitedString(String _delimitedText,
            String _delimiter) throws ParseException {
        Factura fac;
        String[] f = _delimitedText.split(_delimiter);
        fac = new Factura();
        fac.NIFdelReceptor = f[0];
        fac.concepto = f[1];
        fac.fecha = f[2];
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        fac.importe = nf.parse(f[3]).floatValue();
        fac.direccionDelReceptor = f[4];
        fac.tipo_de_IVA = nf.parse(f[5]).floatValue();

        return fac;
    }

    public String asTableRow() {
        String resultado;
        resultado = String.format("<TR><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%f</TD><TD>%s</TD><TD>%s</TD><TD>%f</TD><TR>",
                this.NIFdelReceptor,
                this.concepto,
                this.fecha,
                this.importe,
                this.nombreReceptor,
                this.direccionDelReceptor,
                this.tipo_de_IVA);
        return resultado;
    }

    public static Factura fromTabeddDescription(String tabDesc) throws ParseException {
        Factura fac;
        String[] f = tabDesc.split("\t");
        fac = new Factura();
        fac.NIFdelReceptor = f[0];
        fac.concepto = f[1];
        fac.fecha = f[2];
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        fac.importe = nf.parse(f[3]).floatValue();
        fac.direccionDelReceptor = f[4];
        fac.tipo_de_IVA = nf.parse(f[5]).floatValue();

        return fac;
    }

    /**
     * @return the nombreReceptor
     */
    public String getNombreReceptor() {
        return nombreReceptor;
    }

    /**
     * @param nombreReceptor the nombreReceptor to set
     */
    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    /**
     * @return the razon_social
     */
    public String getDomicilio_social() {
        return direccionDelReceptor;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setDomicilio_social(String razon_social) {
        this.direccionDelReceptor = razon_social;
    }

    /**
     * @return the NIFdelReceptor
     */
    public String getNIFdelReceptor() {
        return NIFdelReceptor;
    }

    /**
     * @param NIFdelReceptor the NIFdelReceptor to set
     */
    public void setNIFdelReceptor(String NIFdelReceptor) {
        this.NIFdelReceptor = NIFdelReceptor;
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
