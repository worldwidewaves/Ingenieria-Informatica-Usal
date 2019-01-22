clc
echo on
%Sesion practica de manejo de matrices usando Matlab   
% Se comienza con la declaracion de la matriz que aparece en el cuadro
% Melancholia I de Durero (1514)
pause %pulse una tecla para continuar
%
%
A=[16 3 2 13; 5 10 11 8; 9 6 7 12; 4 15 14 1]
%
%     Esta matriz es magica... 
%
pause %pulse una tecla para continuar
%
%
%
%Se puede referir a los elementos de la matriz A con la notacion comun
%
A(1,1) + A(2,1) + A(3,1) + A(4,1)
%
%  MATLAB utiliza la variable ans (answer) para almacenar el resultado
%   de un calculo cuando no se ha especificado una variable de salida
%
pause %pulse una tecla para continuar
%
%
%
%Una forma mas rapida de calcular esta suma es con el operador :
%
1:4
%y con el comando sum
%
sum(A(1:4,1))
%
pause %pulse una tecla para continuar
%
%
%
%Se puede acortar de la siguiente forma
%
sum(A(:,1))
%
%si se aplica el comando sum a toda la matriz A
sum(A)
%
%la matriz es magica porque la suma de cada columna es 34
%
pause %pulse una tecla para continuar
%
%
%que ocurre con las filas?
%El apostrofe ' actua como el operador de matriz transpuesta en MATLAB
%
B=A'
%
%Asi se suman facilmente cada una de las filas de A siendo el resultado
sum(B)
%
pause %pulse una tecla para continuar
%
%
%
%Con el comando diag(A) se extrae la diagonal principal de A
%
diag(A)
%
%Si sumamos este vector obtenemos 34
%
sum(ans)
pause %pulse una tecla para continuar
%
%
%
%Incluso se pueden ejecutar estos dos ultimos comandos juntos
%
%
sum(diag(A))
pause %pulse una tecla para continuar
%
%
%
%Para sumar los elementos de la antidiagonal se utiliza la funcion fliplr
%
%
B=fliplr(A)
%
%se obtiene la matriz rotada de izquierda a derecha
%
sum(diag(fliplr(A)))
pause %pulse una tecla para continuar
%
%
%
%Se pueden calcular los autovalores donde aparece de nuevo 34
%
%
eig(A)
pause %pulse una tecla para continuar
%
%
%
% Con el comando who se listan las variables del espacio de trabajo actual
%
%
who
pause %pulse una tecla para continuar
%Para tener mas informacion
%
whos
% Para eliminar una variable del espacio de trabajo
%
clear A
%Para eliminarlas todas
%
clear
pause %pulse una tecla para continuar
%
%
%
%MATLAB dispone de una funcion para crear matrices magicas de cualquier tamano
%
B=magic(4)
% Esta matriz es similar a la inicial pero estan intercambiadas las dos columnas del medio
%
% para obtener la matriz inicial
C=B(:,[1 3 2 4])   
pause %pulse una tecla para continuar
clc
%
%
%
% Los elementos de una matriz pueden ser expresiones
%
%
x = [-1.3 sqrt(3) (1+2+3) *4/5]
pause %pulse una tecla para continuar
%
% Para referenciar elementos de una matriz se utiliza un indice entre ( )
%
x(5) = abs(x(1))
%
% Asi se anade un elemento a una matriz. 
% Como no se especifica el cuarto elemento este se pone a 0 por defecto
%
pause %pulse una tecla para continuar
%
% El comando length permite conocer la longitud de un vector
length(x)
% vector de longitud 5
%
% El comando size permite conocer las dimensiones (n_filas, n_columnas)
% de una matriz
%
B=magic(4);
size(B)
%
% siendo B una matriz de 4 filas y 4 columnas
%
pause %pulse una tecla para continuar
clc
%
%
% MATLAB tambien permite utilizar numeros complejos
%
3 + 4*i
%
%
pause %pulse una tecla para continuar
%
% Dos formas de introducir una matriz compleja
%
A = [1 2; 3 4] + i*[5 6; 7 8]
%
A = [1+5*i 2+6*i; 3+7*i 4+8*i]
%
% se obtiene el mismo resultado
%
pause %pulse una tecla para continuar
clc
%
% Otro ejemplo es evaluar la formula de Euler [ exp(i*x) = cos(x) + i*sin(x)]
% en x = 1+i
%
exp(i*(1+i))
%
cos(1+i) + i*sin(1+i)
%
% Estas dos expresiones son equivalentes tal y como predijo Euler
pause %pulse una tecla para continuar
clc
%
%
% Operaciones con matrices cuadradas que son validas para vectores
%
% Suma +;  Resta -;  Multiplicacion *;  Division derecha /; 
% Division izquierda \;  Potencia ^
%
A = [1 2 3; 4 5 6];
B = [0 1 2; 4 5 6];
%
C = A + B
%
C = A - B
pause %pulse una tecla para continuar
%
% Tambien se le puede sumar o restar un escalar a todos los 
% elementos de una matriz
%
D = A + 2
pause %pulse una tecla para continuar
%
% La transpuesta se obtiene con el apostrofo '
%
C = A'
%
pause %pulse una tecla para continuar
%
% Para una matriz compleja Z, Z' es la transpuesta de la  
% matriz compleja conjugada. 
%
Z = [1+5*i 2+6*i; 3+7*i 4+8*i];
Z'
%
pause %pulse una tecla para continuar
%
%
% Para obtener la transpuesta no conjugada se hace con
%             Z.'   o   conj(Z)
Z.'
%
conj(Z)'
%
pause %pulse una tecla para continuar
%
% Se puede calcula el producto de dos matrices X*Y si 
% el numero de columnas de X coincide con el de filas de Y
%
%
% El producto de dos vectores
X = [1 2 3]; Y = [4 5 6]';
X*Y
%
pause %pulse una tecla para continuar
%
%El producto de una matriz por un vector
%
A = [1 2 3;4 5 6;7 8 0]; x=[2;4;6]
A * x
%
% Multiplicar un escalar por una matriz
%
pi*x
%
pause %pulse una tecla para continuar
%
% Hay dos formas de realizar la division: por la derecha /
%                                         por la izquierda \
B=A';
B/A
A\B
% 
%Un punto . seguido por un operador indica una operacion elemento a elemento
%
x = [1 2 3]; y = [4 5 6];
%
z = x.*y
%
%
pause %pulse una tecla para continuar
% El simbolo .^ denota la potencia elemento por elemento de un vector
%
x = [1 2 3];y=[4 5 6];
z=x.^y;
%
% El exponente puede ser un escalar
%
z=x.^2
pause %pulse una tecla para continuar
%
% o la base puede ser un escalar
%
z= 2 .^[x y]
%
% es necesario un espacio antes del punto
%
pause %pulse una tecla para continuar
clc
%
% Para salir de MATLAB se teclea quit o exit
%
% Para abortar la ejecucion manualmente pulsar ctrl + C
% Al salir desaparece el espacio de trabajo
% Si se desea salvar el espacio de trabajo teclear
%        save
% entonces queda salvado en un fichero llamado matlab.mat
%
%
% Para recuperar el espacio de trabajo se utiliza
%       load
%
% Se puede salvar y recuperar el espacio de trabajo en otros ficheros
% distintos del estandar, con los comandos
%      save nombre-fichero,  load nombre-fichero
%
pause %pulse una tecla para continuar
%
% Con el comando what se listan los ficheros .m y .mat 
%
what
%
pause %pulse una tecla para continuar
%
save
what
%
pause %pulse una tecla para continuar
clc
%
% Operadorea relacionales
%
%   <  Menor que
%   <= Menor o igual que
%   >  Mayor que 
%   >= Mayor o igual que
%   == Igual a
%   ~= Distinto de
%
% Efectuan la comparacion elemento a elemento  entre dos matrices dando
% como resultado una matriz de la misma dimension y cuyos elementos son unos
% y ceros, si la relacion es cierta o falsa respectivamente.
%
% Los operadores relacionales pueden mostrar que elementos de una matriz
% satisfacen algunas condiciones
%
pause %pulse una tecla para continuar
%
% Por ejemplo, calculamos los elementos de la matriz magica de dimension 6
% que son divisibles entre 3
%
A = magic(6)
rem(A,3)
P= (rem(A,3)==0)
%
pause %pulse una tecla para continuar
%
% Una funcion interesante al trabajar con operadores relacionales es
% la funcion find, que permite determinar los elementos no nulos de
% una matriz 0-1 y, por tanto, los datos que satisfacen alguna condicion
% relacional
%
pause %pulse una tecla para continuar
%
% por ejemplo, calculamos los elementos de un vector x menores que 3.0
%
x=[1 2 3 4 5 6];
%
x<3.0
%
find(x<3.0)
%
pause %pulse una tecla para continuar
%
% Operadores logicos
%
% MATLAB dispone de tres operadores logicos que se emplean normalmente 
% con matrices 0-1
%                       & AND
%                       | OR
%                       ~ NOT
%
pause %pulse una tecla para continuar
%
% Por ejemplo:
A=[1 2 3; 4 5 6;7 8 9];
B=A';
%
C=A>B
%
D=A<B
%
pause %pulse una tecla para continuar
%
C&D
%
pause %pulse una tecla para continuar
%
C|D
%
%
pause %pulse una tecla para continuar
%
~D
%
pause %pulse una tecla para continuar
%
%
% Estos operadores se pueden utilizar junto con las funciones any, all
%
% Si x es un vector 0-1, any(x) devuelve uno si algun elemento es distinto
% de cero y cero en caso contrario.
%
% all(x) devuelve uno si todos los elementos de x son distintos de cero
%
pause %pulse una tecla para continuar
%
any(~D)
%
all(~D)
%
pause %pulse una tecla para continuar
clc
%
% Vectores y submatrices
%
% Un vector se define:
% 
%    v=a:b:c 
x=0.0:0.2:1.0
%
% Una forma para crear una tabla es:
x=(0.0:0.2:1.0)';
y=exp(-x).*sin(x);
[x y]
pause %Pulse una tecla para continuar
clc
% 
% Crear submatrices 
%
% A(a:b,c:d)
%
A=[1 2;3 4;5 6]
A(:,2)
%
% La segunda columna de la matriz A
%
% A(:) representa todos los elementos de A en forma de vector columna
% si aparece al lado derecho de una sentencia de asignacion
%
b=A(:)
%
% Si aparece al lado izquierdo de la sentencia de asignacion sirve 
% para modificar el contenido de la matriz A
%
A(:)=11:16
pause %Pulse una tecla para continuar
clc


