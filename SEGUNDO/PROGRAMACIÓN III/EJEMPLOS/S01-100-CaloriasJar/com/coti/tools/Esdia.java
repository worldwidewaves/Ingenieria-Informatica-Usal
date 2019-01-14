package com.coti.tools;

/*
 * Grado en Ingeniería Informática - Universidad de Salamanca
 * Asignatura : Programación III
 * Tema       : Interfaces
 * Copyright (C) J.R. García-Bermejo Giner
 *
 * Now under Git control in Github/bruegel/com (May 2017)
 * No packages at this time
 *
 * Now has a test rig, EsdiaTestRig.java
 *
/*
	
 Para asegurarse de que el compilador utiliza UTF-8, es preciso
 indicarlo en la línea de órdenes:

 javac -J-Dfile.encoding=UTF-8 esdia/Esdia.java

 */
/**
 *
 * @author bruegel
 */

import java.util.Scanner;
import java.util.Arrays;

public class Esdia {

  final public static Scanner SC = new Scanner(System.in,
          System.getProperty("os.name").contains("Windows") ? "iso-8859-1" : "UTF-8");

  /**
   *
   * @param prompt
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
        System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
        numberOkay = false;
      }
    } while (!numberOkay);
    return tempNumber;
  }

  static public float readFloat(String prompt, float min, float max) {
    float tempNumber = 0.0f;
    String temp;
    boolean numberOkay;
    do {
      do {
        System.out.printf(prompt);
        System.out.printf(" (%f <= numero <= %f)", min, max);
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

  static public double readDouble(String prompt, double min, double max) {
    double tempNumber = 0;
    String temp;
    boolean numberOkay = true;
    do {
      numberOkay = false;
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

  static public String readString(String prompt) {
    String temp;
    System.out.printf(prompt);
    temp = SC.nextLine();
    return temp;

  }

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

  static public String readString(String prompt, String[] options) {
    String temp = null;
    //
    // Sorts the options
    //
    Arrays.sort(options);
    String listOfOptions = "( " + options[0];
    for (int i = 1; i < options.length; i++) {
      listOfOptions += ", " + options[i];
    }
    listOfOptions += " )";
    boolean badOption;
    do {
      badOption = false;
      System.out.printf(prompt);
      System.out.printf(" %s ? ", listOfOptions);
      temp = SC.nextLine();
      //
      // Fast lookup
      //
      if (Arrays.binarySearch(options, temp) < 0) {
        badOption = true;
        System.out.printf("%n%n%s no es correcto: Por favor, escriba una de las opciones permitidas : %s%n%n", temp, listOfOptions);
      }
    } while (badOption);
    return temp;
  }
}
