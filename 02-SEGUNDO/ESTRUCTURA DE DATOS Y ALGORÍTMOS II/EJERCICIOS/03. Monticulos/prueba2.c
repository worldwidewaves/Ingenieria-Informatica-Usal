#include <stdlib.h>
#include <stdio.h>
#include "monticulo.h"
int main(void){
  Monticulo m;
  int i, n = 10;
  tipoElemento elemento;

  iniciaMonticulo(&m);

  m.tamanno= n;
  for (i = 1; i <= n; i++)
    m.elemento[i].clave = rand()%100;

  printf("Inicialmente (NO montículo):\n");
  imprimirMonticulo(m);

  printf("\nTras heapsort (SÍ montículo):\n");
  heapsort(&m);
  imprimirMonticulo(m);

  return 0;
}




