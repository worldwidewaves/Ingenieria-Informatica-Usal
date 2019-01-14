import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerNumeros {

    public static void main(String[] args) throws FileNotFoundException {
       String rutaDelEscritorio = System.getProperty("user.home")
                + File.separator
                + "Desktop"
                + File.separator
                + "milnumeros.txt";
       int suma = 0;
       int temp;
       Scanner sc; 
        sc = new Scanner(new File(rutaDelEscritorio));
        while (sc.hasNext()) {
            temp = sc.nextInt();
            suma += temp;
        }
        sc.close();
        System.out.println("La suma de los números leídos es " + suma);
    }
}
