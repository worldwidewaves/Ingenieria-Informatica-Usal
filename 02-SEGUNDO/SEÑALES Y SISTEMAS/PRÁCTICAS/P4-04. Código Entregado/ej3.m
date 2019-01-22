function []=ej3()
[t,f,tfin]=leeraudio('audio1.wav');
[w,F]=espectro(t,f,tfin);

figure()
plot(w, F, "-b");
title("Espectro de Amplitud sin Filtro")

figure()
plot(w, angle(F), "-b");
sgtitle("Espectros de Frecuencia sin Filtro")

figure()
plot(t, f, "-b");
title("Audio sin Filtro")

sound(f,44100)

%%=====================================================
HA=FiltroA(w);
figure()
plot(w, HA, "-g");
title("Espectro de Amplitud tras Filtro A")

figure()
G1= F.*HA;
plot(w, G1, "-g");
sgtitle("Espectros de Frecuencia tras Filtro A")

figure()
[t2,f2]=inv_espectro(w, G1, tfin);
plot(t2, f2, "-g");
title("Audio tras Filtro A")

sound(f2,44100)


%%=====================================================
HB=FiltroB(w);
figure()
plot(w, HB, "-r");
title("Espectro de Amplitud tras Filtro B")

figure()
G2= F.*HB;
plot(w, G2, "-r");
sgtitle("Espectros de Frecuencia tras Filtro B")

figure()
[t3,f3]=inv_espectro(w, G2, tfin);
plot(t3, f3, "-r");
title("Audio tras Filtro B")

sound(f3,44100)