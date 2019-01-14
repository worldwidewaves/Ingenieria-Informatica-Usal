package datos;

import java.util.Random;

/**
 *
 * @author bruegel
 */
public class MiniPersona {

    private String nombre;
    private int edad;
    private float peso;

    public void miniSetRandomAttributes() {
        String[] nombres_aleatorios = {
            "María", "José"
        };
        Random r = new Random();
        this.nombre = nombres_aleatorios[r.nextInt(nombres_aleatorios.length)];
        this.edad = 18 + r.nextInt(81);
        this.peso = (float) (40.0 + r.nextInt(60));
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
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }
}
