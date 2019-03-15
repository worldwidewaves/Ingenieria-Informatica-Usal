#include <stdlib.h>
#include <stdio.h>
#include "arbol.h"
#include "cola.h"

//
// Reserva de memoria para un nuevo nodo de árbol binario
//
Arbol creaNodo(tipoInfo info){
  tipoNodo * nuevo;

  //   nuevo =(tipoNodo *)calloc(1, sizeof(tipoNodo));
  if ((nuevo = (tipoNodo *)malloc(sizeof(tipoNodo))) == NULL)
	  return NULL;
  else { 
    nuevo->info = info;
	  nuevo->izq = NULL;
	  nuevo->der = NULL;
	  return nuevo;
  }
}

//
// Recorrido en amplitud o por niveles: necesita una cola de punteros a nodos de árbol binario!!!
//
void amplitud(Arbol raiz){
  Cola c;
  tipoNodo *nodo;
  colaCreaVacia(&c);
  nodo = raiz;
  if (raiz != NULL)
    colaInserta(nodo, &c);
  while (!colaVacia(&c)){
    nodo = (Arbol) colaSuprime(&c);
    printf(" %c ", nodo->info);
    if (nodo->izq != NULL)
      colaInserta(nodo->izq, &c);
    if (nodo->der != NULL)
      colaInserta(nodo->der, &c);
  }
}

// 
// Recorridos en profundidad "recursivos"
//
void preOrden(Arbol raiz){ 
  if (raiz != NULL){
    printf("%d ",raiz->info);
    preOrden(raiz->izq);
    preOrden(raiz->der);
  }
}

void enOrden(Arbol raiz){ 
  if (raiz != NULL){
    enOrden(raiz->izq);
    printf("%c ",raiz->info);
    enOrden(raiz->der);
  }
}

void postOrden(Arbol raiz){ 
  if (raiz != NULL){
    postOrden(raiz->izq);
    postOrden(raiz->der);
    printf("%c ",raiz->info);
  }
}

int altura(Arbol raiz){
  int hizq, hder;

  if (raiz != NULL){
    hizq = altura(raiz->izq);
    hder = altura(raiz->der);
    if (hizq > hder)
      return hizq + 1;
    else
      return hder + 1;
  }
  else
    return -1;
}

int numNodos(Arbol raiz){
  if (raiz != NULL)
    return 1 + numNodos(raiz->izq) + numNodos(raiz->der);
  else
    return 0;
}

Arbol anula(Arbol raiz){
  if (raiz != NULL){
    anula(raiz->izq);
    anula(raiz->der);
    free(raiz);
  }
  else
    return NULL;
}

int numNodosHoja(Arbol raiz){
  if (raiz != NULL){
    if ((raiz->izq == NULL) && (raiz->der == NULL))
      return 1;
    else
      return 0 + numNodosHoja(raiz->izq) + numNodosHoja(raiz->der);
  }
  else 
    return 0;
}

int numNodosInternos(Arbol raiz){
  return numNodos(raiz) - numNodosHoja(raiz);
}

int sustituye(Arbol raiz, tipoInfo viejo, tipoInfo nuevo){
  int contador = 0;

  if (raiz != NULL){
    if (raiz->info == viejo)
      raiz->info = nuevo;
      contador++;
    sustituye(raiz->izq, viejo, nuevo);
    sustituye(raiz->der, viejo, nuevo);
  }

  return contador;
}

int numHijoUnico(Arbol raiz){
  int contador = 0;

  if (raiz != NULL){
    if ((raiz->izq == NULL && raiz->der != NULL) || (raiz->izq != NULL && raiz->der == NULL))
      contador++;

    contador = contador + numHijoUnico(raiz->izq);
    contador = contador + numHijoUnico(raiz->der);
  }

  return contador;
}

Arbol buscarMax(Arbol raiz){
  Arbol max, maxI, maxD;
  if (raiz != NULL){
      max = raiz;
      maxI = buscarMax(raiz->izq);
      maxD = buscarMax(raiz->der);
      if (maxI != NULL && maxI->info > max->info)
        max = maxI;
      if (maxD != NULL && maxD->info > max->info)
        max = maxD;

      return max;
  }
  return NULL;
}


Arbol buscarMin(Arbol raiz){
  Arbol min, minI, minD;
  if (raiz != NULL){
      min = raiz;
      minI = buscarMin(raiz->izq);
      minD = buscarMin(raiz->der);
      if (minI != NULL && minI->info < min->info)
        min = minI;
      if (minD != NULL && minD->info < min->info)
        min = minD;

      return min;
  }
  return NULL;
}
