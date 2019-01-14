/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg500_a20;

import static com.coti.esdia.Esdia.*;

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

    /*
     * En primer lugar vamos a crear tres constructores: uno que carece de 
     * argumentos, otro que recibe una clase como argumento, y finalmente
     * un tercero que recibe como argumentos los valores de todos los campos.
     */
    
    /*
     * Este es el constructor sin argumentos.
     */
    public Factura(){
        this.NIF = "12345689X";
        this.concepto = "Reparación";
        this.razon_social = "Compañía ACME";
        this.fecha = "1-Septiembre-1939";
        this.importe = 123.456f;
        this.nombre = "Nombre Apellidos";
        this.tipo_de_IVA = 21;
    }
    
    /*
     * Este es el constructor que admite una clase como argumento.
     */
    public Factura(Factura orig) {
        this.NIF = orig.NIF;
        this.concepto = orig.concepto;
        this.razon_social = orig.razon_social;
        this.fecha = orig.fecha;
        this.importe = orig.importe;
        this.nombre = orig.nombre;
        this.tipo_de_IVA = orig.tipo_de_IVA;
        
    }
    /*
     * Finalmente este es el constructor que admite como argumentos
     * los valores de todos los campos.
     * 
     */
    
    public Factura(String _NIF,
            String _concepto,
            String _razon,
            String _fecha,
            float _importe,
            String _nombre,
            float _tipo_IVA) {
        this.NIF = _NIF;
        this.concepto = _concepto;
        this.fecha = _fecha;
        this.importe = _importe;
        this.nombre = _nombre;
        this.razon_social = _razon;
        this.tipo_de_IVA = _tipo_IVA;
    }
        /*
         * A continuación se incluyen los métodos necesarios para leer de
         * teclado y escribir en pantalla el estado de una clase.
         */
        // Métodos auxiliares
    public void leerDeTeclado() {
        this.NIF =          readString("Por favor, escriba el NIF                   : ");
        this.concepto =     readString("Por favor, escriba el concepto              : ");
        this.fecha =        readString("Por favor, escriba la fecha                 : ");
        this.importe =       readFloat("Por favor, escriba el importe               : ");
        this.nombre =       readString("Por favor, escriba el nombre                : ");
        this.razon_social = readString("Por favor, escriba la razón social          : ");
        this.tipo_de_IVA =   readFloat("Por favor, escriba el tipo de IVA           : ");
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
