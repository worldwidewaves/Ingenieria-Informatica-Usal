#include <stdio.h>
#include <stdlib.h>

int main (void) {
    int f, c;        //   0    1   2   3   4    [c=5]   
    int matriz[4][5] = {  11, 12, 13, 14, 15,   // 0
                          21, 22, 23, 24, 25,   // 1
                          31, 32, 33, 34, 35,   // 2
                          41, 42, 43, 44, 45 }; // 3
                                                // [f=4]
   
   
   
   
   
   printf("Normal:\n");
   for (f=0;f<4;f++){
       for (c=0;c<5;c++){
           printf("%d\t", matriz[f][c]);
           }
           printf("\n");
       }
   printf("\n\n\n");
   
   
   
   
   
   
   
   printf("Descendente por filas, ascendente por columnas:\n");
   for (f=3;f>=0;f--){
       for (c=0;c<5;c++){
           printf("%d\t", matriz[f][c]);
           }
           printf("\n");
       }
   printf("\n\n\n");
   
   
   
   
   
   printf("Descendente por columnas, descendente por filas:\n");
   for (c=4;c>=0;c--){
       for (f=3;f>=0;f--){
           printf("%d\t", matriz[f][c]);
           }
           printf("\n");
       }
   printf("\n\n\n");
   
   
   
   
   
   printf("Ascendente por columnas, ascendente por filas:\n");
   for (c=0;c<5;c++){
       for (f=0;f<4;f++){
           printf("%d\t", matriz[f][c]);
           }
           printf("\n");
       }
   printf("\n\n\n");
   
   
   
   
   system("pause");
   return 0;
}
