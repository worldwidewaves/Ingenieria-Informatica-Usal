package calculadoras;

import java.util.stream.IntStream;

public class SinIndices {
	int suma;
	int ultimoNumero;
	
	public SinIndices() {
		suma = 0;
		ultimoNumero = 10;
	}
	
	public SinIndices(int n) {
		suma = 0;
		ultimoNumero = n;
	}
	
	public void calcularSuma() {
		for (int i : IntStream.range(1, ultimoNumero + 1).toArray()) {
			suma += i;
		}

	}
	
	public void mostrarResultado() {
		System.out.printf("La suma de los %d primeros números es %d%n%n", 
		ultimoNumero,
		suma);
	}
}
