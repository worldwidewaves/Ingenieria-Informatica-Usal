#include <stdio.h>
#include <stdlib.h>

int main (void){
    int vector[15];
    int *ordenado[15];
    int j, k;
    int repetido;
    int encontrado;
    const int INF = 1000;
    const int SUP = 7000;
    int i;
    int klv;
    
    ordenado[0]=NULL;
    
    printf("Introduce 15 numeros enteros distintos entre 1000 y 7000:\n");
    for(j = 0;j < 15;j++){
          do{
             do{
                  printf("Introduzca la clave %d: ", j+1);
                  scanf("%d", &vector[j]);
             }
             while (vector[j] > SUP || vector[j] < INF);
             fflush(stdin);
             repetido = 0;
             k = (j - 1);
             while((k >= 0) && (repetido == 0)){
                      if (vector[j] == vector[k]){
                         repetido = 1;
                      }
                      k = (k - 1);
             }
          }
          while(repetido == 1);
    }
    printf("\n\n");
    
    
    i = 0;
    for(klv = INF;klv < SUP;klv++){
            j = -1;
            encontrado = 0;
            while (!encontrado && (j < 15)){
                  j = j + 1;
                  if (vector[j] == klv){
                                encontrado = 1;
                  }
            }
            
            if (encontrado){
                            ordenado[i] = &vector[j];
                            i = i + 1;
            }
    }
    
    
    printf("Las claves ordenadas son:\n");
    for(j=0;j<15;j++){
    	printf("%d\t",*ordenado[j]);
	}
    
    
    
    
    printf("\n\n");
    system("pause");
    return 0;
}
