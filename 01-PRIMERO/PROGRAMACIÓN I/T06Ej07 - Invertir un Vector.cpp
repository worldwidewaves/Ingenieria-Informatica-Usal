#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int main (void){
	int DIM, f;
	float vector[MAX], vector_inv[MAX];
	
	do {
	printf("Introduce la dimension del vector (Maximo %d): ", MAX);
	scanf("%d", &DIM);
	}
	while (DIM < 0 || DIM > 100);
	printf("\n\n");
	
	printf("Introduce el vector:\n");
	for (f=0;f<DIM;f++){
		scanf("%f", &vector[f]);
		fflush(stdin);
		vector_inv[DIM - 1 - f]=vector[f];
	}
	printf("\n\n");
	
	printf("El vector introducido es:\n");
	for (f=0;f<DIM;f++){
		printf("%g\t", vector[f]);
	}
	printf("\n\n");
	
	printf("El vector invertido es:\n");
	for (f=0;f<DIM;f++){
		printf("%g\t", vector_inv[f]);
	}
	printf("\n\n");
	
	system("pause");
	return 0;
}
