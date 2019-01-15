#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int main (void){
	int vector[MAX];
	int DIM;
	int j;
	int diff;
	int diffmax;
	
	
	//DIMENSION
	do{
		printf("Introduce la dimension del vector (MAX %d): ", MAX);
		scanf("%d", &DIM);
		fflush(stdin);
	}
	while (DIM < 2 || DIM > MAX);
	printf("\n\n");
	
	
	//DATOS
	printf("Introduce el vector de numeros crecientes:\n");
	scanf("%d", &vector[0]);
	for (j=1;j<DIM;j++){
		do{
			scanf("%d", &vector[j]);
			if (vector[j] <= vector [j-1]){
				printf("El numero debe ser mayor que el anterior.");
			}
			fflush(stdin);
		}
		while (vector[j]<=vector[j-1]);
	}
	printf("\n\n");
	
	
	
	//OPERACIONES
	diffmax=vector[1]-vector[0];
	for (j=2;j<DIM;j++){
		diff=vector[j]-vector[j-1];
		if (diff > diffmax){
			diffmax = diff;
		}
	}
	printf("\n\n");
	
	
	
	//RESULTADOS
	printf("El vector es:\n");
	for (j=0;j<DIM;j++){
		printf("%d\t", vector[j]);
	}
	printf("\n");
	printf("La diferencia mas grande es: %d", diffmax);
	printf("\n\n");
	
	
	
	//FIN
	system("pause");
	return 0;
}
