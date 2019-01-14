package testtablas;
/*
 Version history

 Modified 2013
 added writeObject/readObject methods
 added new, faster versions of several
 methods, making use of Files.readAllLines,
 Files.write etc.
 */
/*

Proxima 2014
Escribiendo tabla en formato delimitado...terminado, t = 2792
Escribiendo tabla en formato de objeto...terminado, t = 88
Escribiendo tabla en formato binario...terminado, t = 101
Leyendo tabla en formato delimitado...terminado, t = 1009
Leyendo tabla en formato de objeto...terminado, t = 32
Leyendo tabla en formato binario...terminado, t = 48

 Magallanes versión 1

 Escribiendo tabla en formato delimitado...terminado, t = 4387
 Escribiendo tabla en formato de objeto...terminado, t = 584
 Escribiendo tabla en formato binario...terminado, t = 504
 Leyendo tabla en formato delimitado...terminado, t = 1880
 Leyendo tabla en formato de objeto...terminado, t = 141
 Leyendo tabla en formato binario...terminado, t = 159

 Magallanes versión 2

 Escribiendo tabla en formato delimitado...terminado, t = 1884
 Escribiendo tabla en formato de objeto...terminado, t = 588
 Escribiendo tabla en formato binario...terminado, t = 534
 Leyendo tabla en formato delimitado...terminado, t = 1441
 Leyendo tabla en formato de objeto...terminado, t = 142
 Leyendo tabla en formato binario...terminado, t = 157

 Proxima versión 1

 Escribiendo tabla en formato delimitado...terminado, t = 2010
 Escribiendo tabla en formato de objeto...terminado, t = 50
 Escribiendo tabla en formato binario...terminado, t = 47
 Leyendo tabla en formato delimitado...terminado, t = 1189
 Leyendo tabla en formato de objeto...terminado, t = 26
 Leyendo tabla en formato binario...terminado, t = 52

 Proxima versión 2

 Escribiendo tabla en formato delimitado...terminado, t = 573
 Escribiendo tabla en formato de objeto...terminado, t = 51
 Escribiendo tabla en formato binario...terminado, t = 52
 Leyendo tabla en formato delimitado...terminado, t = 765
 Leyendo tabla en formato de objeto...terminado, t = 29
 Leyendo tabla en formato binario...terminado, t = 56

 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//
// Tools->Analyze Javadoc
//

// Adding times (write+read), objects are fastest
/**
 *
 * @author coti
 */
public class Tablas {

    public static final String lineSeparator = System.lineSeparator();

