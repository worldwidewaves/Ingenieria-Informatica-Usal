/*
 * ENUNCIADO:
   La práctica consiste en generar cuatro procesos que pretenden acceder a una zona de exclusión mutua en 
   la que solo pueden estar dos de ellos a la vez. El acceso a la zona de exclusión mutua se regulará por un
   semáforo. Cada proceso calculará un número igual a la parte entera de la última cifra de su PID dividida por dos.
   A ese número le sumará uno y le llamará somnolencia. El proceso dormirá tanto como indique su somnolencia,
   esperará hasta entrar en la sección crítica, dormirá dentro tanto como indique su somnolencia y,
   vuelta a empezar. Se puede usar la función sleep, aunque no system, para dormir. Cuando se pulse CTRL+C, todos
   los procesos acabarán y el semáforo será borrado del Sistema Operativo. 
  
   Salida por pantalla: para comprobar el correcto comportamiento del programa,
   la salida por pantalla será como sigue. Al principio, el primer proceso limpiará la pantalla con la función:
   system("clear"); 
   
   Cuando un proceso entre en la sección crítica escribirá la última cifra de su PID en la línea de la pantalla 
   cuyo número es igual a ella. Cuando vaya a salir de la sección crítica borrará (escribirá un espacio encima) 
   en dicha línea. Así se podrá observar a simple vista que no hay más de dos procesos a la vez en la sección
   crítica. Para poner el cursor en la línea 7, columna 3, por ejemplo, se puede usar la función:
   system("tput cup 7 3"); 
  
   Observación: si usáis printf para escribir en la pantalla debéis saber que esta función tiene un búfer
   intermedio que hace que lo que se escriba no aparezca inmediatamente en pantalla. El búfer se vacía en tres 
   circunstancias:
   
   - Se recibe un retorno del carro (\n).
   - Se llena y no queda más remedio que volcarlo.
   - Se ejecuta la función fflush(stdout);.
   
   Tenedlo en consideración. Podéis encontrar en /usuarios/profes/gyermo/SESION6/critica el ejecutable de
   esta práctica.
**/

// * Bibliotecas
#include <stdio.h>    // printf()...
#include <stdlib.h>   // exit()...
#include <signal.h>   // sigaction()...
#include <unistd.h>   // system(), fork(),...
#include <sys/sem.h>  // semctl(), semop()...
#include <sys/wait.h> // wait()

// * Varibles Globales
int semaforo;
pid_t pid[3];

// * Prototipos de Funciones
void newsigint(int signal);
void MEZ_algorithm(int semaforo);

// * Main
int main(int argc, char *argv[]){
    int info;
    struct sigaction new, old;
    sigset_t mask;

    // Creación de 1 semáforo visible para procesos padre e hijos
    if((semaforo = semget(IPC_PRIVATE, 1, IPC_CREAT | 0600)) == -1){
        perror("Error en creación de semáforo");
        exit(1);
    }
    
    // Número de procesos en SC a la vez: 2 
    // --> Dar valor 2 a semáforo nº0 (el primero)
    if (semctl(semaforo, 0, SETVAL, 2) == -1){
        perror("Error en asignación de valor al semáforo");
        exit(2);
    }

    system("clear");

    // Creación procesos hijos
    switch (pid[0] = fork()){
        case -1:
            perror("Error en creación del segundo proceso");
            exit(3);

        case 0:     // Segundo Proceso
            MEZ_algorithm(semaforo);

        default:    // Primero Proceso
            switch (pid[1] = fork()){
                case -1:
                    perror("Error en creación del tercer proceso");
                    exit(4);

                case 0:     // Tercer Proceso
                    MEZ_algorithm(semaforo);

                default:    // Primer Proceso
                    switch(pid[2] = fork()){
                        case -1:
                            perror("Error en creación del cuarto proceso");
                            exit(5);

                        case 0:     // Cuarto Proceso
                            MEZ_algorithm(semaforo);

                        default:    // Primer Proceso
                            // Cambiar comportamiento de SIGINT
                            new.sa_handler = newsigint;
                            sigemptyset(&mask);
                            new.sa_mask = mask;
                            
                            if (sigaction(SIGINT, &new, &old) == -1){
                                perror("Error en cambio de comportamiento de SIGINT");
                                exit(6);
                            }
                            

                            MEZ_algorithm(semaforo);
                    }
            }
    }
}


// * Definicinones de Funciones

// * Nueva SIGINT
void newsigint(int signal){
    int i, data;

    for (i = 0; i < 3; i++){
        kill(pid[i], SIGINT);
        wait(&data); 
    }

    // Borrar semáforo
    if (semctl(semaforo, 0, IPC_RMID) == -1){
        perror("Error en borrado de semáforo");
        exit(7);
    }

    system("clear");
    exit(0);
}

// * Mutual Exclusion Zone Algorithm
void MEZ_algorithm(int semaforo){
    struct sembuf swait;
    swait.sem_num = 0;
    swait.sem_op = -1;
    swait.sem_flg = 0;
    struct sembuf ssignal;
    ssignal.sem_num = 0;
    ssignal.sem_op = 1;
    ssignal.sem_flg = 0;
    char command[20];
    int somnolencia = ((getpid() % 10) >> 1) + 1;   // Fórmula de dividir unidades por dos

    while (420){
        sleep(somnolencia);

        // Hacer WAIT
        if (semop(semaforo, &swait, 1) == -1){
            perror("Error en operación WAIT en semáforo");
            exit(8);
        }

        sprintf(command, "tput cup %d 1", getpid() % 10);
        system(command);
        printf("%d\b", getpid() % 10);
        fflush(stdout);
        sleep(somnolencia);
        printf(" \b");
        fflush(stdout);

        // Hacer SIGNAL
        if (semop(semaforo, &ssignal, 1) == -1){
            perror("Error en operación SIGNAL en semáforo");
            exit(9);
        }
    }
}