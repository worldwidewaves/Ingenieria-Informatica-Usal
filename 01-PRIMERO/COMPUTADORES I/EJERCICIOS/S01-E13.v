module Ej13;
	//REGISTROS
	//Apartado a)
	reg reloj;
	reg [31:0] busA;
	reg signed [63:0] m;
	//Apartado b)
	reg [15:0] b;
	//Apartado c)
	reg [15:0] c;
	reg [15:0] c2;
	//Apartado d)
	reg [15:0] d;
	//Apartado e)
	reg signed [7:0] e;
	reg signed [15:0] e2;

	initial
	begin
		//ASIGNAR VALORES
		//Apartado a)
		reloj = 1 'b0;
		busA = 'hAAAABBBB;
		busA[7:4] = 4 'hC;
		m = -1;
		//Apartado b)
		b = 2323;
		//Apartado c)
		c = 'b1111_1111_1111_1111;
		c2 = 'b0000_0000_0000_0000;
		//Apartado d)
		d = 6789;
		//Apartado e)
		e = -22;
		e2 = -22;

		//MOSTRAR VALORES
		//Apartado a)
		$display("Ejercicio 13\n");
		$display("a) reloj en hexacedimal vale: %0h\n", reloj);
		$display("busA en hexacedimal vale: %0h\n", busA);
		$display("m (%0d en decimal) en hexacedimal vale: %0h\n\n", m, m);
		//Apartado b)
		$display("b) b (%0d en decimal) vale %0b en binario y %0h en hexadecimal\n\n", b, b, b);
		//Apartado c)
		$display("c) El número más alto que se puede almacenar en un registro de 16bits sin signo es %0h en hexadecimal, %0b en binario y %0d en decimal\n", c, c, c);
		$display("El número más bajo que se puede almacenar en un registro de 16bits sin signo es %0h en hexadecimal, %0b en binario y %0d en decimal\n\n", c2, c2, c2);
		//Apartado d)
		$display("d) El número %0d en decimal vale %b en complemento a dos (binario) en un registro de 16bits\n\n", d, d);
		//Apartado e)
		$display("e) El número %0d en decimal vale %0b en un registro de 8bits y %0b en uno de 16bits", e, e, e2);
	end
endmodule
	
