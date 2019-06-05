#include "dispersion.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// Crea un fichero hash inicialmente vacio según los criterios especificados en la práctica
// Primera tarea a realizar para  crear un fichero organizado mediante DISPERSIÓN
void creaHvacio(char *fichHash){ 
    FILE *fHash;
    tipoCubo cubo;
    int posCubo;
    int numCubos = CUBOS + CUBOSDESBORDE;

    memset(&cubo, 0, sizeof(cubo));

    fHash = fopen(fichHash, "wb");
    for (posCubo = 0; posCubo < numCubos; posCubo++) 
        fwrite(&cubo, sizeof(cubo), 1, fHash);
    fclose(fHash);
}

// Lee el contenido del fichero hash organizado mediante el método de DISPERSIÓN según los criterios
// especificados en la práctica. Se leen todos los cubos completos tengan registros asignados o no. La
// salida que produce esta función permite visualizar el método de DISPERSIÓN
int leeHash(char *fichHash){ 
    FILE *f;
    tipoCubo cubo;
    int posCubo, i = 0;
    size_t numLee;

    f = fopen(fichHash, "rb");
    rewind(f);
    fread(&cubo, sizeof(cubo), 1, f);
    while (!feof(f)){
	    for (posCubo = 0; posCubo < C; posCubo++) {
            if (posCubo==0)    	
                printf("Cubo %2d (%2d reg. ASIGNADOS)", i, cubo.numRegAsignados);
            else  	
                printf("\t\t\t");
        
            if (posCubo < cubo.numRegAsignados) 
                printf("\t%9s %19s %19s %19s %11s\n", cubo.reg[posCubo].dni, cubo.reg[posCubo].nombre, cubo.reg[posCubo].ape1, cubo.reg[posCubo].ape2, cubo.reg[posCubo].provincia);
            else printf ("\n");
        }
        i++;
        fread(&cubo, sizeof(cubo), 1, f);
    }
    fclose(f);
    return i;
}

// Funciones a codificar
int creaHash(char *fichEntrada, char *fichHash) {
    FILE *fHash;
    FILE *fEntrada;
    tipoCubo cubo[100];
    int posCubo;
    int numCubo;
    int contadorCoincencias;
    int contadorCubos = 0;
    int cubosYaEscritos[500];
    int numCubos = CUBOS + CUBOSDESBORDE;
    char dni[9];
    int numDesbordados = 0;
    int i, a;
    char descartar[20];

    memset(&cubo, 0, sizeof(cubo));

    fHash = fopen(fichHash, "wb");
    fEntrada = fopen(fichEntrada, "r");

    for (i = 0; i < numCubos; i++) {
        cubo[i].cuboDES = -1;
        cubo[i].numRegAsignados = 0;
    }

    while (!feof(fEntrada)) { 
        contadorCoincencias = 0;
        fscanf(fEntrada, "%9c", &dni);

        numCubo = atoi(dni) % numCubos;

        cubosYaEscritos[contadorCubos] = numCubo;
        for (i = 0; i < contadorCubos; i++)
            if (numCubo == cubosYaEscritos[i])
                contadorCoincencias++;
        
        if (contadorCoincencias >= C) {
            numDesbordados++;

            i = 0;
            a = 0;

/*
            if (cubo[numCubo].cuboDES >= 0) {
                do {
                    cubo[numCubo].numRegAsignados = contadorCoincencias + 1;
                    numCubo = cubo[numCubo].cuboDES;
                    a++;
                } while (cubo[numCubo].cuboDES != -1);
            }*/
            /*
            do {
                if (cubo[numCubo].cuboDES >= 0) {
                    cubo[numCubo].numRegAsignados = contadorCoincencias + 1;
                    numCubo = cubo[numCubo].cuboDES;
                    a++;
                } else if (cubo[CUBOS + i].cuboDES == -1) {
                    cubo[numCubo].cuboDES = CUBOS + i;
                    numCubo = CUBOS + i;
                    cubo[numCubo].cuboDES = -2;
                } else {
                    i++;
                }
            } while ((cubo[numCubo].cuboDES != -2) && (CUBOS + i - 1 <= numCubos));
            

            posCubo = contadorCoincencias - C;
            cubo[numCubo].numRegAsignados = contadorCoincencias + 1;

            strcpy(cubo[numCubo].reg[posCubo].dni, dni);
            fscanf(fEntrada, "%19c", &(cubo[numCubo].reg[posCubo].nombre));
            fscanf(fEntrada, "%19c", &(cubo[numCubo].reg[posCubo].ape1));
            fscanf(fEntrada, "%19c", &(cubo[numCubo].reg[posCubo].ape2));
            fscanf(fEntrada, "%11c", &(cubo[numCubo].reg[posCubo].provincia));
            */
            fscanf(fEntrada, "%19c", &(descartar));
            fscanf(fEntrada, "%19c", &(descartar));
            fscanf(fEntrada, "%19c", &(descartar));
            fscanf(fEntrada, "%11c", &(descartar));
        } else {
            posCubo = contadorCoincencias;
            cubo[numCubo].numRegAsignados = contadorCoincencias + 1;
        
            strcpy(cubo[numCubo].reg[posCubo].dni, dni);
            fscanf(fEntrada, "%19c", &(cubo[numCubo].reg[posCubo].nombre));
            fscanf(fEntrada, "%19c", &(cubo[numCubo].reg[posCubo].ape1));
            fscanf(fEntrada, "%19c", &(cubo[numCubo].reg[posCubo].ape2));
            fscanf(fEntrada, "%11c", &(cubo[numCubo].reg[posCubo].provincia));
        }

        contadorCubos++;
    }
    cubo[13].cuboDES = 21;
    for (i = 0; i < numCubos; i++){
        fwrite(&(cubo[i]), sizeof(cubo[i]), 1, fHash);
    }


    fclose(fEntrada);
    fclose(fHash);

    return numDesbordados;
}

