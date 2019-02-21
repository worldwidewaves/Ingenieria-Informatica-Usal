/*
PRÁCTICAS SISTEMAS DE BASES DE DATOS
*/

/*
SESIÓN 1: Introducción
*/ 

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

/*
SESIÓN 2: Modificaciones de Información
*/
set autocommit on

/*
01. Aumentar en 3 el número de ejemplares del libro con ISBN 5025496 para la
    sucursal 9. Comprobar que la actualización ha sido correcta.
*/
update dispone
set num_ejemplares = num_ejemplares + 3, licornum_disponibles = num_disponibles + 3
where ISBN = 5025496 and cod_suc = 9;

/*
02. El lector con código 7395860 ha cambiado su dirección a la C/Sevilla, 1 de
    Aldeadávila en la provincia de Salamanca. Actualice sus datos en la base de datos.
*/
update lector
set direccion = 'C/Sevilla, 1', poblacion = 'Aldeadávila', provincia = 'SALAMANCA'
where codigo = 7395860;

/*
03. Actualizar la tabla SUCURSAL la sucursal con código 15 para que pase a estar
    ubicada en la ciudad de SEGOVIA con dirección en C/ SAN AGUSTÍN, 10.
*/
update sucursal
set direccion = 'C/San Agustín, 10', poblacion = 'Segovia', provincia = 'SEGOVIA'
where codigo = 15;

/*
04. Actualizar la dirección de los lectores con códigos 71259836 y 94246322 a Av. de
    Alemania, 49, Miajadas, Cáceres y Daoiz y Velarde, 24, Benavente, Zamora,
    respectivamente.
*/
update lector
set direccion = 'Av. de Alemania, 49', poblacion = 'Miajadas', provincia = 'CACERES'
where codigo = 71259836;
update lector
set direccion = 'Daoiz y Velarde, 24', poblacion = 'Benavente', provincia = 'ZAMORA'
where codigo = 94246322;

/*
05. Se acaban de comprar 15 ejemplares, 1 para cada una de las 15 sucursales, del
    premio Planeta 2001 titulada ‘EL PREMIO ERES TÚ’ con ISBN 8408104829
    escrita por de Javier Moro (Madrid, 1955) y publicada por la editorial Planeta en el
    2001. Realizar su inserción en el sistema añadiendo los datos correspondientes en
    todas las tablas que sea necesario.
*/
insert into autor (codigo, nombre, apellido, ano_nac, cod_nacion) values (159, 'JAVIER', 'MORO', 1955, 9);
insert into escribe values (159, 8408104829);
insert into editorial values (12, 'PLANETA');
insert into libro values (8408104829, 'EL PREMIO ERES TU', 2011, 12);
insert into dispone values (1, 8408104829, 1, 1);
insert into dispone values (2, 8408104829, 1, 1);
insert into dispone values (3, 8408104829, 1, 1);
insert into dispone values (4, 8408104829, 1, 1);
insert into dispone values (5, 8408104829, 1, 1);
insert into dispone values (6, 8408104829, 1, 1);
insert into dispone values (7, 8408104829, 1, 1);
insert into dispone values (8, 8408104829, 1, 1);
insert into dispone values (9, 8408104829, 1, 1);
insert into dispone values (10, 8408104829, 1, 1);
insert into dispone values (11, 8408104829, 1, 1);
insert into dispone values (12, 8408104829, 1, 1);
insert into dispone values (13, 8408104829, 1, 1);
insert into dispone values (14, 8408104829, 1, 1);
insert into dispone values (15, 8408104829, 1, 1);

/*
06. Añadir una nueva sucursal en la ciudad de Soria, en la dirección “Calle de los
    Caballeros, 32”. Esta sucursal tendrá asociado el código 16.
*/
insert into sucursal (codigo, direccion, poblacion, provincia) values (16, 'Calle de los Caballeros, 32', 'Soria', 'SORIA');

/*
07. La nueva sucursal creada en la ciudad de Soria en el ejercicio anterior, se dota con
    los mismos ejemplares que tiene la sucursal 2.
*/
insert into dispone select 16, ISBN, num_ejemplares, num_disponibles from dispone
where cod_suc = 2;

/*
08. El lector Francisco Roldán se ha dado de baja en la biblioteca, por tanto debe ser
    dado de baja en la base de datos. (Atención, deberá dar de baja todos los registros
    que tengan que ver con ese alumno en todas las tablas y además en el orden
    adecuado).
*/

/*
09. Incrementar en dos unidades disponibles por sucursal el libro del que más préstamos
    se realizan.
*/

/*
10. Realizar un incremento en 1 ejemplar en todas las sucursales de aquellos libros para
    los se han contabilizado más de 4 préstamos.
*/

/*
11. Eliminar todos los préstamos de los lectores de la provincia de Zamora. 
*/