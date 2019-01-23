#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "pila.h"


int pilaCreaVacia(Pila *p){
	if (p == NULL) {
		return -1;
	}
	else {
		*p = NULL;
		return 0;
	}
}


int pilaVacia(Pila *p){
	if (p == NULL) {
		return -1;
	}
	else {
		if (*p == NULL) {
			return 1;
		}
		else {
			return 0;
		}
	}
}


int pilaInserta(tipoElemento elemento, Pila *p){
	tipoCelda *temp = (tipoCelda *)malloc(sizeof(tipoCelda));

	if (p == NULL || temp == NULL) {
		return -1;
	}
	else {
		temp->elemento = elemento;
		temp->sig = *p;
		*p = temp;
		return 0;
	}  
}


tipoElemento pilaSuprime(Pila *p){
	tipoElemento elemento;
	tipoCelda *aBorrar;

	if (p == NULL || *p == NULL) {
		return -1;
	}
	else {
		elemento = (*p)->elemento;
		aBorrar = (*p);
		*p = aBorrar->sig;
		free(aBorrar);
		return elemento;
	}
}