    /**
     *
     * @param t the table that is to be written to disk as an object
     * @param pathToFile the path to the file it will be written into
     */
    public static void writeTableToDiskAsObject(double[][] t,
            File pathToFile) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(pathToFile)));
            oos.writeObject(t);
            oos.close();
        } catch (IOException ex) {
            System.err.println("Tablas:writeTableToDiskAsObject:"
                    + " Could not write file");
        }
    }// End of writeTableToDiskAsObject

    /**
     *
     * @param pathToFile
     * @return
     */
    public static double[][] readTableFromDiskAsObject(File pathToFile) {
        ObjectInputStream ois;
        double[][] result;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(pathToFile)));
            result = (double[][]) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            System.err.println("Tablas:readTableFromDiskAsObject:"
                    + " Could not read file");
        } catch (ClassNotFoundException ex) {
            System.err.println("Tablas:readTableFromDiskAsObject:"
                    + " Could not find class");
        }
        return null;
    }

    /**
     *
     * @param t
     * @param pathToFile
     */
    public static void writeTableToDisk(double[][] t,
            File pathToFile) {
        DataOutputStream dos;
        BufferedOutputStream bos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(pathToFile);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
        } catch (FileNotFoundException ex) {
            System.out.println("Tablas:writeTableToDisk: "
                    + "Could not open file "
                    + pathToFile
                    + " for writing.");
            return;
        }
        int i, j;
        try {
            // Escribimos el número de filas y el de columnas
            dos.writeInt(t.length);
            dos.writeInt(t[0].length);
        } catch (IOException ex) {
            System.out.println("Tablas:writeTableToDisk: "
                    + "Could not write rows and columns to file "
                    + pathToFile);
        }
        for (i = 0; i < t.length; i++) {
            for (j = 0; j < t[i].length; j++) {
                try {
                    dos.writeDouble(t[i][j]);
                } catch (IOException ex) {
                    System.out.println("Tablas:writeTableToDisk: "
                            + "Could not write number to file "
                            + pathToFile);
                }
            }
        }
        try {
            dos.close();
        } catch (IOException ex) {
            System.out.println("Tablas:writeTableToDisk: Could not"
                    + " close file "
                    + pathToFile
                    + " after writing.");
        }
    } // Fin de writeTableToDisk (formato binario)

    //
    // Only PrintWriter version
    //
    /**
     *
     * @param t
     * @param pathToFile
     * @param separator
     */
    public static void exportTableToDisk(double[][] t,
            File pathToFile,
            String separator) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(pathToFile)));
        } catch (IOException ex) {
            System.err.println("Tablas:exportTableToDisk:"
                    + " Could not open file "
                    + pathToFile
                    + " for writing.");
            return;
        }
        int i, j;
        for (i = 0; i < t.length; i++) {
            for (j = 0; j < t[i].length - 1; j++) {
                pw.printf("%f%s", t[i][j], separator);
            }
            pw.printf("%f%n", t[i][j]);
        }
        pw.close();
    }

    //
    // Files.write + StringBuilder version
    //
    /**
     *
     * @param t
     * @param pathToFile
     * @param separator
     */
    public static void exportTableToDisk2(double[][] t,
            File pathToFile,
            String separator) {
        StringBuilder sb = new StringBuilder(24 * t.length * t[0].length);
        int i, j;
        for (i = 0; i < t.length; i++) {
            for (j = 0; j < t[i].length - 1; j++) {
                sb.append(t[i][j]).append(separator);
            }
            sb.append(t[i][j]).append(lineSeparator);
        }
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(pathToFile)));
            pw.print(sb);
            pw.close();
        } catch (IOException e) {
            System.err.println("Tablas:exportTableToDisk2: Could not open file "
                    + pathToFile
                    + " for writing.");
            System.out.println(e);
        }
    }

    /**
     *
     * @param t
     */
    public static void writeTableToTerminal(double[][] t) {

        int i, j;
        for (i = 0; i < t.length; i++) {
            System.out.print("|");
            for (j = 0; j < t[i].length; j++) {
                System.out.printf("%8.2f", t[i][j]);
            }
            System.out.printf("|%n");
        }
    }

    //
    // Pre-readAllLines version, slower
    //
    /**
     *
     * @param pathToFile
     * @param separator
     * @return
     */
    public static double[][] importTableFromDisk(File pathToFile,
            String separator) {
        Scanner sc = null;
        ArrayList<String> temp = new ArrayList<>();
        try {
            sc = new Scanner(pathToFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Tablas:readTableFromDisk: Could not open file "
                    + pathToFile
                    + " for reading.");
        }
        String s;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            temp.add(s);
        }
        sc.close();

        //
        // If we do get here, temp contains all of the lines in file pathToFile
        //
        int numberOfRows = temp.size();
        int numberOfColumns = temp.get(0).split(separator).length;
        double[][] resultado = new double[numberOfRows][numberOfColumns];

        Locale spanishLocale = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanishLocale);

        for (int i = 0; i < numberOfRows; i++) {
            String[] campos = temp.get(i).split(separator);
            for (int j = 0; j < campos.length; j++) {
                try {
                    resultado[i][j] = nf.parse(campos[j]).floatValue();
                } catch (ParseException ex) {
                    System.out.println("Tablas:readTableFromDisk: Could not parse item m["
                            + i
                            + "]["
                            + j
                            + "] = "
                            + campos[j]);
                }
            }
        }
        return resultado;

    }

    //
    // readAllLines version, faster
    //
    /**
     *
     * @param pathToFile
     * @param separator
     * @return
     */
    public static double[][] importTableFromDisk2(File pathToFile,
            String separator) {
        Scanner sc = null;
        List<String> temp;
        try {
            temp = Files.readAllLines(pathToFile.toPath(),
                    Charset.defaultCharset());
        } catch (IOException ex) {
            System.err.println("Tablas:importTableFromDisk2:"
                    + "list of lines could not be read.");
            return null;
        }

        //
        // If we do get here, temp contains all of the lines in file pathToFile
        //
        int numberOfRows = temp.size();
        int numberOfColumns = temp.get(0).split(separator).length;
        double[][] resultado = new double[numberOfRows][numberOfColumns];

        Locale spanishLocale = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanishLocale);

        for (int i = 0; i < numberOfRows; i++) {
            String[] campos = temp.get(i).split(separator);
            for (int j = 0; j < campos.length; j++) {
                try {
                    resultado[i][j] = nf.parse(campos[j]).floatValue();
                } catch (ParseException ex) {
                    System.out.println("Tablas:readTableFromDisk:"
                            + " Could not parse item "
                            + "m[" + i + "][" + j + "] = "
                            + campos[j]);
                }
            }
        }
        return resultado;
    }

    /**
     *
     * @param pathToFile
     * @return
     */
    public static double[][] readTableFromDisk(File pathToFile) {

        DataInputStream dis;
        BufferedInputStream bis;
        FileInputStream fis;
        try {
            fis = new FileInputStream(pathToFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Tablas:readTableFromDisk: Could not open file "
                    + pathToFile
                    + " for writing.");
            return null;
        }
        bis = new BufferedInputStream(fis);
        dis = new DataInputStream(bis);
        // Declaramos variables temporales para leer el número de filas y columnas
        int numRows = 0, numColumns = 0;
        try {
            // Por comodidad, leemos el número de filas y el de columnas
            numRows = dis.readInt();
            numColumns = dis.readInt();
        } catch (IOException ex) {
            System.out.println("Tablas:readTableFromDisk: Could not read rows and columns from file "
                    + pathToFile);
        }
        double[][] resultado = new double[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                try {
                    resultado[i][j] = dis.readDouble();
                } catch (IOException ex) {
                    System.out.println("Tablas:readTableFromDisk: Could not read number from file "
                            + pathToFile + " [" + i + "]" + "[" + j + "]");
                }
            }
        }
        try {
            dis.close();
        } catch (IOException ex) {
            System.out.println("Tablas:readTableFromDisk: Could not close file "
                    + pathToFile
                    + " after reading.");
        }
        return resultado;
    }

    /**
     *
     * @param numRows
     * @param numColumns
     * @return
     */
    public static double[][] createRandomTable(int numRows,
            int numColumns) {
        double[][] resultado;
        resultado = new double[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                resultado[i][j]
                        = (Math.random() - 0.5d) * 1000000.0d;
            }
        }
        return resultado;
    }

    //
    // Methods that deal with String arrays
    //
    public String[][] readColumnarTable(int[] field_length, File f) {
        int i;
        int j;
        String[][] table;
        StringBuilder temp;
        List<String> list = null;
        int number_of_rows, number_of_columns;
        int number_of_fields;
        try {
            list = Files.readAllLines(f.toPath(), Charset.defaultCharset());
        } catch (IOException ex) {
            System.err.println("Tablas:readColumnarTable:"
                    + " could not read file"
                    + f.getName());
        }
        if (null == list) {
            System.err.println("AuxTextLo:readColumnarTable: "
                    + "Could not read null file");
            return null;
        }
        number_of_rows = list.size(); /* As many rows as lines we have read */

        if (0 == number_of_rows) {
            System.err.println("AuxTextLo:readColumnarTable: "
                    + "0 rows in table");
            return null;
        }
        number_of_columns = field_length.length; /* This is the number of fields */

        if (0 == number_of_columns) {
            System.err.println("AuxTextLo:readColumnarTable: "
                    + "no field widths given");
            return null;
        }
        table = new String[number_of_rows][number_of_columns];
        int field_start = 0;
        temp = new StringBuilder(8192);
        for (i = 0; i < number_of_rows; i++) {
            field_start = 0;
            temp.append(list.get(i));
            for (j = 0; j < number_of_columns; j++) {
                try {
                    table[i][j] = temp.substring(field_start,
                            field_start + field_length[j]).trim();
                    field_start += field_length[j];
                } catch (Exception e) {
                    System.err.println("AuxTextLo:readColumnarTable"
                            + "Line " + i
                            + " is too short for field " + j
                            + ". Field left empty.");
                    table[i][j] = "";
                }
            }
            temp.delete(0, temp.length());
        }
        return table;
    }

    public boolean writeColumnarTable(String[][] table, int[] lengths, File f) {
        int i;
        int j;
        try {
            int number_of_rows = table.length;
            int number_of_columns = table[0].length;
            StringBuilder sb = new StringBuilder();
            String[] format = new String[number_of_columns];
            for (i = 0; i < number_of_columns; i++) {
                format[i] = "%-" + lengths[i] + "s";
            }
            for (i = 0; i < number_of_rows; i++) {
                for (j = 0; j < number_of_columns; j++) {
                    sb.append(String.format(format[j], table[i][j]));
                }
                sb.append(lineSeparator);
            }
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(f)));
            pw.print(sb);
            pw.close();
            return true;
        } catch (Exception e) {
            System.err.println("AuxTextLo:writeColumnarTable:"
                    + "could not write to file"
                    + f.getName());
            return false;
        }
    }

    public boolean writeColumnarTable(String[][] table, int[] lengths) {
        int i;
        int j;
        try {
            int number_of_rows = table.length;
            int number_of_columns = table[0].length;
            StringBuilder sb = new StringBuilder();
            String[] format = new String[number_of_columns];
            for (i = 0; i < number_of_columns; i++) {
                format[i] = "%-" + lengths[i] + "s";
            }
            for (i = 0; i < number_of_rows; i++) {
                for (j = 0; j < number_of_columns; j++) {
                    sb.append(String.format(format[j], table[i][j]));
                }
                sb.append(lineSeparator);
            }
            System.out.print(sb);
            return true;
        } catch (Exception e) {
            System.err.println("AuxTextLo:writeColumnarTable:"
                    + " could not write to console");
            return false;
        }
    }

}
