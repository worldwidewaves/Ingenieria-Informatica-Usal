module Ej20;
	//REGISTROS
	reg [15:0] a;
	reg [15:0] b;	
	reg [15:0] c;
	
	initial
	begin
		//ASIGNAR VALORES
		a = 'b0000_1111_xxxx_zzzz;
		b = a + a;
		c = a * a;
		
		//IMPRIMIR EN PANTALLA
		$display("El valor del registro en binario es %b", a);
		$display("El registro más sí mismo es: %b + %b = %b", a, a, b);
		$display("El registro por sí mismo es: %b * %b = %b", a, a, c);	
	end
endmodule
