#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 8:
Descomponer un número entero en sus cifras*/

int main(void)
{
    int num, unidades, decenas, centenas, millar, suma, temp;
    printf("Introduce un numero de hasta 4 cifras\n");
    scanf("%d", &num);
    
    unidades = num % 10;
    temp = num / 10;
    decenas = temp % 10;
    temp = temp / 10;
    centenas = temp % 10;
    millar = temp / 10;
    
    printf("El numero ordenado:\n");
    printf("%d\n", millar);
    printf("%d\n", centenas);
    printf("%d\n", decenas);
    printf("%d\n\n", unidades);
    
    printf("El numero invertido:\n");
    printf("%d\n", unidades);
    printf("%d\n", decenas);
    printf("%d\n", centenas);
    printf("%d\n\n", millar);
    
    suma = num + (unidades * 1000 + decenas * 100 + centenas * 10 + millar);
    printf("La suma del numero con su invertido es %d\n\n\n", suma);
    
    system("pause");
    return 0;
}
