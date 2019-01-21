#ifndef __CABECERA_H
#define __CABECERA_H

#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

#define N 50
#define M 30
#define O 10


/*--------------Structs----------------*/
struct tipoFecha{
	int dia;
	int mes;
	int anio;
};

struct tipoAlumnos{
	char nombre[N];
	int curso;
	struct tipoFecha fecha;
	char direccion[M];
	float notas[O];
};



/*------------Declaraciones-------------*/
struct tipoAlumnos leerAlumno (void);
void leerAlumnoRef (struct tipoAlumnos *);
void mostrarAlumno (struct tipoAlumnos);
void mostrarAlumnoRef (struct tipoAlumnos *);




#endif
