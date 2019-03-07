#include <stdlib.h>
#include <stdio.h>
#include "monticulo.h"

/* Ejercicio 1 */

void iniciaMonticulo(Monticulo *m){
    m->tamanno = 0;
}

int vacioMonticulo(Monticulo m){
    if (m.tamanno == 0)
        return 1;
    return 0;
}

void imprimirMonticulo(Monticulo m){
    int i;
    printf("\nM(%d) : ", m.tamanno);
    for (i = 0; i <= m.tamanno; i++)
        printf("(%d)-", m.elemento[i].clave);
    printf("\n");
}

int insertar(tipoElemento x, Monticulo *m){
    int i;
    if (m->tamanno == MAXIMO){
        printf("Montículo lleno\n");
        return -1;
    } else {
        m->tamanno = m->tamanno + 1;
        i = m->tamanno;
        m->elemento[i] = x;
        filtradoAscendente(m, i);
    }
    return 0;
}

int eliminarMinimo(Monticulo *m, tipoElemento *minimo){
    tipoElemento ultimo, min;
    int i, finFiltrado, hijo;
    if (vacioMonticulo(*m)){
        printf("Montículo Vacío\n");
        return -1;
    } else {
        *(minimo) = min = m->elemento[1];
        ultimo = m->elemento[m->tamanno];
        m->elemento[1] = ultimo;
        m->tamanno = m->tamanno - 1;
        i = 1;
        filtradoDescendente(m, i); 
    }
}

void decrementarClave(int pos, tipoClave cantidad, Monticulo *m){
    int i;
    m->elemento[pos].clave -= cantidad;
    i=pos;
    filtradoAscendente(m, i);
}

void incrementarClave(int pos, tipoClave cantidad, Monticulo *m){
    tipoElemento ultimo;
    int finFiltrado;
    int i, hijo;
    m->elemento[pos].clave += cantidad;
    filtradoDescendente(m, i);
}

int esMonticulo(Monticulo m){
    int i = 1;
    while (2*i <= m.tamanno){
        if ((m.elemento[i].clave > m.elemento[2*i].clave) || ((m.elemento[i].clave > m.elemento[2*i+1].clave) && (2*i+1) <= m.tamanno))
            return 0;
        i++;
    }
    return 1;
}

/* Funciones auxiliares que conviene implementar: las dos estrategias de filtrado en las 
   que se basan todos los algoritmos que manejan montículos */

void filtradoAscendente(Monticulo *m, int i){
    tipoElemento x = (m->elemento[i]);
    while (m->elemento[i/2].clave > x.clave && (i > 1)){
        m->elemento[i] = m->elemento[i/2];
        i = i/2;
    }
    m->elemento[i] = x;
}

void filtradoDescendente(Monticulo *m, int i){
    int hijo, finFiltrado = 0;
    tipoElemento ultimo = m->elemento[i];
    while ((2*i <= m->tamanno) && (!(finFiltrado))){
        hijo = 2*i;
        if (hijo != m->tamanno)
            if (m->elemento[hijo + 1].clave < m->elemento[hijo].clave)
                hijo++;
        if (m->elemento[hijo].clave < ultimo.clave){
            m->elemento[i] = m->elemento[hijo];
            i = hijo;
        } else
            finFiltrado = 1;
    }
}

/* Operación crearMonticulo la utilizaremos en ejercicio 2 y en tema de grafos */ 

void crearMonticulo(Monticulo *m){
    int i, n;
    n = m->tamanno;
    for (i = n/2; i >= 1; i--)
        filtradoDescendente(m, i);
}

void heapsort(Monticulo *m){
    int i;
    Monticulo o;
    iniciaMonticulo(&o);
    for (i = 1; i <= m->tamanno; i++)
        insertar(m->elemento[i], &o);
    for (i = 1; i <= m->tamanno; i++)
        eliminarMinimo(&o, &m->elemento[i]);
}

void heapSort0(Monticulo *m){
    int i, j;
    int n;

    tipoElemento min;
    n = m->tamanno;
    j = n;
    for (i = 1; i <= n; i++){
        if (!vacioMonticulo(*m)){
            eliminarMinimo(m, &min);
            m->elemento[j].clave = min.clave;
            j--;
        }
    }

    m->tamanno = n;
}

void heapSort1(int *vector, int N){
    Monticulo m;
    tipoElemento x;
    int i;
    iniciaMonticulo(&m);
    for (i = 0; i < N; i++){
        x.clave = vector[i];
        insertar(x, &m);
    }
    i = 0;
    while (!vacioMonticulo(m)){
        eliminarMinimo(&m, &x);
        vector[i] = x.clave;
        i++;
    }
}

void heapSort2(int *vector, int N){
    Monticulo m;
    tipoElemento x;
    int i;
    iniciaMonticulo(&m);
    for (i = 0; i < N; i++)
        m.elemento[i+1].clave = vector[i];
    m.tamanno = N;
    crearMonticulo(&m);
    i = 0;
    while (!vacioMonticulo(m)){
        eliminarMinimo(&m, &x);
        vector[i] = x.clave;
        i++;
    }
}

void heapSort3(int *vector, int N){
    Monticulo m;
    tipoElemento x;
    int i;
    iniciaMonticulo(&m);
    for (i = 0; i < N; i++)
        m.elemento[i+1].clave = vector[i];
    m.tamanno = N;
    for (i = m.tamanno/2; i > 0; i--)
        filtradoDescendente(&m, i);
    i = 0;
    while (!vacioMonticulo(m)){
        eliminarMinimo(&m, &x);
        vector[i] = x.clave;
        i++;
    }
}