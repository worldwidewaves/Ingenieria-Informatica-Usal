#ifndef __LISTA_H
#define __LISTA_H

#ifndef __TIPO_ELEMENTO_LISTA
#define __TIPO_ELEMENTO_LISTA
typedef int tipoElementoLista;
#endif

#ifndef __TIPO_CELDA_LISTA
#define __TIPO_CELDA_LISTA
typedef struct tipoCeldaLista {
	tipoElementoLista elemento;
	struct tipoCeldaLista * sig;
	} tipoCeldaLista;
#endif
	
	
typedef struct {
	tipoCeldaLista * raiz , *ultimo;
	} Lista;

typedef tipoCeldaLista *tipoPosicion;

int creaVacia(Lista *l);
tipoPosicion primero(Lista *l);
tipoPosicion siguiente(tipoPosicion p, Lista *l);
tipoPosicion anterior(tipoPosicion p, Lista *l);
tipoPosicion fin(Lista *l);

int inserta(tipoElementoLista x, tipoPosicion p, Lista *l);
int suprime (tipoPosicion p, Lista *l);
int anula(Lista *l);

int vacia(Lista *l);
tipoPosicion localiza (tipoElementoLista x, Lista *l);
tipoElementoLista recupera(tipoPosicion p, Lista *l);
void imprime(Lista *l);
int destruye(Lista *l);

#endif 
