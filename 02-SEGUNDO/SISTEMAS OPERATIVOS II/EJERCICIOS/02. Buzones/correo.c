#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <unistd.h>
#include <string.h>
#include <pwd.h>
#include <stdio.h>

#define LONG_MSG

int main(const int argc, const char *argv[]){
    key_t clave;
    int buzon, envio, recibo;
    char etiqueta[100];
    struct passwd *informe;
    struct tipo_mensaje{
        long tipo;
        char remite[12];
        char mensaje[LONG_MSG];
    } mensaje;

    if (((argc == 3) && (strcmp(argv[1], "-r"))) || ((argc == 4) && (strcmp(argv[1], "-e"))) || ((argc != 1) && (argc != 3) && (argc != 4))){
        printf("\nArgumentos Incorrectos\n\n");
        return 4;
    }

    clave = ftok("/bin/ls", 'q');

    buzon = msgget(clave, IPC_CREAT | 0444);

    if (buzon == -1){
        perror("No se puede crear/encontrar el buzón");
        return 2;
    }

    if (argc == 1){
        printf("\nINSTRUCCIONES DE USO:");
        printf("\nA este programa se le puede pasar tres tipos de opciones por la línea de órdenes:");
        printf("\nNada: imprimirá la forma de uso.");
        printf("\n-e tipo mensaje: el programa enviará a un buzón el mensaje mensaje con el tipo tipo.");
        printf("\n-r tipo: el programa recibirá un mensaje del tipo tipo. Si no lo hay, se quedará bloqueado.\n\n");
    } else if (!strcmp(argv[1], "-e")){
        mensaje.tipo = strtol(argv[2], NULL, 10);
        informe = getpwuid(getuid());
        strcpy(mensaje.remite, informe->pw_name);
        strcpy(mensaje.mensaje, argv[3]);
        envio = msgsnd(buzon, &mensaje, sizeof(struct tipo_mensaje)-sizeof(long), IPC_NOWAIT);

        if (envio == -1){
            perror("Fallo en el envío");
            return 3;
        }
    } else if (!strcmp(argv[1], "-r")){
        mensaje.tipo = strtol(argv[2], NULL, 10);
        recibo = msgrcv(buzon, &mensaje, sizeof(struct tipo_mensaje)-sizeof(long), mensaje.tipo, MSG_NOERROR);
        if (recibo == -1){
            perror("Fallo en la recepción");
            return 3;
        }
        printf("%s: %s\n", mensaje.remite, mensaje.mensaje);
    }
    
    return 0;
}