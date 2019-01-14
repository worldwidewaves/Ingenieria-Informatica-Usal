#include <stdio.h>
#include <stdlib.h>
#define MAX  25

int main (void) {

	long matrizA[MAX][MAX], matrizB[MAX][MAX], matrizP[MAX][MAX];
	int filA, colA, filB, colB, filP, colP, f, c, j;

	do{
		printf("Numero de filas de la matriz A (MAX %d): ", MAX);
		scanf("%d", &filA);
	} 
	while ((filA <= 0) || (filA > MAX));


	do{
    	printf("Numero de columnas de la matriz A (MAX %d): ", MAX);
    	scanf("%d", &colA);
   	}
	while ((colA <=0) || (colA > MAX));

	filB = colA;

	do{
		printf("Numero de columnas de la matriz B (MAX %d): ", MAX);
    	scanf("%d", &colB);
  	}
 	while ((colB <=0) || (colB > MAX));

	printf("\nIntroduzca la matriz A:\n");
	for (f = 0; f < filA; f++)
		for (c = 0; c < colA; c++){
	 		printf("Elemento (%d, %d)=> ", f+1, c+1);
	   		scanf("%ld", &matrizA[f][c]);
        }
  
	printf("\n\nIntroduzca la matriz B:\n");
	for (f = 0; f < filB; f++)
		for (c = 0; c < colB; c++){
	  		printf("Elemento (%d, %d)=> ", f+1, c+1);
	   		scanf("%ld", &matrizB[f][c]);
        }

	filP = filA;
	colP = colB;

	for (f = 0; f < filA; f++)
		for (c = 0; c < colB; c++){
    		matrizP[f][c] = 0;
      		for (j = 0; j < colA; j++)
          		matrizP[f][c] = matrizP[f][c] + (matrizA[f][j] * matrizB[j][c]);
    	}

	printf("\nMatriz A:\n");
	for (f = 0; f < filA; f++){
    	for (c = 0; c < colA; c++)
	  		printf("%5ld", matrizA[f][c]);
    	printf("\n");
  	}

	printf("\nMatriz B:\n");
  	for (f = 0; f < filB; f++){
    	for (c = 0; c < colB; c++)
	  		printf("%5ld", matrizB[f][c]);
    	printf("\n");
  	}

	printf("\nMatriz Producto:\n");
	for (f = 0; f < filP; f++){
    	for (c = 0; c < colP; c++)
	  		printf("%5ld", matrizP[f][c]);
    	printf("\n");
  	}

	printf("\n\n");
	system("pause");
	return 0;
}
