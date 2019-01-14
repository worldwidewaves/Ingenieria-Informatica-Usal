import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EscribirMilNumeros {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        PrintWriter pw = new PrintWriter(new File("milnumeros.txt"));
        for (int i = 1; i <= 1000; i++) {
            pw.printf("%d%n", i);
        }
        pw.close();
    }
}
