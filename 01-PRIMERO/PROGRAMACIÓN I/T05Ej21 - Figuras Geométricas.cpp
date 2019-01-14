#include <stdio.h>
#include <stdlib.h>

int main(void){
const char blanco = ' ';
char carext, carint;
int alt, i, j;

printf("Introduce el caracter con el que hacer el exterior del triangulo: ");
scanf("%c", &carext);
fflush(stdin);
printf("Introduce el caracter con el que hacer el interior del triangulo: ");
scanf("%c", &carint);
fflush(stdin);
printf("Introduce la altura del triangulo: ");
scanf("%d", &alt);

//T1
for (i = 0; i <= alt; i++){
	for (j = 0; j <= alt - i; j++){
		printf("%c", blanco);
		}
	for (j = 1; j <= i; j++){
		printf("%c", carint);
		}
	for (j = 1; j <= i; j++){
		printf("%c", carint);
		}
	for (j = 0; j <= alt - i; j++){
		printf("%c", blanco);
		}
	printf("\n");
	}
for (i = 0; i <= alt; i++){
		for (j = 0; j <= i; j++){
		printf("%c", blanco);
		}
	for (j = 1; j <= alt - i; j++){
		printf("%c", carint);
		}
	for (j = 1; j <= alt - i; j++){
		printf("%c", carint);
		}
	for (j = 0; j <= i; j++){
		printf("%c", blanco);
		}
	printf("\n");
	}
printf("\n\n\n");

//T2
for (i = 0; i <= alt; i++){
	for (j = 0; j <= alt - i; j++){
		printf("%c", carext);
		}
	for (j = 1; j <= i; j++){
		printf("%c", blanco);
		}
	for (j = 1; j <= i; j++){
		printf("%c", blanco);
		}
	for (j = 0; j <= alt - i; j++){
		printf("%c", carext);
		}
	printf("\n");
	}
for (i = 0; i <= alt; i++){
		for (j = 0; j <= i; j++){
		printf("%c", carext);
		}
	for (j = 1; j <= alt - i; j++){
		printf("%c", blanco);
		}
	for (j = 1; j <= alt - i; j++){
		printf("%c", blanco);
		}
	for (j = 0; j <= i; j++){
		printf("%c", carext);
		}
	printf("\n");
	}
printf("\n\n\n");

//T3
for (i = 0; i <= alt; i++){
	for (j = 0; j <= alt - i; j++){
		printf("%c", carext);
		}
	for (j = 1; j <= i; j++){
		printf("%c", carint);
		}
	for (j = 1; j <= i; j++){
		printf("%c", carint);
		}
	for (j = 0; j <= alt - i; j++){
		printf("%c", carext);
		}
	printf("\n");
	}
for (i = 0; i <= alt; i++){
		for (j = 0; j <= i; j++){
		printf("%c", carext);
		}
	for (j = 1; j <= alt - i; j++){
		printf("%c", carint);
		}
	for (j = 1; j <= alt - i; j++){
		printf("%c", carint);
		}
	for (j = 0; j <= i; j++){
		printf("%c", carext);
		}
	printf("\n");
	}

printf("\n");
system("pause");
return 0;
}
