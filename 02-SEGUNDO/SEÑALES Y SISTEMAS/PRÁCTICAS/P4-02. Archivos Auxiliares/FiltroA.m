function H=FiltroA(w)
     [b,a]=butter(8,5000,'low','s');
     H=freqs(b,a,w);
end