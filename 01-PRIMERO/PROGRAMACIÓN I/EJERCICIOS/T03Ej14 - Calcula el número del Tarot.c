#include <stdio.h>
#include <stdlib.h>

/*Ejercicio 14:
El número del Tarot*/

int main(void)
{
    long fecha, dd, mm, aa, d1, d2, m1, m2, a1, a2, a3, a4, tarot, t1, t2, t3, t4, T1, T2, temp;
    printf("Introduce tu fecha de nacimiento en el formato AAAAMMDD:\n");
    scanf("%ld", &fecha);
    
    a1 = fecha / 10000000;
    temp = fecha % 1000000;
    a2 = temp / 1000000;
    temp = temp % 1000000;
    a3 = temp / 100000;
    temp = temp % 100000;
    a4 = temp / 10000;
    temp = temp % 10000;
    m1 = temp / 1000;
    temp = temp % 1000;
    m2 = temp / 100;
    temp = temp % 100;
    d1 = temp / 10;
    temp = temp % 10;
    d2 = temp;
    
    dd = d1 * 10 + d2;
    mm = m1 * 10 + m2;
    aa = a1 * 1000 + a2 * 100 + a3 * 10 + a4;
    
    tarot = dd + mm + aa;
    t1 = tarot / 1000;
    temp = tarot % 1000;
    t2 = temp / 100;
    temp = temp % 100;
    t3 = temp / 10;
    temp = temp % 10;
    t4 = temp;
    
    tarot = t1 + t2 + t3 + t4;
    T1 = tarot / 10;
    temp = tarot % 10;
    T2 = temp;
    tarot = T1 + T2;
    printf("Tu numero del Tarot es: %d\n\n", tarot);
    
    system("pause");
    return 0;
}
