#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*Ejercicio 6:
Código murciélago*/

int main(void)
{
    int num, millar, centena, decena, unidad, resto;
    char num_murcielago[25] ="";
    
    printf("Introduce el numero de hasta cuatro cifras a convertir:");
    scanf("%d", &num);
    
    if (num > 0 && num < 10000)
    {
            //Descomposición en dígitos
            millar  = num / 1000;
            resto   = num % 1000;
            centena = resto / 100;
            resto   = resto % 100;
            decena  = resto / 10;
            unidad  = resto % 10;
            
            //Adicción de valores a cadena
            switch (millar) {
                   case  0 : strcat(num_murcielago, "O"); break;
                   case  1 : strcat(num_murcielago, "G"); break;
                   case  2 : strcat(num_murcielago, "A"); break;
                   case  3 : strcat(num_murcielago, "L"); break;
                   case  4 : strcat(num_murcielago, "E"); break;
                   case  5 : strcat(num_murcielago, "I"); break;
                   case  6 : strcat(num_murcielago, "C"); break;
                   case  7 : strcat(num_murcielago, "R"); break;
                   case  8 : strcat(num_murcielago, "U"); break;
                   case  9 : strcat(num_murcielago, "M"); break;
                   }
                   
            switch (centena) {
                   case  0 : strcat(num_murcielago, "O"); break;
                   case  1 : strcat(num_murcielago, "G"); break;
                   case  2 : strcat(num_murcielago, "A"); break;
                   case  3 : strcat(num_murcielago, "L"); break;
                   case  4 : strcat(num_murcielago, "E"); break;
                   case  5 : strcat(num_murcielago, "I"); break;
                   case  6 : strcat(num_murcielago, "C"); break;
                   case  7 : strcat(num_murcielago, "R"); break;
                   case  8 : strcat(num_murcielago, "U"); break;
                   case  9 : strcat(num_murcielago, "M"); break;
                   }
                   
            switch (decena) {
                   case  0 : strcat(num_murcielago, "O"); break;
                   case  1 : strcat(num_murcielago, "G"); break;
                   case  2 : strcat(num_murcielago, "A"); break;
                   case  3 : strcat(num_murcielago, "L"); break;
                   case  4 : strcat(num_murcielago, "E"); break;
                   case  5 : strcat(num_murcielago, "I"); break;
                   case  6 : strcat(num_murcielago, "C"); break;
                   case  7 : strcat(num_murcielago, "R"); break;
                   case  8 : strcat(num_murcielago, "U"); break;
                   case  9 : strcat(num_murcielago, "M"); break;
                   }
                   
            switch (unidad) {
                   case  0 : strcat(num_murcielago, "O"); break;
                   case  1 : strcat(num_murcielago, "G"); break;
                   case  2 : strcat(num_murcielago, "A"); break;
                   case  3 : strcat(num_murcielago, "L"); break;
                   case  4 : strcat(num_murcielago, "E"); break;
                   case  5 : strcat(num_murcielago, "I"); break;
                   case  6 : strcat(num_murcielago, "C"); break;
                   case  7 : strcat(num_murcielago, "R"); break;
                   case  8 : strcat(num_murcielago, "U"); break;
                   case  9 : strcat(num_murcielago, "M"); break;
                   }
                   
            printf("El numero %d en codigo murcielago es %s.\n", num, num_murcielago);
    }
    else
    {
        printf("\nEl numero es negativo o mayor de 4 cifras.\n");
        }
    
    system("pause");
    return 0;
}
