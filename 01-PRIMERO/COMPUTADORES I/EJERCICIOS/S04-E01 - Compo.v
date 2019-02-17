module Comp2 (output wire mayor,
		output wire igual,
		output wire menor,
		input wire [1:0]a,
		input wire [1:0]b);
wire c0M,c0i,c0m,c1M,c1i,c1m,a1s,a2s;
	Comp1 c0(c0M,c0i,c0m,a[0],b[0]);
	Comp1 c1(c1M,c1i,c1m,a[1],b[1]);

	and a1(a1s,c1i,c0M);
	and a2(a2s,c1i,c0m);
	and a3(igual,c0i,c1i);
	or o1(mayor,c1M,a1s);
	or o2(menor,c1m,a2s);
endmodule
