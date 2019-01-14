/* 
 * Para aportar argumentos de la línea de órdenes en NetBeans,
 * 
 * Run->Set Project Configuration->Customize...
 * 
 * En el Epígrafe Run, se da el valor 4 6 al cuadro de texto Arguments
 * 
 */
package cartas;

/**
 *
 * @author Tests by coti
 */
import java.util.*;

public class Cartas {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Uso: Cartas cuantos_jugadores cuantas_cartas");
      return;
    }
    int numJugadores = Integer.parseInt(args[0]);
    int numCartas = Integer.parseInt(args[1]);

    // Se crea una baraja normal
    String[] palo = {
      "oros", "copas", "espadas", "bastos"};
    String[] carta = {
      "as", "2", "3", "4", "5", "6", "7", "8",
      "9", "10", "sota", "caballo", "rey"};
    List<String> baraja = new ArrayList<String>();
    for (String palo1 : palo) {
      for (String carta1 : carta) {
        baraja.add(carta1 + " de " + palo1);
      }
    }

    // Barajamos.
    Collections.shuffle(baraja);

    if (numJugadores * numCartas > baraja.size()) {
      System.out.println("Faltan cartas.");
      return;
    }

    for (int i = 0; i < numJugadores; i++) {
      System.out.println(repartirCartas(baraja, numCartas));
    }
  }

  public static <E> List<E> repartirCartas(List<E> baraja, int n) {
    int numTotalCartas = baraja.size();
    System.out.println(baraja.size());
    List<E> cartasDeLaMano = baraja.subList(numTotalCartas - n, numTotalCartas);
    List<E> mano = new ArrayList<E>(cartasDeLaMano);
    cartasDeLaMano.clear();
    return mano;
  }
}
