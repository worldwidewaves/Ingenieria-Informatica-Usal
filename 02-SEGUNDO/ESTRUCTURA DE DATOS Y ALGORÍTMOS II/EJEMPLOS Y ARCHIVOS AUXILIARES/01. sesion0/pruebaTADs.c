/*
 * pruebaTADs.c	Ejemplo de utilización de TADs
 *
 *  Created on: 07/02/2019
 *      Author: M J Polo
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "pila.h"
#include "cola.h"
#include "lista.h"
int sintaxis(char * expresion);
int palindromo(char *expresion);
int purga(Lista *l);
int main(void)
{
// 1. Prueba eqiuilibrio de símbolos (TAD pila)
  int i;
  char expresion[50] = "{{{{((())";
	// Modificar adecuadamente la función sintaxis para que pueda
	// comprobar que una expresión aritmetica es correcta!!
	// strcpy(expresion, "[a+(b-c)*3+5]");

  if (sintaxis(expresion))
     printf("Expresion %s OK\n", expresion);
  else
       printf("Expresion %s incorrecta\n",expresion);
  strcpy(expresion, "{()}");
  if (sintaxis(expresion))
     printf("Expresion %s OK\n", expresion);
  else
       printf("Expresion %s incorrecta\n",expresion);

// 2. Prueba Palindromo (TADs pila y cola)
  strcpy(expresion, "anula la luz azul a la luna"); 
  if (palindromo(expresion))
     printf("Expresion: %s (SI es palindromo)\n", expresion);
  else
     printf("Expresion; %s (NO es palindromo)\n", expresion);

// 3. Prueba purga (TAD lista)

  Lista miLista;
  creaVacia(&miLista);
  // Insertamos 100 elementos (con valores entre 0 y 9 para que haya repetidos) 
  for (i=0;i<100;i++) 
      inserta(rand()%10,fin(&miLista),&miLista);
  //  imprime(&miLista);
  purga(&miLista);	// Eliminamos los repetidos, quedarán 10!!
  imprime(&miLista);
}

// 1. Equilibrio de símbolos utilizando TAD Pila
//    Ojo que dependiendo de la representación puede
//    quedar memoria sin liberar!!!!
//    Modificar adecuadamente la función para que no ocurra!!
int sintaxis(char * expresion)
{ Pila miPila;
  char c1,c2,finExp='\0';
  int i=0;

  pilaCreaVacia(&miPila);
  c1=expresion[i];

  while (c1!=finExp)
  { if (c1 =='{' ||c1 =='[' ||c1 =='(' )
       pilaInserta(c1,&miPila);
    else { if (pilaVacia(&miPila)) return 0;
           else { c2 = pilaSuprime(&miPila);
		switch (c2) {
			case '{': if (c1 != '}') return 0;
				  break;
			case '(':if (c1 != ')') return 0;
				  break;
                	case '[':if (c1 != ']') return 0;
				  break;
                	default:break;
	  	}
	}
   }
   i++;
   c1=expresion[i];
  }
  if (!pilaVacia(&miPila))  return 0;
  else return 1;
}
// 2. Función que determina si una frase se lee igual 
//    de derecha a izquierda que de izquierda a derecha,
//    utilizando TAD Pila y TAD Cola

int palindromo(char *expresion)
{ 

}
// 3. Eliminación de elementos repetidos en una lista utilizando TAD Lista

int purga(Lista *l)
{

}
