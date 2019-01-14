//	Includes
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h>
#include <signal.h>
#include <sys/mman.h>

//	Defines
#define NOMBRE_PROGRAMA			"charlie"
#define NOMBRE_PROCESO_CHARLIE 	"./charlie"		//  "./charlie" de normal, "charlie" en encina
#define NOMBRE_PROCESO_MALO 	"malo"	
#define NOMBRE_PROCESO_BOSLEY 	"bosley"
#define NOMBRE_PROCESO_SABRINA 	"sabrina"
#define NOMBRE_PROCESO_JILL 	"jill"
#define NOMBRE_PROCESO_KELLY 	"kelly"
#define	REENCARNACIONES_MALO	20
#define DISPAROS_POR_ANGEL		3
#define DESCANSO_MIN_ANGELES	6
#define DESCANSO_MAX_ANGELES	12
#define DESCANSO_MIN_MALO		1
#define DESCANSO_MAX_MALO		3

//	Declaraciones de funciones
int funcCharlie(const int argc, const char *argv[]);
int funcMalo(const int argc, const char *argv[]);
int funcBosley(const int argc, const char *argv[]);
int funcSabrina(const int argc, const char *argv[]);
int funcJill(const int argc, const char *argv[]);
int funcKelly(const int argc, const char *argv[]);
void morirMalo(void);
void esperar(void);
void morirTodos(void);

//	Función Main
int main(const int argc, const char *argv[]){
	
	//	División en funciones según proceso
	if (strcmp(argv[0], NOMBRE_PROCESO_CHARLIE) == 0){
		funcCharlie(argc, argv);
	} else if (strcmp(argv[0], NOMBRE_PROCESO_MALO) == 0){
		funcMalo(argc, argv);
	} else if (strcmp(argv[0], NOMBRE_PROCESO_BOSLEY) == 0){
		funcBosley(argc, argv);
	} else if (strcmp(argv[0], NOMBRE_PROCESO_SABRINA) == 0){
		funcSabrina(argc, argv);
	} else if (strcmp(argv[0], NOMBRE_PROCESO_JILL) == 0){
		funcJill(argc, argv);
	} else if (strcmp(argv[0], NOMBRE_PROCESO_KELLY) == 0){
		funcKelly(argc, argv);
	} else {
		perror("Problema al asignar función"); 
		return 1;
	}

	return 0;
}

