package data;

import java.io.Serializable;

public class Pelicula implements Serializable{
    
    private String titulo;
    private int annio;
    private int duracion;
    private String pais;
    private String[] direccion;
    private String guion;
    private String musica;
    private String fotografia;
    private String[] reparto;
    private String productora;
    private String genero;
    private String sinopsis;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        if (!"".equals(this.titulo)){
            return this.titulo;
        }
        return "-- Vacio --";
    }
    
    public void setAnnio(String annio) {
        if (!"".equals(annio)){
            this.annio = Integer.parseInt(annio);
        }
    }
    
    public int getAnnioINT() {
        return this.annio;
    }
    
    public void setAnnioINT(int annio) {
        this.annio = annio;
    }

    public String getAnnio() {
        if (this.annio != 0){
            return String.valueOf(this.annio);
        }
        return "-- Vacio --";
    }
    
    public void setDuracion(String duracion) {
        if (!"".equals(duracion)){
            this.duracion = Integer.parseInt(duracion);
        }
    }
    
    public String getDuracion() {
        if (this.duracion != 0){
            return String.valueOf(this.duracion);
        }
        return "-- Vacio --";
    }
    
    public void setDuracionINT(int duracion) {
        this.duracion = duracion;
    }
    
    public int getDuracionINT() {
        return this.duracion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getPais() {
        if (!"".equals(this.pais)){
            return this.pais;
        }
        return "-- Vacio --";
    }

    public void setDireccion(String[] direccion) {
        this.direccion = direccion;
    }
    
    public String[] getDireccion() {
        String[] vacio = new String[1];
        vacio[0] = "-- Vacio ---";
        
        if (this.direccion[0] != null){
            return this.direccion;
        }
        return vacio;
    }

    public void setGuion(String guion) {
        this.guion = guion;
    }
    
    public String getGuion() {
        if (!"".equals(this.guion)){
            return this.guion;
        }
        return "-- Vacio --";
    }
    
    public void setMusica(String musica) {
        this.musica = musica;
    }
    
    public String getMusica() {
        if (!"".equals(this.musica)){
            return this.musica;
        }
        return "-- Vacio --";
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
    
    public String getFotografia() {
        if (!"".equals(this.fotografia)){
            return this.fotografia;
        }
        return "-- Vacio --";
    }

    public void setReparto(String[] reparto) {
        this.reparto = reparto;
    }
    
    public String[] getReparto() {
        String[] vacio = new String[1];
        vacio[0] = "-- Vacio ---";
        
        if (this.reparto[0] != null){
            return this.reparto;
        }
        return vacio;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }
    
    public String getProductora() {
        if (!"".equals(this.productora)){
            return this.productora;
        }
        return "-- Vacio --";
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getGenero() {
        if (!"".equals(this.genero)){
            return this.genero;
        }
        return "-- Vacio --";
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    public String getSinopsis() {
        if (!"".equals(this.sinopsis)){
            return this.sinopsis;
        }
        return "-- Vacio --";
    }
    
    public String exportStateAsColums(){
        return String.format("| %-56s | %-7d | %-8d | %-32s | %-19s |%n",
                this.titulo,
                this.annio,
                this.duracion,
                this.pais,
                this.genero);
    }
      
}
