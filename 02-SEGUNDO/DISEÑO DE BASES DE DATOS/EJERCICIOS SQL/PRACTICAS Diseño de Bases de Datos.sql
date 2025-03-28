/*
▀█████████▄     ▄████████    ▄████████    ▄████████    ▄████████      ████████▄     ▄████████      ████████▄     ▄████████     ███      ▄██████▄     ▄████████                              
  ███    ███   ███    ███   ███    ███   ███    ███   ███    ███      ███   ▀███   ███    ███      ███   ▀███   ███    ███ ▀█████████▄ ███    ███   ███    ███                              
  ███    ███   ███    ███   ███    █▀    ███    █▀    ███    █▀       ███    ███   ███    █▀       ███    ███   ███    ███    ▀███▀▀██ ███    ███   ███    █▀                               
 ▄███▄▄▄██▀    ███    ███   ███         ▄███▄▄▄       ███             ███    ███  ▄███▄▄▄          ███    ███   ███    ███     ███   ▀ ███    ███   ███                                     
▀▀███▀▀▀██▄  ▀███████████ ▀███████████ ▀▀███▀▀▀     ▀███████████      ███    ███ ▀▀███▀▀▀          ███    ███ ▀███████████     ███     ███    ███ ▀███████████                              
  ███    ██▄   ███    ███          ███   ███    █▄           ███      ███    ███   ███    █▄       ███    ███   ███    ███     ███     ███    ███          ███                              
  ███    ███   ███    ███    ▄█    ███   ███    ███    ▄█    ███      ███   ▄███   ███    ███      ███   ▄███   ███    ███     ███     ███    ███    ▄█    ███                              
▄█████████▀    ███    █▀   ▄████████▀    ██████████  ▄████████▀       ████████▀    ██████████      ████████▀    ███    █▀     ▄████▀    ▀██████▀   ▄████████▀                               
                                                                                                                                                                                            
                                                ▄████████      ▄█    ▄████████    ▄████████  ▄████████  ▄█   ▄████████  ▄█   ▄██████▄     ▄████████         ▄████████ ████████▄    ▄█       
                                               ███    ███     ███   ███    ███   ███    ███ ███    ███ ███  ███    ███ ███  ███    ███   ███    ███        ███    ███ ███    ███  ███       
                                               ███    █▀      ███   ███    █▀    ███    ███ ███    █▀  ███▌ ███    █▀  ███▌ ███    ███   ███    █▀         ███    █▀  ███    ███  ███       
                                              ▄███▄▄▄         ███  ▄███▄▄▄      ▄███▄▄▄▄██▀ ███        ███▌ ███        ███▌ ███    ███   ███               ███        ███    ███  ███       
                                             ▀▀███▀▀▀         ███ ▀▀███▀▀▀     ▀▀███▀▀▀▀▀   ███        ███▌ ███        ███▌ ███    ███ ▀███████████      ▀███████████ ███    ███  ███       
                                               ███    █▄      ███   ███    █▄  ▀███████████ ███    █▄  ███  ███    █▄  ███  ███    ███          ███               ███ ███    ███  ███       
                                               ███    ███     ███   ███    ███   ███    ███ ███    ███ ███  ███    ███ ███  ███    ███    ▄█    ███         ▄█    ███ ███  ▀ ███  ███▌    ▄ 
                                               ██████████ █▄ ▄███   ██████████   ███    ███ ████████▀  █▀   ████████▀  █▀    ▀██████▀   ▄████████▀        ▄████████▀   ▀██████▀▄█ █████▄▄██ 
                                                          ▀▀▀▀▀▀                 ███    ███                                                                                       ▀         
*/





/*
███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗     ██╗   
██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║    ███║
███████╗█████╗  ███████╗██║██║   ██║██╔██╗ ██║    ╚██║
╚════██║██╔══╝  ╚════██║██║██║   ██║██║╚██╗██║     ██║
███████║███████╗███████║██║╚██████╔╝██║ ╚████║     ██║
╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝     ╚═╝   
╔═╗╔═╗╦  ╔═╗╔═╗╔╦╗  ╔╗ ╔═╗╔═╗╦╔═╗╔═╗
╚═╗║╣ ║  ║╣ ║   ║   ╠╩╗╠═╣╚═╗║║  ╠═╣
╚═╝╚═╝╩═╝╚═╝╚═╝ ╩   ╚═╝╩ ╩╚═╝╩╚═╝╩ ╩
*/
/*1. Obtener toda la información almacenada en la base de datos, relacionada con los autores, sucursales, lectores, libros y editoriales.*/
	select * from univ.autor; select * from univ.lector; etc.

/*2. Obtener la fecha de nacimiento de cada uno de los lectores ordenados del más joven al mayor de ellos.*/
	select fecha_nac from lector orDER BY fecha_nac DESC;

/*3. Obtener el ISBN de los libros que están prestados indicando la sucursal y la fecha en la que se realizó el préstamo. Ordenar la salida por sucursal y fecha de préstamo.*/
	select ISBN, Cod_Suc, fecha_ini from prestamo where fecha_dev IS NOT NULL orDER BY Cod_Suc, fecha_ini ASC;

/*4. Obtener el código y nombre de las editoriales. Incluir entre ambos campos el literal NOMBRE.*/
	select codigo || ' NOMBRE ' || Nombre from univ.editorial;

/*5. Obtener primer apellido, segundo apellido y nombre de todos los lectores de la biblioteca ordenados primer y segundo apellido.*/
	select ape_1 || ' ' || ape_2 || ' ' || nombre from lector orDER BY ape_1, ape_2;

/*6. Obtener un listado de los libros ordenado de menor a mayor antigüedad.*/
	select * from libro orDER BY ano_edicion DESC;

/*7. Obtener las distintas poblaciones en las que están domiciliados los lectores, dando el nombre de la población y la provincia de cada una de ellas. 
	El listado deberá obtenerse ordenado por nombre de provincia y población. Comparar el resultado que se hubiera obtenido, de no utilizar DISTINCT.*/
	select DISTINCT poblacion, provincia from lector orDER BY provincia, poblacion;
	select poblacion, provincia from lector orDER BY provincia, poblacion;