//	Función de Charlie
funcCharlie(const int argc, const char *argv[]){
	int valorDevuelto;
	int vDBosley;
	pid_t pid;

	int *ficheroPIDs;

	int pidCharlie = getpid();
	int pidBosley;
	int pidMalo;

	int fd;
	int x = 0;
	int i;

	char buffer[0x1000];
	size_t length;
	
	//	Título
	write(STDOUT_FILENO, "\n", sizeof("\n"));
	write(STDOUT_FILENO, "██╗      ██████╗ ███████╗     █████╗ ███╗   ██╗ ██████╗ ███████╗██╗     ███████╗███████╗\n", sizeof("██╗      ██████╗ ███████╗     █████╗ ███╗   ██╗ ██████╗ ███████╗██╗     ███████╗███████╗\n"));
	write(STDOUT_FILENO, "██║     ██╔═══██╗██╔════╝    ██╔══██╗████╗  ██║██╔════╝ ██╔════╝██║     ██╔════╝██╔════╝\n", sizeof("██║     ██╔═══██╗██╔════╝    ██╔══██╗████╗  ██║██╔════╝ ██╔════╝██║     ██╔════╝██╔════╝\n"));
	write(STDOUT_FILENO, "██║     ██║   ██║███████╗    ███████║██╔██╗ ██║██║  ███╗█████╗  ██║     █████╗  ███████╗\n", sizeof("██║     ██║   ██║███████╗    ███████║██╔██╗ ██║██║  ███╗█████╗  ██║     █████╗  ███████╗\n"));
	write(STDOUT_FILENO, "██║     ██║   ██║╚════██║    ██╔══██║██║╚██╗██║██║   ██║██╔══╝  ██║     ██╔══╝  ╚════██║\n", sizeof("██║     ██║   ██║╚════██║    ██╔══██║██║╚██╗██║██║   ██║██╔══╝  ██║     ██╔══╝  ╚════██║\n"));
	write(STDOUT_FILENO, "███████╗╚██████╔╝███████║    ██║  ██║██║ ╚████║╚██████╔╝███████╗███████╗███████╗███████║\n", sizeof("███████╗╚██████╔╝███████║    ██║  ██║██║ ╚████║╚██████╔╝███████╗███████╗███████╗███████║\n"));
	write(STDOUT_FILENO, "╚══════╝ ╚═════╝ ╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚══════╝╚══════╝╚══════╝\n", sizeof("╚══════╝ ╚═════╝ ╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚══════╝╚══════╝╚══════╝\n"));
	write(STDOUT_FILENO, "                                    ██████╗ ███████╗     ██████╗██╗  ██╗ █████╗ ██████╗ ██╗     ██╗███████╗\n", sizeof("                                    ██████╗ ███████╗     ██████╗██╗  ██╗ █████╗ ██████╗ ██╗     ██╗███████╗\n"));
	write(STDOUT_FILENO, "                                    ██╔══██╗██╔════╝    ██╔════╝██║  ██║██╔══██╗██╔══██╗██║     ██║██╔════╝\n", sizeof("                                    ██╔══██╗██╔════╝    ██╔════╝██║  ██║██╔══██╗██╔══██╗██║     ██║██╔════╝\n"));
	write(STDOUT_FILENO, "                                    ██║  ██║█████╗      ██║     ███████║███████║██████╔╝██║     ██║█████╗  \n", sizeof("                                    ██║  ██║█████╗      ██║     ███████║███████║██████╔╝██║     ██║█████╗  \n"));
	write(STDOUT_FILENO, "                                    ██║  ██║██╔══╝      ██║     ██╔══██║██╔══██║██╔══██╗██║     ██║██╔══╝  \n", sizeof("                                    ██║  ██║██╔══╝      ██║     ██╔══██║██╔══██║██╔══██╗██║     ██║██╔══╝  \n"));
	write(STDOUT_FILENO, "                                    ██████╔╝███████╗    ╚██████╗██║  ██║██║  ██║██║  ██║███████╗██║███████╗\n", sizeof("                                    ██████╔╝███████╗    ╚██████╗██║  ██║██║  ██║██║  ██║███████╗██║███████╗\n"));
	write(STDOUT_FILENO, "                                    ╚═════╝ ╚══════╝     ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚══════╝\n", sizeof("                                    ╚═════╝ ╚══════╝     ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚══════╝\n"));
	write(STDOUT_FILENO, "\n", sizeof("\n"));                                                                                                       
	
	//	Cambiar el funcionamiento de SIGUSR1
	sigset_t conjuntoVacio;
	struct sigaction accionNueva1, actionVieja2;
	sigemptyset(&conjuntoVacio);
    accionNueva1.sa_handler = esperar;
	accionNueva1.sa_mask = conjuntoVacio;
    accionNueva1.sa_flags = 0;
    if (sigaction(SIGUSR1, &accionNueva1, &actionVieja2) == -1){
		perror("Error al cambiar el comportamiento de SIGUSR1");
	}

	//	Cambiar el funcionamiento de SIGINT
	struct sigaction accionNueva, actionVieja;
    accionNueva.sa_handler = morirTodos;
	accionNueva1.sa_mask = conjuntoVacio;
    accionNueva.sa_flags = 0;
    if (sigaction(SIGINT, &accionNueva, &actionVieja) == -1){
		perror("Error al cambiar el comportamiento de SIGINT");
	}

	//	Comprobar modo velocidad
	char *velocidad;

	if (argc == 1){
		velocidad = "normal";
	} else if (argc == 2){
		if((strcmp(argv[1], "normal") == 0) || (strcmp(argv[1], "veloz") == 0)){
			velocidad = argv[1];
		} else {
			length = snprintf(buffer, sizeof(buffer), "Error al escribir el modo (normal/veloz) [%s].\n", argv[1]);
			write(STDOUT_FILENO, buffer, length);
			return 1;
		}
	} else {
		length = snprintf(buffer, sizeof(buffer), "Número incorrecto de argumentos [%d].\n", argc);
		write(STDOUT_FILENO, buffer, length);
		return 1;
	}
	
	length = snprintf(buffer, sizeof(buffer), "Velocidad puesta a [%s].\n", velocidad);
	write(STDOUT_FILENO, buffer, length);

	//	Crear Bosley
	switch (pidBosley = fork()){
		case -1: 
			perror("Problema en fork() de crear a Bosley"); 
			return 1;
		case 0:
			execl(NOMBRE_PROGRAMA, NOMBRE_PROCESO_BOSLEY, velocidad, (char*) NULL);	
			break;													
		default:
			length = snprintf(buffer, sizeof(buffer), "CHARLIE: Bosley, hijo de mis entretelas, tu PID es %d. Espero a que me avises...\n", pidBosley);
			write(STDOUT_FILENO, buffer, length);
	}

	//	Esperar a que Bosley le diga que ha creado los Ángeles
	sigsuspend(&conjuntoVacio);
	write(STDOUT_FILENO, "CHARLIE: Veo que los Ángeles ya han nacido. Creo al malo...\n", sizeof("CHARLIE: Veo que los Ángeles ya han nacido. Creo al malo...\n"));

	//	Inicializar fichero de PIDs a 0 y proyectarlo en memoria
	fd = open("pids.bin", O_CREAT | O_TRUNC | O_RDWR | O_APPEND, 0644);
	if (fd != NULL){
		for (i = 0; i < REENCARNACIONES_MALO; i++){
			write(fd, &x, sizeof(int));
		}
		close(fd);
	}

	//	Crear Malo
	switch (pidMalo = fork()){
		case -1: 
			perror("Problema en fork() de crear al malo"); 
			return 1;
		case 0:
			execl(NOMBRE_PROGRAMA, NOMBRE_PROCESO_MALO, velocidad, "1", (char*) NULL);	//  El malo empieza siendo la reencarnacion 1, no la 0
			break;																		//	y el nº de reencarnación se guarda en argv[2]
		default:
			length = snprintf(buffer, sizeof(buffer), "CHARLIE: El malo ha nacido y su PID es %d. Aviso a Bosley\n", pidMalo);
			write(STDOUT_FILENO, buffer, length);

			//	Comunicar a Bosley que el malo ha nacido y que ha de continuar
			kill(pidBosley, SIGUSR1);

			//	Esperar por la muerte del primer malo para no quedarse zombie
			pid = waitpid(pidMalo, &valorDevuelto, 0);
			if (pid == -1){
				perror("Problema en wait de la muerte del primer malo de Charlie"); 
				return 1;
			}
	}


	//	Esperar por la muerte de Bosley
	pid = waitpid(pidBosley, &valorDevuelto, 0);
	if (pid == -1){
		perror("Problema en wait de la muerte de Bosley en Charlie"); 
		return 1;
	}
	vDBosley = WEXITSTATUS(valorDevuelto);

	//	Mostrar un mensaje dependiendo de los resultados
	switch (vDBosley){
		case 0:
			write(STDOUT_FILENO, "CHARLIE: El pájaro voló. Ahora se pone tibio a daiquiris en el Caribe\n", sizeof("CHARLIE: El pájaro voló. Ahora se pone tibio a daiquiris en el Caribe\n"));
			break;
		case 1:
			write(STDOUT_FILENO, "CHARLIE: Bien hecho, Sabrina, siempre fuiste mi favorita\n", sizeof("CHARLIE: Bien hecho, Sabrina, siempre fuiste mi favorita\n"));
			break;
		case 2:
			write(STDOUT_FILENO, "CHARLIE: Jill, donde pones el ojo, pones la bala\n", sizeof("CHARLIE: Jill, donde pones el ojo, pones la bala\n"));
			break;
		case 3:
			write(STDOUT_FILENO, "CHARLIE: Bravo por Kelly\n", sizeof("CHARLIE: Bravo por Kelly\n"));
			break;
		case 4:
			write(STDOUT_FILENO, "CHARLIE: Kelly, mala suerte, tus compañeras acertaron y tú, no\n", sizeof("CHARLIE: Kelly, mala suerte, tus compañeras acertaron y tú, no\n"));
			break;
		case 5:
			write(STDOUT_FILENO, "CHARLIE: Sabrina, otra vez será, te apuntaré a una academia de tiro\n", sizeof("CHARLIE: Sabrina, otra vez será, te apuntaré a una academia de tiro\n"));
			break;
		case 6:
			write(STDOUT_FILENO, "CHARLIE: Jill, no te preocupes, seguro que la pistola está mal\n", sizeof("CHARLIE: Jill, no te preocupes, seguro que la pistola está mal\n"));
			break;
		case 7:
			write(STDOUT_FILENO, "CHARLIE: Pobre malo. Le habéis dejado como un colador... Sois unos Ángeles letales\n", sizeof("CHARLIE: Pobre malo. Le habéis dejado como un colador... Sois unos Ángeles letales\n"));
			break;
		default:
			perror("Error en el valor de retorno de Bosley\n");
			return -1;
	}
	
	//	Impedir que el Malo se siga reencarnando si los Ángeles se quedan sin balas
	kill(0, SIGTERM);

	exit(0);
}

