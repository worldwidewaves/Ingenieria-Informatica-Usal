--* PRÁCTICAS SISTEMAS DE BASES DE DATOS


--* SESIÓN 1: Introducción

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
select distinct nombre, ape_1, ape_2 from LECTOR, PRESTAMO where lector.poblacion = 'SALAMANCA' and cod_lector = lector.codigo and to_char(fecha_ini, 'yyyy') = 2011;
spool off
show spool

/*
02. Generar un fichero de comandos que realice un listado de todos los préstamos
    ordenados por sucursales y para cada sucursal ordenar dichos préstamos
    cronológicamente.
*/
spool ej2
set echo off
select * from PRESTAMO order by cod_suc, fecha_ini;
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
select * from AUTOR where ano_nac is NULL or ano_fall is NULL;
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
spool ej5
set pause 'Pulse una tecla para continuar'
set pause on
select l.isbn, cod_suc as Sucursal, titulo from LIBRO l, DISPONE d where l.isbn = d.isbn and cod_suc in (1,2,3) order by l.isbn, cod_suc;
spool off
show spool

/*
06. Volver a realizar un archivo de comandos que saque el listado de todos los libros
    con los que cuenta una sucursal, cuyo código se pasará como parámetro, ordenados
    por ISBN, estableciendo pausas para su mejor visualización a través del comando
    pause.
*/
spool ej6
set pause 'Pulse una tecla para continuar'
set pause on
select l.isbn, titulo from LIBRO l, DISPONE d where l.isbn = d.isbn and cod_suc = &1 order by l.isbn;
spool off
show spool

/*
07. Sacar la información de todos los autores de los que o bien no se conoce su fecha de
    nacimiento o de muerte indicando además su nacionalidad y no el código de ésta.
*/
spool ej7
select a.nombre, apellido, ano_nac, ano_fall, nacionalidad.nombre
from AUTOR a, NACIONALIDAD n where a.cod_nacion = n.codigo
and (ano_fall is null or ano_nac is null);
spool off
show spool

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
spool ej8
set pagesize 50
set linesize 80
ttitle 'INFORME DE AUTORES |CON FECHAS NO CONOCIDAS'
btitle 'SERVICIO DE BIBLIOTECAS'
column nombre format a12
column apellido format a12
column ano_nac wrap heading 'ANO|NACIMIENTO'
column ano_fall wrap heading 'ANO|MUERTE'
set pause 'Una tecla...'
set pause on
column nombre format a15 heading 'NACION'
select a.nombre, apellido, ano_nac, ano_fall, n.nombre
from AUTOR a, NACIONALIDAD n where a.cod_nacion = n.codigo
and (ano_fall is null or ano_nac is null);
ttitle off
btitle off
clear columns
set pause off
spool off
show spool

/*
09. Volver a realizar la consulta anterior insertando ‘???’ en los lugares donde no se
    conoce la fecha de nacimiento o defunción de los autores.
*/
spool ej9
set pagesize 50
set linesize 80
ttitle 'INFORME DE AUTORES |CON FECHAS NO CONOCIDAS'
btitle 'SERVICIO DE BIBLIOTECAS'
column nombre format a12
column apellido format a12
column ano_nac wrap heading 'ANO|NACIMIENTO' NULL '????'
column ano_fall wrap heading 'ANO|MUERTE' NULL '????'
set pause 'Una tecla...'
set pause on
column nombre format a15 heading 'NACION'
Select a.nombre, apellido, ano_nac, ano_fall, n.nombre
from AUTOR a, NACIONALIDAD n where a.cod_nacion = n.codigo
and (ano_fall is null or ano_nac is null);
ttitle off
btitle off
clear columns
set pause off
spool off
show spool


--* SESIÓN 2: Modificaciones de Información

set autocommit on

/*
01. Aumentar en 3 el número de ejemplares del libro con ISBN 5025496 para la
    sucursal 9. Comprobar que la actualización ha sido correcta.
*/
update DISPONE
set num_ejemplares = num_ejemplares + 3, num_disponibles = num_disponibles + 3
where ISBN = 5025496 and cod_suc = 9;

/*
02. El lector con código 7395860 ha cambiado su dirección a la C/Sevilla, 1 de
    Aldeadávila en la provincia de Salamanca. Actualice sus datos en la base de datos.
*/
update LECTOR
set direccion = 'C/Sevilla, 1', poblacion = 'Aldeadávila', provincia = 'SALAMANCA'
where codigo = 7395860;

/*
03. Actualizar la tabla SUCURSAL la sucursal con código 15 para que pase a estar
    ubicada en la ciudad de SEGOVIA con dirección en C/ SAN AGUSTÍN, 10.
*/
update SUCURSAL
set direccion = 'C/San Agustín, 10', poblacion = 'Segovia', provincia = 'SEGOVIA'
where codigo = 15;

/*
04. Actualizar la dirección de los lectores con códigos 71259836 y 94246322 a Av. de
    Alemania, 49, Miajadas, Cáceres y Daoiz y Velarde, 24, Benavente, Zamora,
    respectivamente.
*/
update LECTOR
set direccion = 'Av. de Alemania, 49', poblacion = 'Miajadas', provincia = 'CACERES'
where codigo = 71259836;
update LECTOR
set direccion = 'Daoiz y Velarde, 24', poblacion = 'Benavente', provincia = 'ZAMORA'
where codigo = 94246322;

