#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 13:
El problema de los acentos y la �*/

int main(void)
{
    printf("Sin secuencias de escape:\nM�s, Ver�n, Autom�tico,\nTambi�n, Num�rico, Qu�,\nM�nimo, D�gito, Ah�,\nPrecisi�n, C�digo, Programaci�n,\nMin�scula, N�mero, Seg�n,\nA�adir, Espa�ol, �apa, �isca");
    printf("\n\n");
    printf("Con secuencias de escape:\nM\xA0s, Ver\xA0n, Autom\xA0tico,\nTambi\x82n, Num\x82rico, Qu\x82,\nM\xA1nimo, D\xA1gito, Ah\xA1,\nPrecisi\xA2n, C\242digo, Programaci\xA2n,\nMin\xA3scula, N\xA3mero, Seg\xA3n,\nA\244adir, Espa\244ol, \245apa, \245isca\n\n");
    
    system("pause");
    return 0;
}
