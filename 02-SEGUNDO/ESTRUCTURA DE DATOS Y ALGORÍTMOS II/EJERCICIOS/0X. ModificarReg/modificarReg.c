// Daniel García González
// 70924776K

#include "dispersion.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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