/*
05. Se acaban de comprar 15 ejemplares, 1 para cada una de las 15 sucursales, del
    premio Planeta 2001 titulada ‘EL PREMIO ERES TÚ’ con ISBN 8408104829
    escrita por de Javier Moro (Madrid, 1955) y publicada por la editorial Planeta en el
    2001. Realizar su inserción en el sistema añadiendo los datos correspondientes en
    todas las tablas que sea necesario.
*/
insert into AUTOR (codigo, nombre, apellido, ano_nac, cod_nacion) values (159, 'JAVIER', 'MORO', 1955, 9);
insert into ESCRIBE values (159, 8408104829);
insert into EDITORIAL values (12, 'PLANETA');
insert into LIBRO values (8408104829, 'EL PREMIO ERES TU', 2011, 12);
insert into DISPONE values (1, 8408104829, 1, 1);
insert into DISPONE values (2, 8408104829, 1, 1);
insert into DISPONE values (3, 8408104829, 1, 1);
insert into DISPONE values (4, 8408104829, 1, 1);
insert into DISPONE values (5, 8408104829, 1, 1);
insert into DISPONE values (6, 8408104829, 1, 1);
insert into DISPONE values (7, 8408104829, 1, 1);
insert into DISPONE values (8, 8408104829, 1, 1);
insert into DISPONE values (9, 8408104829, 1, 1);
insert into DISPONE values (10, 8408104829, 1, 1);
insert into DISPONE values (11, 8408104829, 1, 1);
insert into DISPONE values (12, 8408104829, 1, 1);
insert into DISPONE values (13, 8408104829, 1, 1);
insert into DISPONE values (14, 8408104829, 1, 1);
insert into DISPONE values (15, 8408104829, 1, 1);

/*
06. Añadir una nueva sucursal en la ciudad de Soria, en la dirección “Calle de los
    Caballeros, 32”. Esta sucursal tendrá asociado el código 16.
*/
insert into SUCURSAL (codigo, direccion, poblacion, provincia) values (16, 'Calle de los Caballeros, 32', 'Soria', 'SORIA');

/*
07. La nueva sucursal creada en la ciudad de Soria en el ejercicio anterior, se dota con
    los mismos ejemplares que tiene la sucursal 2.
*/
insert into DISPONE (select s.codigo, ISBN, num_ejemplares, num_disponibles from SUCURSAL s, DISPONE d
where s.codigo = 16 and d.cod_suc = 2);

/*
08. El lector Francisco Roldán se ha dado de baja en la biblioteca, por tanto debe ser
    dado de baja en la base de datos. (Atención, deberá dar de baja todos los registros
    que tengan que ver con ese alumno en todas las tablas y además en el orden
    adecuado).
*/
delete from PRESTAMO where codigo = (select codigo from LECTOR where nombre = 'FRANCISCO' and ape_1 = 'ROLDAN');
delete from LECTOR where nombre = 'FRANCISCO' and ape_1 = 'ROLDAN';

/*
09. Incrementar en dos unidades disponibles por sucursal el libro del que más préstamos
    se realizan.
*/
UPDATE DISPONE
set num_ejemplares = num_ejemplares + 2, num_disponibles = num_disponibles + 2
where ISBN in (select ISBN from PRESTAMO p group by ISBN having count(*) = (select max(count(*)) from PRESTAMO group by ISBN));

/*
10. Realizar un incremento en 1 ejemplar en todas las sucursales de aquellos libros para
    los se han contabilizado más de 4 préstamos.
*/
/* Este enunciado se puede interpretar de distintas formas: */
/*  - Primera Interpretación - 
  La interpretación más simple sería considerar que si un libro se ha prestado más de cuatro veces en el conjunto de todas las sucursales
  se debe incrementar en una unidad los ejemplares asignados de dicho libro en cualquiera (todas y cada una) de las sucursales que lo tuvieran.
  Con esta interpretación, la solución sería:
*/
UPDATE DISPONE
set num_ejemplares = num_ejemplares + 1, num_disponibles = num_disponibles + 1
where ISBN in (select ISBN from PRESTAMO p group by ISBN having count(*) > 4);

/*  - Segunda Interpretación - 
  Otra posibilidad un poco más elaborada sería considerar que solo se desea incrementar en 1 el número de ejemplares de un libro 
  si ese libro ha sido prestado más de cuatro veces al menos en una sucursal. Es decir, no basta con haber tenido más de cuatro préstamos 
  en total contando los prestamos del conjunto de las sucursales, sino que tiene que haber  sido prestado más de 4 veces en, al menos,
  una sucursal. Si se cumple esa condición, se incrementará en 1 el número de ejemplares de ese libro pero en todas las sucursales
  que ya lo tuvieran (tanto en las que tuviera más de cuatro préstamos como en las que hubiera tenido menos).
  Con esta interpretación, la solución sería:
*/
UPDATE DISPONE
set num_ejemplares = num_ejemplares + 1, num_disponibles = num_disponibles + 1
where ISBN in (select ISBN from PRESTAMO p group by cod_suc, ISBN having count(*) > 4);

