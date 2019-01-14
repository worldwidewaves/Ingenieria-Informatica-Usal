/* 
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */


function listing() {
    var tema = ["00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
    var ficha = ["01", "02", "03", "04", "05", "06", "07", "08"];
    var ntema = [
	"Introducci&oacute;n a la Programaci&oacute;n en C",
	 "Tipos Primitivos",
		"Tipos de Datos Estructurados Inhomogéneos (struct)",
		"Operadores Aritm&eacute;ticos, L&oacute;gicos y Relacionales",
		"Estructuras de Control",
		 "E/S básica (pantalla y teclado)",
		"Listas de tipos de datos estructurados",
		 "Punteros",
		"Subprogramas (funciones)",
		 "Bibliotecas de Funciones", 
		 "Tratamiento de Archivos",
		"Asignaci&oacute;n Din&aacute;mica de Memoria",
		 "Versiones Finales"];
    var tmp = "<table border = '1' class='t750' cellspacing='2' cellpadding='6'>";
    for (t = 0; t < tema.length; t++)
    {
        tmp += "<tr><td class='chapter_number'>" + t + "</td>";
        var num_tema = tema[t];
        var nombre_tema = ntema[t];
        tmp += "<td class='chapter_name'><a href='" + num_tema + "xx_PAGS/" + num_tema + "xx.html'>" + nombre_tema + "</a></td>";
        var directorio = tema[t] + "xx_PAGS/";
        for (f = 0; f < 8; f++)
        {
            base = num_tema + ficha[f];
            tmp += "<td class='form_number'><a href='" + directorio + base + ".html'>" + base + "</a></td>";
        }
        tmp += "</tr>";
    }
    tmp += "</table>";
    document.write(tmp);
    return tmp;
}
