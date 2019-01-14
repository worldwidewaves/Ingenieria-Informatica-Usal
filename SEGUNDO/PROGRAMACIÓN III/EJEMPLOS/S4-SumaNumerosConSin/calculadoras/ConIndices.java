package calculadoras;

public class ConIndices {

	int suma;
	int ultimoNumero;
	
	public ConIndices() {
		suma = 0;
		ultimoNumero = 10;
	}
	
	public ConIndices(int n) {
		suma = 0;
		ultimoNumero = n;
	}
	
	public void calcularSuma() {
		for(int i=1; i<=ultimoNumero;i++) {
			suma += i;
		}
	}
	
	public void mostrarResultado() {
		System.out.printf("La suma de los %d primeros números es %d%n%n", 
		ultimoNumero,
		 suma);
	}
}