/*  - Tercera Interpretación - 
  La última posibilidad, que es la más compleja, sería considerar que solo se desea incrementar en 1 el número de ejemplares de un libro 
  en aquellas sucursales en las que el libro haya sido prestado más de 4 veces. Por tanto, a diferencia de los casos anteriores, el número
  de ejemplares de un mismo libro puede incrementarse en una sucursal y no hacerlo en otra.
  Con esta interpretación, la solución sería:
*/
UPDATE dispone
set num_ejemplares = num_ejemplares + 1, num_disponibles = num_disponibles + 1
where exists (select * from PRESTAMO p where ISBN = dispone.ISBN and cod_suc = dispone.cod_suc group by cod_suc, ISBN having count(*) > 4);


/*
11. Eliminar todos los préstamos de los lectores de la provincia de Zamora. 
*/
delete from PRESTAMO where codigo in (select codigo from LECTOR where poblacion = 'ZAMORA');


--* SESIÓN 3: Índices, Vistas, Sinónimos y Secuencias

set autocommit on

/*
01. Se ha observado que una parte importante de las consultas a la base de datos que
    requieren mejorar su eficiencia acceden a los datos de la tabla LECTOR según el
    valor de la PROVINCIA. ¿Qué podemos hacer para mejorar los tiempos de
    respuesta de dichas consultas?
*/
create index LECTOR_PROVINCIA on LECTOR (provincia);

/*
02. Crear una vista para seleccionar los códigos de los préstamos activos (libros no
    devueltos) junto a los códigos de los lectores.
*/
create view PRESTAMOS_ACTIVOS as select cod_lector, codigo from PRESTAMO where fecha_dev IS NULL;

/*
03. Crear una vista que liste los libros que se encuentran en la actualidad prestados,
    incluyendo el ISBN y título. Generar dicha esta vista eliminando las filas
    duplicadas.
*/
create view LIBROS_PRESTADOS as select distinct l.isbn, l.titulo from PRESTAMO p, LIBRO l where p.isbn = l.isbn and p.fecha_dev IS NULL;

/*
04. Crear una vista para el fondo de préstamo de la sucursal 3, indicando el ISBN, título
    del libro y el número de ejemplares asignados y disponibles para dicha sucursal.
*/
create view FONDO_PRESTAMO_SUC3 as select l.isbn, l.titulo, d.num_ejemplares, d.num_disponibles from DISPONE d, LIBRO l where d.cod_suc = 3 and l.isbn = d.isbn;

/*
05. Crear una vista que liste todas las columnas de la tabla PRESTAMO para aquellos
    prestamos finalizados en la sucursal 1.
*/
create view PRESTAMOS_FINALIZADOS_SUC1 as select * from PRESTAMO where cod_suc = 1 and fecha_dev IS NOT NULL;

/*
06. Usar la vista anterior para insertar una nueva tupla en la tabla PRESTAMO
    correspondiente a un préstamo iniciado hoy y no finalizado de la sucursal 4.
    Comprobar la diferencia de comportamiento si la vista está creada con la
    claúsula WITH CHECK OPTION o no.
*/
insert into PRESTAMOS_FINALIZADOS_SUC1 values (10000, 15838332, 5025700, 4, sysdate, NULL);
select * from PRESTAMOS_FINALIZADOS_SUC1 where codigo = 10000; /* No recupera nada */
select * from PRESTAMO where codigo = 10000; /* Sí recupera la tupla insertada */
/* 
Me deja meterlo pero al hacer un select sobre la vista no sale porque la vista está hecha
sobre la sucursal 1 y esto es de la 4.
*/
drop view PRESTAMOS_FINALIZADOS_SUC1;
create view PRESTAMOS_FINALIZADOS_SUC1 as select * from PRESTAMO where cod_suc = 1 and fecha_dev IS NOT NULL with check option;
insert into PRESTAMOS_FINALIZADOS_SUC1 values (10000, 15838332, 5025700, 4, sysdate, NULL);
/*
La tupla no se inserta porque no cumple las condiciones de la vista.
*/

/*
07. Modificar la vista anterior de forma que no pueda realizarse ninguna modificación
    sobre ella. Intentar borrar con esa vista los préstamos finalizados hace más de 5
    años. ¿Cuál es la salida?
*/
drop view PRESTAMOS_FINALIZADOS_SUC1;
create view PRESTAMOS_FINALIZADOS_SUC1 as select * from PRESTAMO where cod_suc = 1 and fecha_dev IS NOT NULL with read only;
delete from PRESTAMOS_FINALIZADOS_SUC1 where fecha_dev < sysdate - 365*5;
/* Al intentar hacer el delete se obtiene un mensaje de error que indica que no es posible hacer ese borrado */

