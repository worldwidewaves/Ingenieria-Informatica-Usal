#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <unistd.h>
#include <string.h>
#include <pwd.h>
#include <stdio.h>

int main(const int argc, const char *argv[]){
    /*
        HIJO        PADRE
        ----------  ----------
        wait(s1)    wait(s2)
        print(0)    print(1)
        signal(s2)  signal(s1)
    */
}