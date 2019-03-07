#include "genArbol.h"

Arbol genArbol(char *exPostfija){
    Arbol a;
    Pila p;
    int i;
    char simbolo;
    pilaCreaVacia(&p);
    simbolo = exPostfija[0];
    i = 0;

    while (simbolo != '\0'){
        switch (simbolo){
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                a = creaNodo(simbolo);
                pilaInserta(a, &p);
                break;
            case '+':
            case '-':
            case '*':
                a = creaNodo(simbolo);
                a->der = pilaSuprime(&p);
                a->izq = pilaSuprime(&p);
                pilaInserta(a, &p);
                break;
        }
        i = i + 1;
        simbolo = exPostfija[i];
    }
    return pilaSuprime(&p);
}

int evaluar(Arbol a){
    if (a == NULL) return -99999;
    if (a->info == '+')
        return (evaluar(a->izq) + evaluar(a->der));
    if (a->info == '-')
        return (evaluar(a->izq) - evaluar(a->der));
    if (a->info == '*')
        return (evaluar(a->izq) * evaluar(a->der));

    return (a->info - 48);  // 48 = Código ASCII del 0
}