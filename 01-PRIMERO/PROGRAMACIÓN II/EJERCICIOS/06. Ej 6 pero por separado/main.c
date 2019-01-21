#include "cabecera.h"
/*---------------------------Función Main--------------------------------*/
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

