function H=FiltroB(w)
     [b,a]=butter(8,30000,'high','s');
     H=freqs(b,a,w);
end