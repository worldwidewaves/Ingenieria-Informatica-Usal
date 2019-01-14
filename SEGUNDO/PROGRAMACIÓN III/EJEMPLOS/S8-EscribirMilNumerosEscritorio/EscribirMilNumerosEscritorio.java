import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EscribirMilNumerosEscritorio {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        PrintWriter pw;
        String rutaDelEscritorio = System.getProperty("user.home")
                + File.separator
                + "Desktop"
                + File.separator
                + "numeros.txt";
        pw = new PrintWriter(rutaDelEscritorio);
        for (int i = 1; i <= 1000; i++) {
            pw.printf("%d%n", i);
        }
        pw.close();
        System.out.println("Ruta del archivo: "+rutaDelEscritorio);
    }
}
