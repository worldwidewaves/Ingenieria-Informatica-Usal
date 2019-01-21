#include <stdio.h>
#include <stdlib.h>
#include <locale.h>



/*--------------Definición de Tipos----------------*/
typedef int tipoInfo;
typedef tipoInfo *tipoInfoRef;

typedef struct tipoNodo{
	tipoInfo info;
	struct tipoNodo *sig;
} tipoNodo;

typedef tipoNodo *tipoNodoRef;
typedef tipoNodo *listaEnlazada;

typedef listaEnlazada *listaEnlazadaRef;



/*----------------------------------------Declaraciones------------------------------------------------*/
//La raiz se mete por valor porque no se va a cambiar
int estaVacia (listaEnlazada);				
int numeroNodos (listaEnlazada);				
tipoNodoRef bucarValorLista (listaEnlazada, tipoInfoRef, int *);

int eliminarNodo (listaEnlazadaRef, tipoNodoRef);
int eliminarNodoNum (listaEnlazadaRef, int);
int nuevoNodoPrimero (listaEnlazadaRef, tipoInfoRef);




/*----------------------------------Función Main-------------------------------------*/
int main (void){
	setlocale (LC_ALL, "spanish");



	return 0;
}



/*-----------------------------Función estaVacia--------------------------------*/
int estaVacia (listaEnlazada raiz){
	return (raiz == NULL);
}



/*-----------------------------Función numeroNodos--------------------------------*/
int numeroNodos (listaEnlazada raiz){
	int numero;
	tipoNodoRef indice;
	
	numero = 0;
	indice = raiz;
	
	while (indice->sig != NULL){
		indice = indice->sig;
		numero++;
	}
	
	return numero;
	//Funciona con listas vacias
}



/*-----------------------------Función eliminarNodo--------------------------------*/
int eliminarNodo (listaEnlazadaRef refRaiz, tipoNodoRef pos){
	tipoNodoRef anterior;
	
	
	//lista está vacía
	if (estaVacia(*refRaiz)){
		return -1;
	}
	
	//pos es NULL
	else if (pos == NULL){
		return -2;
	}
	
	//pos es el la raíz
	else if (pos == *refRaiz){
		*refRaiz = (*refRaiz)->sig;
		free(pos);
		return 0;
	}
	
	//se recorre la lista
	else{
		anterior = *refRaiz;

		while (anterior->sig != NULL && anterior != pos){
			anterior = anterior->sig;
		}
		
		//se ha encontrado pos
		if (anterior->sig != NULL){
			anterior->sig = pos->sig;
			free(pos);
			return 0;
		}
		
		//si pos no pertenece a la lista
		else
			return -3;
	}
}


/*-----------------------------Función eliminarNodoNum--------------------------------*/
int eliminarNodoNum (listaEnlazadaRef raizRef, int num){
	int cont;
	tipoNodoRef ant, indice;
	
	//lista esta vacia
	if (estaVacia(*raizRef))
		return -1;
	
	//valor 0 o negativo
	else if	(num <= 0)
		return -2;
		
	//valor 1 (primero)
	else if (num == 1){
		indice = *raizRef;
		(*raizRef) = (*raizRef)->sig;
		free(indice);
		return 0;
	}
	
	//se recorre la lista
	else{
		cont = 1;
		ant = *raizRef;
		while (ant->sig != NULL && cont != num-1){
			ant = ant->sig;
			cont++;
		}
		
		//se ha llegado a num
		if (ant->sig != NULL){
			indice = ant->sig;
			ant->sig = indice->sig;
			free(indice);
			return 0;
		}
		
		//ant->sig = NULL, se ha acabado la lista, num > nª elementos de la lista
		else
			return -3;
	}
}


/*-----------------------------Función nuevoNodoPrimero--------------------------------*/
int nuevoNodoPrimero (listaEnlazadaRef raizRef, tipoInfoRef infoRef){
	tipoNodoRef nuevo;
	
	if ((nuevo = (tipoNodoRef) malloc(sizeof(tipoNodo))) != NULL){
		nuevo->info = *infoRef;
		nuevo->sig = *raizRef;
		*raizRef = nuevo;
	}
	
	else
		return -1;
}



/*-----------------------------Función buscarValorLista--------------------------------*/
tipoNodoRef bucarValorLista (listaEnlazada raiz, tipoInfoRef infoRef, int *numRef){
	tipoNodoRef indice;
	
	indice = raiz;
	*numRef = 1;
	
	while (indice->sig != NULL && indice->info != *infoRef){
		indice = indice->sig;
		(*numRef)++;
	}
	
	if (indice->sig != NULL){
		*numRef = indice->info;
		return indice;
	}
	
	else{
		*numRef = 0;
		return NULL;
	}
}

