#include <stdio.h>
#include <stdlib.h>
#define MAX 25

int main (void){
	float matriz[MAX][MAX], maximo, minimo;
    int F, C, f, c;
	
	do{
	printf("Introduce el numero de filas de la matriz (MAX %d): ", MAX);
    scanf("%d", &F);
    }
    while (F < 0 || F > MAX);
    do{
	printf("\nIntroduce el numero de columnas de la matriz (MAX %d): ", MAX);
    scanf("%d", &C);
	}
	while (C < 0 || C > MAX);
    printf("\nIntroduce los terminos de la matriz:\n");
    for (f=0;f<F;f++)
        for (c=0;c<C;c++)
            scanf("%f", &matriz[f][c]);
    printf("\n\n");
    
    maximo=matriz[0][0];
    minimo=matriz[0][0];
    for (f=0;f<F;f++){
    	for (c=0;c<C;c++){
    		if (matriz[f][c]>maximo){
    			maximo=matriz[f][c];
			}
			else if (matriz[f][c]<minimo){
				minimo=matriz[f][c];
			}
		}
	}
	printf("El maximo es %g", maximo);
	printf("\n");
	printf("El minimo es %g", minimo);
	printf("\n\n");
	
	printf("La fila y columna de los numeros que coinciden con el maximo son:\n");
	for (f=0;f<F;f++){
		for (c=0;c<C;c++){
			if (matriz[f][c]==maximo){
				printf("%d, %d\n", f+1, c+1);
			}
		}
	}
	printf("\n\n");
	
	system("pause");
	return 0;
}