/*
08. Examínese la diferencia entre tener un privilegio sobre una tabla y tenerlo sobre una
    vista definida sobre esa tabla. En especial, la manera en que un usuario puede tener
    un privilegio (por ejemplo SELECT) sobre una vista sin tenerlo también sobre todas
    las tablas subyacentes.
*/
/* Creamos una tabla cualquiera, por ejemplo una tabla que sea copia de alguna de las de la base de datos                                 */
create table XXX as select * from libro;
/* creamos una vista que use esa tabla                                                                                                    */
create view UNAVISTA as select * from XXX;
/* autorizamos a un compañero o a todo el mundo a hacer consultas sobre la vista                                                          */
grant select on UNAVISTA to public;
/* ahora, cuando la persona autorizada intente consultar la tabla xxx no podrá hacerlo, pero sí podrá consultar la vista unavista         */
/* recuérdese que quien quiera acceder a la vista o tabla que hemos creado deberá preceder el nombre del objeto con el de nuestro usuario */
/* por ejemplo: select * from OPS$Ixxxxxxx.UNAVISTA;                                                                                      */
/* para saber qué usuario somos: select user from DUAL;                                                                                   */
/*
Si damos privilegios a alguien a una vista de una tabla pero no a la tabla, la persona
en cuestión podrá acceder a la vista pero no a la tabla.
*/

/*
09. Crear un sinónimo para la tabla dispone y hacer uso de él para consultar un listado
    por sucursal de los ISBN que tienen a su disposición.
*/
create synonym POMELO for DISPONE;
select cod_sucursal, isbn from POMELO order by cod_sucursal;

/*
10. Un análisis de la base de datos muestra que es necesario añadir un campo más a la
    tabla sucursal, para almacenar el nombre de la sucursal. Haga una copia de la tabla
    sucursal y posteriormente, realice en esa tabla las operaciones necesarias para incluir
    el nuevo dato.
*/
create table COPIA_SUCURSAL as select * from SUCURSAL;
alter table COPIA_SUCURSAL add nombre varchar(20);

/*
11. Se desea disponer de una nueva tabla AUTORESP que contenga información de los
    autores de nacionalidad española. En esa tabla, cada autor tendrá un nuevo atributo
    que llamaremos CodAutorEsp que será la clave primaria de esa tabla. El valor del
    atributo CodAutorEsp no tiene por qué coincidir con el código que el autor tenga en
    la tabla AUTOR. El valor de este código se generará de manera automática
    mediante una secuencia.
    a.  Crear la secuencia necesaria.
    b.  Crear la tabla que contenga los siguientes atributos: CodAutorEsp,
        Nombre, Apellido.
    c.  Rellenar la nueva tabla con los datos de los escritores españoles que se
        obtengan de la tabla AUTOR.
*/
create sequence CLAVE_AUTORESP;

create table AUTORESP (
CodAutorEsp		integer not null primary key,
Nombre			VARCHAR(50),
Apellido		VARCHAR(50));

insert into AUTORESP select CLAVE_AUTORESP.nextval, nombre, apellido from AUTOR 
where cod_nacion = (select codigo from NACIONALIDAD where nombre = 'ESPANA');

/*
12. Crear una relación ANUNCIO que permita que los distintos usuarios de la base de
    datos inserten anuncios de cualquier tipo. El esquema de la relación será:
    ANUNCIO (Codigo, autor, texto). El Código deberá ser único y creado
    automáticamente mediante una secuencia. El atributo autor se rellenará por defecto
    con el user de quien realice la inserción. Se darán permisos para que cualquier 
    usuario pueda hacer insercciones y consultas en la tabla. Probar a insertar alguna
    tupla en nuestra tabla y también en la creada por algún compañero.
*/
create sequence CLAVE_ANUNCIO;
grant all on CLAVE_ANUNCIO to public;

create table ANUNCIO (
codigo integer not null primary key,
autor  varchar(20) default user,
texto  varchar (30));

grant all on ANUNCIO to public;

insert into ANUNCIO (codigo, texto) values (CLAVE_ANUNCIO.nextval, 'vendo moto barata');
insert into ANUNCIO (codigo, texto) values (CLAVE_ANUNCIO.nextval, 'se pasan trabajos a ordenador');

insert into otrousuario.ANUNCIO (codigo, texto) values (otrousuario.CLAVE_ANUNCIO.nextval, 'compro libros antiguos');

/*
13. Crear una vista MISANUNCIOS que recupere los datos de los anuncios cuyo autor
    coincida con el usuario que está consultando la vista. Dar los permisos adecuados a
    dicha vista. Realizar las pruebas del funcionamiento de esta vista cooperando con un
    compañero. Hay que recordar que varios usuarios pueden crear objetos con el
    mismo nombre y que se puede acceder a los objetos creados por otros usuarios
    mediante esquema.objeto, siendo esquema el usuario propietario del objeto.
*/
create view MISANUNCIOS as select * from ANUNCIO where autor = user;
grant select on MISANUNCIOS to public;

select * from MISANUNCIOS;
select * from ANUNCIO;
/*  Si en nuestra tabla, además de nosotros ha insertado tuplas algún compañero, los resultados de las consulta a la vista 
	misanuncios serán distintos de los de la consulta a la tabla anuncio */

/*
14. Eliminar todos los índices, vistas, tablas, sinónimos y secuencias creados en los
    ejercicios anteriores.
*/
drop index LECTOR_PROVINCIA;
drop view PRESTAMOS_ACTIVOS;
drop view LIBROS_PRESTADOS;
drop view FONDO_PRESTAMO_SUC3;
drop view PRESTAMOS_FINALIZADOS_SUC1;
drop view UNAVISTA;
drop table XXX;
drop synonym POMELO;
drop table COPIA_SUCURSAL;
drop table AUTORESP;
drop view MISANUNCIOS;
drop table ANUNCIO;
drop sequence CLAVE_AUTORESP;
drop sequence CLAVE_ANUNCIO;

