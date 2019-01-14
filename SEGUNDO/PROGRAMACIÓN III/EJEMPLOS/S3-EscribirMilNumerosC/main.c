/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */

/* 
 * File:   main.c
 * Author: bruegel
 *
 * Created on 25 May 2018, 20:25
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    printf("Escribir mil numeros en disco\n");
    FILE * fp = fopen("/Users/bruegel/Desktop/milnumeros.txt", "w");
    int i;
    for(i=1; i < 1001; i++) {
        fprintf(fp,"%d\n", i);
    }
    fclose(fp);
    return (EXIT_SUCCESS);
}

