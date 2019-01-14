// 
// Decompiled by Procyon v0.5.30
// 

class Persona
{
    String nombre;
    int tel;
    
    public Persona() {
        this.nombre = "Juan";
        this.tel = 5551234;
    }
    
    public Persona(final String nombre, final int tel) {
        this.nombre = nombre;
        this.tel = tel;
    }
    
    public void decirHola() {
        System.out.printf("Hola, me llamo %s", this.nombre);
    }
    
    public void decirAdios() {
        System.out.printf("Adios, mi telefono es el %d", this.tel);
    }
}
