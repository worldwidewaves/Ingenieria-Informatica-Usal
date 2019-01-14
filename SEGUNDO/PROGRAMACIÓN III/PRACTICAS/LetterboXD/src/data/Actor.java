package data;

import java.io.Serializable;
import java.time.LocalDate;

public class Actor implements Serializable{
    
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private int annioDeDebut;
    private String[] peliculas;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        if (!"".equals(this.nombre)){
            return this.nombre;
        }
        return "-- Vacio --";
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        if (!"".equals(fechaDeNacimiento)){
            this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento);
        }
    }
    
    public void setFechaDeNacimientoLC(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setAnnioDeDebut(String annioDeDebut) {
        if (!"".equals(annioDeDebut)){
            this.annioDeDebut = Integer.parseInt(annioDeDebut);
        }
    }
    
    public void setAnnioDeDebutINT(int annioDeDebut) {
        this.annioDeDebut = annioDeDebut;
    }

    public void setPeliculas(String[] peliculas) {
        this.peliculas = peliculas;
    }

    public String exportStateAsColums() {
        String fechaNacimiento;
        if (this.fechaDeNacimiento != null){
            fechaNacimiento = this.fechaDeNacimiento.toString();
        } else {
            fechaNacimiento = "";
        }
        String annioDebut;
        if (this.annioDeDebut != 0){
            annioDebut = String.valueOf(this.annioDeDebut);
        } else {
            annioDebut = "";
        }
        return String.format("| %-32s | %-19s | %-23s | %-13s |%n",
                this.nombre,
                fechaNacimiento,
                this.nacionalidad,
                annioDebut);
    }

    public String getFechaDeNacimiento() {
        if (this.fechaDeNacimiento != null){
            return this.fechaDeNacimiento.toString();
        }
        return "-- Vacio --";
    }

    public String getNacionalidad() {
        if (!"".equals(this.nacionalidad)){
            return this.nacionalidad;
        }
        return "-- Vacio --";
    }

    public String getAnnioDeDebut() {
        if (this.annioDeDebut != 0){
            return String.valueOf(this.annioDeDebut);
        }
        return "-- Vacio --";
    }

    public String[] getPeliculas() {
        return this.peliculas;
    }

}
