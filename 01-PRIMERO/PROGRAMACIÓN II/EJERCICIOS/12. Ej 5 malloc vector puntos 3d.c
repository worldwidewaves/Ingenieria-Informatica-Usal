#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

typedef struct p3d{
	int x;
	int y;
	int z;
} tipoP3D;

typedef  tipoP3D * tipoP3DRef;

/*---------------------------Función Main--------------------------------*/
int main (void){
	int dim;
	int i;
	tipoP3DRef poligono, ppol;

	setlocale (LC_ALL, "spanish");
	
	
	
	printf("Introduce la dimensión del vector (número de puntos): ");
	do{
		scanf("%d", &dim);
		fflush(stdin);
	}
	while (dim <= 0);

	
	
	
	if(NULL == (poligono = (tipoP3DRef) malloc(dim * sizeof(tipoP3D))))
		return -1;
	
	
	
	
	else{
		for (i=0, ppol=poligono; i<dim; i++, ppol++)
			printf("Punto número [%d]:\tX: %5d\tY: %5d\tZ: %5d\n",
				i+1,
				ppol->x = rand(),
				ppol->y = rand(),
				ppol->z = rand());
		
		
		return 0;
	}
}

