//EJERCICIO RESUELTO NUMERO 4 TIPOS DEFINIDOS POR EL USUARIO
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

enum tipoEstaciones{
		Primavera  	= 1,
		Verano		= 2,
		Otonho		= 3,
		Invierno	= 4,
};

enum tipoEstaciones leerEstaciones (void);

int main (void){
	printf("El numero correspondiente a la estación introducida es: %d\n", leerEstaciones());
	
	return 0;
}
enum tipoEstaciones leerEstaciones (void){
	setlocale (LC_ALL, "spanish");
	
	int e;
	
	printf("Introduce un numero para la estación del año:\n");
	printf("1 - Primavera\n");
	printf("2 - Verano\n");
	printf("3 - Otoño\n");
	printf("4 - Invierno\n");
	
	
	do{
		printf("\nNUMERO ===> ");
		scanf("%d", &e);
	}
	while (e>4 || e<1);
	
	switch (e){
		case 1:	return (Primavera);	break;
		case 2:	return (Verano);	break;
		case 3:	return (Otonho);	break;
		case 4:	return (Invierno);	break;
	}
}
