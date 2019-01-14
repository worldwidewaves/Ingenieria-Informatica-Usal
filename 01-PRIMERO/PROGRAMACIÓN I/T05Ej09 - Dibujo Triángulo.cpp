#include <stdio.h>
#include <stdlib.h>

int main(void){
const char blanco = ' ';
char car;
int alt, i, j;

printf("Introduce el caracter con el que hacer el triangulo: ");
scanf("%c", &car);
printf("\nIntroduce la altura del triangulo: ");
scanf("%d", &alt);

for (i = 1; i <= alt; i++){
	for (j = 1; j <= alt - i; j++){
		printf("%c", blanco);
		}
	for (j = 1; j <= i; j++){
		printf("%c", car);
		}
	printf("\n");
	}

printf("\n");
system("pause");
return 0;
}
