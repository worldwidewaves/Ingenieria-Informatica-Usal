function y=H5(w)
% Función de transferencia que produce distorsiones de atenuación y retardo en una señal 
% PARÁMETROS:
%     w valores de frecuencia.

y=sin(w/20)*exp(-j*0.005*w.^3);