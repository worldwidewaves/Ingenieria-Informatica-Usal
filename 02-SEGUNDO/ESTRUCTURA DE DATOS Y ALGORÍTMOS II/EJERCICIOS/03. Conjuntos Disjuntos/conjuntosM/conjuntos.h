#ifndef __CONJUNTOS_H
#define __CONJUNTOS_H

#define MAXIMO 16
typedef int particion[MAXIMO];
typedef int tipoConjunto;
typedef int tipoElemento;

// Funciones a implementar
void crea(particion C);
tipoElemento buscar(tipoElemento x, particion C);
void unir(tipoElemento x, tipoElemento y, particion C);

// Funciones proporcionadas
void verParticion(particion C);
void verClaseEquivalencia(tipoElemento x, particion P);

#endif
