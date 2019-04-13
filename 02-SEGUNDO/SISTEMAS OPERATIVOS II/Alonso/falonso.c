//* Includes
#include "falonso.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/sem.h>
#include <string.h>
#include <pwd.h>
#include <signal.h>
#include <sys/shm.h>

//* Defines
#define NUM_SEMAFOROS 5
#define TAM_MEMORIA_COMPARTIDA 1600    // En bytes
#define PERMISOS 0600
#define MIN_NUM_COCHES 1
#define MAX_NUM_COCHES 22
#define MAX_V 99
#define MIN_V 20
#define DIF_MAX_V 10
#define DIF_MIN_V -10
#define VEL_VARIABLE
//#define SOLARIS

//* Variables Globales
int semaforo, memoriaCompartida, buzon;
int *cuenta;

//* Prototipos
void cerrar_y_salir(void);

//* Variable operaciones semáforo
struct sembuf semaWait[1];
struct sembuf semaSignal[1];

//* Union Semun
#ifdef SOLARIS
union semun {
    int val;
    struct semid_ds *buf;
    ushort_t *array;
};
#endif

//* Función Main
int main(int argc, char *argv[]){

    // Variables para función write
	char buffer[0x1000];
	size_t length;

    // Variables union semun
    #ifdef SOLARIS
    union semun cero;
    cero.val = 0;
    union semun uno;
    uno.val = 1;
    #endif

	// Comprobar número de coches y velocidad
    int numCoches;
	int velocidadCoche;

    if (argc == 3){
        numCoches = atoi(argv[1]);
	    velocidadCoche = atoi(argv[2]);
        if (numCoches < MIN_NUM_COCHES || numCoches > MAX_NUM_COCHES){
            length = snprintf(buffer, sizeof(buffer), "Número incorrecto de coches (Min = %d/Máx = %d) [%s].\n", MIN_NUM_COCHES, MAX_NUM_COCHES, argv[1]);
			write(STDOUT_FILENO, buffer, length);
			return 1;
        }
		if (velocidadCoche != 0 && velocidadCoche != 1){
			length = snprintf(buffer, sizeof(buffer), "Error al escribir el modo (normal = 1/veloz = 0) [%s].\n", argv[2]);
			write(STDOUT_FILENO, buffer, length);
			return 1;
		}
	} else {
		length = snprintf(buffer, sizeof(buffer), "Número incorrecto de argumentos [%d].\n", argc);
		write(STDOUT_FILENO, buffer, length);
		return 1;
	}

    // Crear semáforo, memoria compartida y buzón
    if ((semaforo = semget(IPC_PRIVATE, NUM_SEMAFOROS, IPC_CREAT | PERMISOS)) == -1){
        perror("Error en creación del semáforo");
        cerrar_y_salir();
        return 1;
    }
    if ((memoriaCompartida = shmget(IPC_PRIVATE, TAM_MEMORIA_COMPARTIDA, IPC_CREAT | PERMISOS)) == -1){
        perror("Error en creación de la memoria compartida");
        cerrar_y_salir();
        return 1;
    }
    if ((buzon = msgget(IPC_PRIVATE, IPC_CREAT | PERMISOS)) == -1){
        perror("Error en creación de los buzones");
        cerrar_y_salir();
        return 1;
    }

    // Cambiar el funcionamiento de SIGINT
    sigset_t mascara;
    if ((sigemptyset(&mascara)) == -1){
        perror("Error al crear la máscara");
        cerrar_y_salir();
        return 1;
    }
	struct sigaction accionNueva, accionVieja;
    accionNueva.sa_handler = cerrar_y_salir;
	accionNueva.sa_mask = mascara;
    accionNueva.sa_flags = 0;
    if (sigaction(SIGINT, &accionNueva, &accionVieja) == -1){
		perror("Error al cambiar el comportamiento de SIGINT");
        cerrar_y_salir();
        return 1;
	}

    // Crear puntero a memoria compartida
    char *memComp = shmat(memoriaCompartida, 0, 0);
    cuenta = shmat(memoriaCompartida, 0, 0);
    cuenta[301] = 0;

    // Iniciar semáforo
    #ifdef SOLARIS
    if ((semctl(semaforo, 1, SETVAL, cero)) == -1){
        perror("Error al iniciar el semáforo a 0");
        cerrar_y_salir();
        return 1;
    }
    #endif
    #ifndef SOLARIS
    if ((semctl(semaforo, 1, SETVAL, 0)) == -1){
        perror("Error al iniciar el semáforo a 0");
        cerrar_y_salir();
        return 1;
    }
    #endif

    // Inicio cirtuito
    if (inicio_falonso(1, semaforo, memComp) == -1){
        perror("Error en llamada a inicio_falonso");
        cerrar_y_salir();
        return 1;
    }

    // Variables coche
    int posCoche;
    int carrilCoche;
    int colorCoche;
    int posComprobar;
    int posComprobarCambio;
    int yaCambiadoFlg = 0;
    int atascadoFlg = 0;
    int pasadoMetaFlg = 0;
    int velAleatoria;
    int nuevaVelAleatoria;

    // Definir wait
    semaWait[0].sem_num = 1;
    semaWait[0].sem_op = -1;
    semaWait[0].sem_flg = 0;

    // Definir signal
    semaSignal[0].sem_num = 1;
    semaSignal[0].sem_op = 1;
    semaSignal[0].sem_flg = 0;

    // Empezar bucle coches
    int i;
    for (i = 0; i < numCoches; i++){

        // Asignar posición al coche
        if (i % 2 == 0){
            carrilCoche = CARRIL_DERECHO;
            posCoche = i;
        } else {
            carrilCoche = CARRIL_IZQUIERDO;
            posCoche = i;
        }
        
        // Asignar color al coche
        do {
            colorCoche = (rand() % (BLANCO - NEGRO + 1)) + NEGRO;
        } while (colorCoche == AZUL);

        // Empezar a tener procesos hijos
        switch(fork()){
            case -1:
                perror("Error al crear al hijo");
                cerrar_y_salir();
                exit(1);
            case 0:
                // Iniciar coche
                if((inicio_coche(&carrilCoche, &posCoche, colorCoche)) == -1){
                    perror("Error al iniciar un coche");
                    cerrar_y_salir();
                    exit(1);
                }

                // Asignar velocidad constante
                velAleatoria = rand() % (MAX_V - MIN_V + 1) + MIN_V;

                for (;;){

                    #ifdef VEL_VARIABLE
                    // Asignar velocidad variable
                    do {
                        nuevaVelAleatoria = velAleatoria + (rand() % (DIF_MAX_V - DIF_MIN_V + 1) + DIF_MIN_V);
                    } while (nuevaVelAleatoria < MIN_V || nuevaVelAleatoria > MAX_V);
                    velAleatoria = nuevaVelAleatoria;
                    #endif

                    // Hace una pausa proporcional a su velocidad
                    if (velocidadCoche == 0){
                        if((velocidad(100, carrilCoche, posCoche)) == -1){
                            perror("Error al iniciar a velocidad 100");
                            cerrar_y_salir();
                            exit(1);
                        }
                    } else {
                        if((velocidad(velAleatoria, carrilCoche, posCoche)) == -1){
                            perror("Error al iniciar a velocidad aleatoria");
                            cerrar_y_salir();
                            exit(1);
                        }
                    }

                    // Wait
                    if ((semop(semaforo, semaWait, 1)) == -1){
                        perror("Error al hacer wait");
                        cerrar_y_salir();
                        exit(1);
                    }

                    //* Comprobar que no hay nadie delante
                    // Asignar posComprobar
                    if ((carrilCoche == CARRIL_DERECHO) && (posCoche + 1 == 137))
                        posComprobar = 0;
                    else if (carrilCoche == CARRIL_DERECHO)
                        posComprobar = posCoche + 1;
                    else if ((carrilCoche == CARRIL_IZQUIERDO) && (posCoche + 137 + 1 == 274))
                        posComprobar = 137;
                    else if (carrilCoche == CARRIL_IZQUIERDO)
                        posComprobar = posCoche + 137 + 1;

                    // Comprobarla si hay alguien en posComprobar
                    if (memComp[posComprobar] != ' '){
                        //* Si hay alguien, comprobar si hay alguien en el otro carril para cambiarse
                        // Desde el carril derecho
                        if (carrilCoche == CARRIL_DERECHO){
                            if (posCoche >= 0 && posCoche <= 13)
                                posComprobarCambio = posCoche + 137;
                            else if (posCoche >= 14 && posCoche <= 28)
                                posComprobarCambio = posCoche + 137 + 1;
                            else if (posCoche >= 29 && posCoche <= 60)
                                posComprobarCambio = posCoche + 137;
                            else if (posCoche >= 61 && posCoche <= 62)
                                posComprobarCambio = posCoche + 137 - 1;
                            else if (posCoche >= 63 && posCoche <= 65)
                                posComprobarCambio = posCoche + 137 - 2;
                            else if (posCoche >= 66 && posCoche <= 67)
                                posComprobarCambio = posCoche + 137 - 3;
                            else if (posCoche == 68)
                                posComprobarCambio = posCoche + 137 + 4;
                            else if (posCoche >= 69 && posCoche <= 129)
                                posComprobarCambio = posCoche + 137 - 5;
                            else if (posCoche == 130)
                                posComprobarCambio = posCoche + 137 - 3;
                            else if (posCoche >= 131 && posCoche <= 134)
                                posComprobarCambio = posCoche + 137 - 2;
                            else if (posCoche >= 135 && posCoche <= 136)
                                posComprobarCambio = posCoche + 137 - 1;
                        }
                        // Desde el carril izquierdo
                        else if (carrilCoche == CARRIL_IZQUIERDO){
                            if (posCoche >= 0 && posCoche <= 15)
                                posComprobarCambio = posCoche;
                            else if (posCoche >= 16 && posCoche <= 28)
                                posComprobarCambio = posCoche - 1;
                            else if (posCoche >= 29 && posCoche <= 58)
                                posComprobarCambio = posCoche;
                            else if (posCoche >= 59 && posCoche <= 60)
                                posComprobarCambio = posCoche + 1;
                            else if (posCoche >= 61 && posCoche <= 62)
                                posComprobarCambio = posCoche + 2;
                            else if (posCoche >= 63 && posCoche <= 64)
                                posComprobarCambio = posCoche + 4;
                            else if (posCoche >= 65 && posCoche <= 125)
                                posComprobarCambio = posCoche + 5;
                            else if (posCoche == 126)
                                posComprobarCambio = posCoche + 4;
                            else if (posCoche >= 127 && posCoche <= 128)
                                posComprobarCambio = posCoche + 3;
                            else if (posCoche >= 129 && posCoche <= 133)
                                posComprobarCambio = posCoche + 2;
                            else if (posCoche >= 134 && posCoche <= 136)
                                posComprobarCambio = 136;
                        }
                        // Si no hay nadie en el otro carril, Y NO ESTÁ CERCA DE UN SEMÁFORO EN ROJO, se cambia a ese
                        if (memComp[posComprobarCambio] == ' ' && !yaCambiadoFlg
                            && !(((carrilCoche == CARRIL_IZQUIERDO && posComprobarCambio == 106) || (carrilCoche == CARRIL_DERECHO && posComprobarCambio == 99 + 137)) && memComp[274] != VERDE)     // Semáforo horizontal
                            && !(((carrilCoche == CARRIL_IZQUIERDO && posComprobarCambio == 21) || (carrilCoche == CARRIL_DERECHO && posComprobarCambio == 23 + 137)) && memComp[275] != VERDE)){    // Semáforo vertical
                            cambio_carril(&carrilCoche, &posCoche, colorCoche);
                            yaCambiadoFlg = 1;
                        }
                    }

                    // Si no hay nadie delante, comprobar semáforos para avanzar
                    else if (!(((carrilCoche == CARRIL_DERECHO && posCoche == 105) || (carrilCoche == CARRIL_IZQUIERDO && posCoche == 98)) && memComp[274] != VERDE)    // Semáforo horizontal
                          && !(((carrilCoche == CARRIL_DERECHO && posCoche == 20) || (carrilCoche == CARRIL_IZQUIERDO && posCoche == 22)) && memComp[275] != VERDE)){   // Semáforo vertical
                        avance_coche(&carrilCoche, &posCoche, colorCoche);
                        yaCambiadoFlg = 0;
                    } else {
                        atascadoFlg = 1;
                    }

                    // Aumentar cuenta si pasa por la línea de meta
                    if (!pasadoMetaFlg && (((carrilCoche == CARRIL_DERECHO) && (posCoche == 133)) || ((carrilCoche == CARRIL_IZQUIERDO) && (posCoche == 131)))){
                        cuenta[301]++;
                        pasadoMetaFlg = 1;
                    } else if (posCoche >= 0 && posCoche <= 15){
                        pasadoMetaFlg = 0;
                    }

                    // Signal
                    if ((semop(semaforo, semaSignal, 1)) == -1){
                        perror("Error al hacer signal");
                        cerrar_y_salir();
                        exit(1);
                    }

                    // No consumir tanta CPU si está atascado
                    if (atascadoFlg){
                        atascadoFlg = 0;
                        if ((pausa()) == -1){
                            perror("Error al hacer pausa");
                            cerrar_y_salir();
                            exit(1);
                        }
                    }
                }
        }
    }

    // Pistoletazo de salida
    if((usleep(1000000)) == -1){
        perror("Error al hacer usleep");
        cerrar_y_salir();
        exit(1);
    }
    if((luz_semAforo(1, ROJO)) == -1){
        perror("Error al cambiar el color del semáforo 1 a rojo");
        cerrar_y_salir();
        exit(1);
    }
    if((usleep(1000000)) == -1){
        perror("Error al hacer usleep");
        cerrar_y_salir();
        exit(1);
    }
    if((luz_semAforo(1, AMARILLO)) == -1){
        perror("Error al cambiar el color del semáforo 1 a amarillo");
        cerrar_y_salir();
        exit(1);
    }
    if((usleep(1000000)) == -1){
        perror("Error al hacer usleep");
        cerrar_y_salir();
        exit(1);
    }
    if((luz_semAforo(1, VERDE)) == -1){
        perror("Error al cambiar el color del semáforo 1 a verde");
        cerrar_y_salir();
        exit(1);
    }
    if((luz_semAforo(0, ROJO)) == -1){
        perror("Error al cambiar el color del semáforo 0 a rojo");
        cerrar_y_salir();
        exit(1);
    }
    #ifdef SOLARIS
    if ((semctl(semaforo, 1, SETVAL, uno)) == -1){
        perror("Error al iniciar el semáforo a 1");
        cerrar_y_salir();
        return 1;
    }
    #endif
    #ifndef SOLARIS
    if ((semctl(semaforo, 1, SETVAL, 1)) == -1){
        perror("Error al iniciar el semáforo a 1");
        cerrar_y_salir();
        return 1;
    }
    #endif
    
    // Bucle semaforístico
    for (;;){

        // Wait
        if ((semop(semaforo, semaWait, 1)) == -1){
            perror("Error al hacer wait");
            cerrar_y_salir();
            return 1;
        }
        if ((luz_semAforo(1, VERDE)) == -1){
            perror("Error al cambiar el color del semáforo");
            cerrar_y_salir();
            return 1;
        }
        // Signal
        if ((semop(semaforo, semaSignal, 1)) == -1){
            perror("Error al hacer signal");
            cerrar_y_salir();
            return 1;
        }
        if ((sleep(1)) == -1){
            perror("Error al hacer sleep");
            cerrar_y_salir();
            return 1;
        }

        // Wait
        if ((semop(semaforo, semaWait, 1)) == -1){
            perror("Error al hacer wait");
            cerrar_y_salir();
            return 1;
        }
        if ((luz_semAforo(1, ROJO)) == -1){
            perror("Error al cambiar el color del semáforo");
            cerrar_y_salir();
            return 1;
        }
        if ((luz_semAforo(0, AMARILLO)) == -1){
            perror("Error al cambiar el color del semáforo");
            cerrar_y_salir();
            return 1;
        }
        // Signal
        if ((semop(semaforo, semaSignal, 1)) == -1){
            perror("Error al hacer signal");
            cerrar_y_salir();
            return 1;
        }
        if ((sleep(1)) == -1){
            perror("Error al hacer sleep");
            cerrar_y_salir();
            return 1;
        }

        // Wait
        if ((semop(semaforo, semaWait, 1)) == -1){
            perror("Error al hacer wait");
            cerrar_y_salir();
            return 1;
        }
        if ((luz_semAforo(0, VERDE)) == -1){
            perror("Error al cambiar el color del semáforo");
            cerrar_y_salir();
            return 1;
        }
        // Signal
        if ((semop(semaforo, semaSignal, 1)) == -1){
            perror("Error al hacer signal");
            cerrar_y_salir();
            return 1;
        }
        if ((sleep(1)) == -1){
            perror("Error al hacer sleep");
            cerrar_y_salir();
            return 1;
        }

        // Wait
        if ((semop(semaforo, semaWait, 1)) == -1){
            perror("Error al hacer wait");
            cerrar_y_salir();
            return 1;
        }
        if ((luz_semAforo(0, ROJO)) == -1){
            perror("Error al cambiar el color del semáforo");
            cerrar_y_salir();
            return 1;
        }
        if ((luz_semAforo(1, AMARILLO)) == -1){
            perror("Error al cambiar el color del semáforo");
            cerrar_y_salir();
            return 1;
        }
        // Signal
        if ((semop(semaforo, semaSignal, 1)) == -1){
            perror("Error al hacer signal");
            cerrar_y_salir();
            return 1;
        }
        if ((sleep(1)) == -1){
            perror("Error al hacer sleep");
            cerrar_y_salir();
            return 1;
        }
    }

    return 0;
}

//* Función de cierre (SIGINT)
void cerrar_y_salir(){
    
    // Finalizar circuito
    if ((fin_falonso(&cuenta[301])) == -1){
        perror("Error al finalizar falonso");
    }

    // Borrar semáforos, memoria compartida y buzón
    if (semctl(semaforo, 0, IPC_RMID) == -1){
        perror("Error en borrado de semáforo");
    }
    if (msgctl(buzon, IPC_RMID, 0) == -1){
        perror("Error en borrado del buzón");
    }
    if (shmctl(memoriaCompartida, IPC_RMID, 0) == -1){
        perror("Error en borrado de memoria compartida");
    }

    // Cerrar todos los programas
	kill(0, SIGTERM);
}