/*8. Obtener el domicilio del lector cuyo segundo apellido sea BENITO.*/
	select direccion from lector where ape_2 = 'BENITO';

/*9. Obtener el nombre completo de los autores con  nacionalidad  española (Busque previamente el código correspondiente en la tabla nacionalidad).*/
	select codigo from univ.nacionalidad where nombre = 'ESPANA';    
	/*=> EL CODIGO ES 9*/
	select apellido || ' ' || nombre as AUTor from univ.autor where cod_nacion = '9';

/*10. Obtener la dirección postal completa de la sucursal cuyo código es 12*/
	select direccion || ', ' || poblacion || ', ' || provincia as DIRECCION from univ.sucursal where codigo = '12';

/*11. De los diferentes libros de los que disponen las sucursales indicar aquellas sucursales que tienen más de 3 ejemplares de un mismo libro. 
    Indique el código de la sucursal, el ISBN del libro y el número de ejemplares con el requisito requerido (3 o más de 3 ejemplares).*/
	select cod_suc, ISBN, num_ejemplares from univ.dispone where num_ejemplares > 3 orDER BY cod_suc ASC;

/*12. Obtener el código de los lectores s que han cogido en préstamos el libro de ISBN 5023024 ordenados por sucursal y fecha de préstamo.*/
	select cod_lector from prestamo where isbn = '5023024' order by cod_suc, fecha_ini asc;

/*13. Obtener el Código de los autores ya fallecidos la fecha en la que fallecieron y los años que tenían.*/
	select codigo, ano_fall, ano_fall-ano_nac from univ.autor where ano_fall is not null;

/*14. Obtener nombre y dos apellidos de los lectores que hayan nacido antes de 1980.*/
	select nombre, ape_1, ape_2 from lector where to_char(fecha_nac, 'yyyy') < 1980;

/*15. Obtener un listado de los lectores que a lo largo de este año superan los 23 años.*/
	select nombre, ape_1, ape_2 from lector where to_char(fecha_nac, 'yyyy') = to_char(sysdate, 'yyyy')-23;

/*16. Obtener un listado ordenado alfabéticamente de todos los lectores registrados en la base de datos que tienen domicilio en Zamora.*/
	select * from lector where poblacion = 'ZAMORA';

/*17. Obtener los libros disponibles en la sucursal con código5.*/
	select ISBN from univ.dispone where cod_suc = '5';

/*18. Obtener el código y nombre de los libros con más de 12 años de edición.*/
	select ISBN, titulo from libro where ano_edicion < to_char(sysdate, 'yyyy')-12;

/*19. Obtener los lectores cuyo domicilio habitual está en las provincias de Salamanca o Ávila.*/
	select * from lector where provincia = 'SALAMANCA' or provincia = 'AVILA';

/*20. Obtener los préstamos que no han sido devueltos indicando el código de préstamo, código de lector y fecha de inicio del préstamo. Ordénese la salida por sucursal.*/
	select codigo, cod_lector, fecha_ini from prestamo where fecha_dev is null order by cod_suc;

/*21. Obtener el nombre de los profesores pertenecientes las nacionalidades española, francesa o británica 
	(Busque previamente el código correspondiente en la tabla nacionalidad).
	=> 9, 11, 25*/
	select nombre, apellido from univ.autor where cod_nacion = '9' or cod_nacion = '11' or cod_nacion = '25';

/*22. Obtener un listado que incluya el código, nombre y provincia de los lectores que no vivan ni en la provincia de Salamanca ni en la de Zamora.*/
	select codigo, nombre, provincia from lector where provincia != 'SALAMANCA' and provincia != 'ZAMORA';

/*23. Obtener el nombre y apellido de aquellos lectores cuyo primer apellido empiece por M.*/
	select nombre, ape_1, ape_2 from lector where ape_1 like 'M%';

/*24. Obtener el nombre de los lectores cuyo apellido empiece por G e incluya alguna Z.*/
	select nombre from lector where (ape_1 like 'G%' and ape_1 like '%Z%') or (ape_2 like 'G%' and ape_2 like '%Z%');

/*25. Obtener el nombre y apellidos de aquellos lectores que tengan un primer apellido de 7 letras.*/
	select nombre, ape_1, ape_2 from lector where length(ape_1) = 7;

/*26. Seleccionar los lectores que han tengan edades comprendidas entre los 26 y los 36 años. Ordenar de mayor a menor edad.*/
	select nombre, ape_1, ape_2, (to_char(sysdate, 'yyyy')-to_char(fecha_nac,'yyyy')) as edad from lector where (to_char(sysdate, 'yyyy')-to_char(fecha_nac,'yyyy'))
	between 26 and 36 order by 4 desc;

/*27. Seleccionar los autores que no son españoles.*/
	select nombre, apellido from univ.autor where cod_nacion != '9';

/*28. Mostrar los nombres, apellidos y edad de los autores vivos que no son españoles y que tienen más de 70 años o menos de 50.*/
	select nombre, apellido, (to_char(sysdate, 'yyyy')-ano_nac) as edad from univ.autor where ano_fall is null and cod_nacion != '9'
	and (to_char(sysdate, 'yyyy')-ano_nac) BETWEEN 50 and 70;

/*29. Obtener los datos de los préstamos que o bien son de la sucursal 5 y han sido devueltos o bien son de la sucursal 10 y aún están en vigor.*/
	select * from prestamo where (cod_suc = '5' and fecha_dev is not null) or (cod_suc = '10' and fecha_dev is null);





