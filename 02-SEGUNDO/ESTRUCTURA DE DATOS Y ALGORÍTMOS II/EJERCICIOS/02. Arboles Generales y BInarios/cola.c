#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "cola.h"


int colaCreaVacia(Cola *c){    
	if (c == NULL) {
		return -1;
	}
	else {
		c->frente = c->fondo = NULL;
	}
	return 0;
}


int colaVacia(Cola *c){
	if (c == NULL) {
		return -1;
	}
	else {
		if (c->frente == NULL) {
			return 1;
		}
		else {
			return 0;
		}
	}
}


int colaInserta(tipoElementoCola elemento, Cola *c){    
	tipoCeldaCola *temp = (tipoCeldaCola *)malloc(sizeof(tipoCeldaCola));

	if (c == NULL || temp == NULL) {
		return -1;
	}
	else if (c->frente == NULL) {
		c->frente = c->fondo = temp;
	}
	else {
		c->fondo->sig = temp;
	}
	temp->elemento = elemento;
	temp->sig = NULL;
	c->fondo = temp;
	return 0;
}


tipoElementoCola colaSuprime(Cola *c){
	tipoElementoCola elemento;
	tipoCeldaCola *aBorrar;
	if (c == NULL || c->frente == NULL) {
		return NULL;
	}
	else {
		elemento = c->frente->elemento;
		aBorrar = c->frente;
		c->frente = aBorrar->sig;
		free(aBorrar);
		return elemento;
	}
}