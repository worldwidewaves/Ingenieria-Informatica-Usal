#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 100

int main(void){
    char frase[TAM];
    char c;
    int i, longitud,nc=0;
    
    printf("Introduce una frase: ");
    gets(frase);
    printf("\n\n");
    
    printf("Introduce un caracter: ");
    scanf("%c", &c);
    printf("\n\n");
    
    longitud=strlen(frase);
    printf("La longitud es: %d\n", longitud);
    
    for(i=0;i<=longitud;i++){
      if(*(frase+i)==c){
        nc++;
        printf("El caracter se encuentra en las posiciones: %d\n",i+1);
    }}
    printf("Las veces que se encuentra el caracter son: %d\n", nc);
    
    system("pause");
    return 0;
}
    
