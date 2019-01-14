#include <stdio.h>
#include <stdlib.h>
#define MAX 15

int main (void) {
    int f, c;
    int DIM;
    int matriz[MAX][MAX] = {	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
    							0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	};
    int num;
    int numM;
    
    
    
    
    do{
       printf("Introduce un numero impar con el que hacer el cuadrado (MAX. %d): " , MAX);
       scanf("%d", &DIM);
       fflush(stdin);
    }
    while ((DIM < 0) || (DIM > MAX) || (DIM % 2 == 0));
    printf("\n\n");
    
    
    
    
    f = 0;
    c = (DIM / 2);
    num = 1;
    matriz[f][c] = num;
    
    
    for (num = 2; num <= (DIM * DIM); num++){
        f--;
        if (f < 0){
        	f = (DIM - 1);
		}
        c++;
        if (c >= DIM){
        	c = 0;
		}
		if (matriz[f][c] != 0){
			f++;
			if (f >= DIM){
        		f = 0;
			}
			c--;
			if (c < 0){
        	c = (DIM - 1);
        	}
			f++;
		}
        matriz[f][c] = num;
    }
        
    
    
    printf("La matriz es:\n"); 
    for (f=0;f<DIM;f++){
    for (c=0;c<DIM;c++){
        printf("%d\t", matriz[f][c]);
        }
        printf("\n");
    }
	printf("\n");
   
    
    
    
    
    numM = 0;
    c = 0;
    for (f = 0; f < DIM; f++){
    	numM += matriz[f][c];
	}
    printf("El numero magico es: %d", numM);
    printf("\n\n\n");
    
    
    
    
    
    
    
    
	system("pause");
	return 0;
}