% De nuevo con el comando whos se puede ver informacion de todas la varibles
% utilizadas
%
whos
pause
%
% Como se puede ver, todas ellas en este momento son de tipo doble array pero
% algunas de ellas, las calculadas a partir de compraciones, son logicas.
% existen varios tipos de datos
%   char    -caracter
%   single  -precision simple
%   double  -doble precision
%   uint8   -entero de 8 bits sin signo
%   uint16  -entero de 16 bits sin signo
%   uint32  -entero de 32 bits sin signo
%   int8    -entero de 8 bits con signo
%   int16   -entero de 16 bits con signo
%   int32   -entero de 32 bits con signo
% Para convertir una variable al tipo deseado se realiza de la sigiente forma
%
a=uint32(A);
pause
%
% Si miramos ahora las variables utilizadas vemos que a es del tipo deseado
%
whos
pause
%
% De forma similar se puede hacer que una variable sea interpretada como logica
% para ser utilizada como vector 0-1
% Los vectores 0-1 sirven para referenciar elementos de una matriz
% Asi si A es una matriz m x n y L es un vector de longitud m de 0-1
% A(L,:) especifica las filas de A donde los elementos de L no son nulos
%
L=logical([1 0 1 0]);
A=[1 2 3;4 5 6;7 8 9;1 2 3]
A(L,:)
pause %Pulse una tecla para continuar
% Si queremos eliminar de un vector los elementos superiores 
% a la desviacion standard
x=[1 2 4 5 6 -1 -2 -3 -4 0 5 1 9]
x<=std(x)
x=x(x<=std(x))
pause %Pulse una tecla para continuar
clc
%
%
% Como ejercicio reemplazar la matriz A con aquellas de sus filas 
% cuyo tercera columna sea mayor que 5
%
pause %pulse una tecla para continuar
