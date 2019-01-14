#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 11:
Interacambio de dos variables*/

int main(void)
{
    float a, b, c, d;
    
    //Introducción de datos
    printf("Intercambio de dos variables\n");
    printf("Da un valor a la primera variable: ");
    scanf("%g", &a);
    printf("\n");
    printf("Da un valor a la segunda variable: ");
    scanf("%g", &b);
    printf("\n");
    
    //Operaciones
    c = a;
    d = b;
    a = d;
    b = c;
    
    //Resultado
    printf("La primera variable ahora es: %g", a);
    printf("\n");
    printf("La segunda variable ahora es: %g", b);
    printf("\n");
    
    system("pause");
    return 0;
}
