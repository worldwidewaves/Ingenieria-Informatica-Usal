package ejercicio10y11;

public class Persona {

    private int edad;
    private String nombre;
    private float talla;

    
    Persona(){
        
    }
    Persona(String nombre, int edad, float talla){
       this.edad=edad;
       this.nombre=nombre;
       this.talla=talla;
        
    }    
    
    String getNombre() {
        return nombre;
    }

    int getEdad(){
        return edad;
    }

    float getTall(){
        return talla;
    }
    
    void setNombre(String st){
        nombre=st;
    }
   
    void setEdad(int edad){
        this.edad=edad;  
    }
    
    void setTalla(float talla){
        this.talla=talla;
    }
}
