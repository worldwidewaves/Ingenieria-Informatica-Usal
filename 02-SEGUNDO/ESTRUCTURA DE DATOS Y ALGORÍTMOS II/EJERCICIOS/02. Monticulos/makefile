prueba1: prueba1.c monticulo.o monticulo.h
	gcc -g prueba1.c monticulo.o -o prueba1

prueba2: prueba2.c monticulo.o monticulo.h
	gcc -g prueba2.c monticulo.o -o prueba2
	
monticulo.o: monticulo.c monticulo.h
	gcc -c monticulo.c

clean:
	rm *.o