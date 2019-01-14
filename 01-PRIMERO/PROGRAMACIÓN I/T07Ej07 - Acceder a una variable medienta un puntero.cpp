#include <stdio.h>
#include <stdlib.h>

int main (void){
    int var_a;
    int *p_var_a;
    
    //1
    printf("Introduce un valor (entero) para la variable: ");
    scanf("%d", &var_a);
    printf("\n");
    
    //2
    printf("La variable vale: %d", var_a);
    printf("\n\n");
    
    //3
    p_var_a = &var_a;
    
    //4
    printf("La variable vale: %d", *p_var_a);
    printf("\n\n");
    
    
    
    
    //5
    printf("Introduce un valor (entero) para la variable: ");
    scanf("%d", p_var_a);
    printf("\n");
    
    //6
    printf("La variable vale: %d", var_a);
    printf("\n\n");
    
    //7
    printf("La variable vale: %d", *p_var_a);
    printf("\n\n");
    
    
    
    
    //8
    printf("La direccion de var_a es: %p", &var_a);
    printf("\n\n");
    
    //9
    printf("La direccion de var_a es: %p", p_var_a);
    printf("\n\n");
    
    //10
    printf("La direccion de p_var_a vale: %p", p_var_a);
    printf("\n\n");
    
    //11
    printf("El contendo de p_var_a vale: %d", *p_var_a);
    printf("\n\n");
    
    
    system("pause");
    return 0;
}
