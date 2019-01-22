function []=ej2()
tMin= 0;
tMax= 4;

resolucion= pi/60; %Tiempo entre dos valores consecutivos de la representacion
t= tMin:resolucion:tMax; %Dominio temporal de representacion

frecArm1= 2*pi;
frecArm2= 6*pi;
frecArm3= 8*pi;

ampArm1= 1;
ampArm2= -1/3;
ampArm3= 1/4;

faseArm1= 0;
faseArm2= 0;
faseArm3= 0;


%%=====================================================
valoresArm1= ampArm1 * cos(frecArm1 * t + faseArm1);
valoresArm2= ampArm2 * cos(frecArm2 * t + faseArm2);
valoresArm3= ampArm3 * cos(frecArm3 * t + faseArm3);

figure()
subplot(4, 1, 1);
plot(t, valoresArm1, "-b");
title("Armónico 1 (coseno)")
xlabel("Tiempo") 
ylabel("Valores Armónico 1")

subplot(4, 1, 2);
plot(t, valoresArm2, "-g");
title("Armónico 2 (coseno)")
xlabel("Tiempo") 
ylabel("Valores Armónico 2")

subplot(4, 1, 3);
plot(t, valoresArm3, "-r");
title("Armónico 3 (coseno)")
xlabel("Tiempo") 
ylabel("Valores Armónico 3")

valoresSuma= valoresArm1 + valoresArm2 + valoresArm3;
subplot(4, 1, 4);
plot(t, valoresSuma, "-c");
title("Suma")
xlabel("Tiempo") 
ylabel("Valores Suma")

sgtitle("Armónicos y Suma")


%%=====================================================
intervaloFrec= 0:resolucion:10*pi;
sistemaH1= H1(intervaloFrec);
sistemaH2= H2(intervaloFrec);
sistemaH3= H3(intervaloFrec);
sistemaH4= H4(intervaloFrec);
sistemaH5= H5(intervaloFrec);

figure()
subplot(3, 4, 1);
plot(intervaloFrec, abs(sistemaH1), "-b");
title("Espectro de Amplitud H1")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H1") 

subplot(3, 4, 2);
plot(intervaloFrec, angle(sistemaH1), "-b");
title("Espectro de Fase H1")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H1")

%%-----------------------------------------------------
subplot(3, 4, 3);
plot(intervaloFrec, abs(sistemaH2), "-g");
title("Espectro de Amplitud H2")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H2") 

subplot(3, 4, 4);
plot(intervaloFrec, angle(sistemaH2), "-g");
title("Espectro de Fase H2")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H2")

%%-----------------------------------------------------
subplot(3, 4, 5);
plot(intervaloFrec, abs(sistemaH3), "-r");
title("Espectro de Amplitud H3")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H3") 

subplot(3, 4, 6);
plot(intervaloFrec, angle(sistemaH3), "-r");
title("Espectro de Fase H3")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H3")

%%-----------------------------------------------------
subplot(3, 4, 7);
plot(intervaloFrec, abs(sistemaH4), "-c");
title("Espectro de Amplitud H4")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H4") 

subplot(3, 4, 8);
plot(intervaloFrec, angle(sistemaH4), "-c");
title("Espectro de Fase H4")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H4")

%%-----------------------------------------------------
subplot(3, 4, 9);
plot(intervaloFrec, abs(sistemaH5), "-m");
title("Espectro de Amplitud H5")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H5") 

subplot(3, 4, 10);
plot(intervaloFrec, angle(sistemaH5), "-m");
title("Espectro de Fase H5")
xlabel("Intervalo Frecuencias") 
ylabel("Sistema H5")


sgtitle("Amplitud y Fase")

%%=====================================================
figure()
subplot(4, 1, 1);
plot(t, valoresArm1, "-k");
title("Original")

subplot(4, 1, 2);
plot(t, valoresArm2, "-k");

subplot(4, 1, 3);
plot(t, valoresArm3, "-k");

valoresSuma= valoresArm1 + valoresArm2 + valoresArm3;
subplot(4, 1, 4);
plot(t, valoresSuma, "-k");

%%-----------------------------------------------------
figure()
subplot(4, 1, 1);
sistema1H1= H1(frecArm1);
valoresArm1G1= ampArm1 * abs(sistema1H1) * cos(frecArm1 .* t + faseArm1 + angle(sistema1H1));
plot(t, valoresArm1G1, "-b");
title("H1")

subplot(4, 1, 2);
sistema2H1= H1(frecArm2);
valoresArm1G2= ampArm2 * abs(sistema2H1) * cos(frecArm2 .* t + faseArm2 + angle(sistema2H1));
plot(t, valoresArm1G2, "-b");

