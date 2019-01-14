#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 9:
Diferencia de tiempo entre dos corredores*/

int main(void)
{
    int horas1, minutos1, segundos1, horas2, minutos2, segundos2, tiempo1, tiempo2, diferencia, segundos, minutos, horas, temp;
    printf("Introduzca el tiempo del primer corredor\n");
    printf("Horas: ");
    scanf("%d", &horas1);
    printf("\nMinutos: ");
    scanf("%d", &minutos1);
    printf("\nSegundos: ");
    scanf("%d", &segundos1);
    printf("\n\nIntroduzca el tiempo del segundo corredor\n");
    printf("Horas: ");
    scanf("%d", &horas2);
    printf("\nMinutos: ");
    scanf("%d", &minutos2);
    printf("\nSegundos: ");
    scanf("%d", &segundos2);
    
    tiempo1 = horas1 * 60 * 60 + minutos1 * 60 + segundos1;
    tiempo2 = horas2 * 60 * 60 + minutos2 * 60 + segundos2;
    diferencia = tiempo1 - tiempo2;
    
    segundos = diferencia % 60,
    temp = diferencia / 60;
    minutos = temp % 60;
    horas = temp / 60;
    
    printf("\n\nHoras: %d, Minutos: %d, Segundos: %d\n", horas, minutos, segundos);
    
    system("pause");
    return 0;
}