/*
███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗    ██████╗ 
██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║    ╚════██╗
███████╗█████╗  ███████╗██║██║   ██║██╔██╗ ██║     █████╔╝
╚════██║██╔══╝  ╚════██║██║██║   ██║██║╚██╗██║    ██╔═══╝ 
███████║███████╗███████║██║╚██████╔╝██║ ╚████║    ███████╗
╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝    ╚══════╝
 ╦╔═╗╦╔╗╔
 ║║ ║║║║║
╚╝╚═╝╩╚╚╝
*/
/*1. Mostrar el listado de títulos y autores de los libros de la base de datos.*/
	select titulo, a.nombre, a.apellido from autor a, escribe e, libro l where codigo=cod_autor and e.isbn=l.isbn order by 3,2;

/*2. Obtener los títulos de los libros disponibles en las sucursales de la ciudad de Salamanca indicando además el código de la sucursal.*/
	select titulo from libro l, dispone d, sucursal s where l.isbn=d.isbn and (codigo=cod_suc and poblacion='SALAMANCA');

/*3. Listar los títulos de los libros que están actualmente en préstamo en la sucursal con código 7.*/
	select titulo from libro l, prestamo p where l.isbn=p.isbn and cod_suc=7 and fecha_dev is null order by 1;

/*4. Repetir el listado anterior añadiendo el nombre del lector que tiene cada libro.*/
	select titulo, e.nombre from libro l, prestamo p, lector e where l.isbn=p.isbn and cod_suc=7 and fecha_dev is null order by 1;

/*5. Obtener el código de sucursal, título de libro y número de ejemplares asignados para aquellos casos en que el número de ejemplares sea mayor que 3.*/
	select cod_suc, titulo, num_ejemplares from univ.libro l, univ.dispone d where l.isbn=d.isbn and num_ejemplares > 3 order by 1;

/*6. Seleccionar los autores anteriores al siglo XIX mostrando su nombre, apellidos y nacionalidad.*/
	select a.nombre, apellido, n.nombre from univ.autor a, univ.nacionalidad n where cod_nacion=n.codigo and ano_fall < 1800;

/*7. Obtener un listado de los libros de la editorial COSMOS mostrando el título del libro y el nombre y apellidos de su autor.*/
	select titulo, a.nombre, apellido from univ.libro l, univ.autor a, univ.escribe es, univ.editorial ed where l.isbn=es.isbn and a.codigo=es.cod_autor
	and l.cod_editorial=ed.codigo and ed.nombre='COSMOS';

/*8. Obtener un listado de los títulos de los libros que ha leído el socio cuyo primer apellido es TRIGO ordenado por la fecha en la que realizó el préstamo.*/
	select titulo, fecha_ini from univ.prestamo p, univ.libro li, univ.lector le where p.isbn=li.isbn and p.cod_lector=le.codigo and ape_1='TRIGO' order by 2;

/*9. Mostrar la localidad de las sucursales en las que ha realizado prestamos CARLOS LOPEZ CUADRADO*/
	select distinct s.poblacion from univ.sucursal s, univ.prestamo p, univ.lector le where s.codigo=p.cod_suc and le.codigo=p.cod_lector and le.nombre='CARLOS'
	and ape_1='LOPEZ' and ape_2='CUADRADO';

/*10. Listar los nombres de los lectores que han leído libros de MARIO VARGAS LLOSA.*/
	select distinct le.nombre, le.ape_1, le.ape_2 from univ.lector le, univ.prestamo p, univ.escribe e, univ.autor a where le.codigo=p.cod_lector and p.isbn=e.isbn
	and e.cod_autor=a.codigo and a.nombre='MARIO' and a.apellido='VARGAS LLOSA';

/*11. Obtener un listado de los títulos de los libros de autor anónimo.*/
/* select l.titulo from autor a, libro l where a.nombre is null; no funcionaría. */
	select l1.titulo from libro l1
	minus
	select l2.titulo from libro l2, escribe e where l2.isbn=e.isbn;
	/*Le resta a todos los libros (l1) los libros que están vinculados a algún autor (l2). */

/*+12. Todos los autores que tienen algun libro publicado con la editorial LAGARTIJA*/
	select cod_autor, a.nombre, apellido from libro l, editorial e, escribe es, autor a where a.codigo=es.cod_autor and l.cod_editorial=e.codigo and l.isbn=es.isbn
	and e.nombre='LAGARTIJA' order by 3, 2;

/*+13. Todos los libros publicados con la editorial LAGARTIJA*/
	select * from libro, editorial where cod_editorial=codigo and nombre='LAGARTIJA';

/*+14. Mostrar el número de ejemplares disponibles en todas las sucursales de la base de datos del libro "EL HOBBIT".*/
	select sum(d.num_disponibles) as disponibles
	from dispone d, libro l
	where l.isbn=d.isbn and l.titulo='EL HOBBIT';

/*+15. Obtén la edad media de los lectores que han realizado un préstamo en alguna sucursal de la provincia de SALAMANCA.
	Necesita subselect (que aun no se ha visto). */





