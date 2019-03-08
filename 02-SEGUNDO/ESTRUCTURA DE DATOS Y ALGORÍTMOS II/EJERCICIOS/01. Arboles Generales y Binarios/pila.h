#include "arbol.h"

#ifndef __PILA_H
#define __PILA_H

#ifndef __TIPO_ELEMENTO_PILA
#define __TIPO_ELEMENTO_PILA
typedef Arbol tipoElementoPila;
#endif

#ifndef __TIPO_CELDA_PILA
#define __TIPO_CELDA_PILA
typedef struct tipoCeldaPila {
	tipoElementoPila elemento;
	struct tipoCeldaPila * sig;
	} tipoCeldaPila;
#endif
	
typedef tipoCeldaPila * Pila;

int pilaCreaVacia(Pila *p);


// En vacía no sería necesario el paso por referencia
// pero por mantener la misma interfaz con la implementación
// de matrices
int pilaVacia(Pila *p);

int pilaInserta(tipoElementoPila elemento, Pila *p);

tipoElementoPila pilaSuprime(Pila *p);


#endif