--* SESIÓN 4: Disparadores

/*
01. Se desea llevar un control de las actualizaciones que se realizan sobre una base de
    datos que está compuesta por las siguientes tablas:
        PROYECTO (COD_PROY, NOMBRE, PRESUPUESTO)
        DEPARTAMENTO (COD_DPTO, NOMBRE, DIRECCION, NUM_EMPLEADOS)
    Para ello, se crea una tabla donde se registrará cada acción que se realice sobre las
    tablas anteriores. Dicha tabla tendrá el siguiente esquema:
        REGISTRO (ID, FECHA, USUARIO, TABLA, COD_ITEM, ACCION)
    En la tabla REGISTRO se incluirá una tupla por cada acción que se realice en las
    tablas anteriores y que contendrá los siguientes atributos:
    - ID. Será la clave de la tabla registro y se gestionará automáticamente mediante
      un disparador que obtenga el valor correspondiente a partir de una secuencia.
    - Fecha en la que se ha realizado la modificación
    - Usuario que ha realizado la acción
    - Nombre de la tabla modificada (PROYECTO o DEPARTAMENTO)
    - Clave de la tupla insertada, cambiada o borrada
    - Acción que se ha realizado (INSERT, UPDATE o DELETE)
    a) Crear las tres tablas indicadas y los disparadores necesarios para registrar los
       datos de modificación de las tablas.
    b) Insertar, modificar y borrar varias tuplas en las tablas PROYECTO y
       DEPARTAMENTO y consultar el contenido de la tabla REGISTRO para
       comprobar que los disparadores han funcionado correctamente.
*/
create table PROYECTO (
    COD_PROY integer not null primary key,
    NOMBRE varchar(20) not null,
    PRESUPUESTO decimal(8,2)
);

create table DEPARTAMENTO (
    COD_DEPTO integer not null primary key,
    NOMBRE varchar(20) not null,
    DIRECCION varchar(20),
    NUM_EMPLEADOS integer default 0 not null
);

create table REGISTRO (
    ID integer not null primary key,
    FECHA date default sysdate,
    USUARIO varchar(20) not null,
    TABLA varchar(20) not null check (TABLA = 'PROYECTO' or TABLA = 'DEPARTAMENTO'),
    COD_ITEM integer not null,
    ACCION varchar(1) check (ACCION = 'I' or ACCION = 'U' or ACCION = 'D') not null
);

create sequence CLAVE_REG;

create trigger CLAVEREGISTRO
before insert on REGISTRO
for each row
BEGIN
select clave_reg.NEXTVAL into :NEW.id from DUAL;
END;
/

create trigger INS_PROY
after insert on PROYECTO
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) values (user, 'PROYECTO', :new.cod_proy, 'I');
END;
/

create trigger DEL_PROY
after delete on PROYECTO
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) values (user, 'PROYECTO', :old.cod_proy, 'D');
END;
/

create trigger UPD_PROY
after update on PROYECTO
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) VALUES (user, 'PROYECTO', :old.cod_proy, 'U');
END;
/

create trigger INS_DPT
after insert on DEPARTAMENTO 
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) VALUES (user, 'DEPARTAMENTO', :new.cod_dpto, 'I');
END;
/

create trigger DEL_DPT
after delete on DEPARTAMENTO 
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) VALUES (user, 'DEPARTAMENTO', :old.cod_dpto, 'D');
END;
/

create trigger UPD_DPT
after update on DEPARTAMENTO 
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) VALUES (user, 'DEPARTAMENTO', :old.cod_dpto, 'U');
END;
/

/* SENTENCIAS PARA PROBAR EL FUNCIONAMIENTO DE LOS DISPARADORES ANTERIORES */

insert into PROYECTO values (100, 'PUENTE', 25000);
update PROYECTO set presupuesto = presupuesto * 1.1 where cod_proy = 100;
insert into PROYECTO values (200, 'PLAZA', 50000);
delete from PROYECTO where cod_proy = 200;

insert into DEPARTAMENTO values (33, 'INFORMATICA', 'GRAN VIA 23', 0);
update DEPARTAMENTO set direccion = 'GRAN VIA 55' where cod_dpto = 33;
insert into DEPARTAMENTO values (77, 'CONTABILIDAD', 'PLAZA DEL OESTE 23', 0);
delete from DEPARTAMENTO where cod_dpto = 33;

/* Probamos que se registran correctamente las eliminaciones de varias tuplas hechas en una �nica sentencia */
insert into PROYECTO values (250, 'CASA GRANDE', 15000);
insert into PROYECTO values (300, 'ROTONDA', 26000);
insert into PROYECTO values (350, 'CAMINO', 32000);
insert into PROYECTO values (400, 'ACERA', 18000);
delete from PROYECTO where cod_proy > 300;

select * from REGISTRO;