/*
███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗    ██████╗ 
██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║    ╚════██╗
███████╗█████╗  ███████╗██║██║   ██║██╔██╗ ██║     █████╔╝
╚════██║██╔══╝  ╚════██║██║██║   ██║██║╚██╗██║     ╚═══██╗
███████║███████╗███████║██║╚██████╔╝██║ ╚████║    ██████╔╝
╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝    ╚═════╝ 
╔═╗╦ ╦╔╦╗╔═╗╦═╗   ╦╔═╗╦╔╗╔   ╦ ╦╔╗╔╦╔═╗╔╗╔   ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔═╗╔╦╗  ┬ ┬  ╔╦╗╦╔╗╔╦ ╦╔═╗
║ ║║ ║ ║ ║╣ ╠╦╝   ║║ ║║║║║   ║ ║║║║║║ ║║║║   ║║║║ ║ ║╣ ╠╦╝╚═╗║╣ ║   ║   └┬┘  ║║║║║║║║ ║╚═╗
╚═╝╚═╝ ╩ ╚═╝╩╚═  ╚╝╚═╝╩╝╚╝┘  ╚═╝╝╚╝╩╚═╝╝╚╝┘  ╩╝╚╝ ╩ ╚═╝╩╚═╚═╝╚═╝╚═╝ ╩    ┴   ╩ ╩╩╝╚╝╚═╝╚═╝
*/
/*1. Realizar al menos 5 de los ejercicios de la sesión 2, haciendo uso de la clausula JOIN en el FROM.
	Por ejemplo, lo hacemos para los últimos 5 ejercicios de la sesión 2*/
	/*2.6. Seleccionar los autores anteriores al siglo XIX mostrando su nombre, apellidos y nacionalidad.*/
		select a.nombre, apellido, n.nombre from autor a join nacionalidad n on cod_nacion=n.codigo where ano_fall < 1800;

	/*2.7. Obtener un listado de los libros de la editorial COSMOS mostrando el título del libro y el nombre y apellidos de su autor.*/
		select titulo, a.nombre, apellido from ((libro l join escribe es on l.isbn=es.isbn) join autor a on a.codigo=es.cod_autor)
		join editorial ed on l.cod_editorial=ed.codigo
		where ed.nombre='COSMOS';

	/*2.8. Obtener un listado de los títulos de los libros que ha leído el socio cuyo primer apellido es TRIGO ordenado por la fecha en la que realizó el préstamo.*/
		select titulo, fecha_ini from prestamo p join libro li on p.isbn=li.isbn join lector le on p.cod_lector=le.codigo 
		where ape_1='TRIGO' order by 2;

	/*2.9. Mostrar la localidad de las sucursales en las que ha realizado prestamos CARLOS LOPEZ CUADRADO */
		select distinct s.poblacion from sucursal s join prestamo p on s.codigo=p.cod_suc join lector le on le.codigo=p.cod_lector
		where le.nombre='CARLOS' and ape_1='LOPEZ' and ape_2='CUADRADO';

	/*2.10. Listar los nombres de los lectores que han leído libros de MARIO VARGAS LLOSA.*/
		select distinct le.nombre, le.ape_1, le.ape_2 from ((lector le join prestamo p on le.codigo=p.cod_lector) join escribe e on p.isbn=e.isbn)
		join autor a on e.cod_autor=a.codigo
		where a.nombre='MARIO' and a.apellido='VARGAS LLOSA';

/*2. Obtener un listado de los títulos de los libros asignados a la sucursal número 3, indicando para cada uno de ellos 
	los códigos de los lectores que lo han tenido en préstamo. El listado deberá incluir los títulos que no han sido prestados y se presentará ordenado por título.*/
	select titulo, p.cod_lector from (libro li join dispone d on li.isbn=d.isbn) left join prestamo p on p.isbn=d.isbn and p.cod_suc=d.cod_suc
	where d.cod_suc=3 order by 1;

	/*O también*/
	select titulo, p.cod_lector from (libro li join dispone d on li.isbn=d.isbn and d.cod_suc=3) 
	left join prestamo p on p.isbn=d.isbn and p.cod_suc=d.cod_suc order by 1;

/*3. Listar los títulos de los libros que no están asignados a sucursales de la ciudad de SALAMANCA.*/
	select titulo from sucursal s join dispone d on s.codigo=d.cod_suc and s.poblacion='SALAMANCA' right join libro l on l.isbn=d.isbn
	where num_ejemplares is null;

/*4.  Obtener los nombres de los lectores que han retirado préstamos en la sucursal 5 o en la 3.
	Se presentan tres posibles soluciones:*/
	select distinct nombre, ape_1, ape_2 from lector l join prestamo p on l.codigo=p.cod_lector where p.cod_suc in (5, 3);

	select distinct nombre, ape_1, ape_2 from lector l join prestamo p on l.codigo=p.cod_lector where p.cod_suc=5 or p.cod_suc=3;

	select nombre, ape_1, ape_2 from lector l join prestamo p on l.codigo=p.cod_lector where p.cod_suc=5 
	union
	select nombre, ape_1, ape_2 from lector l join prestamo p on l.codigo=p.cod_lector where p.cod_suc=3;

/*5. Obtener los nombres de los lectores que han retirado préstamos tanto en la sucursal 5 como en la 3.*/
	select nombre, ape_1, ape_2 from lector l join prestamo p on l.codigo=p.cod_lector where p.cod_suc=5 
	intersect
	select nombre, ape_1, ape_2 from lector l join prestamo p on l.codigo=p.cod_lector where p.cod_suc=3;

/*6. Obtener un listado de todos los lectores de la provincia de ZAMORA indicando los libros que actualmente tienen en préstamo (pendiente de devolución).
	El listado deberá incluir el nombre del lector, el título del libro prestado y la fecha de inicio del préstamo. 
	Se listarán igualmente aquellos lectores de la provincia indicada que no tengan actualmente ningún préstamo activo.*/
	select nombre, ape_1, ape_2, titulo, fecha_ini from lector le left join prestamo p on fecha_dev is null and le.codigo=p.cod_lector
	left join libro li on p.isbn=li.isbn where provincia='ZAMORA';

/*7. Obtener un listado de los nombres de pila de los lectores que coinciden con nombres de algún escritor.*/
	select nombre from lector
	intersect
	select nombre from autor;

/*8. Obtener un listado de los títulos de libros de autores de nacionalidad italiana o francesa.*/
	select titulo from (((libro l join escribe e on l.isbn=e.isbn) join autor a on a.codigo=e.cod_autor) 
	join nacionalidad n on n.codigo=a.cod_nacion)
	where n.nombre in ('FRANCIA', 'ITALIA');





/*
███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗    ██╗  ██╗
██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║    ██║  ██║
███████╗█████╗  ███████╗██║██║   ██║██╔██╗ ██║    ███████║
╚════██║██╔══╝  ╚════██║██║██║   ██║██║╚██╗██║    ╚════██║
███████║███████╗███████║██║╚██████╔╝██║ ╚████║         ██║
╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝         ╚═╝
╔═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔  ╔╦╗╔═╗  ╔╦╗╔═╗╔╗ ╦  ╔═╗╔═╗
║ ╦║╣ ╚═╗ ║ ║║ ║║║║   ║║║╣    ║ ╠═╣╠╩╗║  ╠═╣╚═╗
╚═╝╚═╝╚═╝ ╩ ╩╚═╝╝╚╝  ═╩╝╚═╝   ╩ ╩ ╩╚═╝╩═╝╩ ╩╚═╝
*/
/*Antes de comenzar a hacer los ejercicios de esta sesión se deben ejecutar los siguientes comandos en sqlplus:*/
	commit;												 
	set autocommit on;

