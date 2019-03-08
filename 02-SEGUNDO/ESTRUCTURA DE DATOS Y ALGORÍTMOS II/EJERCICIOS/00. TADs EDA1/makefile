# Proyecto para ejercicios sobre TADs

pruebaTADs: pruebaTADs.c pila.o cola.o lista.o
	gcc -g pruebaTADs.c pila.o cola.o lista.o -o pruebaTADs

pila.o: pila.c pila.h
	gcc -g -c pila.c
cola.o: cola.c cola.h
	gcc -g -c cola.c
lista.o: lista.c lista.h
	gcc -g -c lista.c
limpiar:
	rm *.o