/*
02. Crear una nueva tabla EMPLEADO (DNI, NOMBRE, APELLIDO, COD_DEPTO).
    Crear los disparadores precisos para que el atributo derivado NUM_EMPLEADOS
    de la tabla DEPARTAMENTO se mantenga consistente con el contenido de la tabla
    EMPLEADOS de modo automático. Comprobar el funcionamiento de los
    disparadores en los siguientes casos:
    - Se insertan varios empleados en distintos departamentos
    - Se cambia el departamento al que está asignado un empleado
    - Se elimina un usuario
    - Se eliminan varios usuarios
    - Se inserta un empleado sin departamentos asignado y posteriormente se
      modifica para asignarlo a un departamento existente
    - Se modifica un empleado asignado a un departamento para que deje de estar
      asignado a ninguno
*/
create table EMPLEADO 
(DNI integer not null primary key, 
 NOMBRE varchar (20),
 APELLIDO varchar (30),
 COD_DEPTO integer references DEPARTAMENTO);
 
create trigger INS_EMP
after insert on EMPLEADO 
for each row
when (new.cod_depto is not null)
BEGIN
update DEPARTAMENTO set num_empleados = num_empleados + 1 where cod_dpto = :new.cod_depto;
END;
/

create trigger DEL_EMP
after delete on EMPLEADO 
for each row
when (old.cod_depto is not null)
BEGIN
update DEPARTAMENTO set num_empleados = num_empleados - 1 where cod_dpto = :old.cod_depto;
END;
/

create trigger UPD_EMP
after update of cod_depto on EMPLEADO 
for each row
when (new.cod_depto is not null or old.cod_depto is not null)
BEGIN
update DEPARTAMENTO set num_empleados = num_empleados + 1 where cod_dpto = :new.cod_depto;
update DEPARTAMENTO set num_empleados = num_empleados - 1 where cod_dpto = :old.cod_depto;
END;
/

/* Sentencias para probar estos disparadores */

/* Creamos tres departamentos sin empleados */
insert into DEPARTAMENTO values (33, 'INFORMATICA', 'GRAN VIA 23', 0);
insert into DEPARTAMENTO values (53, 'ANALISIS', 'PLAZA DE CUBA 18', 0);
insert into DEPARTAMENTO values (83, 'VENTAS', 'CALLE ANCHA 35', 0);

/* Insertamos 5 nuevos empleados, 2 para uno de los departamentos y tres para otro */
insert into EMPLEADO values (123456, 'PATRICIA', 'PEREZ', 33);
insert into EMPLEADO values (456789, 'RAMIRO', 'RODRIGUEZ', 33);
insert into EMPLEADO values (147258, 'MARTA', 'MARTIN', 53);
insert into EMPLEADO values (258369, 'SERGIO', 'SERRANO', 53);
insert into EMPLEADO values (963741, 'BELEN', 'BENITO', 53);

/* Comprobamos que se han actualizado los números de empleados en la tabla DEPARTAMENTO */
select * from DEPARTAMENTO;

/* Cambiamos a un empleado de departamento */
update EMPLEADO set cod_depto = 83 where dni = 147258;
select * from DEPARTAMENTO;

/* Borramos un empleado */
delete from EMPLEADO where dni = 963741;
select * from DEPARTAMENTO;

/* Prueba con un empleado que no se asigna a ningún departamento y luego se modifica para asignarlo a uno */
insert into EMPLEADO values (1564862, 'ALBERTO', 'ALVAREZ', null);
select * from DEPARTAMENTO;

update EMPLEADO set cod_depto = 83 where dni = 1564862;
select * from DEPARTAMENTO;

update EMPLEADO set cod_depto = null where dni = 1564862;
select * from DEPARTAMENTO;

/*
03. Crear dos tablas con los mismos esquemas de las tablas DISPONE y la tabla
    PRESTAMO de la base de datos usada en las prácticas (no es necesario definir en
    ellas las claves externas correspondientes al resto de las tablas de la base de datos
    de prácticas). Crear los disparadores necesarios para que el atributo derivado
    NUM_DISPONIBLES de la tabla creada a imagen de DISPONE se mantenga
    consistente de manera automática.
    Se desea impedir que en la tabla creada a imagen de PRESTAMO se realicen
    modificaciones sobre las columnas ISBN o COD_SUC. Crear un disparador que
    garantice que no se producirán modificaciones de este tipo.
*/
create table MI_DISPONE (
Cod_Suc integer not null ,  
ISBN varchar(10) not null, 
Num_Ejemplares integer, 
Num_Disponibles integer,
primary key (Cod_Suc, ISBN),
check (Num_Disponibles <= Num_Ejemplares AND Num_Disponibles >= 0 AND Num_Ejemplares >= 0)
);

create table MI_PRESTAMO (
Codigo integer not null primary key, 
Cod_Lector integer not null, 
ISBN varchar(10) not null, 
Cod_Suc integer not null, 
Fecha_Ini date not null, 
Fecha_Dev date,
foreign key (Cod_Suc, ISBN) references mi_dispone (Cod_Suc, ISBN)
);

/* Rellenamos inicialmente las tablas con los mismos datos de las tablas DISPONE y PRESTAMO originales */

insert into MI_DISPONE select * from DISPONE;
insert into MI_PRESTAMO select * from PRESTAMO;

