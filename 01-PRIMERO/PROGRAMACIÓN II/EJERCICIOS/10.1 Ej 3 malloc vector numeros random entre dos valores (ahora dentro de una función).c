#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int * crearVectorRandomLimitado(int, int *);

/*---------------------------Funci�n Main--------------------------------*/
int main (void){
	int errNum;
	int i;
	int dimension;
	int *puntero;
	
	setlocale(LC_ALL, "spanish");
	
	
	
	printf("VECTOR DIN�MICO DE NUMEROS ALEATORIOS ENTRE DOS LIMITES\n");
	printf("===========================\n\n");
	
	printf("Introduce la dimensi�n: ");	
	do{
		scanf("%d", &dimension);
		fflush(stdin);
	}
	while (dimension <= 0);
	
	
	
	puntero = crearVectorRandomLimitado(dimension, &errNum);
	printf("\n\n");
	printf("El vector aleatorio es:\n");
	printf("-----------------------\n\n");
		
		
		
	for (i=0; i<dimension; i++)
		printf("%d\t ", *(puntero+i));
	printf("\n");
	
	printf("C�digo de Error: %d", errNum);
	
		
	return 0;
}

/*---------------------------Funci�n crearVectorRandomLimitado--------------------------------*/
int * crearVectorRandomLimitado(int dim, int * errNumRef){
	int limA, limB;
	int i;
	int *punt;
		
	
	printf("Introduce el primer l�mite: ");	
	scanf("%d", &limA);
	fflush(stdin);
	
	
	printf("Introduce el segundo l�mite: ");	
	scanf("%d", &limB);
	fflush(stdin);
	
	
	if (limA > limB){
		i = limA;
		limA = limB;
		limB = i;
	}

	
	if(NULL == (punt = (int *) malloc(dim * sizeof(int)))){
		*errNumRef = -1;
		return NULL;
	}
	
		
	else{
		for (i=0; i<dim; i++)
			*(punt+i) = rand () % (limB-limA+1) + limA;
		
		*errNumRef = 0;
		return punt;
	}
}
