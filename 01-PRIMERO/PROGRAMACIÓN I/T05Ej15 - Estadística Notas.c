#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
	float nota, sobresalientes = 0, notables = 0, aprobados = 0, suspensos = 0, deficientes = 0, total = 0, contador = 0, media;
	char media_letra[20] = "";
	
	printf("Introduce una nota (>0 para salir): ");
	scanf("%f", &nota);
	while (0 <= nota){
		if (nota <= 10){
			if (nota >= 9){
				sobresalientes = sobresalientes + 1;
				}
				else if (7 <= nota && nota < 9){
					notables = notables + 1;
					}
					else if (5 <= nota && nota < 7){
						aprobados = aprobados + 1;
						}
						else if (2 <= nota && nota < 5){
							suspensos = suspensos + 1;
							}
							else if (nota < 2){
								deficientes = deficientes + 1;
								}
			total = total + nota;
			contador = contador +1;	
			}
		scanf("%f", &nota);
		}
		
	media = total / contador;
			if (media >= 9){
				strcpy(media_letra, "Sobresaliente");
			}
				else if (7 <= media && media < 9){
					strcpy(media_letra, "Notable");
					}
					else if (5 <= media && media < 7){
						strcpy(media_letra, "Aprobado");
						}
						else if (2 <= media && media < 5){
							strcpy(media_letra, "Suspenso");
							}
							else if (media < 2){
								strcpy(media_letra, "Muy deficiente");
								}	

	printf("\nTotal alumnos presentados al examen: %g", contador);
	printf("\nNumero de sobresalientes: %g (%g%%)", sobresalientes, (sobresalientes / contador) * 100);
	printf("\nNumero de notables: %g (%g%%)", notables, (notables / contador) * 100);
	printf("\nNumero de aprobados: %g (%g%%)", aprobados, (aprobados / contador) * 100);
	printf("\nNumero de suspensos: %g (%g%%)", suspensos, (suspensos / contador) * 100);
	printf("\nNumero de muy deficientes: %g (%g%%)", deficientes, (deficientes / contador) * 100);
	printf("\nNota media: %f (%s)\n", media, media_letra);
	
	system("pause");
	return 0;
}
