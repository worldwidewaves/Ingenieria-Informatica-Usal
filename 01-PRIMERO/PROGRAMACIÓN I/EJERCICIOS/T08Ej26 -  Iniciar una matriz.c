#include <stdio.h>
#include <stdlib.h>

#define FIL 5
#define COL 3

void iniciar (float (*)[COL], int, float);

int main (void){
	float mat[FIL][COL];
	float valor;
	int f;
	int c;
	
	printf("Introduce el valor al que iniciar la matriz %dx%d: ",FIL,COL);
	scanf("%f",&valor);
	
	iniciar(mat,FIL,valor);
	
	printf("La matriz es:\n");
	for(f=0;f<FIL;f++){
		for(c=0;c<COL;c++)
			printf("%g\t",mat[f][c]);
		printf("\n");
	}
	
	system ("pause");
	return 0;
}


void iniciar (float (*m)[COL], int filas, float valor_ini){
	int f;
	int c;
	
	for(f=0;f<FIL;f++)
		for(c=0;c<COL;c++)
			m[f][c] = valor_ini;
}
