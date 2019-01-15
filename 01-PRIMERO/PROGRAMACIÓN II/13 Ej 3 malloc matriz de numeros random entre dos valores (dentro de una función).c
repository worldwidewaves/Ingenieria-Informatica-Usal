#include <stdio.h>
#include <stdlib.h>
#include <locale.h>


typedef struct tipoMat{
	int **m;
	int numFil;
	int numCol;
} tipoMat;

typedef tipoMat * tipoMatRef;


int * crearVectorRandomLimitado(int, int, int, int *);
tipoMatRef crearMatrizRandomLimitada(int, int, int *);




/*---------------------------Función Main--------------------------------*/
int main (void){
	int errNum;
	int fil, col;
	int f, c;
	
	tipoMatRef mat;

	
	setlocale(LC_ALL, "spanish");
	
	
	
	
	printf("MATRIZ DINÁMICA DE NUMEROS ALEATORIOS ENTRE DOS LIMITES\n");
	printf("===========================\n\n");
	
	printf("Introduce el número de filas: ");	
	do{
		scanf("%d", &fil);
		fflush(stdin);
	}
	while (fil <= 0);
	
	printf("Introduce el número de columnas: ");	
	do{
		scanf("%d", &col);
		fflush(stdin);
	}
	while (col <= 0);
	


	mat = crearMatrizRandomLimitada(fil, col, &errNum);
	
	//Mostrar por pantalla
	if(!errNum){
		printf("\n");
		printf("La matriz introducida es:\n");
		printf("-------------------------\n");
		for (f=0; f<fil; f++){
			for (c=0; c<col; c++)
				printf("%d\t", *(*(mat->m+f)+c));
			printf("\n");
		}
	}

	return errNum;
}




/*---------------------------Función crearMatrizRandomLimitada--------------------------------*/
tipoMatRef crearMatrizRandomLimitada(int fil, int col, int * errNumRef){
	tipoMatRef matriz;
	int f;
	int limA, limB;
	int i;
	
	
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

	
	if (NULL == (matriz = (tipoMatRef) malloc(fil*col*sizeof(tipoMat)))){
		*errNumRef = -1;
		return NULL;
	}
	
	
	else {
		for (f=0; f<fil; f++){
			matriz->m[f] = crearVectorRandomLimitado(limA, limB, col, errNumRef);
		}
		return matriz;
	}
}


/*---------------------------Función crearVectorRandomLimitado--------------------------------*/
int * crearVectorRandomLimitado(int limA, int limB, int dim, int * errNumRef){
	int i;
	int *punt;
		
	

	
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
