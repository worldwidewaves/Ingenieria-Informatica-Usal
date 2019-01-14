package ejercicio10y11;

import java.util.Scanner;

public class Lector {

    Scanner sc = new Scanner(System.in);

    public int leerInt(String cadena) {
        String temp;
        int nume = 0;
        boolean control = false;
        do {
            do {
                System.out.print(cadena + ": ");
                temp = sc.nextLine();
            } while (temp.isEmpty());
            try {
                nume = Integer.parseInt(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor incorrecto");
                control = false;
            }
        } while (!control);
        return nume;
    }
    
    
    public int leerInt(String cadena,int min,int max) {
        String temp;
        int nume = 0;
        boolean control = false;
        do {
            do {
                System.out.print(cadena + ": ");
                temp = sc.nextLine();
            } while (temp.isEmpty());
            try {
                nume = Integer.parseInt(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor incorrecto");
                control = false;
            }
            if(nume<min || nume>max){
                   control=false; 
            }
        } while (!control);
        return nume;
    }
    
    
    
    public float leerFloat(String cadena) {
      String temp;
        float nume = 0;
        boolean control = false;
        do {
            do {
                System.out.print(cadena + ": ");
                temp = sc.nextLine();
            } while (temp.isEmpty());
            try {
                nume = Float.parseFloat(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor incorrecto");
                control = false;
            }
            
        } while (!control);
        return nume;
    }
    
    
    public float leerFloat(String cadena,float min, float max) {
      String temp;
        float nume = 0;
        boolean control = false;
        do {
            do {
                System.out.print(cadena + ": ");
                temp = sc.nextLine();
            } while (temp.isEmpty());
            try {
                nume = Float.parseFloat(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor incorrecto");
                control = false;
            }
            if(nume<=min || nume>max){
                   control=false; 
            }
            
        } while (!control);
        return nume;
    }
    
    
    public double leerDouble(String cadena) {
        String temp;
        double nume = 0;
        boolean control = false;
        do {
            do {
                System.out.print(cadena + ": ");
                temp = sc.nextLine();
            } while (temp.isEmpty());
            try {
                nume = Double.parseDouble(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor incorrecto");
                control = false;
            }
        } while (!control);
        return nume;
    }
}
