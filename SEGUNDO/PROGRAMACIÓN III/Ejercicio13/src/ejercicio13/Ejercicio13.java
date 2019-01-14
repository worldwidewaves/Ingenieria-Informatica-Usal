package ejercicio13;

import java.util.Scanner;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 13:
 * Tomando como base lo visto hasta el momento, escribir un programa que muestre en
 * pantalla los partidos del pleno al 15, pida los resultados y muestre finalmente la
 * quiniela.
 * @author Daniel García González
 */

public class Ejercicio13 {

    public static void main(String[] args) {
        final int NUM_PARTIDOS = 15;
        String[] equipoLocal = new String[NUM_PARTIDOS];
        String[] equipoVisitante = new String[NUM_PARTIDOS];
        int[] golesEquipoLocal = new int[NUM_PARTIDOS];
        int[] golesEquipoVisitante = new int [NUM_PARTIDOS];
        Scanner sc = new Scanner(System.in);
        
        //Lectura de Datos
        for (int i = 0; i < NUM_PARTIDOS; i++){
            System.out.printf("Partido nº %2d%n%n", i + 1);
            System.out.printf("Nombre del equipo local: ");
            equipoLocal[i] = sc.nextLine();
            System.out.printf("%nNombre del equipo visitante: ");
            equipoVisitante[i] = sc.nextLine();
            System.out.printf("%nGoles del equipo local: ");
            golesEquipoLocal[i] = Integer.parseInt(sc.nextLine());
            System.out.printf("%nGoles del equipo visitante: ");
            golesEquipoVisitante[i] = Integer.parseInt(sc.nextLine());
        }
        
        //Impresión de Resultados
        String formato = "|  %7d | %30s | %8s | %n";
        String resultado;
        int local, visitante;
        String equipos;
        
        System.out.printf("+----------+--------------------------------+----------+%n");
        System.out.printf("|  %7s | %30s | %8s | %n", "Partido", "Equipos", "Quiniela");
        System.out.printf("+----------+--------------------------------+----------+%n");
        for (int i = 0; i < NUM_PARTIDOS; i++){
            local = golesEquipoLocal[i];
            visitante = golesEquipoVisitante[i];
            equipos = equipoLocal[i] + " - " + equipoVisitante[i];
            resultado = local > visitante ? "1": (local < visitante ? "2" : "x");
            System.out.printf(formato, i + 1, equipos, resultado);
        }
        System.out.printf("+----------+--------------------------------+----------+%n");
        System.out.printf("Leyenda: 2 = Gana 2º equipo| 1 = Gana 1º equipo| x = Empate%n");
        
        showFinalTime();
    }
    
}
