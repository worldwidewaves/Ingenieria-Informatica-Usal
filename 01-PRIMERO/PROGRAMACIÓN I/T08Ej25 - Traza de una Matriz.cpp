#include <stdio.h>
#include <stdlib.h>

#define FIL 4
#define COL 4

float traza (float (*)[COL]);
int simetrica (float (*)[COL]);


int main (void){
	float mat[FIL][COL];
	int f;
	int c;
	
	printf("Introduce los elementos de una matriz 4x4:\n");
	for(f=0;f<FIL;f++)
		for(c=0;c<COL;c++){
			printf("Introduce el elemento [%d][%d]: ",f+1,c+1);
			scanf("%f",&mat[f][c]);
		}
		
	printf("La traza de la matriz es %g",traza(mat));
	printf("\n");
	
	if (simetrica(mat))
		printf("SI es simetrica.\n");
	else
		printf("NO es simetrica.\n");
	
	system("pause");
	return 0;
}


float traza (float (*m)[COL]){
	float suma = 0;
	int i;
	
	for (i=0;i<COL;i++)
		suma += m[i][i];
		
	return (suma);
}


int simetrica (float (*m)[COL]){
	int f;
	int c;
	int simetria = 1;
	
	for (f=0;f<FIL;f++)
		for (c=0;c<COL;c++)
			if (m[f][c] != m[c][f]){
				simetria = 0;
				break;
			}
			
	return (simetria);	
}

