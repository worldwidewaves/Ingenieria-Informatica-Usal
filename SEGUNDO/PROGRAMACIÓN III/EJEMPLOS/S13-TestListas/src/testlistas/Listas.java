/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlistas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author coti
 */
public class Listas {

  public static double[] createRandomList(int numberOfRows) {
    double[] resultado;
    resultado = new double[numberOfRows];
    for (int i = 0; i < numberOfRows; i++) {
      resultado[i] = 100.0d * (Math.random() - 0.5d);
    }
    return resultado;
  }

  public static void writeListToDisk(double[] m, File f) {
    PrintWriter pw = null;

    try {
      pw = new PrintWriter(f);
      for (int i = 0; i < m.length; i++) {
        pw.printf("%f%n", m[i]);
      }
      pw.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Listas:escribirLista: Could"
              + " not open file for writing");
    } catch (Exception e) {
      System.out.println("Listas:escribirLista:" + e);
    }
  }

  public static void writeListToDisk2(double[] m, File f) {
    // Same as writeListToDisk with an ArrayList<String>
    // and Files.write(). Should be way faster.
  }

  public static void writeListToTerminal(double[] m) {

    for (int i = 0; i < m.length; i++) {
      System.out.printf("%8.2f%n", m[i]);
    }

  }

  public static double[] readListFromDisk(File f) {

    List<String> temp = new ArrayList<>();
//    try {
//      temp = Files.readAllLines(f.toPath(),
    // Charset.defaultCharset());
//    } catch (IOException ex) {
//      Logger.getLogger(Listas.class.getName())
    //.log(Level.SEVERE, null, ex);
//    }
    Scanner sc = null;
    try {
      sc = new Scanner(f);
    } catch (FileNotFoundException ex) {
      System.out.println("Listas:readListFromDisk:"
              + " Could not open file: " + f);
      return null;
    }
    String s;
    while (sc.hasNextLine()) {
      s = sc.nextLine();
      temp.add(s);
    }
    sc.close();
    double[] resultado = new double[temp.size()];
    Locale spanishLocale = new Locale("es", "ES");
    NumberFormat nf = NumberFormat.getInstance(spanishLocale);

    for (int i = 0; i < resultado.length; i++) {
      try {
        resultado[i] = nf.parse(temp.get(i)).doubleValue();
      } catch (ParseException ex) {
        System.out.println("Listas:readListFromDisk: "
                + "Invalid number format " + temp.get(i));
        return null;
      }
    }
    return resultado;
  }
}
