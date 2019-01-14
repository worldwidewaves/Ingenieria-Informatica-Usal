#include <stdio.h>
#include <stdlib.h>
#include <locale.h>


/*---------------------------Función Main--------------------------------*/
int main (void){
	double *punt1, *punt2, *punt3;

	setlocale (LC_ALL, "spanish");
	
	printf("Introduce 3 doubles\n");
	
	if(NULL == (punt1 = (double *) malloc(sizeof(double))))
		return -1;
	else{
		printf("Introduce el primero: ");
		scanf("%lf", punt1);
	}
	
	if(NULL == (punt2 = (double *) malloc(sizeof(double))))
		return -1;
	else{
		printf("Introduce el segundo: ");
		scanf("%lf", punt2);
	}
		
	if(NULL == (punt3 = (double *) malloc(sizeof(double))))
		return -1;
	else{
		printf("Introduce el tercero: ");
		scanf("%lf", punt3);
	}
	
	printf("Primero - Segundo + Tercero = %lf\n", *punt1 - *punt2 + *punt3);
	
	free(punt1);
	free(punt2);
	free(punt3);
	
	return 0;
}
