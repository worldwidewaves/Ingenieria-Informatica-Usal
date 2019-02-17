#! /usr/bin/vvp
:ivl_version "0.9.7 " "(v0_9_7)";
:vpi_time_precision + 0;
:vpi_module "system";
:vpi_module "v2005_math";
:vpi_module "va_math";
S_0x22b5730 .scope module, "TestComp1" "TestComp1" 2 12;
 .timescale 0 0;
v0x22fb4e0_0 .net "M", 0 0, L_0x22fba00; 1 drivers
v0x22fb580_0 .var "a", 0 0;
v0x22fb630_0 .var "b", 0 0;
v0x22fb6e0_0 .net "igual", 0 0, L_0x22fbc00; 1 drivers
v0x22fb7c0_0 .net "m", 0 0, L_0x22fbb00; 1 drivers
S_0x22b5820 .scope module, "c" "Comp1" 2 16, 2 1, S_0x22b5730;
 .timescale 0 0;
L_0x22fb870 .functor NOT 1, v0x22fb580_0, C4<0>, C4<0>, C4<0>;
L_0x22fb950 .functor NOT 1, v0x22fb630_0, C4<0>, C4<0>, C4<0>;
L_0x22fba00 .functor AND 1, v0x22fb580_0, L_0x22fb950, C4<1>, C4<1>;
L_0x22fbb00 .functor AND 1, v0x22fb630_0, L_0x22fb870, C4<1>, C4<1>;
L_0x22fbc00 .functor NOR 1, L_0x22fba00, L_0x22fbb00, C4<0>, C4<0>;
v0x22eb3d0_0 .net "a", 0 0, v0x22fb580_0; 1 drivers
v0x22fb0d0_0 .net "b", 0 0, v0x22fb630_0; 1 drivers
v0x22fb170_0 .alias "igual", 0 0, v0x22fb6e0_0;
v0x22fb210_0 .alias "mayor", 0 0, v0x22fb4e0_0;
v0x22fb2c0_0 .alias "menor", 0 0, v0x22fb7c0_0;
v0x22fb360_0 .net "na", 0 0, L_0x22fb870; 1 drivers
v0x22fb440_0 .net "nb", 0 0, L_0x22fb950; 1 drivers
    .scope S_0x22b5730;
T_0 ;
    %vpi_call 2 20 "$monitor", $time, " a=%b, b=%b, mayor=%b, igual=%b, menor=%b", v0x22fb580_0, v0x22fb630_0, v0x22fb4e0_0, v0x22fb6e0_0, v0x22fb7c0_0;
    %set/v v0x22fb580_0, 0, 1;
    %set/v v0x22fb630_0, 0, 1;
    %delay 5, 0;
    %set/v v0x22fb580_0, 0, 1;
    %set/v v0x22fb630_0, 1, 1;
    %delay 5, 0;
    %set/v v0x22fb580_0, 1, 1;
    %set/v v0x22fb630_0, 0, 1;
    %delay 5, 0;
    %set/v v0x22fb580_0, 1, 1;
    %set/v v0x22fb630_0, 1, 1;
    %end;
    .thread T_0;
# The file index is used to find the file name in the following table.
:file_names 3;
    "N/A";
    "<interactive>";
    "Composo";