/*1. Crear las siguientes tablas correspondientes a una base de datos con información sobre los empleados y proyectos de una empresa:
	EMPLEADO (DNI*, Nombre, Apellidos, FechaAlta, Salario)
	PROYECTO (Codigo*, Nombre, Presupuesto, FechaInicio, FechaFin)
	TRABAJA_EN (DNI*, Cod_Proy*, Horas)
	Teniendo en cuenta las siguientes restricciones:
		• Los atributos DNI y Codigo de proyecto son de tipo entero.
		• Los atributos que aparecen con * son las claves primarias de cada relación.
		• Ningún atributo de la tabla EMPLEADO podrá tener un valor nulo.
		• No se permitirá que dos empleados coincidan en nombre y apellidos.
		• Por defecto, la fecha de alta de un empleado se tomará como la fecha en la que se inserte la tupla correspondiente al empleado.
		• El salario será siempre una cantidad entera entre 14400 y 45000. Por defecto se asignará un valor de 20000 si no se proporciona uno específico
		  en el momento de dar el alta.
		• Los atributos Presupuesto, FechaIncio y FechaFin de la tabla PROYECTO podrán tener un valor nulo. El resto de los atributos de esa tabla serán siempre no nulos.
		• No se permite que dos proyectos tengan el mismo nombre.
		• Por defecto, el atributo FechaInicio tomará el valor correspondiente a la fecha en la que se inserte la tupla en la tabla PROYECTO.
		• El número de horas que un empleado trabaja en cada proyecto será siempre un valor no nulo comprendido entre 10 y 40. Por defecto se asignará el valor 10.*/
	create table EMPLEADO (
	DNI integer not null primary key,
	Nombre varchar(20) not null,
	Apellidos varchar(20) not null,
	FechaAlta date default sysdate not null,
	Salario decimal (7,2) default 20000 not null check (Salario >= 14400 and Salario <= 45000),
	constraint EMP_UNIQ unique (Nombre, Apellidos));

	/*NOTA: Damos el nombre EMP_UNIQ a la última restricció para que nos sea más sencillo eliminarla después. Dar nombre a las restricciones no es obligatorio
	(así, no lo hemos hecho para las restricciones de check o primary key). Por tanto la tabla puede crearse igualmente con la siguiente sentencia:*/
	create table EMPLEADO (
	DNI integer not null primary key,
	Nombre varchar(20) not null,
	Apellidos varchar(20) not null,
	FechaAlta date default sysdate not null,
	Salario decimal (7,2) default 20000 not null check (Salario >= 14400 and Salario <= 45000),
	unique (Nombre, Apellidos));
	/*FIN NOTA*/
	
	create table PROYECTO (
	Codigo integer not null primary key,
	Nombre varchar(20) not null unique,
	Presupuesto decimal (9,2),
	FechaInicio date default sysdate,
	FechaFin date);

	create table TRABAJA_EN (
	DNI integer not null references empleado,
	Cod_Proy integer not null references proyecto,
	Horas integer default 10 not null check (Horas >= 10 and Horas <= 40),
	primary key (DNI, Cod_Proy));
	/*El orden de creación de las tablas es importante. No podemos crear TRABAJA_EN hasta que no estén creadas las otras dos ya que TRABAJA_EN hace referencia a ellas*/

	/*OTRA FORMA DE PONER LAS CLAVES EXTERNAS EN TRABAJA_EN
	
	Sabemos que las restricciones primary key, unique, foreign key y check pueden hacerse de dos maneras:
		- A nivel de columna, cuando la restricción afecta solo a una columna. Se pone la restricción en la definición de la columna afectada.
		- A nivel de tabla. Obligatoriamente si la restricción afecta a máss de una columna y opcionalmente si afecta solo a una.
		  Se pone la restricción aparte de las definiciones de la/s columna/s afectada/s.

	Por ejemplo, en la tabla TRABAJA_EN, la restricción de clave primaria afecta a dos columnas y se tiene que poner obligatoriamente nivel de tabla
	pero la restricción DNI es clave externa sobre EMPLEADO afecta solo a la columna DNI, por lo que podemos elegir entre:
		- Definirla a nivel de columna, como está hecho en la sentencia anterior de creación de la tabla.
		- Definirla a nivel de tabla, como está hecho en la sentencia de creación de la misma tabla escrita a continuación. 
		  En esta sentencia hemos definido las dos claves externass de la tabla a nivel de tabla.*/

	create table TRABAJA_EN (
	DNI integer not null,
	Cod_Proy integer not null,
	Horas integer default 10 not null check (Horas >= 10 and Horas <= 40),
	primary key (DNI, Cod_Proy),
	foreign key (DNI) references empleado,
	foreign key (Cod_Proy) references proyecto(Codigo));

	/*Nótese lo siguiente:
		- Las palabras reservadas foreign key, solo aparecen en la definición a nivel de tabla, no se ponen en la definición a nivel de columna, 
		  aunque el efecto en los dos casos es el mismo.
		- Tenemos también la opción de poner a continuacón del nombre de la tabla referenciada y entre paréntesis en nombre de la columna referenciada.
		  En el último ejemplo hemos usado esta opción en la definición de la clave externa sobre Cod_Proy */

