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

/*
SESIÓN 3: Administración
*/
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

/*
08. Examínese la diferencia entre tener un privilegio sobre una tabla y tenerlo sobre una
    vista definida sobre esa tabla. En especial, la manera en que un usuario puede tener
    un privilegio (por ejemplo SELECT) sobre una vista sin tenerlo también sobre todas
    las tablas subyacentes.
*/
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
/*
Por acabar.
*/

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

/*
12. Crear una relación ANUNCIO que permita que los distintos usuarios de la base de
    datos inserten anuncios de cualquier tipo. El esquema de la relación será:
    ANUNCIO (Codigo, autor, texto). El Código deberá ser único y creado
    automáticamente mediante una secuencia. El atributo autor se rellenará por defecto
    con el user de quien realice la inserción. Se darán permisos para que cualquier 
    usuario pueda hacer insercciones y consultas en la tabla. Probar a insertar alguna
    tupla en nuestra tabla y también en la creada por algún compañero.
*/

/*
13. Crear una vista MISANUNCIOS que recupere los datos de los anuncios cuyo autor
    coincida con el usuario que está consultando la vista. Dar los permisos adecuados a
    dicha vista. Realizar las pruebas del funcionamiento de esta vista cooperando con un
    compañero. Hay que recordar que varios usuarios pueden crear objetos con el
    mismo nombre y que se puede acceder a los objetos creados por otros usuarios
    mediante esquema.objeto, siendo esquema el usuario propietario del objeto.
*/

/*
14. Eliminar todos los índices, vistas, tablas, sinónimos y secuencias creados en los
    ejercicios anteriores.
*/

/*
SESIÓN 4: Disparadores
*/

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
    TABLA varchar(20) not null check (TABLA='PROYECTO' or TABLA='DEPARTAMENTO'),
    COD_ITEM integer not null,
    ACCION varchar(1) check (ACCION='I' or ACCION='U' or ACCION='D') not null
);

create sequence CLAVE_REG;

create trigger CLAVEREGISTRO
before insert on REGISTRO
for each row
BEGIN
select clave_reg.NEXTVAL into :NEW.id from DUAL;
END;

create trigger INS_PROY
after insert on PROYECTO
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) values (user, 'PROYECTO', new.cod_proy, 'I');
END;

create trigger DEL_PROY
after delete on PROYECTO
for each row
BEGIN
insert into REGISTRO (USUARIO, TABLA, COD_ITEM, ACCION) values (user, 'PROYECTO', :old.cod_proy, 'D');
END;

create trigger UPD_PROY
after update on PROYECTO
for each row
BEGIN
/*
aaaaaaaaaaaaaa
*/
END;


select * from DEPARTAMENTO;

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
create table COPIA_DISPONE as select * from DISPONE;
create table COPIA_PRESTAMO as select * from PRESTAMO;
create trigger 

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

/*
05. Eliminar todos los objetos de la base de datos creados a lo largo de esta sesión.
*/