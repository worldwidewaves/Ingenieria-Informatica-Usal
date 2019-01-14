/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalidabasicajava;

import java.io.Console;
import java.util.Scanner;
/*
 * Nota: Comando+Mayús+I añade los import necesarios.
 */

/**
 *
 * @author coti
 */
public class EntradaSalidaBasicaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se declaran variables de todos los tipos primitivos y un descriptor
        // de String. Ojo: cadena es un puntero, aunque parece una variable
        // de tipo String, como ocurría en C++

        boolean var_boolean;
        char var_char;
        char char_list[] = new char[10];
        byte var_byte;
        short var_short;
        int var_int;
        long var_long;
        float var_float;
        double var_double;
        String cadena = null;
        //    ____                      _
        //   / ___|___  _ __  ___  ___ | | ___
        //  | |   / _ \| '_ \/ __|/ _ \| |/ _ \
        //  | |__| (_) | | | \__ \ (_) | |  __/
        //   \____\___/|_| |_|___/\___/|_|\___|
        //
        // Console permite escribir todos los tipos básicos
        // y leer fácilmente cadenas. Solo hay un problema: no funciona
        // desde dentro del IDE, hay que ejecutar el programa desde la
        // terminal.
        Console con = System.console();
        if (null != con) {
            con.printf("%s%n", "Hola, Mundo! desde Console");
            var_boolean = true;
            var_char = 'z';
            var_byte = -33;
            var_short = 1234;
            var_int = 65539;
            var_long = 1234567890;
            var_float = (float) Math.PI;
            var_double = Math.PI;
            con.printf("%d + %d = %d%n", 2, 3, 2 + 3);
            cadena = con.readLine("Por favor escriba su nombre y apellidos : ", cadena);
            con.printf("Se llama usted %s.%n", cadena);
            con.printf("var_boolean = %b%n", var_boolean); // %b para escribir boolean
            con.printf("var_char    = %c%n", var_char);
            con.printf("var_byte    = %d%n", var_byte);
            con.printf("var_short   = %d%n", var_short);
            con.printf("var_int     = %d%n", var_int);
            con.printf("var_long    = %d%n", var_long);
            con.printf("var_float   = %14.9f%n", var_float);
            con.printf("var_double  = %20.15f%n", var_double);
        } else {
            System.err.println("Perdón, no se puede usar la consola.");
        }
        
        
        //  ____
        // / ___|  ___  __ _ _ __  _ __   ___  _ __
        // \___ \ / __|/ _` | '_ \| '_ \ / _ \| '__|
        //  ___) | (__| (_| | | | | | | |  __/| |
        // |____/ \___|\__,_|_| |_|_| |_|\___||_|
        //
        Scanner scan = new Scanner(System.in);
        System.out.printf("Por favor, escriba un boolean : ");
        var_boolean = scan.nextBoolean();
        scan.nextLine();
        System.out.printf("Por favor, escriba un char    : ");
        cadena = scan.nextLine();
        var_char = cadena.charAt(0);
        System.out.printf("Por favor, escriba un byte    : ");
        var_byte = scan.nextByte();
        System.out.printf("Por favor, escriba un short   : ");
        var_short = scan.nextShort();
        System.out.printf("Por favor, escriba un int     : ");
        var_int = scan.nextInt();
        System.out.printf("Por favor, escriba un long    : ");
        var_long = scan.nextLong();
        System.out.printf("Por favor, escriba un float   : ");
        var_float = scan.nextFloat();
        System.out.printf("Por favor, escriba un double  : ");
        var_double = scan.nextDouble();
        scan.nextLine();
        System.out.printf("Por favor, escriba su nombre y apellidos : ");
        cadena = scan.nextLine();
        System.out.printf("Se llama usted %s%n", cadena);
        System.out.printf("var_boolean = %b%n", var_boolean);
        System.out.printf("var_char    = %c%n", var_char);
        System.out.printf("var_byte    = %d%n", var_byte);
        System.out.printf("var_short   = %d%n", var_short);
        System.out.printf("var_int     = %d%n", var_int);
        System.out.printf("var_long    = %d%n", var_long);
        System.out.printf("var_float   = %14.9f%n", var_float);
        System.out.printf("var_double  = %20.15f%n", var_double);
    }
}
/*
 *
 * Resultado de la ejecución en NetBeans (sin consola)

Perdón, no se puede usar la consola.
Por favor, escriba un boolean : true
Por favor, escriba un char    : ñ
Por favor, escriba un byte    : 1
Por favor, escriba un short   : 2
Por favor, escriba un int     : 3
Por favor, escriba un long    : 4
Por favor, escriba un float   : 5
Por favor, escriba un double  : 6
Por favor, escriba su nombre y apellidos : Juan Pérez
Se llama usted Juan Pérez
var_boolean = true
var_char    = ñ
var_byte    = 1
var_short   = 2
var_int     = 3
var_long    = 4
var_float   =    5,000000000
var_double  =    6,000000000000000
 * 
 * Obsérvese que este método de lectura es frágil, porque basta un pequeño
 * defecto en el formato de un dato para causar una excepción. Es mejor
 * leer con formato alfanumérico (mediante nexLine()) y traducir después
 * al formato de destino dentro de un bloque try-catch. De este modo se captura
 * la excepción y se puede repetir la lectura sin que se detenga el programa.
 * 
 * Este segundo método de lectura se estudiará próximamente.

 */