/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package com.coti.tools;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author bruegel
 */
public class RGBTextInputOutput {
  
  /**
   *
   */
  final public static Scanner SC = new Scanner(System.in,
                                               System.getProperty("os.name").contains("Windows") ? "iso-8859-1" : "UTF-8");
  
  /**
   *
   * @param possiblePath String checked for validity as a Path
   * @return
   */
  public static boolean isValidPath(String possiblePath) {
    
    try {
      Paths.get(possiblePath);
    } catch (InvalidPathException | NullPointerException ex) {
      return false;
    }
    return true;
  }
  
  /**
   *
   * @param prompt shown before waiting for a float
   * @return
   */
  public static Path readPathFromKeyboard(String prompt) {
    Path p;
    String possiblePath;
    do {
      possiblePath = readString_ne(prompt);
      
      p = Paths.get(possiblePath);
      
    } while (!isValidPath(possiblePath));
    return p;
  }
  
  /**
   *
   * @param prompt shown before waiting for a float
   * @return
   */
  static public float readFloat(String prompt) {
    float tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        
        System.out.printf(prompt);
        temp = SC.nextLine();
        
      } while (temp.isEmpty());
      
      try {
        tempNumber = Float.parseFloat(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.err.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for a float
   * @param defaultValue value returned if user types enter
   * @return
   */
  static public float readFloat(String prompt, float defaultValue) {
    float tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt + " [" + defaultValue + "]");
        temp = SC.nextLine();
        if (temp.isEmpty()) {
          return defaultValue;
        }
      } while (temp.isEmpty());
      try {
        tempNumber = Float.parseFloat(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for a Float
   * @param min no value admitted below this
   * @param max no value admitted above this
   * @return
   */
  static public float readFloat(String prompt, float min, float max) {
    float tempNumber = 0.0f;
    String temp;
    boolean numberOkay;
    do {
      do {
        
        System.out.printf(prompt + " (%f <= n <= %f)", min, max);
        temp = SC.nextLine();
        
      } while (temp.isEmpty());
      try {
        tempNumber = Float.parseFloat(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
      if (tempNumber < min || tempNumber > max) {
        System.out.printf("%n%nPor favor, escriba un número entre %f y %f%n%n", min, max);
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for a String
   * @return
   */
  static public double readDouble(String prompt) {
    double tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt);
        temp = SC.nextLine();
        
      } while (temp.isEmpty());
      try {
        tempNumber = Double.parseDouble(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for a Double
   * @param defaultValue value returned if user types Enter
   * @return
   */
  static public double readDouble(String prompt, double defaultValue) {
    double tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt + " [" + defaultValue + "]");
        temp = SC.nextLine();
        if (temp.isEmpty()) {
          return defaultValue;
        }
      } while (temp.isEmpty());
      try {
        tempNumber = Double.parseDouble(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for a double
   * @param min no values admitted below this
   * @param max no values admitted above this
   * @return
   */
  static public double readDouble(String prompt, double min, double max) {
    double tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt);
        System.out.printf(" (%f <= numero <= %f)", min, max);
        temp = SC.nextLine();
        
      } while (temp.isEmpty());
      try {
        tempNumber = Double.parseDouble(temp);
        numberOkay = true;
      } catch (Exception e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
      if (tempNumber < min || tempNumber > max) {
        System.out.printf("%n%nPor favor, escriba un número entre %f y %f%n%n", min, max);
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for an Int
   * @return
   */
  static public int readInt(String prompt) {
    int tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt);
        temp = SC.nextLine();
        
      } while (temp.isEmpty());
      try {
        tempNumber = Integer.parseInt(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for an Int
   * @param defaultValue value returned if use types enter
   * @return
   */
  static public int readInt(String prompt, int defaultValue) {
    int tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt + " [" + defaultValue + "]");
        temp = SC.nextLine();
        if (temp.isEmpty()) {
          return defaultValue;
        }
      } while (temp.isEmpty());
      try {
        tempNumber = Integer.parseInt(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt show before waiting for an Int
   * @param min no value admitted below this
   * @param max no value admitted above this
   * @return
   */
  static public int readInt(String prompt, int min, int max) {
    int tempNumber = 0;
    String temp;
    boolean numberOkay;
    do {
      do {
        
        System.out.printf(prompt);
        System.out.printf(" (%d <= numero <= %d)", min, max);
        temp = SC.nextLine();
        
      } while (temp.isEmpty());
      try {
        tempNumber = Integer.parseInt(temp);
        numberOkay = true;
      } catch (NumberFormatException e) {
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
      if (tempNumber < min || tempNumber > max) {
        System.out.printf("%n%nPor favor, escriba un número entre %d y %d%n%n", min, max);
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }
  
  /**
   *
   * @param prompt shown before waiting for an int
   * @return
   */
  static public String readString(String prompt) {
    String temp;
    System.out.printf(prompt);
    temp = SC.nextLine();
    return temp;
    
  }
  
  /**
   *
   * @param prompt shown before waiting for an Int
   * @param defaultValue value returned if user types enter
   * @return
   */
  static public String readString(String prompt, String defaultValue) {
    String temp;
    System.out.printf(prompt + "\\[" + defaultValue + "\\]");
    temp = SC.nextLine();
    if (temp.length() == 0) {
      temp = defaultValue;
    }
    return temp;
    
  }
  
  /**
   *
   * @param prompt shown while waiting for a non-empty string
   * @return
   */
  static public String readString_ne(String prompt) {
    String temp = null;
    do {
      System.out.printf(prompt);
      temp = SC.nextLine();
      if (temp.isEmpty()) {
        System.out.printf("%nError: este campo no puede estar vacío.%n");
      }
    } while (temp.isEmpty());
    return temp;
    
  }
  
  /**
   *
   * @param prompt shown while waiting for one of the two strings op1, op2
   * @param op1 first accepted value
   * @param op2 second accepted value
   * @return
   */
  static public String readString(String prompt, String op1, String op2) {
    String temp = null;
    boolean badOption;
    do {
      System.out.printf(prompt);
      System.out.printf(" (%s,%s) ? ", op1, op2);
      temp = SC.nextLine();
      boolean tempIsNotOp1 = temp.equals(op1);
      boolean tempIsNotOp2 = temp.equals(op2);
      badOption = tempIsNotOp1 && tempIsNotOp2;
      if (badOption) {
        System.out.printf("%nOpción incorrecta: Por favor, escriba %s o %s%n%n", op1, op2);
      }
    } while (badOption);
    return temp;
  }
  
  /**
   *
   * @param prompt shown while waiting for one of the values in options
   * @param options list of values acceptable as an answer
   * @return
   */
  static public String readString(String prompt, String[] options) {
    String temp = null;
    Arrays.sort(options);
    String listOfOptions = "( " + options[0];
    for (int i = 1; i < options.length; i++) {
      if (i % 6 == 0) {
        listOfOptions += ", " + "\n" + options[i];
      } else {
      listOfOptions += ", " + options[i];
      }
    }
    listOfOptions += " )";
    boolean badOption;
    do {
      badOption = false;
      System.out.printf(prompt);
      System.out.printf("\nOption: %s ? ", listOfOptions);
      temp = SC.nextLine();
      if (Arrays.binarySearch(options, temp) < 0) {
        badOption = true;
        System.out.printf("%n%n%s no es correcto: Por favor, escriba una de las opciones permitidas : %s%n%n", temp, listOfOptions);
      }
    } while (badOption);
    return temp;
  }
  
  static public boolean readBoolean(String prompt) {
    return readString(prompt, "y", "n").equalsIgnoreCase("y");
  }
} // End of RGBTextInputOutput
