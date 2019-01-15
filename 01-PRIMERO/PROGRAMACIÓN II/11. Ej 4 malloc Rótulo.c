#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct boton{
	char *rotulo;
	int codigo;
};

typedef struct boton tipoBoton;
typedef tipoBoton * tipoBotonRef;

/*---------------------------Funci�n Main--------------------------------*/
int main (void){
	int dim;
	tipoBotonRef b;

	setlocale (LC_ALL, "spanish");
	
	
	
	if(NULL == (b = (tipoBotonRef) malloc(sizeof(tipoBoton))))
		return -1;
		
	else{
		do{
			printf("Introduce la dimensi�n del r�tulo: ");
			scanf("%d", &dim);
			fflush(stdin);
		}
		while (dim <= 0);
		
		
		
		if (NULL == (b->rotulo = (char *) malloc(dim * sizeof(char))))
			return -2;
		else{
			//Introducci�n de datos
			printf("Introduce el r�tulo: ");
			gets(b->rotulo);
			fflush(stdin);
			
			printf("Introduce el c�digo: ");
			scanf("%d", &b->codigo);
			fflush(stdin);
			
			
			
			//Mostrar por pantalla
			printf("\n\n");
			printf("El r�tulo es:\n");
			printf("%s", b->rotulo);
			printf("\n\n");
			
			printf("El c�digo es:\n");
			printf("%d", b->codigo);
			printf("\n");
			
			
			
			//Liberar
			free(b->rotulo);
			free(b);	
			
			
			
			
			return 0;
		}	
	}	
}

