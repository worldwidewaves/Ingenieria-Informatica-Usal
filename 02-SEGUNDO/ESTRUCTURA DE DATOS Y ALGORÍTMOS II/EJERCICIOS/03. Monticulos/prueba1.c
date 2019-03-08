#include <stdlib.h>
#include <stdio.h>
#include "monticulo.h"
int main(void){
  Monticulo m;
  tipoElemento elemento;
  int i, n = 10;

  iniciaMonticulo(&m);
  elemento.clave = 12;
  elemento.informacion = 0;

  i = insertar(elemento, &m);

  while (m.tamanno < n){ 
    elemento.clave = rand()%100;
    i = insertar(elemento, &m);
  }
  imprimirMonticulo(m);

  decrementarClave(6, 10, &m);
  imprimirMonticulo(m);

  return 0;
}