/*2. Comprobar la estructura de las tablas creadas usando el comando desc de sqlplus*/
	desc EMPLEADO

	/*NOTA:	desc no es una sentencia SQL sino un comando de sqlplus que nos muestra información sobre una tabla. 
	Ver este y otros comandos de sqlplus en el guión de la Sesión 0 de prácticas de la asignatura. La información mostrada se obtiene del católogo de ORACLE.

	Al ejecutar el comando anterior obtendríamos la siguiente información :
	Name                                      Null?    Type
	----------------------------------------- -------- ----------------------------
	DNI                                       NOT NULL NUMBER(38)
	NOMBRE                                    NOT NULL VARCHAR2(20)
	APELLIDOS                                 NOT NULL VARCHAR2(20)
	FECHAALTA                                 NOT NULL DATE
	SALARIO                                   NOT NULL NUMBER(7,2)

	FIN NOTA*/

	desc PROYECTO
	desc TRABAJA_EN 

/*3. Insertar los siguientes datos correspondientes a un empleado: Agustin Perez Marcos, con DNI 1231234 y salario 21000. Realizar la inserción
	sin proporcionar valor para el atributo FechaAlta. Comprobar que se ha insertado correctamente la tupla con el valor adecuado en FechaAlta.*/
	insert into EMPLEADO (NOMBRE, APELLIDOS, DNI, SALARIO) values ('Agustin', 'Perez Marcos', 1231234, 21000);
	select * from EMPLEADO where dni=1231234;

/*4. Insertar la siguiente información correspondiente a un proyecto: Código=21234, Nombre=’PUENTE’. Comprobar la información insertada.*/
	insert into PROYECTO (CODIGO, NOMBRE) values (21234, 'PUENTE');
	select * from PROYECTO where codigo=21234;

/*5. Insertar una tupla en TRABAJA_EN Indicando que el empleado Agustin Perez trabaja 15 horas semanales en el proyecto PUENTE.*/
	insert into TRABAJA_EN values (1231234, 21234, 15);

/*6. Insertar una tupla en TRABAJA_EN indicando que el empleado con DNI 3214321 trabaja 10 horas en el proyecto PUENTE. ¿Qué ocurre?*/
	insert into TRABAJA_EN values (3214321, 21234, 10);

	/*Lo que ocurre es que se obtiene un error debido a que el DNI 3214321 no existe en la tabla EMPELADO, por lo que esta inserción violaría la restriccióon de que DNI
	es clave externa sobre TRABAJA_EN

	El mensaje obtenido sería similar al siguiente:
	ERROR at line 1:
	ORA-02291: integrity constraint (OPS$i010101010.SYS_C0086669) violated - parent key not found

	En este mensaje se indica el nombre de la restricción (OPS$i010101010.SYS_C0086669). Este es un nombre puesto por el sistema
	puesto que no lo hemos proporcionado nosotros en la definición

	IMPORTANTE: Si no se obtiene un error, es que la definición de la tabla no es correcta pues no se ha incluido una restricción de integridad necesaria.*/

/*7. Modificar la estructura de la tabla EMPLEADO para que contenga una nueva columna que permita almacenar la titulación de cada empleado.*/
	alter table EMPLEADO add titulacion varchar(50);

/*8. Modificar la tabla empleado para eliminar la restricción que no permite que dos empleados se llamen igual.
	Nótese que hemos sido previsores y en la creación de la tabla dimos un nombre a esa restricción por lo que ahora simplemente tenemos que indicar que se elimine esa restricción.
	Si no le hemos dado un nombre en la creación, tenemos que averiguar qué nombre le ha dado el sistema, para lo cual podemos consultar el catálogo o bien
	intentar violarla para ver, en el mensaje de error que obtendremos, el nombre de la restricción, de modo similar a lo visto en el EJERCICIO 6*/
	alter table EMPLEADO drop constraint EMP_UNIQ;

/*9. Eliminar la tabla EMPLEADO. ¿Qué ocurre?*/
	drop table EMPLEADO;

	/*No se nos debe permitir hacerlo porque no se puede eliminar una tabla que es referenciada por otro objeto, ya que esto violaría la regla de integridad referencial. 
	En nuestro caso, EMPLEADO está referenciada por TRABAJA_EN.
	
	Deberíamos obtener un mensaje de error como el siguiente:
	ERROR at line 1:
	ORA-02449: unique/primary keys in table referenced by foreign keys*/

/*10. Eliminar todas las tablas creadas en el orden adecuado.
	No podemos empezar borrando las tablas EMPLEADO ni PROYECTO, puesto que TRABAJA_EN hace referecia a ellas.
	Por tanto, se elimina primero la tabla TRABAJA_EN, ya que no hay ninguna otra que haga referencia a ella.
	A continuación, ya nadie hace referencia a EMPLEADO ni a PROYECTO, por lo que las podemos eliminar en cualquier orden.*/
	drop table TRABAJA_EN;
	drop table EMPLEADO;
	drop table PROYECTO;





/*
███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗    ███████╗
██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║    ╚════██║
███████╗█████╗  ███████╗██║██║   ██║██╔██╗ ██║        ██╔╝
╚════██║██╔══╝  ╚════██║██║██║   ██║██║╚██╗██║       ██╔╝ 
███████║███████╗███████║██║╚██████╔╝██║ ╚████║       ██║  
╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝       ╚═╝ 
╔═╗╔═╗╦═╗╦ ╦╔═╗╔═╗╔═╗╦╔═╗╔╗╔  ╔╦╗╔═╗  ╦═╗╔═╗╔═╗╦ ╦╦ ╔╦╗╔═╗╔╦╗╔═╗╔═╗
╠═╣║ ╦╠╦╝║ ║╠═╝╠═╣║  ║║ ║║║║   ║║║╣   ╠╦╝║╣ ╚═╗║ ║║  ║ ╠═╣ ║║║ ║╚═╗
╩ ╩╚═╝╩╚═╚═╝╩  ╩ ╩╚═╝╩╚═╝╝╚╝  ═╩╝╚═╝  ╩╚═╚═╝╚═╝╚═╝╩═╝╩ ╩ ╩═╩╝╚═╝╚═╝
(No, no faltan sesiones, se salta la 5 y la 6 (las ordena de otra manera))
*/
/*1. Hallar el n�mero de lectores que no tienen domicilio en Salamanca capital.*/
	select count(codigo) from univ.LECTOR where poblacion != 'SALAMANCA';
	/*O también*/
	select count(*) from univ.LECTOR where poblacion != 'SALAMANCA';

