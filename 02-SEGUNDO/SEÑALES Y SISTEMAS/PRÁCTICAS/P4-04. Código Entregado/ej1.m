function []=ej1()
periodo= 5;
V= 5;
tau= 0.5;
desplazamientoTemporal= 0;
tMin= -30;
tMax= 30;
numeroArmonicos= 50;

[~, ~, vectorTiempo, valoresFunc]= rectangular_c(V,tau,periodo,tMin,tMax,numeroArmonicos,desplazamientoTemporal);
[vectorFrecuencias, coeficientesFourier]= espectro(vectorTiempo, valoresFunc, periodo);

sistema1= redRC(vectorFrecuencias, 4*pi/5);
sistema2= redRC(vectorFrecuencias, 4*pi);
sistema3= redRC(vectorFrecuencias, 200*pi);

G1= coeficientesFourier.*sistema1;
G2= coeficientesFourier.*sistema2;
G3= coeficientesFourier.*sistema3;


%%=====================================================
figure()
subplot(3, 1, 1);
plot(vectorTiempo, valoresFunc, "-b")
title("Representación Función")
xlabel("Tiempo") 
ylabel("Valor") 

%%-----------------------------------------------------
subplot(3, 1, 2);
plot(vectorTiempo, coeficientesFourier, "-g")
title("Coeficientes Fourier")
xlabel("Tiempo") 
ylabel("Coeficiente") 


%%-----------------------------------------------------
subplot(3, 1, 3);
plot(vectorTiempo, vectorFrecuencias, "-r")
title("Frecuencias")
xlabel("Tiempo") 
ylabel("Frecuencia (rad/s)") 


sgtitle("Función, Coeficientes de Fourier y Frecuencias")


%%=====================================================
figure()
subplot(3, 2, 1);
plot(vectorFrecuencias, abs(sistema1), "-g");
title("Espectro de Amplitud [4*pi/5]")
xlabel("w") 
ylabel("abs(sistema1)") 

subplot(3, 2, 2);
plot(vectorFrecuencias, angle(sistema1), "-g");
title("Espectro de Fase [4*pi/5]")
xlabel("w") 
ylabel("angle(sistema1)") 

%%-----------------------------------------------------
subplot(3, 2, 3);
plot(vectorFrecuencias, abs(sistema2), "-r");
title("Espectro de Amplitud [4*pi]")
xlabel("w") 
ylabel("abs(sistema2)") 

subplot(3, 2, 4);
plot(vectorFrecuencias, angle(sistema2), "-r");
title("Espectro de Fase [4*pi]")
xlabel("w") 
ylabel("angle(sistema2)") 

%%-----------------------------------------------------
subplot(3, 2, 5);
plot(vectorFrecuencias, abs(sistema3), "-c");
title("Espectro de Amplitud [200*pi]")
xlabel("w") 
ylabel("abs(sistema3)") 

subplot(3, 2, 6);
plot(vectorFrecuencias, angle(sistema3), "-c");
title("Espectro de Fase [200*pi]")
xlabel("w") 
ylabel("angle(sistema3)") 


sgtitle("Espectros de Amplitud y Fase")


%%=====================================================
figure()
subplot(2, 2, 1);
plot(vectorFrecuencias, coeficientesFourier, "-b");
title("F")
xlabel("w") 
ylabel("F") 

subplot(2, 2, 2);
plot(vectorFrecuencias, G1, "-g");
title("G1 [4*pi/5]")
xlabel("w") 
ylabel("G1") 

subplot(2, 2, 3);
plot(vectorFrecuencias, G2, "-r");
title("G2 [4*pi]")
xlabel("w") 
ylabel("G2") 

subplot(2, 2, 4);
plot(vectorFrecuencias, G3, "-c");
title("G3 [200*pi]")
xlabel("w") 
ylabel("G3") 

sgtitle("Espectros de Frecuencia")


%%=====================================================
figure()
[t,f]=inv_espectro(vectorFrecuencias, coeficientesFourier, 5);
subplot(4, 1, 1);
plot(t, f, "-b");
title("F1")
xlabel("t") 
ylabel("f")

[t,f]=inv_espectro(vectorFrecuencias, G1, 5);
subplot(4, 1, 2);
plot(t, f, "-g");
title("G1 [4*pi/5]")
xlabel("t") 
ylabel("f")

[t,f]=inv_espectro(vectorFrecuencias, G2, 5);
subplot(4, 1, 3);
plot(t, f, "-r");
title("G2 [4*pi]")
xlabel("t") 
ylabel("f")

[t,f]=inv_espectro(vectorFrecuencias, G3, 5);
subplot(4, 1, 4);
plot(t, f, "-c");
title("G3 [200*pi]")
xlabel("t") 
ylabel("f")

sgtitle("Señales en el dominio del tiempo")

