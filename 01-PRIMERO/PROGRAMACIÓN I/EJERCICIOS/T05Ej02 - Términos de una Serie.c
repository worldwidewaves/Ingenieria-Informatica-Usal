#include <stdio.h>
#include <stdlib.h>

int main(void){
    float N = 0, limite, S = 0;
    
    printf("Terminos de una serie\nDesarrolla un programa que calcule cuantos terminos deben sumarse de la serie\n1/2   2/3   3/4   4/5  ...   N /(N+1)\npara que su suma supere el valor limite S que se introduce por teclado entre (0 < S <= 10000.8)\nMostrar N y la suma por pantalla.\n\n");
    printf("Introduce un valor limite entre 0 y 10000.8:");
    scanf("%f", &limite);
    if (limite > 0 && limite <= 10000.8){
               while (S < limite){
                     N += 1;
                     S += N/(N+1);
                     }
               printf("\nEl numero de terminos es %g y la suma es %g\n", N, S);
               }
               else {
                    printf("El valor introducido no es valido.\n");
                    }
    
    system("pause");
    return 0;
}