/*2. Calcular la edad máxima, mínima y media de los lectores.*/
	select max(to_char(sysdate, 'yyyy') - to_char(fecha_nac, 'yyyy')) as Edad_Max,
	min(to_char(sysdate, 'yyyy') - to_char(fecha_nac, 'yyyy')) as Edad_Min,
	avg(to_char(sysdate, 'yyyy') - to_char(fecha_nac, 'yyyy')) as Edad_Media
	from univ.lector;

/*3. Obtener el total de préstamos realizados por cada sucursal en el año 2007.*/
	select cod_suc as Suc, count(*) as Total_Prestamos 
	from univ.prestamo where to_char(fecha_ini, 'yyyy')=2007 group by cod_suc order by cod_suc;

/*4. Obtener un listado con el código de todos los lectores que realizaron préstamos el año 96.*/
	select cod_lector from univ.prestamo where to_char(fecha_ini, 'yyyy')=1996 group by cod_lector;

	/*También se puede hacer con distinct en lugar de con la agrupación. Si no se usan funciones de agregación, distinct y group by son equivalentes*/
	select distinct cod_lector from univ.prestamo where to_char(fecha_ini, 'yyyy')=1996;

/*5. Obtener el número de autores por nacionalidades de los que se tiene ejemplares en la biblioteca.*/
	select n.nombre Nacion, count(a.codigo) Num_Autores from univ.nacionalidad n join univ.autor a on n.codigo=a.cod_nacion
	group by n.codigo, n.nombre;

/*6. Hacer un listado con el número de ejemplares en préstamo en cada sucursal.
	Nota: Entendemos que se refiere a ejemplares actualmente en préstamo.*/
	select cod_suc, count(codigo) 
	from univ.prestamo where fecha_dev is null group by cod_suc order by cod_suc;

	/*También podríamos obtenerlo a partir de la tabla DISPONE restando del total de ejemplares el total de los disponibles:*/
	select cod_suc, sum(num_ejemplares) - sum (num_disponibles) from univ.dispone group by cod_suc order by cod_suc;

	/*O bien:*/ 
	select cod_suc, sum(num_ejemplares - num_disponibles) from univ.dispone group by cod_suc order by cod_suc;

/*7. Obtener los títulos de los libros y el número total de ejemplares en el conjunto de las sucursales.*/
	select titulo, sum (num_ejemplares) from univ.libro l join univ.dispone d on l.isbn=d.isbn
	group by l.isbn, titulo;

	/*Agrupamos también por isbn en previsión de que libros distintos puedan tener el mismo título.*/

/*8. Obtener un listado de sucursales y el n�mero de ejemplares de los que dispone.*/
	select s.codigo, sum (num_ejemplares) from univ.sucursal s left join univ.dispone d on s.codigo=d.cod_suc group by s.codigo order by 2;

/*9. Indicar para los años 2000 a 2005 el número de lectores que realizaron préstamos cada uno de esos años.*/
	select to_char(fecha_ini, 'yyyy'), count(*) from univ.prestamo where to_char(fecha_ini, 'yyyy') between 2000 and 2005
	group by to_char(fecha_ini, 'yyyy') order by 1;

/*10. Obtener los títulos de los libros que hayan tenido más de 5 préstamos, indicando el número total de préstamos de cada libro.*/
	select titulo, count(p.codigo) from univ.libro l join univ.prestamo p on l.isbn=p.isbn 
	group by l.isbn, titulo having count(p.codigo) > 5;

/*11. Obtener los nombres y apellidos de los lectores de la ciudad de Salamanca que tienen en este momento más de un libro en préstamo.*/
	select nombre, ape_1, ape_2 from univ.lector l join univ.prestamo p on l.codigo=p.cod_lector 
	where fecha_dev is null and poblacion='SALAMANCA'
	group by l.codigo, nombre, ape_1, ape_2 having count(*) > 1;

	/*Incluimos el código del lector en el group by en previsión de que distintos lectores puedan tener los mismos nombres y apellidos.*/

/*12. Obtener, para cada título, el número medio de ejemplares de ese título en todas las sucursales.*/
	select titulo, avg(num_ejemplares) as Media_Ejemplares from univ.libro l left join univ.dispone d on l.isbn=d.isbn
	group by l.isbn, titulo;

/*13. Obtener el libro más recientemente editado*/
	select l1.isbn, l1.titulo from libro l1, libro l2 group by l1.isbn, l1.titulo, l1.ano_edicion having l1.ano_edicion = max (l2.ano_edicion);

	/*NOTA: Este ejercicio también se puede resolver mediante subselect.*/





/*
███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗     █████╗ 
██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║    ██╔══██╗
███████╗█████╗  ███████╗██║██║   ██║██╔██╗ ██║    ╚█████╔╝
╚════██║██╔══╝  ╚════██║██║██║   ██║██║╚██╗██║    ██╔══██╗
███████║███████╗███████║██║╚██████╔╝██║ ╚████║    ╚█████╔╝
╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝     ╚════╝ 
╔═╗╦ ╦╔╗ ╔═╗╔═╗╦  ╔═╗╔═╗╔╦╗
╚═╗║ ║╠╩╗╚═╗║╣ ║  ║╣ ║   ║ 
╚═╝╚═╝╚═╝╚═╝╚═╝╩═╝╚═╝╚═╝ ╩
*/
/*1. Listar los ISBN de los libros disponibles en la sucursal 5 en un nº superior al del libro con ISBN 5024392.*/ 
	select isbn, num_disponibles from univ.dispone where cod_suc=5 and Num_Disponibles > 
	(select num_disponibles from univ.dispone where ISBN= 5024392 and cod_suc=5); 

