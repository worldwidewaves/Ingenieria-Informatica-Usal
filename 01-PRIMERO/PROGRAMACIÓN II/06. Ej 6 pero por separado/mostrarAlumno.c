#include "cabecera.h"
/*-------------------------------Función mostrarAlumno----------------------------------*/
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
			
	//------------> Dirección
	printf("Dirección: %s", alumno.direccion);
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
