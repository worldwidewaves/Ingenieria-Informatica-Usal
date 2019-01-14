#include <stdio.h>
#include <stdlib.h>

#define DIM 7
#define FIL 3
#define COL 4

int main (void){
    //VARIABLES///////////////////////////////////////////
    int vector[DIM] = { 25, 40, 55, 70, 85, 100, 115 };
    int tabla[FIL][COL] = {  15,  25,  35,  45,
                            115, 125, 135, 145,
                            215, 225, 235, 245 };
    
    int f;
    int c;
    
    int *p_vector = vector;
    int (*p_tabla)[FIL][COL];
    p_tabla=&tabla;
    
       
    //VECTOR//////////////////////////////////////////////
    printf("VECTOR");
    printf("\n\n");
    
    //1) Índice                  
    for(f=0;f<DIM;f++)
      printf("%4d", vector[f]);
    printf("\n\n");
    
    //2) Nombre como puntero
    for(f=0;f<DIM;f++)
      printf("%4d", *(vector+f));
    printf("\n\n");
    
    //3) Puntero
    for(f=0;f<DIM;f++)
      printf("%4d", *(p_vector+f));
    printf("\n\n");
    
    
    //TABLA//////////////////////////////////////////////
    printf("TABLA");
    printf("\n\n");
    
    //1) Índices
    for(f=0;f<FIL;f++){
      for(c=0;c<COL;c++)
        printf("%4d", tabla[f][c]);
      printf("\n");
    }
    printf("\n\n");
    
    //2) Nombre como puntero
    for(f=0;f<FIL;f++){
      for(c=0;c<COL;c++)
        printf("%4d", *(*(tabla+f)+c));
      printf("\n");
    }
    printf("\n\n");
    
	//3) Puntero
    for(f=0;f<FIL;f++){
      for(c=0;c<COL;c++)
        printf("%4d", *(*((*p_tabla)+f)+c));
      printf("\n");
    }
    printf("\n\n");
    
    
    //FIN/////////////////////////////////////////////////
    system("pause");
    return 0;
}
