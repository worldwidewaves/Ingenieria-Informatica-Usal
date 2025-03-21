#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "arbol.h"

int main(void){
 /* Arbol varArbol;

// Creación arbol ejemplo de las transparencias de recorridos
  varArbol = creaNodo('A');
  varArbol->izq = creaNodo('B');
  varArbol->der = creaNodo('C');
  varArbol->izq->izq = creaNodo('D');
  varArbol->izq->der = creaNodo('E');
  varArbol->der->izq = creaNodo('F');
  varArbol->der->der = creaNodo('G');

// Aplicación de recorridos al arbol ejemplo

  printf("Recorrido en PRE_ORDEN: ");
  preOrden(varArbol);
  printf("\n");

  printf("Recorrido en ORDEN: ");
  enOrden(varArbol);
  printf("\n");

  printf("Recorrido en POST_ORDEN: ");
  postOrden(varArbol);
  printf("\n");

  printf("Recorrido en AMPLITUD: ");
  amplitud(varArbol);
  printf("\n");

// Comenzar a implementar y probar las funciones del ejercicio 2 ... y segunda parte del ejercicio 3
  printf("ALTURA: ");
  printf("%d", altura(varArbol));
  printf("\n");

  printf("NUM NODOS: ");
  printf("%d", numNodos(varArbol));
  printf("\n");

  printf("NUM NODOS HOJA: ");
  printf("%d", numNodosHoja(varArbol));
  printf("\n");

  printf("NUM NODOS INTERNOS: ");
  printf("%d", numNodosInternos(varArbol));
  printf("\n");

  printf("Sustituir E por la X con SUSTITUYE: ");
  printf("\n");
  printf("- Número de cambios: %d", sustituye(varArbol, 'E', 'X'));
  printf("\n");
  printf("- Recorrido en ORDEN: ");
  enOrden(varArbol);
  printf("\n");

  printf("NUM NODOS HIJOS ÚNICOS: ");
  printf("%d", numHijoUnico(varArbol));
  printf("\n");

  printf("Árbol tras ANULA: ");
  varArbol = anula(varArbol);
  enOrden(varArbol);
  printf("\n");
*/
// Poner "typedef int tipoInfo" en arbol.h para usar int's en vez de char's
  
  Arbol varArbolNum;

  varArbolNum = creaNodo(18);
  varArbolNum->izq = creaNodo(12);
  varArbolNum->der = creaNodo(32);
  varArbolNum->izq->izq = creaNodo(13);
  varArbolNum->izq->der = creaNodo(45);
  varArbolNum->der->izq = creaNodo(2);
  varArbolNum->der->der = creaNodo(31);

  printf("MÁX: %d\n", buscarMax(varArbolNum)->info);
  printf("MIN: %d\n", buscarMin(varArbolNum)->info);
  
  return 1;
}

