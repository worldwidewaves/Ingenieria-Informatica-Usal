#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 10:
Paso de grados a radianes*/

int main(void)
{
    float grados, radianes, pi;
    pi = 3.14159;
    
    //Introducción de datos
    printf("Paso de grados a radianes");
    printf("\n");
    printf("Introduce el valor de un angulo en grados: ");
    scanf("%g", &grados);
    printf("\n");
    
    //Operaciones
    radianes = (pi / 180) * grados;
    
    //Resultado
    printf("%g grados en radianes es: %g radianes", grados, radianes);
    printf("\n");
    
    system("pause");
    return 0;
}
    
    
