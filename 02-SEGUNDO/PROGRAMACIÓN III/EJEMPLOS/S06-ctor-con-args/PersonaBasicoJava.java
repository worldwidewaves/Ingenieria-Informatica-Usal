public class PersonaBasicoJava
{
    public static void main(final String[] array) {
        final Persona persona = new Persona();
        System.out.println("Nombre: " + persona.nombre);
        System.out.println("Telefono: " + persona.tel);
        final Persona persona2 = new Persona("Hermenegildo", 5551234);
        System.out.println("Nombre: " + persona2.nombre);
        System.out.println("Telefono: " + persona2.tel);
    }
}
