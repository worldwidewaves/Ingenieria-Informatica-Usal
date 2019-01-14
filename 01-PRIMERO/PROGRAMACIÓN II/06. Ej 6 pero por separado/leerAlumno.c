#include "cabecera.h"
/*-----------------------------Función leerAlumno--------------------------------*/
struct tipoAlumnos leerAlumno (void){
	int i;
	struct tipoAlumnos alumno;
	
	//----------> Nombre
	printf("Introduce el nombre, máximo [%d] caracteres: ", N);
	fflush(stdin);
	gets(alumno.nombre);
	
	//----------> Curso
	do {
		printf("Introduce el curso [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno.curso);
	}
	while (alumno.curso <= 0);
	
	//-----------> Dia
	do {
		printf("Introduce el día de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno.fecha.dia);
	}
	while (alumno.fecha.dia <= 0);
	
	//-----------> Mes
	do {
		printf("Introduce el mes de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno.fecha.mes);
	}
	while (alumno.fecha.mes <= 0);
	
	//-----------> Año
	do {
		printf("Introduce el año de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno.fecha.anio);
	}
	while (alumno.fecha.anio <= 0);
	
	//------------> Dirección
	printf("Introduce la dirección, máximo [%d] caracteres: ", M);
	fflush(stdin);
	gets(alumno.direccion);
	
	//-------------> Notas
	printf("Introduce [%d] notas parciales:\n", O);
	for (i=0; i<O; i++){
		do {
			fflush(stdin);
			printf("Introduzca la nota número [%d]: ", i+1);
			scanf("%f", &alumno.notas[i]);
		}
		while (alumno.notas[i] < 0);
	}
	printf("\n");
	
	return alumno;
}
