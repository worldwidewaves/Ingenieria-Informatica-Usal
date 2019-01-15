#include <stdio.h>
#include <stdlib.h>

#define Aa 1
#define Bb 2
#define Cc 3
#define Dd 4

#define Ee 0
#define Ff 5

struct estructuraBiteriana{
		unsigned A:Aa;
		unsigned B:Bb;
		unsigned C:Cc;
		unsigned D:Dd;
		
		unsigned  :Ee;
		unsigned  :Ff;
	};

int main (void){
	struct estructuraBiteriana ejemplo;
/*	NO SE PUEDE HACER EL SIZEOF DE CAMPOS DE BITS
	printf("El tamaño de A es: %d\n", sizeof(ejemplo.A));
	printf("El tamaño de B es: %d\n", sizeof(ejemplo.B));
	printf("El tamaño de C es: %d\n", sizeof(ejemplo.C));
	printf("El tamaño de D es: %d\n", sizeof(ejemplo.D));
	printf("\n");
*/	
	printf("El tamaño total de la estructura de bits es: %d\n", sizeof(ejemplo)*sizeof(unsigned));
	printf("El tamaño usado de la estructura de bits es: %d\n", Aa + Bb + Cc + Dd + Ee + Ff);
	
	
	return 0;
}
