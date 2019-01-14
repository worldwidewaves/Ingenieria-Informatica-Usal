package data;

import com.coti.tools.Rutas;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class Filmoteca {
    
    private final int NUM_PELICULAS = 20;
    private final int NUM_DIRECTORES = 20;
    private final int NUM_ACTORES = 50;
    private int numPeliculas;
    private int numDirectores;
    private int numActores;
    private Pelicula[] peliculas = new Pelicula[NUM_PELICULAS];
    private Director[] directores = new Director[NUM_DIRECTORES];
    private Actor[] actores = new Actor[NUM_ACTORES];
    
    private final String carpeta = "Filmot18";
    private final String archivoDirectores = "directores.col";
    private final String archivoPeliculas = "peliculas.html";
    private final String ficheroBinPeliculas = "peliculas.bin";
    private final String ficheroBinDirectores = "directores.bin";
    private final String ficheroBinActores = "actores.bin";
    private final String ficheroAltPeliculas = "peliculas.txt";
    private final String ficheroAltDirectores = "directores.txt";
    private final String ficheroAltActores = "actores.txt";
    
    public Filmoteca(){
        for(int i = 0; i < NUM_PELICULAS; i++){
            this.peliculas[i] = new Pelicula();
        }
        for(int i = 0; i < NUM_DIRECTORES; i++){
            this.directores[i] = new Director();
        }
        for(int i = 0; i < NUM_ACTORES; i++){
            this.actores[i] = new Actor();
        }
    }
    
    public void setNumPeliculas(int numPeliculas){
        this.numPeliculas = numPeliculas;
    }
    
    public void setNumDirectores(int numDirectores){
        this.numDirectores = numDirectores;
    }
    
    public void setNumActores(int numActores){
        this.numActores = numActores;
    }
    
    public int getNumPeliculas(){
        return this.numPeliculas;
    }
    
    public int getNumDirectores(){
        return this.numDirectores;
    }
    
    public int getNumActores(){
        return this.numActores;
    }
    
    public Pelicula[] getListadoPeliculas(){
        return peliculas;
    }
    
    public Director[] getListadoDirectores(){
        return directores;
    }
    
    public Actor[] getListadoActores() {
        return actores;
    }

    public String getNombreCarpeta() {
        return this.carpeta;
    }

    public String getNombreFicheroBinPeliculas() {
        return this.ficheroBinPeliculas;
    }

    public String getNombreFicheroBinDirectores() {
        return this.ficheroBinDirectores;
    }

    public String getNombreFicheroBinActores() {
        return this.ficheroBinActores;
    }
    
    public String getNombreFicheroAltPeliculas() {
        return this.ficheroAltPeliculas;
    }

    public String getNombreFicheroAltDirectores() {
        return this.ficheroAltDirectores;
    }

    public String getNombreFicheroAltActores() {
        return this.ficheroAltActores;
    }
    
    public String getNombreArchivoDirectores() {
        return this.archivoDirectores;
    }

    public String getNombreArchivoPeliculas() {
        return this.archivoPeliculas;
    }

    public Pelicula[] getPeliculas() {
        return this.peliculas;
    }

    public Director[] getDirectores() {
        return this.directores;
    }

    public Actor[] getActores() {
        return this.actores;
    }

    public String peliculaVaciaColumns(String titulo){
        return String.format("| %-56s | %-7s | %-8s | %-32s | %-19s |%n",
                titulo,
                "",
                "",
                "",
                "");
    }

    public void salida() {
        Path rutaPeliculas = Rutas.pathToFileInFolderOnDesktop(this.carpeta, this.ficheroBinPeliculas);
        Path rutaDirectores = Rutas.pathToFileInFolderOnDesktop(this.carpeta, this.ficheroBinDirectores);
        Path rutaActores = Rutas.pathToFileInFolderOnDesktop(this.carpeta, this.ficheroBinActores);
        try {
            FileOutputStream fos = new FileOutputStream(rutaPeliculas.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(peliculas);
            oos.close();
        } catch (IOException ex) {
                System.out.println("No fue posible guardar el archivo binario de películas");
                System.out.println(ex.toString());
        }
        try {
            FileOutputStream fos = new FileOutputStream(rutaDirectores.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(directores);
            oos.close();
        } catch (IOException ex) {
                System.out.println("No fue posible guardar el archivo binario de directores");
                System.out.println(ex.toString());
        }
        try {
            FileOutputStream fos = new FileOutputStream(rutaActores.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(actores);
            oos.close();
        } catch (IOException ex) {
                System.out.println("No fue posible guardar el archivo binario de actores");
                System.out.println(ex.toString());
        }
    }

    public void leerBinPeliculas() {
        Path rutaPeliculas = Rutas.pathToFileInFolderOnDesktop(this.carpeta, this.ficheroBinPeliculas);
        try {
            FileInputStream fis = new FileInputStream(rutaPeliculas.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            peliculas = (Pelicula[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No fue posible leer el archivo binario de películas");
            System.out.println(ex.toString());
        }
    }

    public void leerBinDirectores() {
        Path rutaDirectores = Rutas.pathToFileInFolderOnDesktop(this.carpeta, this.ficheroBinDirectores);
        try {
            FileInputStream fis = new FileInputStream(rutaDirectores.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            directores = (Director[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No fue posible leer el archivo binario de directores");
            System.out.println(ex.toString());
        }
    }

    public void leerBinActores() {
        Path rutaActores = Rutas.pathToFileInFolderOnDesktop(this.carpeta, this.ficheroBinActores);
        try {
            FileInputStream fis = new FileInputStream(rutaActores.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            actores = (Actor[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No fue posible leer el archivo binario de actores");
            System.out.println(ex.toString());
        }
    }
}
