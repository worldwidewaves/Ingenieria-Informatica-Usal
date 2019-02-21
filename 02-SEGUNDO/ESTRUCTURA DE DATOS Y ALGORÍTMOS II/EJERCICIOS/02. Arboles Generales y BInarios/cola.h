#include "arbol.h"

#ifndef __COLA_H
#define __COLA_H

#ifndef __TIPO_ELEMENTO_COLA
#define __TIPO_ELEMENTO_COLA
typedef tipoNodo* tipoElementoCola;
#endif

#ifndef __TIPO_CELDA_COLA
#define __TIPO_CELDA_COLA
typedef struct tipoCeldaCola {
	tipoElementoCola elemento;
	struct tipoCeldaCola * sig;
	} tipoCeldaCola;
#endif

typedef struct {
        tipoCeldaCola *frente, *fondo;
} Cola;

int colaCreaVacia(Cola *c);

// En vacía no sería necesario el paso por referencia
// pero por mantener la misma interfaz con la implementación
// de matrices
int colaVacia(Cola *c);

int colaInserta(tipoElementoCola elemento, Cola *c);

tipoElementoCola colaSuprime(Cola *c);

#endif