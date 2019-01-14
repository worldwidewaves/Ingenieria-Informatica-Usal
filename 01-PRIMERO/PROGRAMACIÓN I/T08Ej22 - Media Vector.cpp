#include <stdio.h>
#include <stdlib.h>

#define MAX 100

float media_vector (int *, int);


int main (void){
    int dim;
    int vector[MAX];
    int i;
    
    
    printf("Introduce la dimension del vector (MAX %d): ", MAX);
    scanf("%d", &dim);
    printf("\n");
    
    
    for (i = 0;i < dim; i++){
        printf("Introduce el elemento %d del vector: ", i+1);
        scanf("%d", &vector[i]);
        printf("\n");
    }
    
    
    printf("La media del vector es %g.", media_vector(vector, dim));
    printf("\n");
    
    
    system("pause");
    return 0;
}
    
    
float media_vector (int *la, int dim){
      int i;
      float media = 0;
      
      
      for (i = 0;i < dim;i++)
          media += *(la + i);
      media = (float) media / dim;
      
      return media;
}

