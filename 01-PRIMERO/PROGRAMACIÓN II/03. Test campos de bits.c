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
	printf("El tama�o de A es: %d\n", sizeof(ejemplo.A));
	printf("El tama�o de B es: %d\n", sizeof(ejemplo.B));
	printf("El tama�o de C es: %d\n", sizeof(ejemplo.C));
	printf("El tama�o de D es: %d\n", sizeof(ejemplo.D));
	printf("\n");
*/	
	printf("El tama�o total de la estructura de bits es: %d\n", sizeof(ejemplo)*sizeof(unsigned));
	printf("El tama�o usado de la estructura de bits es: %d\n", Aa + Bb + Cc + Dd + Ee + Ff);
	
	
	return 0;
}
