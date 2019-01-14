package com.coti.tools;

/*
 
Now has package and git
 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author coti
 */
public class OpMat {
  
  public static void inputMat(double[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to inputMat a null array of double");
    }
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < numRows; ++i) {
      for (int j = 0; j < numColumns; ++j) {
        System.out.printf("m[%d][%d] = ", i, j);
        matrix[i][j] = sc.nextDouble();
      }
    }
    sc.skip("\n");
  }
  
  public static void inputMat(float[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to inputMat a null array of float");
    }
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < numRows; ++i) {
      for (int j = 0; j < numColumns; ++j) {
        System.out.printf("m[%d][%d] = ", i, j);
        matrix[i][j] = sc.nextFloat();
      }
    }
    sc.skip("\n");
  }
  
  public static void inputMat(int[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to inputMat a null array of int");
    }
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < numRows; ++i) {
      for (int j = 0; j < numColumns; ++j) {
        System.out.printf("m[%d][%d] = ", i, j);
        matrix[i][j] = sc.nextInt();
      }
    }
    sc.skip("\n");
  }
  
  public static void printToScreen(String[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to printToScreen a null array of String");
    }
    for (String[] row : matrix) {
      System.out.print("| ");
      for (String value : row) {
        System.out.printf("%15s", value);
      }
      System.out.println(" |");
    }
  }
  
  public static void printToScreen(double[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to printToScreen a null array of double");
    }
    for (double[] row : matrix) {
      System.out.print("| ");
      for (double value : row) {
        System.out.printf("%8.3f", value);
      }
      System.out.println(" |");
    }
  }
  
  public static void printToScreen(float[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to printToScreen a null array of float");
    }
    for (float[] row : matrix) {
      System.out.print("| ");
      for (float value : row) {
        System.out.printf("%8.3f", value);
      }
      System.out.println(" |");
    }
  }
  
  public static void printToScreen(int[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to printToScreen a null array of int");
    }
    for (int[] row : matrix) {
      System.out.print("| ");
      for (int value : row) {
        System.out.printf("%8d", value);
      }
      System.out.println(" |");
    }
  }
  
  public static void saveToDisk(File f, double[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to saveToDisk a null array of double");
    }
    FileOutputStream fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(matrix);
    oos.close();
  }
  
  public static void saveToDisk(File f, float[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to saveToDisk a null array of float");
    }
    FileOutputStream fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(matrix);
    oos.close();
  }
  
  public static void saveToDisk(File f, int[][] matrix) throws Exception {
    if (null == matrix) {
      throw new Exception("Attempt to saveToDisk a null array of int");
    }
    FileOutputStream fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(matrix);
    oos.close();
  }
  
  public static double[][] loadFromDisk(File f, double dummy) throws Exception {
    double[][] result = null;
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    result = (double[][]) ois.readObject();
    ois.close();
    return result;
  }
  
  public static float[][] loadFromDisk(File f, float dummy) throws Exception {
    float[][] result = null;
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    result = (float[][]) ois.readObject();
    ois.close();
    return result;
  }
  
  public static int[][] loadFromDisk(File f, int dummy) throws Exception {
    int[][] result = null;
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    result = (int[][]) ois.readObject();
    ois.close();
    return result;
  }
  
  public static String[][] importFromDisk(File f, String delimiter) throws Exception {
    String[][] result = null;
    List<String> lines = Files.readAllLines(f.toPath());
    int numRows = lines.size();
    result = new String[numRows][];
    for(int row = 0; row < numRows; row++ ) {
      result[row] = lines.get(row).split(delimiter);
    }
    return result;
  }
  
  public static float[][] importFromDisk(File f, String delimiter, float dummy) throws Exception {
    float[][] result = null;
    return result;
  }
  
  public static double[][] importFromDisk(File f, String delimiter, double dummy) throws Exception {
    double[][] result = null;
    return result;
  }
  
  public static void exportToDisk(String[][] matrix, File f, String delimiter) throws Exception {
    StringBuilder sb = new StringBuilder();
    int numRows = matrix.length;
    for(int row = 0; row < numRows; row++) {
      int numCols = matrix[row].length;
      sb.append(String.format("%s", matrix[row][0]));
      for(int col=1; col < numCols; col++) {
        sb.append(String.format("%s%s", delimiter, matrix[row][col]));
      }
      sb.append("\n");
    }
    PrintWriter pw = new PrintWriter(f);
    pw.print(sb.toString());
    pw.close();
  }
  
  public static void exportToDisk(int[][] matrix, File f, String delimiter) {
  }
  
  public static void exportToDisk(float[][] matrix, File f, String delimiter) {
  }
  
  public static void exportToDisk(double[][] matrix, File f, String delimiter) {
  }
  
  public static int[][] sum(int[][] a, int[][] b) {
    int[][] result = null;
    return result;
  }
  
  public static float[][] sum(float[][] a, float[][] b) {
    float[][] result = null;
    return result;
  }
  
  public static double[][] sum(double[][] a, double[][] b) {
    double[][] result = null;
    return result;
  }
  
  
}
