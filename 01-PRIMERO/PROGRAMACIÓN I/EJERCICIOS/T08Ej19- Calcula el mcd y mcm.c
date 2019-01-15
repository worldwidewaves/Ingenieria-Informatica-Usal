#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//1
int mcd(int A, int B){
    int C;
    int S;
    
    
    if (B > A){
    	S = A;
    	A = B;
    	B = S;
	}
	
	//Algoritmo de Euclides
	do{
		C = A % B;
		if (C != 0){
			A = B;
			B = C;
		}
	}
	while (C != 0);
	
	
    return B;
}

//2
int mcm(int A, int B){
	int m;
	
	
    if (A > B)
    	m = A;
    else
    	m = B;
    
    
    do
    	m++;
    while ((m % A != 0) || (m % B != 0));
    
    
    return m;
}



int main(void){
    int A, B;
    
    
	printf("Introduce dos enteros para calcular su mcd y mcm.\n");
	printf("Introduce el primer entero: ");
	scanf("%d", &A);
	printf("Introduce el segundo entero: ");
	scanf("%d", &B);
	
    printf("El resultado es:\nMCD = %d\nMCM = %d", mcd(A,B), mcm(A,B));
    printf("\n\n");
    
    system("pause");
    return 0;
}
