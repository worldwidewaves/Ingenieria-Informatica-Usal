function y = media(x)
% Devuelve el valor medio
% Para vectores, media(x) devuelve el valor medio
% Para matrices, media(x) es un vector fila que 
% contiene el valor medio de cada columna
%

[m,n] = size(x);
if m == 1
	m = n;
end
y = sum(x)/m;