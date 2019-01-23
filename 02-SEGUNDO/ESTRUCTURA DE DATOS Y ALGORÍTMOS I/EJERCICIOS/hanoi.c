#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <windows.h>

//	Número de discos
#define DISCOS 3

//	Colores decorativos
#define FC_CIAN_INT (FOREGROUND_BLUE | FOREGROUND_GREEN | FOREGROUND_INTENSITY)
#define FC_BLANCO	(FOREGROUND_RED | FOREGROUND_BLUE | FOREGROUND_GREEN)

//	Declaraciones de funciones
void hanoi(int n, int origen, int temporal, int destination);
void moverDisco( int origen, int destination );

//	Variables Globales
int torre[3][DISCOS];
char nombreTorre[3] = {'A', 'B', 'C'};
int paso= 0;
HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
	
//	Función Main
int main(void) {
	setlocale(LC_ALL, "spanish");


	
	int i;
	int j;
	
	//	Título
	SetConsoleTextAttribute(hStdOut, FC_CIAN_INT);
	printf("**=================================================**\n");
	printf("||                                                 ||\n");
	printf("||  Demostración del Algoritmo de Hanoi por pasos  ||\n");
	printf("||                                                 ||\n");
	printf("**=================================================**\n\n");
	SetConsoleTextAttribute(hStdOut, FC_BLANCO);
	
	//	Inicialización
	for(i= 0; i < 3; i++){
		for(j= 0; j < DISCOS; j++){
			if(i == 0){
				torre[i][j]= j + 1;
			}else{
				torre[i][j]= 0;
			}
		}
	}
	
	//  Imprimir posición inicial
	SetConsoleTextAttribute(hStdOut, FC_CIAN_INT);
	printf("[Paso nº%d] " , paso);
	SetConsoleTextAttribute(hStdOut, FC_BLANCO);
	printf("Posiciones iniciales:\n");
	printf("\n\n\tA B C\n");
	printf("\t- - -\n");

	for(j= 0; j < DISCOS; j++)
	{
		printf("\t%d %d %d\n", torre[0][j], torre[1][j], torre[2][j]);
	}
	printf("\n");
	
	//	Ejecución de Algoritmo de Hanoi
	hanoi (DISCOS, 0, 1, 2);
	
	//	Fin	
	return 0;
}

//	Función Hanoi
void hanoi(int n, int origen, int temporal, int destino){
	if (n == 1){	//	Caso base
		paso++;
		moverDisco(origen, destino);
	}else{
		hanoi(n - 1, origen, destino, temporal);
		paso++;
		moverDisco(origen, destino);
		hanoi(n - 1, temporal, origen, destino);
	}
	
	//	Fin
	return;
}

//	Función MoverDisco
void moverDisco(int origen, int destino){
	int i= 0;
	int j= 0;

	//	Determinar el origen
	while(torre[origen][i] == 0){
		i++;
	}

	//  Determinar el destino
	while((torre[destino][j] == 0) && (j < DISCOS)){
		j++;
	}
	j--;

	//	Mover el disco del origen al destino
	SetConsoleTextAttribute(hStdOut, FC_CIAN_INT);
	printf("\n[Paso nº%d] " , paso);
	SetConsoleTextAttribute(hStdOut, FC_BLANCO);
	printf("Mover disco #%d de %c a %c:\n\n", torre[origen][i], nombreTorre[origen], nombreTorre[destino]);
	torre[destino][j]= torre[origen][i];
	torre[origen][i]= 0;

	//  Imprimir posición después del movimiento
	printf("\n\n\tA B C\n");
	printf("\t- - -\n");

	for(j= 0; j < DISCOS; j++){
		printf("\t%d %d %d\n", torre[0][j], torre[1][j], torre[2][j]);
	}
	printf("\n");

	//	Fin
	getchar()
	return;
}
