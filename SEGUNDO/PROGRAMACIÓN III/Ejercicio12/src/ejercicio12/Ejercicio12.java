package ejercicio12;

import java.io.Console;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 12:
 * Empleando el método readPassword(), de Console, crear un programa que pida
 * usuario y contraseña al entrar. Si la pareja usuario / contraseña es correcta, emitir un
 * mensaje de bienvenida y salir de programa. Si no, salir de programa.
 * Mejora: ofrecer una pista al usuario si se equivoca
 * Mejora: salir del programa después de tres fallos
 * @author Daniel García González
 */

public class Ejercicio12 {

    public static void main(String[] args) {
        String[] listaUsu = {"Rosa", "Pedro", "Ana", "Marcos"};
        String[] listaCont = {"rosita", "peterg", "anana", "cosa"};
        String usu, contra;
        int posic = 0, conta = 0;
        boolean encontrado = false;
        
        Console conso = System.console();
        if (conso != null) {
            conso.printf("Usuario: %n");
            usu = conso.readLine();
            while (!encontrado && posic < listaUsu.length)
                if (listaUsu[posic].compareToIgnoreCase(usu) == 0){
                    encontrado = true;
                }
                else{
                    posic++;
                }
        }
                
        if (encontrado){
            do{
                conso.printf("Contraseña: %n");
                contra = String.valueOf(conso.readPassword());
                if (contra.compareTo(listaCont[posic]) == 0){
                    System.out.println("(Bienvenido y hasta pronto)");
                    conta = 3;
                }
                else{
                    conta++;
                    System.out.println("Su contraseña empieza por: " + listaCont[posic].charAt(0));
                }
            }
            while (conta<3);
        }
        else {
            System.out.println("Usuario no registrado.");
        }
        
        showFinalTime();
    }
}