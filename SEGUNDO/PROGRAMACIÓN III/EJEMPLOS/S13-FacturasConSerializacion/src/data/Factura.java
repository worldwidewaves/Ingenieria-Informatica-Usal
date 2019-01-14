/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package data;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;
import static com.coti.tools.Esdia.*;
import java.io.Serializable;

/**
 *
 * @author coti
 */
public class Factura implements Serializable {

    private String NIF;
    private String concepto;
    private String fecha;
    private float importe;
    private String nombre;
    private String razon_social;
    private float tipo_de_IVA;

    //
    // Static values used for random attributes
    //
    private static final String[] NIFS = {
        "12345678A",
        "23456789B",
        "34567890C"
    };
    private static final String[] CONCEPTOS = {
        "Recambios",
        "Fungibles",
        "Adquisiciones"
    };
    private static final String[] DIRECCIONES = {
        "Calle del Pez, 13",
        "Rue du Percebe, 14",
        "Roßauer Lände, 1",
        "Rebengasse, 3",
        "Krankenhausstraße, 1"
    };
    private static final String[] FECHAS = {
        "23/Nov/1989",
        "12/Oct/1492",
        "20/Feb/2038"
    };
    private static final String[] NOMBRES = {
        "John Doe", "Richard Roe",
        "Hans Wurst", "Juan Palomo"
    };
    private static final float IVAS[] = {
        10f,
        22f,
        6f
    };

    /*
     * En primer lugar vamos a crear tres constructores: uno que carece de
     * argumentos, otro que recibe una clase como argumento, y finalmente
     * un tercero que recibe como argumentos los valores de todos los campos.
     */
 /*
     * Este es el constructor sin argumentos.
     */
    public Factura() {
        this.NIF = "12345689X";
        this.concepto = "Reparación";
        this.fecha = "1-Septiembre-1939";
        this.importe = 123.456f;
        this.nombre = "Nombre Apellidos";
        this.razon_social = "Compañía ACME";
        this.tipo_de_IVA = 21;
    }

    /*
     * Este constructor admite una clase como argumento.
     */
    private Factura(Factura orig) {
        this.NIF = orig.NIF;
        this.concepto = orig.concepto;
        this.fecha = orig.fecha;
        this.importe = orig.importe;
        this.nombre = orig.nombre;
        this.razon_social = orig.razon_social;
        this.tipo_de_IVA = orig.tipo_de_IVA;
    }

    /*
     * Este constructor admite como argumentos
     * los valores de todos los campos.
     *
     */
    
    private Factura(String _NIF,
            String _concepto,
            String _fecha,
            float _importe,
            String _nombre,
            String _razon_social,
            float _tipo_IVA) {
        this.NIF = _NIF;
        this.concepto = _concepto;
        this.fecha = _fecha;
        this.importe = _importe;
        this.nombre = _nombre;
        this.razon_social = _razon_social;
        this.tipo_de_IVA = _tipo_IVA;
    }

    public static Factura instanceWithRandomAttributes() {
        Random r = new Random();

        Factura f = new Factura(
                NIFS[r.nextInt(NIFS.length)],
                CONCEPTOS[r.nextInt(CONCEPTOS.length)],
                FECHAS[r.nextInt(FECHAS.length)],
                1.0f + 1000.0f * r.nextFloat(),
                NOMBRES[r.nextInt(NOMBRES.length)],
                DIRECCIONES[r.nextInt(DIRECCIONES.length)],
                IVAS[r.nextInt(IVAS.length)]
        );

        return f;
    } // End of instanceWithRandomAttributes()

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

    // El delimitador es una cadena con una sola restricción: no puede formar
    // parte de los campos que separa
    public String exportStateWithDelimiters(String delimiter) {
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
                + "%s" // nombre
                + "%s" // Delimitador
                + "%s" // razon_social
                + "%s" // Delimitador
                + "%f",// tipo_de_IVA
                this.NIF,
                delimiter,
                this.concepto,
                delimiter,
                this.fecha,
                delimiter,
                this.importe,
                delimiter,
                this.nombre,
                delimiter,
                this.razon_social,
                delimiter,
                this.tipo_de_IVA);

        return resultado;
    }

    public static Factura createInstanceFromStringWithDelimiter(String line,
            String delimiter) throws ParseException {
        Factura fac;
        String[] f = line.split(delimiter);
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
     *
     * @return
     */
    public String exportStateAsHTMLRow() {
        return String.format("<TR><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%f</TD><TD>%s</TD><TD>%s</TD><TD>%f</TD><TR>",
                this.NIF,
                this.concepto,
                this.fecha,
                this.importe,
                this.nombre,
                this.razon_social,
                this.tipo_de_IVA);
    }

    /**
     *
     * @return
     */
    public String exportStateAsColumns() {
        return String.format("| %9s | %-15s | %11s | %7.2f | %-15s | %-25s | %8.2f |",
                this.NIF,
                this.concepto,
                this.fecha,
                this.importe,
                this.nombre,
                this.razon_social,
                this.tipo_de_IVA
        );
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