subplot(4, 1, 3);
sistema3H1= H1(frecArm3);
valoresArm1G3= ampArm3 * abs(sistema3H1) * cos(frecArm3 .* t + faseArm3 + angle(sistema3H1));
plot(t, valoresArm1G3, "-b");

subplot(4, 1, 4);
sumaH1= valoresArm1G1 + valoresArm1G2 + valoresArm1G3;
plot(t, sumaH1, "-b");

%%-----------------------------------------------------
figure()
subplot(4, 1, 1);
sistema1H2= H2(frecArm1);
valoresArm2G1= ampArm1 * abs(sistema1H2) * cos(frecArm1 .* t + faseArm1 + angle(sistema1H2));
plot(t, valoresArm2G1, "-g");
title("H2")

subplot(4, 1, 2);
sistema2H2= H2(frecArm2);
valoresArm2G2= ampArm2 * abs(sistema2H2) * cos(frecArm2 .* t + faseArm2 + angle(sistema2H2));
plot(t, valoresArm2G2, "-g");

subplot(4, 1, 3);
sistema3H2= H2(frecArm3);
valoresArm2G3= ampArm3 * abs(sistema3H2) * cos(frecArm3 .* t + faseArm3 + angle(sistema3H2));
plot(t, valoresArm2G3, "-g");

subplot(4, 1, 4);
sumaH2= valoresArm2G1 + valoresArm2G2 + valoresArm2G3;
plot(t, sumaH2, "-g");

%%-----------------------------------------------------
figure()
subplot(4, 1, 1);
sistema1H3= H3(frecArm1);
valoresArm3G1= ampArm1 * abs(sistema1H3) * cos(frecArm1 .* t + faseArm1 + angle(sistema1H3));
plot(t, valoresArm3G1, "-r");
title("H3")

subplot(4, 1, 2);
sistema2H3= H3(frecArm2);
valoresArm3G2= ampArm2 * abs(sistema2H3) * cos(frecArm2 .* t + faseArm2 + angle(sistema2H3));
plot(t, valoresArm3G2, "-r");

subplot(4, 1, 3);
sistema3H3= H2(frecArm3);
valoresArm3G3= ampArm3 * abs(sistema3H3) * cos(frecArm3 .* t + faseArm3 + angle(sistema3H3));
plot(t, valoresArm3G3, "-r");

subplot(4, 1, 4);
sumaH3= valoresArm3G1 + valoresArm3G2 + valoresArm3G3;
plot(t, sumaH3, "-r");

%%-----------------------------------------------------
figure()
subplot(4, 1, 1);
sistema1H4= H4(frecArm1);
valoresArm4G1= ampArm1 * abs(sistema1H4) * cos(frecArm1 .* t + faseArm1 + angle(sistema1H4));
plot(t, valoresArm4G1, "-c");
title("H4")

subplot(4, 1, 2);
sistema2H4= H4(frecArm2);
valoresArm4G2= ampArm2 * abs(sistema2H4) * cos(frecArm2 .* t + faseArm2 + angle(sistema2H4));
plot(t, valoresArm4G2, "-c");

subplot(4, 1, 3);
sistema3H4= H4(frecArm3);
valoresArm4G3= ampArm3 * abs(sistema3H4) * cos(frecArm3 .* t + faseArm3 + angle(sistema3H4));
plot(t, valoresArm4G3, "-c");

subplot(4, 1, 4);
sumaH4= valoresArm4G1 + valoresArm4G2 + valoresArm4G3;
plot(t, sumaH4, "-c");

%%-----------------------------------------------------
figure()
subplot(4, 1, 1);
sistema1H5= H5(frecArm1);
valoresArm5G1= ampArm1 * abs(sistema1H5) * cos(frecArm1 .* t + faseArm1 + angle(sistema1H5));
plot(t, valoresArm5G1, "-m");
title("H5")

subplot(4, 1, 2);
sistema2H5= H5(frecArm2);
valoresArm5G2= ampArm2 * abs(sistema2H5) * cos(frecArm2 .* t + faseArm2 + angle(sistema2H5));
plot(t, valoresArm5G2, "-m");

subplot(4, 1, 3);
sistema3H5= H5(frecArm3);
valoresArm5G3= ampArm3 * abs(sistema3H5) * cos(frecArm3 .* t + faseArm3 + angle(sistema3H5));
plot(t, valoresArm5G3, "-m");

subplot(4, 1, 4);
sumaH5= valoresArm5G1 + valoresArm5G2 + valoresArm5G3;
plot(t, sumaH5, "-m");