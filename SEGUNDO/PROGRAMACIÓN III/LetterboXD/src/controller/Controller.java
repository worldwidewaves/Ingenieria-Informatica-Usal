package controller;

import com.coti.tools.Rutas;
import data.Actor;
import data.Director;
import data.Filmoteca;
import data.Pelicula;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Controller {
    Filmoteca m = new Filmoteca();  //  Filmoteca = Modelo
    
    public int arranque() {
        /**
         * Pedir al modelo el nombre de los ficheros y la ruta de estos
         */
        String carpeta = m.getNombreCarpeta();
        String ficheroPeliculas = m.getNombreFicheroBinPeliculas();
        String ficheroDirectores = m.getNombreFicheroBinDirectores();
        String ficheroActores = m.getNombreFicheroBinActores();
        Path rutaPeliculas = Rutas.pathToFileInFolderOnDesktop(carpeta, ficheroPeliculas);
        Path rutaDirectores = Rutas.pathToFileInFolderOnDesktop(carpeta, ficheroDirectores);
        Path rutaActores = Rutas.pathToFileInFolderOnDesktop(carpeta, ficheroActores);
        
        /**
         * Si los archivos no existen, usar los .txt
         */
        if (!Files.exists(rutaPeliculas)){
            ficheroPeliculas = m.getNombreFicheroAltPeliculas();
            rutaPeliculas = Rutas.pathToFileInFolderOnDesktop(carpeta, ficheroPeliculas);
            if (!Files.exists(rutaPeliculas)){
                /**
                * Si los .txt no existen, se manda un error
                */
                System.err.printf("%n%nNO EXISTE %s EN ~Desktop/%s%n%n", ficheroPeliculas, carpeta);
                System.err.println("\n\nCOPIE DATOS EN EL ESCRITORIO\n\n");
                return -1;
            }
            /**
            * Si los archivos no se puede leer, notificar al usuario
            */
            List<String> tmpPeliculas;
            try {
                tmpPeliculas = Files.readAllLines(rutaPeliculas);
            } catch(IOException ex) {
                System.err.printf("%n%nERROR: No fue posible leer el archivo '%s'%n%n", ficheroPeliculas);
                return -2;
            }
            /**
            * Leer .txt's
            */
            Pelicula[] p = m.getPeliculas();
            m.setNumPeliculas(tmpPeliculas.size());
            for(int i = 0; i < tmpPeliculas.size(); i++){
                String[] campos = tmpPeliculas.get(i).split("#");
                p[i].setTitulo(campos[0]);
                p[i].setAnnio(campos[1]);
                p[i].setDuracion(campos[2]);
                p[i].setPais(campos[3]);
                String[] subcampo1 = campos[4].split("\t");
                p[i].setDireccion(subcampo1);
                p[i].setGuion(campos[5]);
                p[i].setMusica(campos[6]);
                p[i].setFotografia(campos[7]);
                String[] subcampo2 = campos[8].split("\t");
                p[i].setReparto(subcampo2);
                p[i].setProductora(campos[9]);
                p[i].setGenero(campos[10]);
                p[i].setSinopsis(campos[11]);
            }
        } else {
            m.leerBinPeliculas();
            int p = 0;
            Pelicula[] peliculas = m.getPeliculas();
            for (Pelicula pelicula : peliculas){
                if (pelicula.getTitulo() != null){
                    p++;
                }
            }
            m.setNumPeliculas(p);
        }
        
        if (!Files.exists(rutaDirectores)){
            ficheroDirectores = m.getNombreFicheroAltDirectores();
            rutaDirectores = Rutas.pathToFileInFolderOnDesktop(carpeta, ficheroDirectores);
            if (!Files.exists(rutaDirectores)){
                /**
                * Si los .txt no existen, se manda un error
                */
                System.err.printf("%n%nNO EXISTE %s EN ~Desktop/%s%n%n", ficheroDirectores, carpeta);
                System.err.println("\n\nCOPIE DATOS EN EL ESCRITORIO\n\n");
                return -1;
            }
            /**
            * Si los archivos no se puede leer, notificar al usuario
            */
            List<String> tmpDirectores;
            try {
                tmpDirectores = Files.readAllLines(rutaDirectores);
            } catch(IOException ex) {
                System.err.printf("%n%nERROR: No fue posible leer el archivo '%s'%n%n", ficheroDirectores);
                return -2;
            }
            /**
            * Leer .txt's
            */
            Director[] d = m.getDirectores();
            m.setNumDirectores(tmpDirectores.size());
            for(int i = 0; i < tmpDirectores.size(); i++){
                String[] campos = tmpDirectores.get(i).split("#");
                d[i].setNombre(campos[0]);
                d[i].setFechaDeNacimiento(campos[1]);
                d[i].setNacionalidad(campos[2]);
                d[i].setOcupacion(campos[3]);
                String[] subcampo1 = campos[4].split("\t");
                d[i].setPeliculas(subcampo1);
            }
        } else {
            m.leerBinDirectores();
            int d = 0;
            Director[] directores = m.getDirectores();
            for (Director director : directores){
                if (director.getNombre() != null){
                    d++;
                }
            }
            m.setNumDirectores(d);
        }
        if (!Files.exists(rutaActores)){
            ficheroActores = m.getNombreFicheroAltActores();
            rutaActores = Rutas.pathToFileInFolderOnDesktop(carpeta, ficheroActores);
            if (!Files.exists(rutaActores)){
                /**
                * Si los .txt no existen, se manda un error
                */
                System.err.printf("%n%nNO EXISTE %s EN ~Desktop/%s%n%n", ficheroActores, carpeta);
                System.err.println("\n\nCOPIE DATOS EN EL ESCRITORIO\n\n");
                return -1;
            }
            /**
            * Si los archivos no se puede leer, notificar al usuario
            */
            List<String> tmpActores;
            try {
                tmpActores = Files.readAllLines(rutaActores);
            } catch(IOException ex) {
                System.err.printf("%n%nERROR: No fue posible leer el archivo '%s'%n%n", ficheroActores);
                return -2;
            }
            /**
            * Leer .txt's
            */
            Actor[] a = m.getActores();
            m.setNumActores(tmpActores.size());
            for(int i = 0; i < tmpActores.size(); i++){
                String[] campos = tmpActores.get(i).split("#");
                a[i].setNombre(campos[0]);
                a[i].setFechaDeNacimiento(campos[1]);
                a[i].setNacionalidad(campos[2]);
                a[i].setAnnioDeDebut(campos[3]);
                String[] subcampo1 = campos[4].split("\t");
                a[i].setPeliculas(subcampo1);
            }
        } else {
            m.leerBinActores();
            int a = 0;
            Actor[] actores = m.getActores();
            for (Actor actor : actores){
                if (actor.getNombre() != null){
                    a++;
                }
            }
            m.setNumActores(a);
        }
        
        return 0;
    }
    
    public String exportarDirectores() {
        /**
         * Pedir al modelo el nombre de los ficheros y la ruta de estos
         */
        String carpeta = m.getNombreCarpeta();
        String archivoDirectores = m.getNombreArchivoDirectores();
        
        return archivoDirectores;
    }

    public String exportarPeliculas() {
        /**
         * Pedir al modelo el nombre de los ficheros y la ruta de estos
         */
        String carpeta = m.getNombreCarpeta();
        String archivoPeliculas = m.getNombreArchivoPeliculas();
        
        return archivoPeliculas;
    }
  
    public String[] obtenerListadoPeliculas(){
        if(m.getListadoPeliculas()[0] == null){
            return null;
        }
        String[] temp = new String[m.getNumPeliculas()];
        for(int i = 0; i < temp.length; i++){
            temp[i] = m.getListadoPeliculas()[i].exportStateAsColums();
        }
        return temp;
    }

    public String[] obtenerListadoDirectores() {
        if(m.getListadoDirectores()[0] == null){
            return null;
        }
        String[] temp = new String[m.getNumDirectores()];
        for(int i = 0; i < temp.length; i++){
            temp[i] = m.getListadoDirectores()[i].exportStateAsColums();
        }
        return temp;
    }

    public String[] obtenerListadoActores() {
        if(m.getListadoActores()[0] == null){
            return null;
        }
        String[] temp = new String[m.getNumActores()];
        for(int i = 0; i < temp.length; i++){
            temp[i] = m.getListadoActores()[i].exportStateAsColums();
        }
        return temp;
    }
    
    public int peliculasGetIndiceByTitulo(String titulo) {
        Pelicula[] p = m.getPeliculas();
        
        for (int i = 0; i < m.getNumPeliculas(); i++){
            if (titulo.equals(p[i].getTitulo())){
                return i;
            }
        }
        return -1;
    }
    
    public int directoresGetIndiceByNombre(String nombre) {
        Director[] d = m.getDirectores();
        
        for (int i = 0; i < m.getNumDirectores(); i++){
            if (nombre.equals(d[i].getNombre())){
                return i;
            }
        }
        return -1;
    }
    
    public int actoresGetIndiceByNombre(String nombre) {
        Actor[] a = m.getActores();
        
        for (int i = 0; i < m.getNumActores(); i++){
            if (nombre.equals(a[i].getNombre())){
                return i;
            }
        }
        return -1;
    }

    public void directoresAltas(String nombre, LocalDate fechaDeNacimiento, String nacionalidad, String ocupacion, String[] peliculas) {
        Director[] d = m.getDirectores();
        int numDirectores = m.getNumDirectores();
       
        d[numDirectores].setNombre(nombre);
        d[numDirectores].setFechaDeNacimientoLC(fechaDeNacimiento);
        d[numDirectores].setNacionalidad(nacionalidad);
        d[numDirectores].setOcupacion(ocupacion);
        d[numDirectores].setPeliculas(peliculas);
        
        m.setNumDirectores(numDirectores + 1);
    }
    
    public void peliculasAltas(String titulo, int annio, int duracion, String pais, String[] directores, String guion, String musica, String fotografia, String[] actores, String productora, String genero, String sinopsis) {
        Pelicula[] p = m.getPeliculas();
        int numPeliculas = m.getNumPeliculas();
        
        p[numPeliculas].setTitulo(titulo);
        p[numPeliculas].setAnnioINT(annio);
        p[numPeliculas].setDuracionINT(duracion);
        p[numPeliculas].setPais(pais);
        p[numPeliculas].setDireccion(directores);
        p[numPeliculas].setGuion(guion);
        p[numPeliculas].setMusica(musica);
        p[numPeliculas].setFotografia(fotografia);
        p[numPeliculas].setReparto(actores);
        p[numPeliculas].setProductora(productora);
        p[numPeliculas].setGenero(genero);
        p[numPeliculas].setSinopsis(sinopsis);
        
        m.setNumPeliculas(numPeliculas + 1);
    }

    public String directoresGetFechaDeNacimiento(int indice) {
        Director[] d = m.getDirectores();
        return d[indice].getFechaDeNacimiento();
    }

    public String directoresGetNacionalidad(int indice) {
        Director[] d = m.getDirectores();
        return d[indice].getNacionalidad();
    }

    public String directoresGetOcupacion(int indice) {
        Director[] d = m.getDirectores();
        return d[indice].getOcupacion();
    }

    public void directoresSetFechaDeNacimiento(int indice, LocalDate fechaDeNacimiento) {
        Director[] d = m.getDirectores();
        d[indice].setFechaDeNacimientoLC(fechaDeNacimiento);
    }

    public void directoresSetNacionalidad(int indice, String nacionalidad) {
        Director[] d = m.getDirectores();
        d[indice].setNacionalidad(nacionalidad);
    }

    public void directoresSetOcupacion(int indice, String ocupacion) {
        Director[] d = m.getDirectores();
        d[indice].setOcupacion(ocupacion);
    }

    public void directoresBorrarDirector(int indice) {
        Director[] d = m.getDirectores();
        int numDirectores = m.getNumDirectores();
        for (int i = indice; i < numDirectores; i++){
            if (i != numDirectores - 1){
                d[i] = d[i+1];
            }
        }
        m.setNumDirectores(numDirectores - 1);
    }
    
    public void peliculasBorrarPelicula(int indice) {
        Pelicula[] p = m.getPeliculas();
        int numPeliculas = m.getNumPeliculas();
        for (int i = indice; i < numPeliculas; i++){
            if (i != numPeliculas - 1){
                p[i] = p[i+1];
            }
        }
        m.setNumDirectores(numPeliculas - 1);   // setNumPeliculas ???
    }

    public String[] directoresComprobarPeliculas(int indice) {
        Director[] d = m.getDirectores();
        String[] peliculas = d[indice].getPeliculas();
        int tam = 0;
        
        for (String pelicula : peliculas) {
            if (this.peliculasGetIndiceByTitulo(pelicula) != -1) {
                tam++;
            }
        }
        
        String[] peliculasEncontradas = new String[tam];
        
        int a = 0;
        for (String pelicula : peliculas) { //  seguro que se puede hacer con un bucle solo
            if (this.peliculasGetIndiceByTitulo(pelicula) != -1) {
                peliculasEncontradas[a] = pelicula;
                a++;
            }
        }
        
        return peliculasEncontradas;
    }

    public void actoresAltas(String nombre, LocalDate fechaDeNacimiento, String nacionalidad, int annioDeDebut, String[] peliculas) {
        Actor[] d = m.getActores();
        int numActores = m.getNumActores();
       
        d[numActores].setNombre(nombre);
        d[numActores].setFechaDeNacimientoLC(fechaDeNacimiento);
        d[numActores].setNacionalidad(nacionalidad);
        d[numActores].setAnnioDeDebutINT(annioDeDebut);
        d[numActores].setPeliculas(peliculas);
        
        m.setNumActores(numActores + 1);
    }

    public String actoresGetFechaDeNacimiento(int indice) {
        Actor[] a = m.getActores();
        return a[indice].getFechaDeNacimiento();
    }

    public String actoresGetNacionalidad(int indice) {
        Actor[] a = m.getActores();
        return a[indice].getNacionalidad();
    }

    public String actoresGetAnnioDeDebut(int indice) {
        Actor[] a = m.getActores();
        return a[indice].getAnnioDeDebut();
    }

    public void actoresSetFechaDeNacimiento(int indice, LocalDate fechaDeNacimiento) {
        Actor[] a = m.getActores();
        a[indice].setFechaDeNacimientoLC(fechaDeNacimiento);
    }

    public void actoresSetNacionalidad(int indice, String nacionalidad) {
        Actor[] a = m.getActores();
        a[indice].setNacionalidad(nacionalidad);
    }

    public void actoresSetAnnioDeDebut(int indice, int annioDeDebut) {
        Actor[] a = m.getActores();
        a[indice].setAnnioDeDebutINT(annioDeDebut);
    }

    public String[] actoresComprobarPeliculas(int indice) {
        Actor[] a = m.getActores();
        String[] peliculas = a[indice].getPeliculas();
        int tam = 0;
        
        for (String pelicula : peliculas) {
            if (this.peliculasGetIndiceByTitulo(pelicula) != -1) {
                tam++;
            }
        }
        
        String[] peliculasEncontradas = new String[tam];
        
        int b = 0;
        for (String pelicula : peliculas) {
            if (this.peliculasGetIndiceByTitulo(pelicula) != -1) {
                peliculasEncontradas[b] = pelicula;
                b++;
            }
        }
        
        return peliculasEncontradas;
    }

    public void actoresBorrarActor(int indice) {
        Actor[] a = m.getActores();
        int numActores = m.getNumActores();
        for (int i = indice; i < numActores; i++){
            if (i != numActores - 1){   // hacer hasta i < numActores - 1 ???
                a[i] = a[i+1];
            }
        }
        m.setNumDirectores(numActores - 1); // setNumActores ???
    }

    public String[] obtenerListadoPeliculasActor(int indice) {
        if(m.getListadoPeliculas()[0] == null){
            return null;
        }
        
        Actor[] a = m.getActores();
        Pelicula[] p = m.getPeliculas();
        String[] peliculas = a[indice].getPeliculas();
        
        for (int b = 0; b < peliculas.length; b++) {
            if (peliculas[b].equals(p[b].getTitulo())){
                peliculas[b] = p[b].exportStateAsColums();
            } else {
                peliculas[b] = m.peliculaVaciaColumns(peliculas[b]);
            }
        }
        
        return peliculas;
    }

    public void salida() {
        m.salida();
    }

    public String peliculasGetAnnio(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getAnnio();
    }

    public String peliculasGetDuracion(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getDuracion();
    }

    public String peliculasGetPais(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getPais();
    }

    public String peliculasGetDireccion(int indice) {
        Pelicula[] p = m.getPeliculas();
        return Arrays.toString(p[indice].getDireccion());
    }

    public String peliculasGetGuion(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getGuion();
    }

    public String peliculasGetMusica(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getMusica();
    }

    public String peliculasGetFotografia(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getFotografia();
    }

    public String peliculasGetReparto(int indice) {
        Pelicula[] p = m.getPeliculas();
        return Arrays.toString(p[indice].getReparto());
    }

    public String peliculasGetProductora(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getProductora();
    }

    public String peliculasGetGenero(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getGenero();
    }

    public String peliculasGetSinopsis(int indice) {
        Pelicula[] p = m.getPeliculas();
        return p[indice].getSinopsis();
    }

    public void peliculasSetAnnio(int indice, int annio) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setAnnioINT(annio);
    }

    public void peliculasSetDuracion(int indice, int duracion) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setDuracionINT(duracion);
    }

    public void peliculasSetPais(int indice, String pais) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setPais(pais);
    }

    public void peliculasSetGuion(int indice, String guion) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setGuion(guion);
    }

    public void peliculasSetMusica(int indice, String musica) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setMusica(musica);
    }

    public void peliculasSetFotografia(int indice, String fotografia) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setFotografia(fotografia);
    }

    public void peliculasSetProductora(int indice, String productora) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setProductora(productora);
    }

    public void peliculasSetGenero(int indice, String genero) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setGenero(genero);
    }

    public void peliculasSetSinopsis(int indice, String sinopsis) {
        Pelicula[] p = m.getPeliculas();
        p[indice].setSinopsis(sinopsis);
    }    

}
