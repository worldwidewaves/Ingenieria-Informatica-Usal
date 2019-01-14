#include <stdio.h>
#include <stdlib.h>

int main(void){
    int contador = 1, acumulador = 0, num = 1, num2 = 1, num3, num4, bandera = 1;
    
    //1
    printf("Bucle controlados por contador. Muestra los 20 primeros numeros enteros separados por tabulador:\n");
    while (contador <= 20){
          printf("%d\t", contador);
          contador += 1;
          }
    printf("\n\n");
    
    //2
    printf("Bucle controlados por acumulador. Muestra los primeros numeros enteros cuya suma es menor o igual que 100:\n");
    while (acumulador <= 100){
          printf("%d\t", num);
          num += 1;
          acumulador += num;
          }
    printf("\n\n");
    
    //3
    printf("Bucle controlado por un valor centinela. Presenta por pantalla los numeros introducidos por teclado hasta que pulses -1:\n");
    while (num2 != -1){
          scanf("%d", &num2);
          }
    printf("\n\n");
    
    //4
    printf("Bucle controlado por bandera. Muestra por pantalla los numeros introducidos de manera ordenada, creciente. Hasta que pulses un numero desordenado:\n");
    scanf("%d", &num3);
    while (bandera){
          num4 = num3;
          scanf("%d", &num3);
          if (num3 < num4){
                   bandera = 0;
                   }
          }
          
    printf("\n\n");
    system("pause");
    return 0;
}
    
