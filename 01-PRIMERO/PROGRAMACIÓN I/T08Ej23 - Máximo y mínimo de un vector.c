#include <stdio.h>
#include <stdlib.h>

#define DIM 100

float media_vector  (int *, int);
void max_min_vector (int *, int, int *, int *); 

int main(void){
    int dimension, i;
    int vector[DIM];
    int max, min;
    
    do{
        printf("Introduce dimension del vector: ");     scanf("%d", &dimension);
    
    }while(dimension<0 || dimension>DIM);
    
    for(i=0; i<dimension; i++){
       printf("\nIntroduce el elemento %d del vector: ", i+1);
       scanf("%d", &vector[i]);
    }
    
    printf("\nLa media es %g", media_vector(vector, dimension));
    max_min_vector(vector, dimension, &max, &min);
	printf("\nEl maximo es %d y el minimo es %d", max, min);
	
	
	puts("");
    system ("pause");
    return 0;
}

float media_vector (int *la, int dim){
      float suma=0;
      float media;
      int i;
      
      for(i=0; i<dim; i++)
         suma+=la[i];
      
      media= suma/dim;
      
      return media;
      
}

void max_min_vector (int *v, int dim, int *max, int *min){
     int i;
     int maximo, minimo;
     
     maximo=minimo=v[0];
     
     for(i=0; i<dim; i++)
        if(v[i]>maximo)
          maximo=v[i];
        else if(v[i]<minimo)
               minimo=v[i];
   *max=maximo;
   *min=minimo;
}
     
     
     
     