/* Triggers para el mantenimiento del atributo derivado NUM_DISPONIBLES de MI_DISPONE */

create or replace trigger INS_MIPRES
after insert on MI_PRESTAMO 
for each row
when (new.fecha_dev is null)
BEGIN
update MI_DISPONE set num_disponibles = num_disponibles - 1 where ISBN = :new.ISBN and cod_suc = :new.cod_suc;
END;
/

create or replace trigger DEL_MIPRES
after delete on MI_PRESTAMO 
for each row
when (old.fecha_dev is null)
BEGIN
update MI_DISPONE set num_disponibles = num_disponibles + 1 where ISBN = :old.ISBN and cod_suc = :old.cod_suc;
END;
/

create or replace trigger UPD_FDEV_MIPRES
after update of FECHA_DEV on MI_PRESTAMO 
for each row
when (old.fecha_dev is null and new.fecha_dev is not null)
BEGIN
update MI_DISPONE set num_disponibles = num_disponibles + 1 where ISBN = :old.ISBN and cod_suc = :old.cod_suc;
END;
/

create or replace trigger UPD_MIPRES
after update of COD_SUC, ISBN on MI_PRESTAMO 
for each row
BEGIN
raise_application_error(-20000, 'OPERACION NO PERMITIDA');
END;
/


/* Comprobamos el funcionamiento de los triggers  simulando prestamos y devoluciones de libros */
select * from MI_DISPONE where cod_suc = 17 and isbn = '5023876';
insert into MI_PRESTAMO values (919191, 123, '5023876', 17, sysdate, null);
select * from MI_DISPONE where cod_suc = 17 and isbn = '5023876';

update MI_PRESTAMO set fecha_dev = sysdate where codigo = 919191;
select * from MI_DISPONE where cod_suc = 17 and isbn = '5023876';

delete from MI_PRESTAMO where codigo = 919191;
select * from MI_DISPONE where cod_suc = 17 and isbn = '5023876';

/*
04. La biblioteca desea incentivar los hábitos de lectura de sus socios estableciendo una
    clasificación de los mismos en función del número de prestamos que han realizado.
    Solo se incluirán en la clasificación aquellos lectores que hayan realizado como
    mínimo 10 préstamos. En el caso de que varios lectores coincidan con el mismo nº
    de prestamos, se les asignarán números consecutivos en la clasificación sin importar
    el criterio. Para ello, se desea crear una tabla que contenga las siguientes columnas:
    nº de orden en la clasificación a fecha de hoy, código del lector y nº de prestamos
    realizados.
    a. Crear la tabla anterior tomando como clave primaria el nº de orden en la
       clasificación.
    b. Crear una secuencia que se utilizará para obtener los valores de la clave
       primaria de la tabla anterior.
    c. Crear un trigger que genere de forma automática durante la inserción los
       valores para la clave de la tabla.
    d. Rellenar la tabla con los valores correspondientes a partir del contenido
       de la Base de Datos en el momento actual.
*/
create table CLASIFICACION (
posicion integer not null primary key,
cod_lector integer not null references lector,
num_prestamos integer not null check (num_prestamos >= 10));

create sequence SEQ_CLAS;

create or replace trigger TRIG_CLAS
before insert on clasificacion 
for each row
begin
select seq_clas.NEXTVAL into :NEW.posicion from DUAL;
end;
/

insert into CLASIFICACION (cod_lector, num_prestamos)
select cod_lector, count(*) from PRESTAMO
group by cod_lector
having count(*) >= 10
order by 2 desc;

/*
05. Eliminar todos los objetos de la base de datos creados a lo largo de esta sesión.
*/
drop trigger CLAVREGISTRO;
drop trigger INS_PROY;
drop trigger DEL_PROY;
drop trigger UPD_PROY;
drop trigger INS_DPT;
drop trigger DEL_DPT;
drop trigger UPD_DPT;
drop table PROYECTO;
drop table DEPARTAMENTO;
drop table REGISTRO;
drop sequence CLAVE_REG;

drop trigger INS_EMP;
drop trigger DEL_EM;
drop trigger UPD_EM;
drop table EMPLEADO;

drop trigger INS_MIPRES;
drop trigger DEL_MIPRES;
drop trigger UPD_FDEV_MIPRES;
drop trigger UPD_MIPRES
drop table MI_DISPONE;
drop table MI_PRESTAMO;

drop trigger TRIG_CLAS;
drop table CLASIFICACION;
drop sequence SEQ_CLAS;


--* SESIÓN 5: PL/SQL

set serveroutput on

/*
01. Escribir un bloque PL/SQL que calcule la media de tres números y saque el
    resultado por pantalla.
*/
DECLARE
    a number;
    b number;
    c number;
BEGIN
    a := 1;
    b := 2;
    c := 3;
    dbms_output.put_line('Media de a = ' || a || ', b = ' || b || ' y c = ' || c || ' es: ' || (a+b+c)/3);
END;
/

/*
02. Escribir un bloque en PL/SQL que acceda a la base de datos UNIV y saque por
    pantalla los datos del autor MARIO VARGAS LLOSA. Realice el tratamiento de
    errores necesario.
*/
DECLARE
    nombre autor.nombre%TYPE;
    apellido autor.apellido%TYPE;
    pais nacionalidad.nombre%TYPE;
    fecha_nac autor.ano_nac%TYPE;
    fecha_fall autor.ano_fall%TYPE;
