#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 9:
El menor de tres números mediante if's anidados y usando solo tres variables*/

int main(void)
{
    int n1, n2, n3;
    
    printf("Introduce el primer numero:");
    scanf("%d", &n1);
    printf("\nIntroduce el segundo numero:");
    scanf("%d", &n2);
    printf("\nIntroduce el tercer numero:");
    scanf("%d", &n3);
    
    //Comprobar si uno de los números es igual a otro y dar la correspondiente respuesta.
    if (n1 == n2 ||  n1 == n3 || n2 == n3)
    {
          printf("\nNo son numeros distintos\n");
          }
            else if (n1 < n2) //Si ninguno es igual a otro los compara y da la correspondiente respuesta.
            {
               if (n1 < n3)
               {
                      printf("\nEl numero menor es el primero, %d.\n", n1);
                      }
                      else if (n3 < n1)
                      {
                              printf("\nEl numero menor es el tercero, %d.\n", n3);                  
                              }
               }
               else if (n2 < n3)
               {
                       printf("\nEl numero menor es el segundo, %d.\n", n2);
                       }
               else
               {
                       printf("\nEl numero menor es el tercero, %d.\n", n3);
                       }
    system("pause");
    return 0;
}