/*2. Listar el nombre y apellidos de todos los lectores de la provincia de Cáceres que tienen una fecha de nacimiento anterior a la de:
	a. Alguno de los lectores de la provincia de Zamora.*/
	select nombre, ape_1, ape_2 from univ.lector where provincia='CACERES' and fecha_nac < any (select fecha_nac from univ.lector where provincia='ZAMORA');

	/*b. Cualquiera de los lectores de la provincia de Zamora.*/
	select nombre, ape_1, ape_2 from univ.lector where provincia='CACERES' and fecha_nac < all (select fecha_nac from univ.lector where provincia='ZAMORA');

/*3. Lectores que hayan nacido en una fecha posterior a la de todos los autores.*/
	select nombre, ape_1, ape_2 from univ.lector where to_char(fecha_nac, 'yyyy') > all (select ano_nac from univ.autor where ano_nac is not null);

	select nombre, ape_1, ape_2 from univ.lector where to_number(to_char(fecha_nac, 'yyyy')) > all (select to_number(ano_nac) from univ.autor where ano_nac is not null);
	select nombre, ape_1, ape_2 from univ.lector where to_char(fecha_nac, 'yyyy') > (select max(ano_nac) from univ.autor);

/* 4. Autores de la nacionalidad de ISABEL ALLENDE y que hayan nacido en el mismo año que CARMEN POSADAS.*/
	select * from univ.autor where cod_nacion=(select cod_nacion from univ.autor where nombre='ISABEL' and apellido='ALLENDE')
	and ano_nac=(select ano_nac from univ.autor where nombre='CARMEN' and apellido='POSADAS');

/*5. Autores que hayan nacido en una fecha posterior a alguno de los lectores.*/
	select nombre, apellido from univ.autor where ano_nac > any (select to_char(fecha_nac, 'yyyy') from univ.lector);
	/*No hay ninguno.*/

/*6. Datos de la sucursal/sucursales que tiene el mayor número de préstamos*/
	select * from univ.sucursal s where codigo in (select cod_suc from univ.prestamo p group by cod_suc 
	having count(*)=(select max(count(*)) from univ.prestamo group by cod_suc));

/*7. Datos del/los lector/s que realizó durante el año pasado el mayor número de préstamos.*/
	select * from univ.lector l where codigo in (select cod_lector from univ.prestamo p 
	where to_char (fecha_ini, 'yyyy')=to_char(sysdate,'yyyy')-1 group by cod_lector 
	having count(*)=(select max(count(*)) from univ.prestamo where to_char (fecha_ini, 'yyyy')=to_char(sysdate,'yyyy')-1
	group by cod_lector));

/*8. Obtener el listado del autor/es con más libros, indicando el número.*/
	select nombre, apellido, count (*) from univ.autor join univ.escribe on codigo=cod_autor
	group by codigo, nombre, apellido having count(*) >= all (select max(count(*)) from univ.escribe group by cod_autor);

/*9. Datos del lector de más edad de la red de bibliotecas.*/
	select nombre, ape_1, ape_2 from univ.lector where fecha_nac = (select min(fecha_nac) from univ.lector);

/*10. Datos de los lectores de más edad de cada provincia.
	CORRELACIÓN.*/
	select provincia, nombre, ape_1, ape_2 from univ.lector l where fecha_nac = (select min(fecha_nac) from univ.lector where provincia=l.provincia);

/*11. Verifique si existe algún libro que no haya sido nunca cogido en préstamo en alguna sucursal. Si existe proporcione título del libro y 
	la sucursal/es a la que pertenece.
	CORRELACIÓN.*/
	select l.isbn, titulo, cod_suc from univ.libro l join univ.dispone d on l.isbn=d.isbn 
	where not exists (select * from prestamo where isbn=d.isbn and cod_suc=d.cod_suc) order by titulo, cod_suc;

/*12. Verifique si existe algún libro que no haya sido nunca cogido en préstamo en ninguna sucursal. Si existe proporcione título del libro.
	CORRELACIÓN.*/
	select l.isbn, titulo from univ.libro l 
	where not exists (select * from prestamo where isbn=l.isbn) order by titulo;

/*13. Nombre de los autores más antiguos de su nacionalidad, indicando el autor y la nacionalidad.
	CORRELACIÓN.*/
	select n.nombre, a.nombre, a.apellido from univ.nacionalidad n join univ.autor a on n.codigo=a.cod_nacion
	where a.ano_nac <= all (select ano_nac from univ.autor where cod_nacion=a.cod_nacion);

/*14. Presentar un listado de sucursales indicando el libro que más ejemplares tiene.
	CORRELACIÓN.*/
	select d.cod_suc, l.isbn, l.titulo, num_ejemplares from univ.dispone d join univ.libro l on d.isbn=l.isbn
	where num_ejemplares >= all (select num_ejemplares from univ.dispone where cod_suc=d.cod_suc) order by 1;

	select d.cod_suc, l.isbn, l.titulo from univ.dispone d join univ.libro l on d.isbn=l.isbn
	where num_ejemplares = (select max(num_ejemplares) from univ.dispone where cod_suc=d.cod_suc);

/*15. Presentar un listado de todos los lectores que no hayan realizado préstamos.
	CORRELACIÓN.*/
	select nombre, ape_1, ape_2 from univ.lector l where not exists (select * from univ.prestamo where cod_lector=l.codigo);

/*16. Obtener las localidades en las que viven lectores y no existan sucursales.
	CORRELACIÓN.*/
	select distinct poblacion from univ.lector l where not exists (select * from univ.sucursal where poblacion=l.poblacion);

/*17. Nombre de los lectores que han obtenido prestamos en todas las sucursales.
	DIVISIÓN.*/
	select nombre, ape_1, ape_2 from univ.lector l where not exists (select * from univ.sucursal s
	where not exists (select * from univ.prestamo where cod_suc=s.codigo and cod_lector=l.codigo));

/*18. Nombre de los lectores que han obtenido prestamos en todas las sucursales de su provincia de residencia.
	DIVISIÓN.*/
	select nombre, ape_1, ape_2 from univ.lector l where not exists (select * from univ.sucursal s
	where s.provincia=l.provincia and not exists (select * from univ.prestamo where cod_suc=s.codigo and cod_lector=l.codigo));