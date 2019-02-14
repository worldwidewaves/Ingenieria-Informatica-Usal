/*
01. Mandar los resultados de realizar la siguiente consulta a un fichero de cola al que
    daremos el nombre que estimemos. Devolver el nombre y los apellidos de todos los
    lectores que vivan en Salamanca y hayan realizado préstamos en el 2011. Para ello
    será necesario en SQL*Plus
        a. Mandar el Spool al fichero de cola identificado con el nombre elegido
        b. Realizar la consulta
        c. Cerrar el Spool y comprobar que ha sido cerrado
        d. Verificar que tenemos un archivo *.lst generado
*/
spool ej1
select nombre, ape_1, ape_2 from lector, prestamo where lector.provincia='SALAMANCA' and cod_lector=lector.codigo and to_char(fecha_ini,'yyyy')=2011;
spool off
show spool

/*
02. Generar un fichero de comandos que realice un listado de todos los préstamos
    ordenados por sucursales y para cada sucursal ordenar dichos préstamos
    cronológicamente.
*/
spool ej2
set echo off
select * from prestamo order by cod_suc, fecha_ini;
spool off
show spool

/*
03. Guardar en un fichero de comandos a través del comando save la siguiente
consulta: mostrar la información de todos los autores de los que o bien no se conoce
su fecha de nacimiento o de muerte. Para ello será necesario
    a. Realizar la consulta en el entorno de SQL*Plus
    b. Salvar el contenido del buffer indicando el nombre del fichero
       save nombre
    c. Verificar que se ha creado correctamente el archivo generado
       nombre.sql
*/
select * from autor where ano_nac is NULL or ano_fall is NULL;
save ej3
show spool

/*
04. Volver a cargar el fichero de comandos del ejercicio anterior y ejecutarlo activando
    la visualización del contenido a través del comando echo
*/
set echo on
start ej3

/*
05. Volver a realizar un archivo de comandos que saque el listado de todos los libros
    con los que cuenta la sucursal 1, 2 y 3 ordenados por ISBN y por sucursal,
    estableciendo pausas para su mejor visualización a través del comando pause.
*/
set pause on
spool ej5
select l.isbn, cod_suc as Sucursal, titulo from libro l, dispone d where l.isbn=d.isbn and cod_suc in (1,2,3) order by l.isbn, cod_suc;
spool off
show spool

/*
06. Volver a realizar un archivo de comandos que saque el listado de todos los libros
    con los que cuenta una sucursal, cuyo código se pasará como parámetro, ordenados
    por ISBN, estableciendo pausas para su mejor visualización a través del comando
    pause.
*/
75, 81 resultados

/*
07. Sacar la información de todos los autores de los que o bien no se conoce su fecha de
    nacimiento o de muerte indicando además su nacionalidad y no el código de ésta.
*/
59 resultados

/*
08. Ejecutaremos la consulta anterior con un formato que genere una salida más legible:
        a. Seleccione un tamaño de página igual a 50
        b. Seleccione un tamaño de línea igual a 80
        c. Añada un título en la parte superior de la página con el texto ‘Informe de
            autores’ y ‘con fechas no conocidas’ en dos líneas separadas.
        d. Añada un pie de página con el texto ‘SERVICIO DE BIBLIOTECAS’
        e. Formatee el apellido para que ocupe exactamente 12 caracteres.
        f. Formatee el nombre de las columnas ANO_NAC y ANO_FALL para
            que se muestre en cada caso el título ANO NACIMIENTO o ANO
            MUERTE en dos líneas separadas.
        g. Formatee la nacionalidad empleando NACION como título y fijando la
            longitud de los datos en 15 caracteres.
*/

/*
09. Volver a realizar la consulta anterior insertando ‘???’ en los lugares donde no se
    conoce la fecha de nacimiento o defunción de los autores.
*/