#include <stdio.h>
#include <stdlib.h>

int main(void){
    int num, a, factorial = 1;
    printf("Introduce un numero para obtener su factorial:");
    scanf("%d", &num);
    a = num;
    while (a != 1){
          factorial = factorial * a;
          a -= 1;
          }
    printf("\nEl factorial de %d es %d\n\n", num, factorial);
    
    system("pause");
    return 0;
}
