#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//1
int suma(int n){
    int i;
    int suma = 0;
    for(i=0;i<=n;i++){
      suma +=i;
    }
    return suma;
}

//2
int pares(int a, int b){
    int i;
    int suma = 0;
    if (a%2!=0){
      a++;
    }
    if (a>b){
      for(i=a;i<=b;i=i+2){
        suma+=i;
      }
    }
    else{
      for(i=a;i<=b;i=i+2){
        suma+=i;
      }
    }
    return suma;
}

//3
int serie(int x, int n){
    int suma = 0;
    for(;n>=0;n--){
      suma+=pow(x,n);
    }
    return suma;
}

int main(void){
    int n, x;
    
    int a;
    int b, c;
    int d, e;
    
    printf("Introduce un valor para el Apartado 1: ");
    scanf("%d", &a);
    printf("\n");
    printf("El resultado del Apartado 1 es: %d", suma(a));
    printf("\n\n");
    
    printf("Introduce un primer valor para el Apartado 2: ");
    scanf("%d", &b);
    printf("\n");
    printf("Introduce un segundo valor para el Apartado 2: ");
    scanf("%d", &c);
    printf("\n");
    printf("El resultado Apartado 2 es: %d", pares(b,c));
    printf("\n\n");
    
    printf("Introduce un primer valor para el Apartado 3: ");
    scanf("%d", &d);
    printf("\n");
    printf("Introduce un segundo valor para el Apartado 3: ");
    scanf("%d", &e);
    printf("\n");
    printf("El resultado Apartado 3 es: %d", serie(d,e));
    printf("\n\n");
    
    system("pause");
    return 0;
}
