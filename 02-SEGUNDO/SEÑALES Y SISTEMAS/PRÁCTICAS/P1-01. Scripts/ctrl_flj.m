clear
echo on
%
% CONTROL DE FLUJO	- Bucles FOR
%			- Bucles WHILE
%			- Sentencia IF y BREAK
%
% 1.1.- BUCLES FOR
%
% La forma general de un bucle for es:
%		for v=expresion
%		   sentencias
%		end
%
pause	%pulse una tecla para continuar
n=10;
for i=1:n, x(i)=0, end
%
pause	%pulse una tecla para continuar
%
%
% Pueden incluirse bucles dentro de otros bucles
%
m=10;
for i=1:m
	for j=1:n
		A(i,j)=1/(i+j-1);
	end
end
A
%
pause	%pulse una tecla para continuar
%
%
% Se debe finalizar cada lazo con un end, si no se pone end
% es sistema espera a que se teclee 
%
% for i=1:n, x(i)=0
%
% La expresion puede ser m:n , o  m:i:n
%
% Si t=[-1; 0;1;3;5] y se quiere generar la matriz de Vandermonde,
% una matriz cuyas columnas son las potencias sucesivas de t.
% 
%
%
pause	%pulse una tecla para continuar
%
clear A
t=[-1; 0;1;3;5]
n=length(t);
for j=1:n
	for i=1:n
		A(i,j)=t(i)^(n-j);
	end
end
A
%
pause	%pulse una tecla para continuar
%
%
% Para hacerlo de forma mas rapida
%
clear A
n=length(t);
A(:,n)=ones(n,1);
for j=n-1:-1:1
	A(:,j)=t.*A(:,j+1);
end
A
%
pause	%pulse una tecla para continuar
%
%
% 1.2.- BUCLES WHILE
%
%	La forma general de un bucle WHILE
%		
%		while expresion_logica
%			sentencias
%		end

%
% Calcula el primer numero entero cuyo factorial tiene mas
% de cien digitos 
n=1;
while prod(1:n) < 1.e100
	n=n+1;
end
disp('El entero cuyo factorial tiene mas de cien digitos: '),n
%
pause	%pulse una tecla para continuar
%
%
% Otra forma de mostrar variables por pantalla es 
% 	s = sprintf('format',variables,...)
%
s=sprintf('el numero es %3.0f',n)
echo on
%
pause	%pulse una tecla para continuar
%
%
% Ejercicio:
%  Calcular expm(A)= I + A + A^2/2! + A^3/3! + ...
%  siendo A cualquier matriz cuadrada
%  Ayuda	I=eye(size(A))
%  La condicion de finalizacion es:
%	Sea E y E2 son dos aproximaciones sucesivas.
%	Se considera la matriz diferencia y se evalua
%	el maximo de las sumas por columnas de los valores 
%	absolutos de los elementos.
%	El calculo se realiza mientras que este valor es > 0
%			help norm
%
%
%
pause	%pulse una tecla para continuar
%
%
% 1.3.- SENTENCIAS IF-ELSE-ELSEIF-END
%
%	El formato de esta sentencia es:
%
%	if condicion_logica
%		sentencias
%	elseif condicion_logica
%		sentencias
%	else
%		sentencias
%	end
%
%
pause	%pulse una tecla para continuar
%
% A continuacion se muestra un ejemplo de como calcular  
% el signo y la paridad de n.
%
n=input('Introducir un numero');
if n<0
	disp('negativo')
elseif rem(n,2)==0
	disp('par')
else
	disp('impar')
end
%
pause	%pulse una tecla para continuar
%
%
%
% 1.4.- SENTENCIA BREAK
%
%	Se utiliza para salir de bucles while y for
%
% Problema 1:
% 	Decodificar las condiciones siguientes
%
%
pause	%pulse una tecla para continuar
%
while 1
	n=input('introducir n: ');
	if n <=0, break,end
	while n>1
		if rem(n,2)==0
			n=n/2
		else
			n=3*n+1
		end
	end
end
%
pause	%pulse una tecla para continuar
%
%
%
% Problema 2:
% Representar los terminos de la serie de Fibonacci 
%	f(i+2) = f(i) +f(i+1)		hasta que
% la suma de los dos ultimos terminos sea menor que 1000
%
%
pause	%pulse una tecla para continuar
%
%
%
% 2.1.-	    M-Files: Guiones (Scripts) y Funciones
%
% M-files sirven para ejecutar secuencias de comandos almacenados
% en un fichero. Se distinguen dos tipos: scripts y funciones.
%
% 	Scripts 	ejecutan de forma automatica 
%			secuencias largas de comandos
%	Funciones	permiten crear nuevas funciones 
%			para resolver problemas del usuario
%
pause	%pulse una tecla para continuar
%
% Un M-file que contiene la palabra 'function' al comienzo
% de la primera linea del fichero es un 'fichero de funcion'.
%
% Una funcion se diferencia de un script o guion en que se le
% deben pasa argumentos y las variables definidas y manipuladas
% en su interior son locales. Por tanto se le deben definir 
% valores de retorno.
%
% Por ejemplo, en el fichero media.m se encuentra
% definida una funcion 'media' que calcula la media de un vector
%
%
pause	%pulse una tecla para continuar
%
% Para usarla, si z es un vector de enteros desde 1 a 99
%
z=1:99;
media(z)
%
pause	%pulse una tecla para continuar
%

% Ejercicio: Hacer una funcion que devuelva la media y la
% desviacion estandar

pause