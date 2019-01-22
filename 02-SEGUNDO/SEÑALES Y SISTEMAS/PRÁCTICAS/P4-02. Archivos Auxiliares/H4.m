function y=H4(w)
% Función de transferencia que produce distorsion de retardo en una señal sin atenuarla
% PARÁMETROS:
%     w valores de frecuencia.

y=exp(-j*0.005*w.^3);