#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*Ejercicio 5:
Funciones matemáticas (2 primeros apartados)*/

int main(void)
{
    double num, cuadrado, cubo;
    printf("Introduce un numero real mayor que 0\n");
    scanf("%lf", &num);
    
    cuadrado = pow(num,2);
    printf("El cuadrado de %lg es : %lg\n", num, cuadrado);
    
    cubo = pow(num,3);
    printf("El cubo de %lg es: %lg\n", num, cubo);
    
    system("pause");
    return 0;
}
