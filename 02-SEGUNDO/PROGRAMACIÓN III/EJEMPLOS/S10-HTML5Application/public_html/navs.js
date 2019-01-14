/* 
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
function bignav(name, url){
var tmp = "<table class='t750' border='1' cellspacing='2' cellpadding='0'><tr><td class='w33c'><a name='top'></a>" +
		"<a href='" + url[0] +"'>" + name[0] + "</a></td>" +
		"<td class='w33c'><a href=' " + url[1] +"'>" + name[1] +"</a></td>" +
		"<td class='w33c'><span class='big_marker'>" + name[2] +"</span></td></tr></table>";
   return tmp;
}

function bignav_theme(name, url){
var tmp = "<table class='t750' border='1' cellspacing='2' cellpadding='2'><tr><td class='centradon'><a name='top'></a>" +
		"<a href='" + url[0] + "'>TEMA ANTERIOR</a></td><td class='centradon'><a href='../MAIN.html'>LISTA DE TEMAS</a></td>" +
		"<td class='centradon'><a href='" + url[1] + "'>TEMA SIGUIENTE</a></td>" +
		"<td class='centrado'><span class='big_marker'>" + name[2] + "</span></td></tr></table>";
	return tmp;
}

function smallnav(n){
	var tmp = "<table border='1' class='t750' cellspacing='2' cellpadding='0'><tr>";
	for( i=0; i < n.length;  i++)
		{
			tmp += "<td class='tc'><a href='" + n[i] + ".html'>" + n[i] + "</a></td>";
		}
	tmp += "</tr></table>";
	return tmp;
}
