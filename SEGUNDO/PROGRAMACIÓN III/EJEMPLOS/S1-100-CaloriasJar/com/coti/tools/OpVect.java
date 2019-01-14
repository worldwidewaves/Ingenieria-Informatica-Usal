package com.coti.tools;

/**
 *
 * @author bruegel
 */
import static com.coti.tools.Esdia.*;
import static java.lang.Math.*;

public class OpVect {

    public static double[] leerVector(int numElementos) throws Exception {
        if (numElementos <= 0) {
            throw new Exception("leerVector: numElementos <= 0.");
        }
        double[] resultado = new double[numElementos];
        for (int i = 0; i < resultado.length; i++) {
            String indicador = String.format("Escriba d[%d]: ",
                    i);
            resultado[i] = readDouble(indicador);

        }
        return resultado;
    } // Fin leerVector

    public static float[] leerVectorF(int numElementos) throws Exception {
        if (numElementos <= 0) {
            throw new Exception("leerVectorF: numElementos <= 0.");
        }
        float[] resultado = new float[numElementos];
        for (int i = 0; i < resultado.length; i++) {
            String indicador = String.format("Escriba d[%d]: ", i);
            resultado[i] = readFloat(indicador);

        }
        return resultado;
    } // fin leerVectorF

    public static int[] leerVectorI(int numElementos) throws Exception {
        if (numElementos <= 0) {
            throw new Exception("leerVector: numElementos <= 0.");
        }
        int[] resultado = new int[numElementos];
        for (int i = 0; i < resultado.length; i++) {
            String indicador = String.format("Escriba d[%d]: ", i);
            resultado[i] = readInt(indicador);

        }
        return resultado;
    } // fin leerVectorI

    public static double proEscalar(double[] a, double[] b) throws Exception {
        double acum = 0;
        if (a.length != b.length) {
            throw new Exception("proEscalar: no coinciden las dimensiones.");
        }

        for (int i = 0; i < a.length; i++) {
            acum += a[i] * b[i];

        }
        return acum;
    } // fin proEscalar

    public static double[] proVectorial(double[] a,
            double[] b) throws Exception {
        double[] resultado = new double[3];
        if (a.length != b.length) {
            throw new Exception(
                    "proVectorial: no coinciden las dimensiones");
        }
        if (a.length != 3) {
            throw new Exception(
                    "proVectorial: los vectores no son de dimension 3");
        }
        resultado[0] = a[1] * b[2] - a[2] * b[1];
        resultado[1] = a[2] * b[0] - a[0] * b[2];
        resultado[2] = a[0] * b[1] - a[1] * b[0];
        return resultado;
    } // Fin de proVectorial

    public static double proMixto(double[] a,
            double[] b, double[] c) throws Exception {
//        double resultado;
//        double[] v;
//        v = proVectorial(b, c);
//        resultado = proEscalar(a, v);
//        return resultado;
        return proEscalar(a,proVectorial(b,c));
    } //  fin proMixto

    public static double modulo(double[] a) {
        double acum = 0;
        for (int i = 0; i < a.length; i++) {
            acum += pow(a[i], 2);
        }
        return (sqrt(acum));
    } // fin modulo

    public static double modulo2(double[] a) {
        double acum = 0;
        for (double n : a) {
            acum += pow(n, 2);
        }
        return (sqrt(acum));
    } // fin modulo

    public static double distancia(double[] a,
            double[] b) {
        double resultado = 0;
        for (int i = 0; i < a.length; i++) {
            resultado += pow(b[i] - a[i], 2);
        }
        return sqrt(resultado);
    } // fin distancia

  public static String vectorComoCadena(double[] v) {
    String resultado;
    resultado = "{";
    for (int i = 0; i < v.length; i++) {
      if (i < v.length - 1) {
        resultado += String.format(" %.2f,", v[i]);
      } else {
        resultado += String.format( " %.2f}", v[i]);
      }
      
    }
    return resultado;
  } // Fin de vectorComoCadena
  
  public static String vToS(double[] v) {
    String resultado;
    resultado = "{";
    for (int i = 0; i < v.length; i++) {
      if (i < v.length - 1) {
        resultado += String.format(" %.2f,", v[i]);
      } else {
        resultado += String.format( " %.2f}", v[i]);
      }
      
    }
    return resultado;
  } // Fin de vToS
  
}
/*

Véanse Jama y Jampack

*/