BEGIN
    select a.nombre, a.apellido, a.ano_nac, a.ano_fall, n.nombre
    into nombre, apellido, fecha_nac, fecha_fall, pais
    from AUTOR a, NACIONALIDAD n
    where a.nombre = 'MARIO' and a.apellido = 'VARGAS LLOSA' and n.codigo = a.cod_nacion;
    dbms_output.put_line(nombre || ' ' || apellido || ' nacio en ' || pais || ' en ' || fecha_nac);
    if fecha_fall is NULL then
        dbms_output.put_line('Y continua vivo');
    else 
        dbms_output.put_line('Y falleció en: ' || fecha_fall);
    end if;
END;
/

/*
03. Escribir un bloque PL/SQL que muestre por pantalla el número total de libros,
    autores, editoriales, sucursales y lectores que hay en la base de datos UNIV.
    a. Realice el tratamiento de errores necesario.
    b. En caso de que el número de lectores supere en un 20% al número de
       libros. Sacar un mensaje por pantalla que indique “Aumentar fondo de
       préstamo”.
*/
SET SERVEROUTPUT ON -- se mostrarán las salidas por pantalla
DECLARE
    total_libros NUMBER;
    total_editorial NUMBER;
    total_autor NUMBER;
    total_lector NUMBER;
    total_sucursal NUMBER;
BEGIN
     SELECT count(*) INTO total_libros from univ.libro;
     SELECT count(*) INTO total_editorial from univ.editorial;
     SELECT count(*) INTO total_autor from univ.autor;
     SELECT count(*) INTO total_lector from univ.lector;
     SELECT count(*) INTO total_sucursal from univ.sucursal;
     DBMS_OUTPUT.PUT_LINE('El número total de libros es:'|| total_libros);
     DBMS_OUTPUT.PUT_LINE('El número total de editoriales es:'|| total_editorial);
     DBMS_OUTPUT.PUT_LINE('El número total de autores es:'|| total_autor);
     DBMS_OUTPUT.PUT_LINE('El número total de lectores es:'|| total_lector);
     DBMS_OUTPUT.PUT_LINE('El número total de sucursales es:'|| total_sucursal );
  IF (total_lector > (1.2 * total_libros)) THEN
   DBMS_OUTPUT.PUT_LINE('AUMENTAR FONDO DE PRESTAMO');
  END IF;
EXCEPTION
 -- rutina genérica de tratamiento de cualquier tipo de error
 WHEN others then raise_application_error (-20100,'error#'||sqlcode||' desc#: '|| sqlerrm);
     
END;
/

/*
04. Se desea llevar un control de las actualizaciones que se realizan sobre una base de
    datos que está compuesta por las siguientes tablas:
    PROYECTO (COD_PROY, NOMBRE, PRESUPUESTO)
    DEPARTAMENTO (COD_DPTO, NOMBRE, DIRECCION, NUM_EMPLEADOS)
    Para ello, se crea una tabla donde se registrará cada acción que se realice sobre las
    tablas anteriores. Dicha tabla tendrá el siguiente esquema:
    REGISTRO (ID, FECHA, USUARIO, TABLA, COD_ITEM, ACCION)
    En la tabla REGISTRO se incluirá una tupla por cada acción que se realice en las
    tablas anteriores y que contendrá los siguientes atributos:
    - Fecha en la que se ha realizado la modificación
    - Usuario que ha realizado la acción
    - Nombre de la tabla modificada (PROYECTO o DEPARTAMENTO)
    - Clave de la tupla insertada, cambiada o borrada
    - Acción que se ha realizado (INSERT, UPDATE o DELETE)
    Una vez creadas las tablas, crear mediante los mecanismos de control del PL/SQL
    los dos disparadores necesarios para registrar los datos de modificación en cada una
    de las tablas PROYECTO y DEPARTAMENTO. Consultar el contenido de la tabla
    REGISTRO para comprobar que los disparadores han funcionado correctamente.
*/

--* SESIÓN 6: Cursores

/*
01. Obtener el número de sucursal, la dirección y provincia de las distintas sucursales de
    la biblioteca.
*/

/*
02. Realizar un programa en el que dada una provincia se indique qué sucursales y
    poblaciones de dicha provincia existen para la biblioteca.
*/

/*
03. Obtener un listado de los lectores que tienen actualmente en préstamo el libro con
    identificado por su ISBN, desglosado por sucursales y ordenado alfabéticamente
    dentro de cada sucursal.
*/

/*
04. Obtener el expediente de préstamos realizados por un lector cualquiera del que se
    conoce su código. En el expediente debe aparecer el código y nombre del lector y a
    continuación un listado de los libros tomados en préstamo por orden cronológico de
    la fecha en la que se inició dicho préstamo. El expediente mostrará el ISBN de
    dichos libros, la fecha de devolución, si ha sido devuelto, y la sucursal en la que
    realizó dicho préstamo. Al final de dicho expediente se dará el número total de
    préstamos realizados y pendientes.
*/