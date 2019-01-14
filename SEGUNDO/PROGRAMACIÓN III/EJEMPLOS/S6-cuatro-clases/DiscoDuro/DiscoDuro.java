package pkg500_a10;

import static com.coti.esdia.Esdia.*;

/**
 *
 * @author bruegel
 */
public class HardDisk {

    private String fabricante;
    private String modelo;
    private String tecnologia;
    private float megabytes;
    private int velocidadDeRotacion;
    private int tasaDeTransmision;
    private String tipoDeInterface;
    private String numeroDeSerie;

    //
    // Contructores de la clase
    // Este es el constructor sin argumentos. Este constructor es muy primitivo.
    // En versiones posteriores, se crearán constructores que den valores 
    // aleatorios razonables los campos.
    //
    HardDisk() {
        fabricante = "Fabricante";
        modelo = "Modelo";
        tecnologia = "Tecnología";
        megabytes = 0;
        velocidadDeRotacion = 0;
        tasaDeTransmision = 0;
        tipoDeInterface = "Interface";
        numeroDeSerie = "Número de serie";
    }

    // Este constructor sirve para crea una copia de otra clase
    HardDisk(HardDisk orig) {
        this.fabricante = orig.fabricante;
        this.megabytes = orig.megabytes;
        this.modelo = orig.modelo;
        this.numeroDeSerie = orig.numeroDeSerie;
        this.tasaDeTransmision = orig.tasaDeTransmision;
        this.tecnologia = orig.tecnologia;
        this.tipoDeInterface = orig.tipoDeInterface;
        this.velocidadDeRotacion = orig.velocidadDeRotacion;
    }

    // Este constructor sirve para proporcionar directamente a la clase 
    // los valores de todos sus atributos.
    HardDisk(String fab,
            String mod,
            String tec,
            float cap,
            int velRot,
            int velTran,
            String tipoInt,
            String serial) {
        fabricante = fab;
        modelo = mod;
        tecnologia = tec;
        megabytes = cap;
        velocidadDeRotacion = velRot;
        tasaDeTransmision = velTran;
        tipoDeInterface = tipoInt;
        numeroDeSerie = serial;
    }

    // Métodos auxiliares
    public void leerDeTeclado() {
        fabricante = readString("Por favor, escriba el fabricante            : ");
        modelo = readString("Por favor, escriba el modelo                : ");
        tecnologia = readString("Tipo de tecnología (Winchester etc)         : ");
        megabytes = readFloat("Por favor, escriba la capacidad (MB)        : ");
        velocidadDeRotacion = readInt("Por favor, escriba la velocidad de rotacion : ");
        tasaDeTransmision = readInt("Por favor, escriba la tasa de transmision   : ");
        tipoDeInterface = readString("Por favor, escriba el tipo de interface     : ");
        numeroDeSerie = readString("Por favor, escriba el número de serie       : ");
    }

    public void escribirEnPantalla() {
        System.out.printf("+-----------------------------------------------+%n");
        System.out.printf("| Fabricante                : %17s |%n", fabricante);
        System.out.printf("| Modelo                    : %17s |%n", modelo);
        System.out.printf("| Tecnología                : %17s |%n", tecnologia);
        System.out.printf("| Megabytes                 : %17s |%n", megabytes);
        System.out.printf("| Velocidad de rotación     : %17s |%n", velocidadDeRotacion);
        System.out.printf("| Velocidad de transmisión  : %17s |%n", tasaDeTransmision);
        System.out.printf("| Tipo de Interface         : %17s |%n", tipoDeInterface);
        System.out.printf("| Número de serie           : %17s |%n", numeroDeSerie);
        System.out.printf("+-----------------------------------------------+%n");

    }

    // A continuación se tienen los métodos de acceso, que han sido creados
    // automáticamente. 
    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the tecnologia
     */
    public String getTecnologia() {
        return tecnologia;
    }

    /**
     * @param tecnologia the tecnologia to set
     */
    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    /**
     * @return the megabytes
     */
    public float getMegabytes() {
        return megabytes;
    }

    /**
     * @param megabytes the megabytes to set
     */
    public void setMegabytes(float megabytes) {
        this.megabytes = megabytes;
    }

    /**
     * @return the velocidadDeRotacion
     */
    public int getVelocidadDeRotacion() {
        return velocidadDeRotacion;
    }

    /**
     * @param velocidadDeRotacion the velocidadDeRotacion to set
     */
    public void setVelocidadDeRotacion(int velocidadDeRotacion) {
        this.velocidadDeRotacion = velocidadDeRotacion;
    }

    /**
     * @return the tasaDeTransmision
     */
    public int getTasaDeTransmision() {
        return tasaDeTransmision;
    }

    /**
     * @param tasaDeTransmision the tasaDeTransmision to set
     */
    public void setTasaDeTransmision(int tasaDeTransmision) {
        this.tasaDeTransmision = tasaDeTransmision;
    }

    /**
     * @return the tipoDeInterface
     */
    public String getTipoDeInterface() {
        return tipoDeInterface;
    }

    /**
     * @param tipoDeInterface the tipoDeInterface to set
     */
    public void setTipoDeInterface(String tipoDeInterface) {
        this.tipoDeInterface = tipoDeInterface;
    }

    /**
     * @return the numeroDeSerie
     */
    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    /**
     * @param numeroDeSerie the numeroDeSerie to set
     */
    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
}
