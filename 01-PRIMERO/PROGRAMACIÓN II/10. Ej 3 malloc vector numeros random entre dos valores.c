#include <stdio.h>
#include <stdlib.h>
#include <locale.h>


/*---------------------------Función Main--------------------------------*/
int main (void){
	int dim;
	int limA, limB;
	int i;
	int *punt;

	setlocale (LC_ALL, "spanish");
	
	
	printf("VECTOR DINÁMICO DE NUMEROS ALEATORIOS ENTRE DOS LIMITES\n");
	printf("===========================\n\n");
	
	printf("Introduce la dimensión: ");	
	do{
		scanf("%d", &dim);
		fflush(stdin);
	}
	while (dim <= 0);
	
	
	printf("Introduce el primer límite: ");	
	scanf("%d", &limA);
	fflush(stdin);
	
	
	printf("Introduce el segundo límite: ");	
	scanf("%d", &limB);
	fflush(stdin);
	
	
	if (limA > limB){
		i = limA;
		limA = limB;
		limB = i;
	}

	
	if(NULL == (punt = (int *) malloc(dim * sizeof(int))))
		return -1;
		
	else{
		for (i=0; i<dim; i++)
			*(punt+i) = rand () % (limB-limA+1) + limA;

		
		printf("\n\n");
		printf("El vector aleatorio es:\n");
		printf("-----------------------\n\n");
		
		
		for (i=0; i<dim; i++)
			printf("%d\t ", *(punt+i));
		printf("\n");
		
		
		free(punt);
		
		return 0;
	}
}

