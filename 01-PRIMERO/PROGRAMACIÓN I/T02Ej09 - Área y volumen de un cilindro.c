#include <stdio.h>
#include <stdlib.h>

/* Ejercicio 9:
Calcular �rea lateral y volumen de un cilindro */

int main(void)
{
    float radio, altura, perimetro_circunferencia, area_lateral, area_circunferencia, volumen, pi;
    pi = 3.141592;
    
    //Introducci�n de datos
    printf("Calculo del area lateral y volumen de un cilindro\n");
    printf("Introduzca la altura: ");
    scanf("%g", &altura);
    printf("\nIntroduzca el radio: ");
    scanf("%g", &radio);
    
    //C�lculos
    perimetro_circunferencia = 2 * radio * pi;
    area_lateral = perimetro_circunferencia * altura;
    area_circunferencia = radio * radio * pi;
    volumen = area_circunferencia * altura;
    
    //Resultados
    printf("\n\nEl area lateral es: %g", area_lateral);
    printf("\nEl volumen es: %g", volumen);
    printf("\n\n");
    
    system("pause");
    return 0;
}
