#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "conjuntos.h"

tipoCelda celdas[MAXIMO];

/// Incluir aqui las funciones que implementan las tres operaciones básicas 
/// en la representación de CONJUNTOS DISJUNTOS mediante LISTAS
/// ......................................................................
void crea(particion C){
    for (int i = 0; i < MAXIMO; i++){
        celdas[i].elemento = i;
        celdas[i].sig = NULL;
        C[i].primero = &celdas[i];
        C[i].ultimo = &celdas[i];
    }
}

tipoElemento buscar(tipoElemento x, particion C){
    int i;
    tipoCelda *aux;
    for (i = 0; i < MAXIMO; i++) {
        aux = C[i].primero;
        while (aux != NULL){
            if (x == aux->elemento)
                return C[i].primero->elemento;
            aux = aux->sig;
        }
    }
    return 666;
}

void unir(tipoElemento x, tipoElemento y, particion C){
    int i;
    tipoCelda *aux;
    // No se unen si no son representantes (para que tarde tiempo constante)
    if (C[x].primero != NULL && C[y].primero != NULL){
        aux = C[y].primero;
        while (aux != NULL){
            C[x].ultimo->sig = aux;
            C[x].ultimo = C[x].ultimo->sig;
            C[y].primero = C[y].primero->sig;
            aux = C[y].primero;
        }
    }
}

//
// Funciones auxiliares para ver contenido de Partición y Clase de Equivalencia
//
void verParticion(particion C){
    int i;
    tipoCelda *aux;
    for (i = 0; i < MAXIMO; i++) {
        aux = C[i].primero;
        if (aux != NULL) 
            printf("\nClase equivalencia representante %d: ", i);
        while (aux != NULL){
            printf("%d ", aux->elemento);
            aux = aux->sig;
        }
    }
    printf("\n\n");
}

void verClaseEquivalencia(tipoElemento x,particion C){
    int representante;
    tipoCelda *aux;
  
    representante = buscar(x,C);
    printf("\n\nClase de Equivalencia de %d cuyo representante es %d: ", x, representante);
    aux = C[representante].primero;
    while (aux){
        printf(" %d ", aux->elemento);
        aux = aux->sig;
    }
    printf("\n\n");
}