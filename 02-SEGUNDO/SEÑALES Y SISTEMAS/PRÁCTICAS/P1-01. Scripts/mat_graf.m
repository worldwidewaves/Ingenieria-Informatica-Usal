clf
clc
echo on
%	PRACTICA DE UTILIZACION DE GRAFICOS EN MATLAB
%
%	plot--> crea un grafico de los vectores o columnas de matrices
%	tittle--> anade un titulo al grafico
%	xlabel--> pone una etiqueta para el eje X
%	ylabel--> pone una etiqueta para el eje Y
%	text--> pone un texto en una localizacion determinada
%	grid--> activa las lineas de grid
%
%
% Si es un vector plot(y) crea un grafico lineal de los elementos de y frente 
% al indice de los elementos de y.
% Si se especigifican dos vectores como argumentos plot(x,y) crea un grafico de
% y frente a x
%
t=(0:pi/100:2*pi);
x=sin(t);
plot(t,x);
pause % Pulse una tecla para continuar
plot(t);
pause % Pulse una tecla para continuar
plot(x);
pause % Pulse una tecla para continuar
clc
%
% Se pueden especificar varios grupos de datos y definir estilos de lineas 
% y colores para usarlos para cada grupo de datos en una simple llamada a 
% plot
y1=sin(t+.25);
y2=sin(t+.5);
plot(t,y1,'-r',t,y2,'--g');
pause %Pulse una tecla para continuar
%
% Los estilos de lineas son:
%				.		punto
%				o		circulo
%				x		x-marca
%				+		mas
%				*		estrella
%				-		solido
%				:		punteado
%				-.		punto-raya
%				--		raya-raya
% 
%
%
%
clc
%
% El uso del titulo y de las etiquetas es como sigue:
%
plot(x,y1,'g+',x,y2,'b-.');
title('Desplazamiento de fase');
xlabel('x=sin(t)');
ylabel('y=sin(t+)');
pause %Pulse una tecla para continuar
clf
clc
% 
%
% Cada vez que se ejecuta un comando plot, el grafico anterior es borrado
%
% con el comando hold se pueden anadir lineas a un grafico ya existente
% Utilizando hold on, MATLAB no elimina las lineas existentes sino que 
% suma nuevas lineas a los ejes actuales.
%
plot(x);
hold on
plot(y1,'--')
plot(y2,'-.')
hold off
pause %Pulse una tecla para continuar
clc
% Cuando los argumentos de un plot son complejos, se ignora la parte imaginaria % excepto en el caso en que a plot se le pase una solo argumento complejo
% en cuyo caso representara la parte imaginaria frente a la parte real
Z=exp(i*t);
plot(Z);
title('Z = EXP ( i * t)');
xlabel('Real de Z');
ylabel('Imag de Z');
pause %Pulse una tecla para continuar
% 
% Esto es equivalente a representar
plot(real(Z),imag(Z))
title('Z = EXP ( i * t)');
xlabel('Real de Z');
ylabel('Imag de Z');
pause %Pulse una tecla para continuar
clc
% Los comandos:
% 		clc --> Borra la pantalla de comando
%		clf --> Borra la pantalla grafica
pause %Pulse una tecla para continuar
clf
pause %Pulse una tecla para continuar
clc
% La funcion axis tiene un numero de opciones que permiten adecuar
% a medida del usuario el escalado, orientacion y aspecto de los graficos
% Normalmente MATLAB calcula el maximo y el minimo de los datos a representar
% y elige los ejes apropiados.
% Se pueden modificar estos ejes con:
% 	axis([xmin xmax ymin ymax])
%
t2=(-pi:pi/100:pi);
y=sin(t2);
plot(t2,y);xlabel('t');ylabel('y');title('Medio seno de t');text(.5,.75,'Curva','sc')
v=axis;
axis([0 pi -2 2]);
pause %Pulse una tecla para continuar
% Poniendo:
% 		axis
% se recuperan los ejes anteriores.
%
axis([-pi pi -2 2]);
plot(t2,y);xlabel('t');ylabel('y');title('Seno completo de t');text(.5,.75,'Curva completa','sc')
axis;
pause %Pulse una tecla para continuar
clc
% Con el comando subplot(mnp) se puede dividir la pantalla grafica en m x n 
% zonas donde representar otros tantos graficos. El tercer indice sirve para 
% indicar sobre cual de ellos se va dibujar la grafica. La numeracion es de 
% izquierda a derecha y de arriba a abajo.
% A continuacion de cada comando subplot(mnp) se ha de colocar el comando 
% plot correspondiente.
pause %Pulse una tecla para continuar
y3=sin(2*t);
y4=sin(2*t+.5);
%
subplot(221);
plot(t,y1);
title('Fase .25');
xlabel('tiempo (s)');
ylabel('y1');
%
subplot(222);
plot(t,y2);
title('Fase .5');
xlabel('tiempo (s)');
ylabel('y2');
%
subplot(223);
plot(t,y3);
title('Doble frecuencia');
xlabel('tiempo (s)');
ylabel('y3');
%
subplot(224);
plot(t,y4);
title('Doble frecuencia Fase .5');
xlabel('tiempo (s)');
ylabel('y4');
pause %Pulse una tecla para continuar
clc
% Es posible crear graficos en tres dimensiones 
%
% Para ello se utilizan los comandos MESHGRID y MESH
% 
% Primero se disponen la pantalla para una unica figura
subplot(111)
%
% El primer paso es crear unas matrices bidimensionales que contengan la  
% variables de las variables.
% 
[x,y]=meshgrid(-2:.1:2,-2:.1:2);
% A continuacion se crea la variable z correspondiente como una 
% funcion f(x,y)
z=sin(x).*cos(y);
%
% Y la representacion se hace mesh(z)
pause %Pulse una tecla para continuar
mesh(z)
pause %Pulse una tecla para continuar
