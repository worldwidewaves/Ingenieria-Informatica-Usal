#include "conjuntos.h"
#include <stdio.h>

/// Incluir aqui las funciones que implementan las tres operaciones básicas 
/// en la representación de CONJUNTOS DISJUNTOS mediante ÁRBOLES
/// ......................................................................
void crea(particion C){
    for (int i = 0; i < MAXIMO; i++)
        C[i] = i;
}

tipoElemento buscar(tipoElemento x, particion C){
    if (C[x] == x)
        return C[x];
    else
        return buscar(C[x], C);
}

void unir(tipoElemento x, tipoElemento y, particion C){
    tipoElemento raizX = buscar(C[x], C);
    tipoElemento raizY = buscar(C[y], C);
    C[raizY] = raizX;
}

//
// Función auxiliar para ver contenido de Partición 
//
void verParticion(particion C){
    int i;
    printf("\n");
    for (i = 0; i < MAXIMO; i++)
        printf("|%2d", C[i]);
    printf("| contenido  vector\n");
    for (i = 0; i < MAXIMO; i++)
        printf("---");
    printf("\n");
    for (i = 0; i < MAXIMO; i++)
        printf(" %2d", i);
    printf("  índices vector\n\n");
}
