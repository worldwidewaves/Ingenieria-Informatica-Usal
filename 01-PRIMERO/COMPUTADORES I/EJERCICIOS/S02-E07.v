module ej7;
	reg [15:0] inicial;
	
	initial
	begin
		inicial=16'b0110_0111_0111_0110;
		$display("BITRESET: %b & %b = %b",
				inicial,
				16'b11111000_1111111,
				inicial & 16'b11111000_1111111);
	end
endmodule
