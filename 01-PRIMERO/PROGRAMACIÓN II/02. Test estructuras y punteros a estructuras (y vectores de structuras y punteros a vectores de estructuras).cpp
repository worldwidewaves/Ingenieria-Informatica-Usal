#include <stdio.h>
#include <stdlib.h>

struct estructura{
		int A;
		int B;
	};

int main (void){
	int i;
	struct estructura primera, segunda[5];
	struct estructura *puntPrimera, *puntSegunda;

	puntPrimera = &primera;
	puntSegunda = segunda;
	
	
//INICIACION	
	primera.A=1;
	primera.B=2;
	
	for (i=0; i<5; i++){
		segunda[i].A=i;
		segunda[i].B=i*2;
	}
	
	
//PRINTF
	//PRIMERA
	printf("Primera: %d, %d", primera.A, primera.B);
	printf("\n");
	printf("\n");
	
	printf("Punt Primera: %d, %d", puntPrimera->A, puntPrimera->B);
	printf("\n");
	printf("\n");
	
	//SEGUNDA
	for (i=0; i<5; i++){
		printf("Segunda (1)[%d]: %d, %d", i, segunda[i].A, segunda[i].B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
	for (i=0; i<5; i++){
		printf("Segunda (2)[%d]: %d, %d", i, (segunda+i)->A, (segunda+i)->B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
		for (i=0; i<5; i++){
		printf("Punt Segunda (1)[%d]: %d, %d", i, puntSegunda[i].A, puntSegunda[i].B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
	for (i=0; i<5; i++){
		printf("Punt Segunda (2)[%d]: %d, %d", i, (puntSegunda+i)->A, (puntSegunda+i)->B);
		printf("\n");
	}
	printf("\n");
	printf("\n");
	
	
	
	return 0;
}
