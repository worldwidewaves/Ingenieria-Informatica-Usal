module Ej11;
	initial
	begin
		//IMPRIMIR VALORES DE GOLPE (SIN VARIABLES)
		$display("Ejercicio 11\n");
		$display("a) %0h (hexadecimal) en decimal es: %0d\n", 'h1FEA, 'h1FEA);
		$display("b) %0b (binario) en decimal es: %0d\n", 'b1000101, 'b1000101);
		$display("c) %0d (decimal) en octal es: %0o\n", 'd1234, 'd1234);
		$display("d) %0b (binario) en hexadecimal es: %0h\n", 'b1010011, 'b1010011);
	end
endmodule
