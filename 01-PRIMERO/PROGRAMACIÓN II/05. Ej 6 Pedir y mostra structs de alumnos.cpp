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



/*---------------------------Funci�n Main--------------------------------*/
int main (void){
	struct tipoAlumnos alum2;
	setlocale (LC_ALL, "spanish");

	//---------> Cargar
	struct tipoAlumnos alum1 = leerAlumno();	//Por valor de retorno
	leerAlumnoRef(&alum2);						//Por referencia
	
	//---------> Presentar
	mostrarAlumno (alum1);						//Por valor
	mostrarAlumnoRef (&alum2);					//Por referencia
	

	return 0;
}



/*-----------------------------Funci�n leerAlumno--------------------------------*/
struct tipoAlumnos leerAlumno (void){
	int i;
	struct tipoAlumnos alumno;
	
	//----------> Nombre
	printf("Introduce el nombre, m�ximo [%d] caracteres: ", N);
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
		printf("Introduce el d�a de nacimiento [Valor Entero Positivo]: ");
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
	
	//-----------> A�o
	do {
		printf("Introduce el a�o de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno.fecha.anio);
	}
	while (alumno.fecha.anio <= 0);
	
	//------------> Direcci�n
	printf("Introduce la direcci�n, m�ximo [%d] caracteres: ", M);
	fflush(stdin);
	gets(alumno.direccion);
	
	//-------------> Notas
	printf("Introduce [%d] notas parciales:\n", O);
	for (i=0; i<O; i++){
		do {
			fflush(stdin);
			printf("Introduzca la nota n�mero [%d]: ", i+1);
			scanf("%f", &alumno.notas[i]);
		}
		while (alumno.notas[i] < 0);
	}
	printf("\n");
	
	return alumno;
}



/*---------------------------Funci�n leerAlumnoRef----------------------------------*/
void leerAlumnoRef (struct tipoAlumnos *alumno){
	int i;
	
	//----------> Nombre
	printf("Introduce el nombre, m�ximo [%d] caracteres: ", N);
	fflush(stdin);
	gets(alumno->nombre);
	
	//----------> Curso
	do {
		printf("Introduce el curso [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno->curso);
	}
	while (alumno->curso <= 0);
	
	//-----------> Dia
	do {
		printf("Introduce el d�a de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno->fecha.dia);
	}
	while (alumno->fecha.dia <= 0);
	
	//-----------> Mes
	do {
		printf("Introduce el mes de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno->fecha.mes);
	}
	while (alumno->fecha.mes <= 0);
	
	//-----------> A�o
	do {
		printf("Introduce el a�o de nacimiento [Valor Entero Positivo]: ");
		fflush(stdin);
		scanf("%d", &alumno->fecha.anio);
	}
	while (alumno->fecha.anio <= 0);
	
	//------------> Direcci�n
	printf("Introduce la direcci�n, m�ximo [%d] caracteres: ", M);
	fflush(stdin);
	gets(alumno->direccion);
	
	//-------------> Notas
	printf("Introduce [%d] notas parciales:\n", O);
	for (i=0; i<O; i++){
		do {
			fflush(stdin);
			printf("Introduzca la nota n�mero [%d]: ", i+1);
			scanf("%f", &alumno->notas[i]);
		}
		while (alumno->notas[i] < 0);
	}
	printf("\n");
}



/*-------------------------------Funci�n mostrarAlumno----------------------------------*/
void mostrarAlumno (struct tipoAlumnos alumno){
	int i;
	
	//----------> Nombre
	printf("Nombre: %s", alumno.nombre);
	printf("\n");
	
	//----------> Curso
	printf("Curso: %d", alumno.curso);
	printf("\n");
	
	//-----------> Fecha
	printf("Fecha de nacimiento: %02d-%02d-%d",
			alumno.fecha.dia,
			alumno.fecha.mes,
			alumno.fecha.anio);
	printf("\n");
			
	//------------> Direcci�n
	printf("Direcci�n: %s", alumno.direccion);
	printf("\n");
	
	//-------------> Notas
	printf("Notas:");
	printf("\n");
	for (i=0; i<O; i++){
		printf("Nota [%d]: %g", i+1, alumno.notas[i]);
		printf("\n");
	}
	printf("\n");
	
}



/*-------------------------------Funci�n mostrarAlumnoRef----------------------------------*/
void mostrarAlumnoRef (struct tipoAlumnos *alumno){
	int i;
	
	//----------> Nombre
	printf("Nombre: %s", alumno->nombre);
	printf("\n");
	
	//----------> Curso
	printf("Curso: %d", alumno->curso);
	printf("\n");
	
	//-----------> Fecha
	printf("Fecha de nacimiento: %02d-%02d-%d",
			alumno->fecha.dia,
			alumno->fecha.mes,
			alumno->fecha.anio);
	printf("\n");
			
	//------------> Direcci�n
	printf("Direcci�n: %s", alumno->direccion);
	printf("\n");
	
	//-------------> Notas
	printf("Notas:");
	printf("\n");
	for (i=0; i<O; i++){
		printf("Nota [%d]: %g", i+1, alumno->notas[i]);
		printf("\n");
	}
	printf("\n");
	
}

