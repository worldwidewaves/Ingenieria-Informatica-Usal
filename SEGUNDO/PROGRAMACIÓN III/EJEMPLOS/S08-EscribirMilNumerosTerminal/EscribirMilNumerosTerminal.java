import java.io.FileNotFoundException;
import java.io.PrintStream;
/*
 Este program escribir 1000 números en la terminal
 */
public class EscribirMilNumerosTerminal {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // TODO code application logic here
        PrintStream pw = System.out;
         for (int i = 1; i <= 1000; i++) {
             pw.printf("%d%n", i);
        }

     }
}