//	Función del Malo
funcMalo(const int argc, const char *argv[]){
	int pidMaloActual = getpid();
	int dormirAleatorio;

	char *velocidad = argv[1];
	int reencarnacion = strtol(argv[2], NULL, 10);	//	Pasar string a int
	char sigReencarnacion[2];
	sprintf(sigReencarnacion, "%d", reencarnacion + 1);	//	Pasar int a string

	int *ficheroPIDs;
	int fd;
	int i;
	int posicionAletoria;
	srand(time(NULL) + pidMaloActual);

	char buffer[0x1000];
	size_t length;

	//	Cambiar el funcionamiento de SIGUSR2
	sigset_t conjuntoVacio;
	sigemptyset(&conjuntoVacio);
	struct sigaction accionNueva, actionVieja;
    accionNueva.sa_handler = morirMalo;
	accionNueva.sa_mask = conjuntoVacio;
    accionNueva.sa_flags = 0;
    if (sigaction(SIGUSR2, &accionNueva, &actionVieja) == -1){
		perror("Error al cambiar el comportamiento de SIGUSR2");
	}

	if (reencarnacion != 1){
		length = snprintf(buffer, sizeof(buffer), "MALO: JA, JA, JA, me acabo de reencarnar y mi nuevo PID es: %d. Qué malo que soy...\n", pidMaloActual);
		write(STDOUT_FILENO, buffer, length);
	}
	
	//	Almacenar PID en lugar aleatorio del archivo de PIDs proyectado en memoria
	fd = open("pids.bin", O_RDWR, 0644);
	ficheroPIDs = mmap(0, sizeof(int)*REENCARNACIONES_MALO, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

	do{
		posicionAletoria = (int)(rand()/(1.0 + RAND_MAX)*REENCARNACIONES_MALO);
		if (ficheroPIDs[posicionAletoria] == 0){
			ficheroPIDs[posicionAletoria] = pidMaloActual;
		}
	} while (ficheroPIDs[posicionAletoria] != pidMaloActual);

	munmap(ficheroPIDs, sizeof(int)*REENCARNACIONES_MALO);
	close(fd);

	//	Descansar
	if(strcmp(velocidad, "normal") == 0){
		dormirAleatorio = DESCANSO_MIN_MALO + (int)(rand()/(1.0 + RAND_MAX)*(DESCANSO_MAX_MALO - DESCANSO_MIN_MALO + 1));
		sleep(dormirAleatorio);
	}
	
	//	Sistema de Reencarnación
	if (reencarnacion < REENCARNACIONES_MALO){
		switch (fork()){
			case -1: 
				perror("Problema en fork() de reproducción del malo"); 
				return 1;
			case 0:
				execl(NOMBRE_PROGRAMA, NOMBRE_PROCESO_MALO, velocidad, sigReencarnacion, (char*) NULL);
				break;
			default:
				exit(0);	//	Morir
		}
	} else if (reencarnacion == REENCARNACIONES_MALO){
		write(STDOUT_FILENO, "MALO: He sobrevivido a mi vigésima reencarnación. Hago mutis por el foro\n", sizeof("MALO: He sobrevivido a mi vigésima reencarnación. Hago mutis por el foro\n"));
	}

	return 0;
}

// Función Bosley
funcBosley(const int argc, const char *argv[]){
	int pidCharlie = getppid();
	int pidBosley = getpid();
	int pidSabrina;
	int pidJill;
	int pidKelly;

	pid_t pid;
	int valorDevuelto;
	int vDSabrina;
	int vDJill;
	int vDKelly;

	char buffer[0x1000];
	size_t length;

	//	Cambiar el funcionamiento de SIGUSR1
	sigset_t conjuntoVacio;
	struct sigaction accionNueva1, actionVieja2;
	sigemptyset(&conjuntoVacio);
    accionNueva1.sa_handler = esperar;
	accionNueva1.sa_mask = conjuntoVacio;
    accionNueva1.sa_flags = 0;
    if (sigaction(SIGUSR1, &accionNueva1, &actionVieja2) == -1){
		perror("Error al cambiar el comportamiento de SIGUSR1");
	}

	//	Crear Ángeles
	length = snprintf(buffer, sizeof(buffer), "BOSLEY: Hola, papá, dónde está mamá? Mi PID es %d y voy a crear a los Ángeles...\n", pidBosley);
	write(STDOUT_FILENO, buffer, length);

	//	Crear Sabrina
	switch (pidSabrina = fork()){
		case -1: 
			perror("Problema en fork() de crear a Sabrina"); 
			return 1;
		case 0:
			execl(NOMBRE_PROGRAMA, NOMBRE_PROCESO_SABRINA, argv[1], (char*) NULL);	
			break;
	}

	//	Crear Jill
	switch (pidJill = fork()){
		case -1: 
			perror("Problema en fork() de crear a Jill"); 
			return 1;
		case 0:
			execl(NOMBRE_PROGRAMA, NOMBRE_PROCESO_JILL, argv[1], (char*) NULL);	
			break;
	}

	//	Crear Kelly
	switch (pidKelly = fork()){
		case -1: 
			perror("Problema en fork() de crear a Kelly"); 
			return 1;
		case 0:
			execl(NOMBRE_PROGRAMA, NOMBRE_PROCESO_KELLY, argv[1], (char*) NULL);	
			break;
	}

	//	Decirle a Charlie que ya ha creado los Ángeles y que puede continuar
	kill(pidCharlie, SIGUSR1);
	
	//	Esperar a que Charlie le diga que ha creado al malo
	sigsuspend(&conjuntoVacio);

	//	Mandar a los Ángeles disparar
	kill(pidSabrina, SIGUSR1);
	kill(pidJill, SIGUSR1);
	kill(pidKelly, SIGUSR1);

	//	Esperar por la muerte de Sabrina
	pid = waitpid(pidSabrina, &valorDevuelto, 0);
	if (pid == -1){
		perror("Problema en wait de la muerte Sabrina de en Bosley"); 
		return 1;
	}
	vDSabrina = WEXITSTATUS(valorDevuelto);

	//	Esperar por la muerte de Jill
	pid = waitpid(pidJill, &valorDevuelto, 0);
	if (pid == -1){
		perror("Problema en wait de la muerte de Jill en Bosley"); 
		return 1;
	}
	vDJill = WEXITSTATUS(valorDevuelto);

	//	Esperar por la muerte de Kelly
	pid = waitpid(pidKelly, &valorDevuelto, 0);
	if (pid == -1){
		perror("Problema en wait de la muerte de Kelly en Bosley"); 
		return 1;
	}
	vDKelly = WEXITSTATUS(valorDevuelto);

	//	Devolver un valor a Charlie dependiendo de los resultados
	write(STDOUT_FILENO, "BOSLEY: Los tres Ángeles han acabado su misión. Informo del resultado a Charlie y muero\n", sizeof("BOSLEY: Los tres Ángeles han acabado su misión. Informo del resultado a Charlie y muero\n"));

													/*==================================*/
													/*	Sabrina	||	Jill	||	Kelly	*/
													/*==========||==========||==========*/
	if (vDSabrina && vDJill && vDKelly){			/*			||			||			*/
		exit(0);									/*----------||----------||----------*/
	} else if (!vDSabrina && vDJill && vDKelly){	/*	X		||			||			*/
		exit(1);									/*----------||----------||----------*/
	} else if (vDSabrina && !vDJill && vDKelly){	/*			||	X		||			*/
		exit(2);									/*----------||----------||----------*/
	} else if (vDSabrina && vDJill && !vDKelly){	/*			||			||	X		*/
		exit(3);									/*----------||----------||----------*/
	} else if (!vDSabrina && !vDJill && vDKelly){	/*	X		||	X		||			*/
		exit(4);									/*----------||----------||----------*/
	} else if (vDSabrina && !vDJill && !vDKelly){	/*			||	X		||	X		*/
		exit(5);									/*----------||----------||----------*/
	} else if (!vDSabrina && vDJill && !vDKelly){	/*	X		||			||	X		*/
		exit(6);									/*----------||----------||----------*/
	} else if (!vDSabrina && !vDJill && !vDKelly){	/*	X		||	X		||	X		*/
		exit(8);									/*==================================*/
	} else {
		exit(-1);
	}							
}

// Función de Sabrina
funcSabrina(const int argc, const char *argv[]){
	int pidSabrina = getpid();
	char *velocidad = argv[1];
	int dormirAleatorio;

	int *ficheroPIDs;
	int i;
	int fd;
	int posicionAletoria;
	srand(time(NULL) + pidSabrina);

	char buffer[0x1000];
	size_t length;

	//	Cambiar el funcionamiento de SIGUSR1
	sigset_t conjuntoVacio;
	struct sigaction accionNueva1, actionVieja2;
	sigemptyset(&conjuntoVacio);
    accionNueva1.sa_handler = esperar;
	accionNueva1.sa_mask = conjuntoVacio;
    accionNueva1.sa_flags = 0;
    if (sigaction(SIGUSR1, &accionNueva1, &actionVieja2) == -1){
		perror("Error al cambiar el comportamiento de SIGUSR1");
	}

	length = snprintf(buffer, sizeof(buffer), "SABRINA: Hola, he nacido y mi PID es %d\n", pidSabrina);
	write(STDOUT_FILENO, buffer, length);

	//	Esperar a la orden de Bosley para disparar
	sigsuspend(&conjuntoVacio);

	//	Disparar 3 veces a PID aleatorio del fichero en memoria
	for (i = 0; i < DISPAROS_POR_ANGEL; i++){
		//	Descansar
		if(strcmp(velocidad, "normal") == 0){
			dormirAleatorio = DESCANSO_MIN_ANGELES + (int)(rand()/(1.0 + RAND_MAX)*(DESCANSO_MAX_ANGELES - DESCANSO_MIN_ANGELES + 1));
			sleep(dormirAleatorio);
		}

		fd = open("pids.bin", O_RDWR, 0644);
		ficheroPIDs = mmap(0, sizeof(int)*REENCARNACIONES_MALO, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

		posicionAletoria = (int)(rand()/(1.0+RAND_MAX)*REENCARNACIONES_MALO);
		if (ficheroPIDs[posicionAletoria] == 0){
			write(STDOUT_FILENO, "SABRINA: Pardiez! La pistola se ha encasquillado\n", sizeof("SABRINA: Pardiez! La pistola se ha encasquillado\n"));
		} else {
			length = snprintf(buffer, sizeof(buffer), "SABRINA: Voy a disparar al PID %d\n", ficheroPIDs[posicionAletoria]);
			write(STDOUT_FILENO, buffer, length);
			if (kill(ficheroPIDs[posicionAletoria], SIGUSR2) == -1){
				write(STDOUT_FILENO, "SABRINA: He fallado. Vuelvo a intentarlo\n", sizeof("SABRINA: He fallado. Vuelvo a intentarlo\n"));
			} else {
				write(STDOUT_FILENO, "SABRINA: BINGO! He hecho diana! Un malo menos\n", sizeof("SABRINA: BINGO! He hecho diana! Un malo menos\n"));
				exit(0);
			}
		}

		munmap(ficheroPIDs, sizeof(int)*REENCARNACIONES_MALO);
		close(fd);
	}

	write(STDOUT_FILENO, "SABRINA: He fallado ya tres veces y no me quedan más balas. Muero\n", sizeof("SABRINA: He fallado ya tres veces y no me quedan más balas. Muero\n"));
	exit(1);
}

// Función de Jill
funcJill(const int argc, const char *argv[]){
	int pidJill = getpid();
	char *velocidad = argv[1];
	int dormirAleatorio;

	int *ficheroPIDs;
	int i;
	int fd;
	int posicionAletoria;
	srand(time(NULL) + pidJill);

	char buffer[0x1000];
	size_t length;

	//	Cambiar el funcionamiento de SIGUSR1
	sigset_t conjuntoVacio;
	struct sigaction accionNueva1, actionVieja2;
	sigemptyset(&conjuntoVacio);
    accionNueva1.sa_handler = esperar;
	accionNueva1.sa_mask = conjuntoVacio;
    accionNueva1.sa_flags = 0;
    if (sigaction(SIGUSR1, &accionNueva1, &actionVieja2) == -1){
		perror("Error al cambiar el comportamiento de SIGUSR1");
	}

	length = snprintf(buffer, sizeof(buffer), "JILL: Hola, he nacido y mi PID es %d\n", pidJill);
	write(STDOUT_FILENO, buffer, length);

	//	Esperar a la orden de Bosley para disparar
	sigsuspend(&conjuntoVacio);

	//	Disparar 3 veces a PID aleatorio del fichero en memoria
	for (i = 0; i < DISPAROS_POR_ANGEL; i++){
		//	Descansar
		if(strcmp(velocidad, "normal") == 0){
			dormirAleatorio = DESCANSO_MIN_ANGELES + (int)(rand()/(1.0 + RAND_MAX)*(DESCANSO_MAX_ANGELES - DESCANSO_MIN_ANGELES + 1));
			sleep(dormirAleatorio);
		}

		fd = open("pids.bin", O_RDWR, 0644);
		ficheroPIDs = mmap(0, sizeof(int)*REENCARNACIONES_MALO, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

		posicionAletoria = (int)(rand()/(1.0+RAND_MAX)*REENCARNACIONES_MALO);
		if (ficheroPIDs[posicionAletoria] == 0){
			write(STDOUT_FILENO, "JILL: Pardiez! La pistola se ha encasquillado\n", sizeof("JILL: Pardiez! La pistola se ha encasquillado\n"));
		} else {
			length = snprintf(buffer, sizeof(buffer), "JILL: Voy a disparar al PID %d\n", ficheroPIDs[posicionAletoria]);
			write(STDOUT_FILENO, buffer, length);
			if (kill(ficheroPIDs[posicionAletoria], SIGUSR2) == -1){
				write(STDOUT_FILENO, "JILL: He fallado. Vuelvo a intentarlo\n", sizeof("JILL: He fallado. Vuelvo a intentarlo\n"));
			} else {
				write(STDOUT_FILENO, "JILL: BINGO! He hecho diana! Un malo menos\n", sizeof("JILL: BINGO! He hecho diana! Un malo menos\n"));
				exit(0);
			}
		}

		munmap(ficheroPIDs, sizeof(int)*REENCARNACIONES_MALO);
		close(fd);
	}

	write(STDOUT_FILENO, "JILL: He fallado ya tres veces y no me quedan más balas. Muero\n", sizeof("JILL: He fallado ya tres veces y no me quedan más balas. Muero\n"));
	exit(1);
}

// Función de Kelly
funcKelly(const int argc, const char *argv[]){
	int pidKelly = getpid();
	char *velocidad = argv[1];
	int dormirAleatorio;

	int *ficheroPIDs;
	int i;
	int fd;
	int posicionAletoria;
	srand(time(NULL) + pidKelly);

	char buffer[0x1000];
	size_t length;

	//	Cambiar el funcionamiento de SIGUSR1
	sigset_t conjuntoVacio;
	struct sigaction accionNueva1, actionVieja2;
	sigemptyset(&conjuntoVacio);
    accionNueva1.sa_handler = esperar;
	accionNueva1.sa_mask = conjuntoVacio;
    accionNueva1.sa_flags = 0;
    if (sigaction(SIGUSR1, &accionNueva1, &actionVieja2) == -1){
		perror("Error al cambiar el comportamiento de SIGUSR1");
	}

	length = snprintf(buffer, sizeof(buffer), "KELLY: Hola, he nacido y mi PID es %d\n", pidKelly);
	write(STDOUT_FILENO, buffer, length);

	//	Esperar a la orden de Bosley para disparar
	sigsuspend(&conjuntoVacio);

	//	Disparar 3 veces a PID aleatorio del fichero en memoria
	for (i = 0; i < DISPAROS_POR_ANGEL; i++){
		//	Descansar
		if(strcmp(velocidad, "normal") == 0){
			dormirAleatorio = DESCANSO_MIN_ANGELES + (int)(rand()/(1.0 + RAND_MAX)*(DESCANSO_MAX_ANGELES - DESCANSO_MIN_ANGELES + 1));
			sleep(dormirAleatorio);
		}

		fd = open("pids.bin", O_RDWR, 0644);
		ficheroPIDs = mmap(0, sizeof(int)*REENCARNACIONES_MALO, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

		posicionAletoria = (int)(rand()/(1.0+RAND_MAX)*REENCARNACIONES_MALO);
		if (ficheroPIDs[posicionAletoria] == 0){
			write(STDOUT_FILENO, "KELLY: Pardiez! La pistola se ha encasquillado\n", sizeof("KELLY: Pardiez! La pistola se ha encasquillado\n"));
		} else {
			length = snprintf(buffer, sizeof(buffer), "KELLY: Voy a disparar al PID %d\n", ficheroPIDs[posicionAletoria]);
			write(STDOUT_FILENO, buffer, length);
			if (kill(ficheroPIDs[posicionAletoria], SIGUSR2) == -1){
				write(STDOUT_FILENO, "KELLY: He fallado. Vuelvo a intentarlo\n", sizeof("KELLY: He fallado. Vuelvo a intentarlo\n"));
			} else {
				write(STDOUT_FILENO, "KELLY: BINGO! He hecho diana! Un malo menos\n", sizeof("KELLY: BINGO! He hecho diana! Un malo menos\n"));
				exit(0);
			}
		}

		munmap(ficheroPIDs, sizeof(int)*REENCARNACIONES_MALO);
		close(fd);
	}

	write(STDOUT_FILENO, "KELLY: He fallado ya tres veces y no me quedan más balas. Muero\n", sizeof("KELLY: He fallado ya tres veces y no me quedan más balas. Muero\n"));
	exit(1);
}

// Función de Morir del Malo (SIGUSR2)
void morirMalo(){
    write(STDOUT_FILENO, "MALO: AY, me han dado... pulvis sumus, collige, virgo, rosas\n", sizeof("MALO: AY, me han dado... pulvis sumus, collige, virgo, rosas\n"));
	exit(1);
}

//	Función de CTRL-C (SIGINT)
void morirTodos(){
	write(STDOUT_FILENO, "\nCerrando todos los procesos...\n", sizeof("\nCerrando todos los procesos...\n"));
	kill(0, SIGTERM);
}

//	Función de Espera (SIGUSR1)
void esperar(){
	
}