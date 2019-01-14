#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int main (void){
	int f;
	char cadena[MAX], cadena_inv[MAX];
	
	printf("Introduce la cadena (ENTER para acabar):\n");
	scanf("%[^\n]", &cadena);
	printf("\n\n");
	
	printf("La cadena introducida es:\n");
	f = 0;
	while (cadena[f] != '\0'){
		printf("%c", cadena[f]);	
		f++;
	}
	printf("\n\n");
	
	printf("La cadena invertida es:\n");
	while (f >= 0){
		printf("%c", cadena[f]);
		f--;	
	}
	printf("\n\n");
	
	system("pause");
	return 0;
}
