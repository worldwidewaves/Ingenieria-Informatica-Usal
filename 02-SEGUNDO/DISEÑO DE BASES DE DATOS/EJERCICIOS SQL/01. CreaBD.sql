/*drop table prestamo;
drop table lector;
drop table dispone;
drop table sucursal;
drop table escribe;
drop table autor;
drop table nacionalidad;
drop table libro;
drop table editorial;
*/
CREATE TABLE EDITORIAL (
Codigo integer not null primary key, 
Nombre varchar(20)
);

CREATE TABLE LIBRO (
ISBN varchar(10) not null primary key, 
Titulo varchar(60) not null, 
Ano_Edicion integer, 
Cod_Editorial integer not null references editorial
);

CREATE TABLE NACIONALIDAD (
Codigo integer not null primary key, 
Nombre varchar(20)
);
	
CREATE TABLE AUTOR (
Codigo integer not null primary key, 
Nombre varchar(50), 
Apellido varchar (50),
Ano_Nac integer, 
Ano_Fall integer, 
Cod_Nacion  integer references nacionalidad
);


CREATE TABLE ESCRIBE (
ISBN varchar(10) not null references libro, 
Cod_Autor integer not null references autor,
primary key (ISBN, Cod_Autor)
);

CREATE TABLE SUCURSAL (
Codigo integer not null primary key, 
Direccion varchar(50),
Poblacion varchar(50), 
Provincia varchar (15) 
);

CREATE TABLE DISPONE (
Cod_Suc integer not null references sucursal,  
ISBN varchar(10) not null references libro, 
Num_Ejemplares integer, 
Num_Disponibles integer,
primary key (Cod_Suc, ISBN),
check (Num_Disponibles <= Num_Ejemplares AND Num_Disponibles >=0 AND Num_Ejemplares >=0)
);

CREATE TABLE LECTOR (
Codigo integer not null primary key, 
Nombre varchar(20), 
Ape_1 varchar(20), 
Ape_2 varchar(20), 
Direccion varchar(50), 
Poblacion varchar(50), 
Provincia varchar (15), 
Fecha_Nac date
);


CREATE TABLE PRESTAMO (
Codigo integer not null primary key, 
Cod_Lector integer not null references lector, 
ISBN varchar(10) not null, 
Cod_Suc integer not null, 
Fecha_Ini date not null, 
Fecha_Dev date,
foreign key (Cod_Suc, ISBN) references dispone(Cod_Suc, ISBN)
);

grant all on  EDITORIAL to public;
grant all on  LIBRO to public;
grant all on  NACIONALIDAD to public;
grant all on  AUTOR to public;
grant all on  ESCRIBE to public;
grant all on  SUCURSAL to public;
grant all on  DISPONE to public;
grant all on  LECTOR to public;
grant all on  PRESTAMO to public;