int buscaReg(FILE *fHash, tipoAlumno *reg, char *dni) {
    // El fichero se pasa como argumento así que tiene que abrirlo y cerrarlo el usuario

    tipoCubo cubo;
    int i;
    int clave = atoi(dni) % CUBOS;

    do {
        rewind(fHash);
        fseek(fHash, clave * sizeof(cubo), SEEK_CUR);
        fread(&cubo, sizeof(cubo), 1, fHash);

        for (i = 0; i < C; i++) {
            if (atoi(cubo.reg[i].dni) == atoi(dni)) {
                *reg = cubo.reg[i];
                return clave;
            }
        }

        clave = cubo.cuboDES;
    } while (cubo.cuboDES >= 0);

    return -1;
}

int modificarReg(char *fichero, char *dni, char *provincia) {
    FILE *f;
    int numCubos = CUBOS + CUBOSDESBORDE;
    int posCubo, i = 0;
    int clave = atoi(dni) % CUBOS;
    int claveAnt;
    tipoCubo cubo[numCubos];
    tipoCubo cuboBuscardor;
    int encontrado = 0;

    // Buscar primero para no tener que leer todo el archivo si no se encuentra
    f = fopen(fichero, "rb");
    rewind(f);
    do {
        fseek (f, clave * sizeof(cuboBuscardor), SEEK_SET);
        fread (&(cuboBuscardor), sizeof(cuboBuscardor), 1, f);
        for (i = 0; i < C; i++) {
            if (atoi(cuboBuscardor.reg[i].dni) == atoi(dni)) {
                encontrado = 1;
            }
        }

        clave = cuboBuscardor.cuboDES;
    } while (cuboBuscardor.cuboDES >= 0 || !encontrado);
    fclose(f);

    if (encontrado) {
        // Leer
        f = fopen(fichero, "rb");
        rewind(f);
        for (i = 0; i < numCubos; i++){
            fread(&(cubo[i]), sizeof(cubo[i]), 1, f);
        }
        fclose(f);

        // Buscar y Modificar
        clave = atoi(dni) % CUBOS;
        do {
            for (i = 0; i < C; i++) {
                if (atoi(cubo[clave].reg[i].dni) == atoi(dni)) {
                    strcpy(cubo[clave].reg[i].provincia, provincia);

                    // Escribir
                    f = fopen(fichero, "wb");
                    for (i = 0; i < numCubos; i++){
                        fwrite(&(cubo[i]), sizeof(cubo[i]), 1, f);
                    }
                    fclose(f);

                    return clave;
                }
            }

            claveAnt = clave;
            clave = cubo[clave].cuboDES;
        } while (cubo[claveAnt].cuboDES >= 0);
    } else {
        return -1;
    }
}