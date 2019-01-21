#include <stdio.h>
#include <stdlib.h>
#define N 3

struct estructura{
		int A;
		int B;
	};

int main (void){
	int i;
	struct estructura primera, segunda[N];
	struct estructura *puntPrimera, *puntSegunda;

	puntPrimera = &primera;
	puntSegunda = segunda;
	
	
//INICIACION CON PETICIÓN DIRECTA
	//PRIMERA	
	printf("PRIMERA DIRECTA\n");
	printf("Introduce Primera-A: ");
	scanf("%d", &primera.A);
	printf("\n");
	printf("Introduce Primera-B: ");
	scanf("%d", &primera.B);
	printf("\n");	
	
	//SEGUNDA
	printf("SEGUNDA DIRECTA\n");
	for (i=0; i<N; i++){
		printf("Introduce Segunda[%d]-A: ", i+1);
		scanf("%d", &segunda[i].A);
		printf("\n");
		printf("Introduce Segunda[%d]-B: ", i+1);
		scanf("%d", &segunda[i].B);
		printf("\n");
	}
	
	
//PRINTF DIRECTO
	//PRIMERA
	printf("Primera: %d, %d", primera.A, primera.B);
	printf("\n");
	printf("\n");
	
	
	//SEGUNDA
	for (i=0; i<N; i++){
		printf("Segunda (1)[%d]: %d, %d", i+1, segunda[i].A, segunda[i].B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
	for (i=0; i<N; i++){
		printf("Segunda (2)[%d]: %d, %d", i+1, (segunda+i)->A, (segunda+i)->B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
	
	
	
	
	
	
	
//INICIACION CON PETICIÓN POR PUNTEROS
	//PRIMERA	
	printf("PRIMERA PUNT\n");
	printf("Introduce Primera-A: ");
	scanf("%d", &puntPrimera->A);
	printf("\n");
	printf("Introduce Primera-B: ");
	scanf("%d", &puntPrimera->B);
	printf("\n");	
	
	//SEGUNDA
	printf("SEGUNDA PUNT\n");
	for (i=0; i<N; i++){
		printf("Introduce Segunda[%d]-A: ", i+1);
		scanf("%d", &(puntSegunda+i)->A);
		printf("\n");
		printf("Introduce Segunda[%d]-B: ", i+1);
		scanf("%d", &(puntSegunda+i)->B);
		printf("\n");
	}
	
	
	
//PRINTF CON PUNTEROS
	//PRIMERA
	printf("Punt Primera: %d, %d", puntPrimera->A, puntPrimera->B);
	printf("\n");
	printf("\n");
	
	//SEGUNDA
	for (i=0; i<N; i++){
		printf("Punt Segunda (1)[%d]: %d, %d", i+1, puntSegunda[i].A, puntSegunda[i].B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
	for (i=0; i<N; i++){
		printf("Punt Segunda (2)[%d]: %d, %d", i+1, (puntSegunda+i)->A, (puntSegunda+i)->B);
		printf("\n");
	}
	printf("\n");
	printf("\n");	
	
	
	
	return 0;
}
