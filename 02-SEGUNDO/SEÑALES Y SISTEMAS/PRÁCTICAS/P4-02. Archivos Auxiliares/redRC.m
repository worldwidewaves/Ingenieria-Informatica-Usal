function y=redRC(w,w0)
 % Función de transferencia de una red RC
 % Parametros de entrada:
 %   w  vector de frecuencias a evaluar
 %   w0 valor del ancho de banda de la red utilizando el criterio de 3dB
 y=1./(1+j*w./w0);