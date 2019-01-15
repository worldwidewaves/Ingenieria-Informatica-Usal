#include <stdlib.h>
#include <stdio.h>
#define FIL 3
#define COL 4


int main (void){
	char vletras[10]={'A','F','H','K','L','O','S','U','X','Z'};
	char letras[FIL][COL];
	char *mapa[FIL][COL];
	int f, c;
	int v;
	
	
	for(f=0;f<FIL;f++){
		for(c=0;c<COL;c++){
			mapa[f][c]=NULL;
		}
	}
	

	
	for(f=0;f<FIL;f++){
		for(c=0;c<COL;c++){
		printf("Introduzca caracter[%d][%d]: ",f+1,c+1);
		scanf("%c",&letras[f][c]);
		fflush(stdin);
			for(v=0;v<10;v++){
				if(letras[f][c]==vletras[v]){
					mapa[f][c]=&vletras[v];
				}
			}
		}
	}
	printf("\n\n");
	
	
	
	printf("La matriz resultante es:\n");
	for(f=0;f<FIL;f++){
		for(c=0;c<COL;c++){
			if(mapa[f][c]==NULL){
				printf("*\t");
			}
			else{
				printf("%c\t", *mapa[f][c]);
			}	
		}
		printf("\n");
	}
	printf("\n\n");
	
	
	
	system("pause");
	return 0;
}
