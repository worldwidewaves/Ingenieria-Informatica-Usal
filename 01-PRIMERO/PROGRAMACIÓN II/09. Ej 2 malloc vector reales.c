#include <stdio.h>
#include <stdlib.h>
#include <locale.h>


/*---------------------------Función Main--------------------------------*/
int main (void){
	int dim;
	int i;
	float *punt;

	setlocale (LC_ALL, "spanish");
	
	printf("INVERSOR DE VECTOR DINÁMICO\n");
	printf("===========================\n\n");
	printf("Introduce la dimensión: ");
	
	do{
		scanf("%d", &dim);
		fflush(stdin);
	}
	while (dim <= 0);
	
	if(NULL == (punt = (float *) malloc(dim * sizeof(float))))
		return -1;
	else{
		for (i=0; i<dim; i++){
			printf("Introduce el elemento [%d]: ", i+1);
			scanf("%f", punt+i);
			fflush(stdin);
		}
		
		printf("\n\n");
		printf("El vector invertido es:\n");
		printf("-----------------------\n\n");
		
		for (i=dim-1; i>=0; i--)
			printf("%g\t ", *(punt+i));
		printf("\n");
		
		free(punt);
		
		return 0;
	}
}

