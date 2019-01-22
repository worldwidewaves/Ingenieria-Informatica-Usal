function [w,coef]=rectangular(V,tau,T,tmin,tmax,m)
%
%Funcion para sumar la serie de Fourier de un tren de pulsos rectangulares
%Version sin desplazamiento

%coef: vector con los coeficientes de la serie
%w: vector con las frecuencias de los armonicos

%V: amplitud de los pulsos
%tau: ancho de los pulsos
%T: periodo de la señal
%tmin: tiempo inicial de la representacion
%tmax: tiempo final de la representacion
%m: numero de armonicos

resolucion=pi/1000; %Tiempo entre dos valores consecutivos de la representacion
t=tmin:resolucion:tmax; %Dominio temporal de representacion

y=zeros(1,length(t));
coef=zeros(1,m+1);
w=zeros(1,m);
 
%Sumatorio de la serie de Fourier
for n=1:m
    w(n+1)=(2*pi*n)/T;
    coef(n+1)=V*tau*(sin((tau*w(n+1))/2)/((tau*w(n+1))/2));
    y=y+coef(n+1)*cos(w(n+1)*t);
end

%Añado en coef(1) el coeficiente c0 (armonico para frecuencia cero)
w(1)=0;
coef(1)=V*tau;

%Serie de Fourier completa
y=(2/T)*y+coef(1)/T;

figure(1)
plot(t,y, 'r');grid
title('Representacion del tren de pulsos rectangulares en el dominio del tiempo');
xlabel('tiempo');
ylabel('voltaje');

