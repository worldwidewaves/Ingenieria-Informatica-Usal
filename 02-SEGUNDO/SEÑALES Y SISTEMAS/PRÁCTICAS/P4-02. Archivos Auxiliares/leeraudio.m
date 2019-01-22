function [t,y,tfin]=leeraudio(cadena)
    [y,fs]=audioread(cadena);
    t=0:1/fs:(length(y)-1)/fs;
    tfin=(length(y)-1)/fs;
    y=y';