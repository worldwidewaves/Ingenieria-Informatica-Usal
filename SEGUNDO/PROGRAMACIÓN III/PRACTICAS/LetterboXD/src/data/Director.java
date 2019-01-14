package data;

import java.io.Serializable;
import java.time.LocalDate;

public class Director implements Serializable{
    
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private String ocupacion;
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
    
    public String getFechaDeNacimiento() {
        if (this.fechaDeNacimiento != null){
            return this.fechaDeNacimiento.toString();
        }
        return "-- Vacio --";
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    public String getNacionalidad() {
        if (!"".equals(this.nacionalidad)){
            return this.nacionalidad;
        }
        return "-- Vacio --";
    }


    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    public String getOcupacion() {
        if (!"".equals(this.ocupacion)){
            return this.ocupacion;
        }
        return "-- Vacio --";
    } 

    public void setPeliculas(String[] peliculas) {
        this.peliculas = peliculas;
    }
    
    public String[] getPeliculas() {
        return this.peliculas;
    }
    
    public String exportStateAsColums(){
        String fechaNacimiento;
        if (this.fechaDeNacimiento != null){
            fechaNacimiento = this.fechaDeNacimiento.toString();
        } else {
            fechaNacimiento = "";
        }
        return String.format("| %-32s | %-19s | %-23s | %-76s |%n",
                this.nombre,
                fechaNacimiento,
                this.nacionalidad,
                this.ocupacion);
    }

    
}
