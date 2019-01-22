function escribiraudio(cadena,y)
% PARAMETROS
%     cadena    nombre fichero de salida
%     y         señal en el tiempo de audio
    audiowrite(cadena,y,44100);
    