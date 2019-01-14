#include <stdio.h>
#include <stdlib.h>

#define DIM 100

int ComparaVectores (double *, double *, int dm);

int main(void){
    int dimension, i;
    double vector1[DIM];
    double vector2[DIM];
    int max, min;
    
    do{
        printf("Introduce dimension de los vectores: ");
        scanf("%d", &dimension);
    
    }while(dimension<0 || dimension>DIM);
    
    for(i=0; i<dimension; i++){
       printf("\nIntroduce el elemento %d del primer vector: ", i+1);
       scanf("%lf", &vector1[i]);
    }
    printf("\n");
    
    for(i=0; i<dimension; i++){
       printf("\nIntroduce el elemento %d del segundo vector: ", i+1);
       scanf("%lf", &vector2[i]);
    }
    printf("\n");
    
    
    if(ComparaVectores(vector1,vector2,dimension))
        printf("Los vectores son iguales");
    else
        printf("Los vectores son distintos");
        
    printf("\n");
    system ("pause");
    return 0;
}


int ComparaVectores (double *v1, double *v2, int dm){
    int iguales = 1;
    int i;
    
    for (i=0;i<dm;i++){
        if(*(v1+i)!=*(v2+i)){
             iguales = 0;
             break;
        }    
    }
    
    return iguales;
}
