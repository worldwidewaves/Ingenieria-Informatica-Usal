#include "dispersion.h"
#include <stdio.h>
#include <string.h>
#include <sys/types.h>

int main(){
    int i, numRegDes;
    FILE *f;
    tipoAlumno reg;
    char dni[10];

    numRegDes = creaHash("alumnos.dat", "alumnos.hash");
    printf("%d Registros DESBORDADOS\n\n", numRegDes);

    i = leeHash("alumnos.hash");

    f = fopen("alumnos.hash", "rb");

    // Existe en el area PRIMA
    strcpy(dni, "7389298"); 
    i = buscaReg(f, &reg, dni);
    if (i < 0)
        printf("No existe alumno con dni %s\n", dni);
    else { 
        printf("Registro encontrado en el CUBO %d", i);
  	    printf("\t %s %s %s %s %s\n", reg.dni, reg.nombre, reg.ape1, reg.ape2, reg.provincia);
    }

    // Existe en el area De DESBORDE
    strcpy(dni, "33333333"); 
    i = buscaReg(f, &reg, dni);
    if (i < 0) 
        printf("No existe alumno con dni %s\n", dni);
    else { 
        printf("Registro encontrado en el CUBO %d", i);
  	    printf("\t %s %s %s %s %s\n", reg.dni, reg.nombre, reg.ape1, reg.ape2, reg.provincia);
    }

    // No existe
    strcpy(dni, "123456789"); 
    i = buscaReg(f, &reg, dni);
    if (i < 0) 
        printf("\nNo existe alumno con dni %s\n", dni);
    else { 
        printf("Registro encontrado en el CUBO %d", i);
  	    printf("\t %s %s %s %s %s\n", reg.dni, reg.nombre, reg.ape1, reg.ape2, reg.provincia);
    }

    fclose(f);

    printf("AAAAAAAAAAAAA: %d", modificarReg("alumnos.hash", "33333333", "ayy lmao"));
    leeHash("alumnos.hash");
}