package view;

import static com.coti.tools.DiaUtil.clear;
import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.yesOrNo;
import controller.Controller;
import java.io.IOException;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class View {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\033[1;94m";

    Controller c = new Controller();
    Scanner sc = new Scanner(System.in);;
    
    private int arranque() {
        return c.arranque();
    }
    
    public void runMenu(String menu) throws Exception {
        int codigoRetorno = this.arranque();

        if (codigoRetorno == 0){
            boolean salir = false;
            String option;
            String[] availableOptions = {"1", "2", "3", "4", "5", "q"};

            do {
                borrarPantallaYMostrarTitulo();
                option = leerString(menu, availableOptions);
                switch (option){
                    case "1": this.menuArchivos();                                          break;
                    case "2": this.menuPeliculas();                                         break;
                    case "3": this.menuDirectores();                                        break;
                    case "4": this.menuActores();                                           break;
                    case "5": this.menuListados();                                          break;
                    case "q":
                    case "Q": salir = yesOrNo("¿Desea realmente salir de la aplicación?");  break;
                    default: out.printf("%n%nOpción Incorrecta.");                          break;
                }
            } while(!salir);

            this.salida();
        }
    }// End of runMenu

    
    private void menuArchivos() throws Exception{
        boolean salir = false;
        String menu = "\n==============================\n"
                    + "||         ARCHIVOS         ||\n"
                    + "==============================\n"
                    + "1.- Exportar directores\n"
                    + "2.- Exportar películas\n"
                    + "q.- Volver al menú principal\n";
        String option;
        String[] availableOptions = {"1", "2", "q"};
        
        do {
            borrarPantallaYMostrarTitulo();
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": this.archivosExportarDirectores();                            break;
                case "2": this.archivosExportarPeliculas();                             break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);
    }// End of menuArchivos

    
    private void menuPeliculas() {
        boolean salir = false;
        String menu = "\n===============================\n"
                    + "||         PELÍCULAS         ||\n"
                    + "===============================\n"
                    + "1.- Altas\n"
                    + "2.- Bajas\n"
                    + "3.- Modificaciones\n"
                    + "4.- Consulta\n"
                    + "q.- Volver al menú principal\n";
        String option;
        String[] availableOptions = {"1", "2", "3", "4", "q"};
        
        do {
            borrarPantallaYMostrarTitulo();
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": this.peliculasAltas();                                        break;
                case "2": this.peliculasBajas();                                        break;
                case "3": this.peliculasModificaciones();                               break;
                case "4": this.peliculasConsulta();                                     break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);    
    }// End of menuPeliculas

    
    private void menuDirectores() {
        boolean salir = false;
        String menu = "\n================================\n"
                    + "||         DIRECTORES         ||\n"
                    + "================================\n"
                    + "1.- Altas\n"
                    + "2.- Bajas\n"
                    + "3.- Modificaciones\n"
                    + "q.- Volver al menú principal\n";
        String option;
        String[] availableOptions = {"1", "2", "3", "q"};
        
        do {
            borrarPantallaYMostrarTitulo();
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": this.directoresAltas();                                        break;
                case "2": this.directoresBajas();                                       break;
                case "3": this.directoresModificaciones();                              break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);  
    }// End of menuDirectores

    
    private void menuActores() {
        boolean salir = false;
        String menu = "\n=============================\n"
                    + "||         ACTORES         ||\n"
                    + "=============================\n"
                    + "1.- Altas\n"
                    + "2.- Bajas\n"
                    + "3.- Modificaciones\n"
                    + "4.- Películas de un actor\n"
                    + "q.- Volver al menú principal\n";
        String option;
        String[] availableOptions = {"1", "2", "3", "4", "q"};
        
        do {
            borrarPantallaYMostrarTitulo();
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": this.actoresAltas();                                          break;
                case "2": this.actoresBajas();                                          break;
                case "3": this.actoresModificaciones();                                 break;
                case "4": this.actoresPeliculasActor();                                 break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);  
    }// End of menuActores

    private void menuListados() {
        boolean salir = false;
        String menu = "\n==============================\n"
                    + "||         LISTADOS         ||\n"
                    + "==============================\n"
                    + "1.- Listado de películas\n"
                    + "2.- Listado de directores\n"
                    + "3.- Listado de actores\n"
                    + "q.- Volver al menú principal\n";
        String option;
        String[] availableOptions = {"1", "2", "3", "q"};
        
        do {
            borrarPantallaYMostrarTitulo();
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": this.listadosPeliculas();                                     break;
                case "2": this.listadosDirectores();                                    break;
                case "3": this.listadosActores();                                       break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir); 
    }// End of menuListados

    private void archivosExportarDirectores() {
        String archivoDirectores = c.exportarDirectores();
        out.printf("\n\nPOR IMPLEMENTAR");
        continuar();
    }

    private void archivosExportarPeliculas() {
        String archivoPeliculas = c.exportarPeliculas();
        out.printf("\n\nPOR IMPLEMENTAR");
        continuar();
    }

    private void peliculasAltas() {
        out.printf("\n Introduce el TÍTULO de la película a añadir >> ");
        String titulo = sc.nextLine();
        out.printf("\n Introduce el AÑO de la película >> ");
        int annio = sc.nextInt();
        sc.nextLine();
        out.printf("\n Introduce la DURACIÓN de la película >> ");
        int duracion = sc.nextInt();
        sc.nextLine();
        out.printf("\n Introduce el PAÍS de la película >> ");
        String pais = sc.nextLine();
        out.printf("\n Introduce los DIRECTORES de la película >> ");
        out.printf("\n Introduce el NÚMERO DE DIRECTORES de la película >> ");
        int numeroDirectores = sc.nextInt();
        sc.nextLine();
        String[] directores = new String[numeroDirectores];
        for (int i = 0; i < numeroDirectores; i++){
            out.printf("\n Introduce el DIRECTOR NÚMERO %d de la película >> ", i + 1);
            directores[i] = sc.nextLine();
        }
        out.printf("\n Introduce el GUIÓN de la película >> ");
        String guion = sc.nextLine();
        out.printf("\n Introduce la MÚSICA de la película >> ");
        String musica = sc.nextLine();
        out.printf("\n Introduce la FOTOGRAFÍA de la película >> ");
        String fotografia = sc.nextLine();
        out.printf("\n Introduce el REPARTO de la película >> ");
        out.printf("\n Introduce el NÚMERO DE ACTORES de la película >> ");
        int numeroActores = sc.nextInt();
        sc.nextLine();
        String[] actores = new String[numeroActores];
        for (int i = 0; i < numeroActores; i++){
            out.printf("\n Introduce el ACTOR NÚMERO %d de la película >> ", i + 1);
            actores[i] = sc.nextLine();
        }
        out.printf("\n Introduce la PRODUCTORA de la película >> ");
        String productora = sc.nextLine();
        out.printf("\n Introduce el GÉNERO de la película >> ");
        String genero = sc.nextLine();
        out.printf("\n Introduce la SINOPSIS de la película >> ");
        String sinopsis = sc.nextLine();
        
        c.peliculasAltas(titulo, annio, duracion, pais, directores, guion, musica, fotografia, actores, productora, genero, sinopsis);
        out.printf("\n\nDatos de la película %s introducidos con éxito", titulo);
        this.continuar();
    }

    private int peliculasBajas() {
        String titulo = "";
        boolean fallo = false;
        int indice;
        do {    // todo esto se puede hacer con un if-else de mierda eh
            if (fallo){
                out.printf("\nEl título %s no pertenece a ninguna película de la base de datos\n", titulo);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el TÍTULO de la película a dar de baja >> ");
            titulo = sc.nextLine();
            fallo = true;
            indice = c.peliculasGetIndiceByTitulo(titulo);
        } while (indice == -1);
        
        c.peliculasBorrarPelicula(indice);
        out.printf("\nLa película %s ha sido borrada de la base de datos", titulo);
        
        continuar();
        return 0;
    }

    private int peliculasConsulta() {
        String titulo = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl título %s no pertenece a ninguna película de la base de datos\n", titulo);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el TÍTULO de la película de la que desea ver los datos >> ");
            titulo = sc.nextLine();
            fallo = true;
            indice = c.peliculasGetIndiceByTitulo(titulo);
        } while (indice == -1);
        
        out.printf("\n > Título:     " + titulo + "\n"
                 + " > Año:        " + c.peliculasGetAnnio(indice) + "\n"
                 + " > Duración:   " + c.peliculasGetDuracion(indice) + "\n"
                 + " > País:       " + c.peliculasGetPais(indice) + "\n"
                 + " > Dirección:  " + c.peliculasGetDireccion(indice) + "\n"
                 + " > Guión:      " + c.peliculasGetGuion(indice) + "\n"
                 + " > Música:     " + c.peliculasGetMusica(indice) + "\n"
                 + " > Fotografía: " + c.peliculasGetFotografia(indice) + "\n"
                 + " > Reparto:    " + c.peliculasGetReparto(indice) + "\n"
                 + " > Productora: " + c.peliculasGetProductora(indice) + "\n"
                 + " > Género:     " + c.peliculasGetGenero(indice) + "\n"
                 + " > Sinopsis:   " + c.peliculasGetSinopsis(indice) + "\n");
        
        continuar();
        return 0;
    }

    private int peliculasModificaciones() {
        String titulo = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl título %s no pertenece a ninguna película de la base de datos\n", titulo);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el TÍTULO de la película que desea modificar >> ");
            titulo = sc.nextLine();
            fallo = true;
            indice = c.peliculasGetIndiceByTitulo(titulo);
        } while (indice == -1);
        
        boolean salir = false;
        
        String option;
        String[] availableOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "q"};
        
        do {
            String menu = "\n========================================\n"
                        + "||         MODIFICAR PELÍCULA         ||\n"
                        + "========================================\n"
                        + " 1.- Título:                     " + titulo + "\n"
                        + " 2.- Año:                        " + c.peliculasGetAnnio(indice) + "\n"
                        + " 3.- Duración:                   " + c.peliculasGetDuracion(indice) + "\n"
                        + " 4.- País:                       " + c.peliculasGetPais(indice) + "\n"
                        + " 5.- Dirección:                  " + c.peliculasGetDireccion(indice) + "\n"
                        + " 6.- Guión:                      " + c.peliculasGetGuion(indice) + "\n"
                        + " 7.- Música:                     " + c.peliculasGetMusica(indice) + "\n"
                        + " 8.- Fotografía:                 " + c.peliculasGetFotografia(indice) + "\n"
                        + " 9.- Reparto:                    " + c.peliculasGetReparto(indice) + "\n"
                        + "10.- Productora:                 " + c.peliculasGetProductora(indice) + "\n"
                        + "11.- Género:                     " + c.peliculasGetGenero(indice) + "\n"
                        + "12.- Sinopsis:                   " + c.peliculasGetSinopsis(indice) + "\n"
                        + " q.- Volver al menú anterior\n\n";
        borrarPantallaYMostrarTitulo();
            
        option = leerString(menu, availableOptions);
        switch (option){
            case "1": 
                out.printf("\nEl TÍTULO de la película no se puede modificar\n");
                continuar();
                break;
            case "2": 
                out.printf("\n Introduce el AÑO de la película >> ");
                int annio = sc.nextInt();
                sc.nextLine();
                c.peliculasSetAnnio(indice, annio);
                continuar();          
                break;
            case "3": 
                out.printf("\n Introduce la DURACIÓN de la película (en minutos) >> ");
                int duracion = sc.nextInt();
                sc.nextLine();
                c.peliculasSetDuracion(indice, duracion); 
                continuar();
                break;
            case "4": 
                out.printf("\n Introduce el PAÍS de la película >> ");
                String pais = sc.nextLine();
                c.peliculasSetPais(indice, pais);  
                continuar();
                break;
            case "5": 
                out.printf("\nLa DIRECCIÓN de la película no se puede modificar\n");
                continuar();
                break;
            case "6": 
                out.printf("\n Introduce el GUIÓN de la película >> ");
                String guion = sc.nextLine();
                c.peliculasSetGuion(indice, guion);  
                continuar();
                break;
            case "7": 
                out.printf("\n Introduce la MÚSICA de la película >> ");
                String musica = sc.nextLine();
                c.peliculasSetMusica(indice, musica);  
                continuar();
                break;
            case "8": 
                out.printf("\n Introduce la FOTOGRAFÍA de la película >> ");
                String fotografia = sc.nextLine();
                c.peliculasSetFotografia(indice, fotografia);  
                continuar();
                break;
            case "9": 
                out.printf("\nEl REPARTO de la película no se puede modificar\n");
                continuar();
                break;
            case "10": 
                out.printf("\n Introduce la PRODUCTORA de la película >> ");
                String productora = sc.nextLine();
                c.peliculasSetProductora(indice, productora);  
                continuar();
                break;
            case "11": 
                out.printf("\n Introduce el GÉNERO de la película >> ");
                String genero = sc.nextLine();
                c.peliculasSetGenero(indice, genero);  
                continuar();
                break;
            case "12": 
                out.printf("\n Introduce la SINOPSIS de la película >> ");
                String sinopsis = sc.nextLine();
                c.peliculasSetSinopsis(indice, sinopsis);  
                continuar();
                break;
            case "q":
            case "Q": salir = true;                                                 break;
            default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);  
        
        continuar();
        return 0;
    }

    private void directoresAltas() {    // quizas se debería comprobar que el nombre no pertenezca a alguien ya
        out.printf("\n Introduce el NOMBRE del director a añadir >> ");
        String nombre = sc.nextLine();
        out.printf("\n Introduce la FECHA DE NACIMIENTO del director (dd-mm-aaaa) >> ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaDeNacimiento = LocalDate.parse(sc.nextLine(), formatter);
        out.printf("\n Introduce la NACIONALIDAD del director >> ");
        String nacionalidad = sc.nextLine();
        out.printf("\n Introduce la OCUPACIÓN del director >> ");
        String ocupacion = sc.nextLine();
        out.printf("\n Introduce las PELÍCULAS del director >> ");
        out.printf("\n Introduce el NÚMERO DE PELÍCULAS del director >> ");
        int numeroPeliculas = sc.nextInt();
        sc.nextLine();
        String[] peliculas = new String[numeroPeliculas];
        for (int i = 0; i < numeroPeliculas; i++){
            out.printf("\n Introduce la PELÍCULA NÚMERO %d del director >> ", i + 1);
            peliculas[i] = sc.nextLine();
        }
        
        c.directoresAltas(nombre, fechaDeNacimiento, nacionalidad, ocupacion, peliculas);
        out.printf("\n\nDatos del director %s introducidos con éxito", nombre);
        this.continuar();
    }

    private int directoresBajas() {
        String nombre = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl nombre %s no pertenece a ningún director de la base de datos\n", nombre);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el NOMBRE del director a dar de baja >> ");
            nombre = sc.nextLine();
            fallo = true;
            indice = c.directoresGetIndiceByNombre(nombre);
        } while (indice == -1);
        
        String[] peliculas = c.directoresComprobarPeliculas(indice);
        if (peliculas == null){
            c.directoresBorrarDirector(indice);
            out.printf("\nEl director %s ha sido borrado de la base de datos", nombre);
            continuar();
            return 0;
        }
        
        out.printf("\nEl director %s no ha podido ser borrado de la base de datos porque las siguiente películas están todavía registradas:", nombre);
        for (String pelicula : peliculas){
            out.printf("\n > %s", pelicula);
        }
        
        continuar();
        return -1;
    }

    private int directoresModificaciones() {
        String nombre = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl nombre %s no pertenece a ningún director de la base de datos\n", nombre);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el NOMBRE del director a modificar >> ");
            nombre = sc.nextLine();
            fallo = true;
            indice = c.directoresGetIndiceByNombre(nombre);
        } while (indice == -1);
        
        boolean salir = false;
        
        String option;
        String[] availableOptions = {"1", "2", "3", "4", "q"};
        
        do {
            String menu = "\n========================================\n"
                    + "||         MODIFICAR DIRECTOR         ||\n"
                    + "========================================\n"
                    + "1.- Nombre:                   " + nombre + "\n"
                    + "2.- Fecha de nacimiento:      " + c.directoresGetFechaDeNacimiento(indice) + "\n"
                    + "3.- Nacionalidad:             " + c.directoresGetNacionalidad(indice) + "\n"
                    + "4.- Ocupación:                " + c.directoresGetOcupacion(indice) + "\n"
                    + "q.- Volver al menú anterior\n\n";
            borrarPantallaYMostrarTitulo();
            
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": 
                    out.printf("\nEl NOMBRE del director no se puede modificar\n");
                    continuar();
                    break;
                case "2": 
                    out.printf("\n Introduce la FECHA DE NACIMIENTO del director (dd-mm-aaaa) >> ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaDeNacimiento = LocalDate.parse(sc.nextLine(), formatter);
                    c.directoresSetFechaDeNacimiento(indice, fechaDeNacimiento);
                    continuar();          
                    break;
                case "3": 
                    out.printf("\n Introduce la NACIONALIDAD del director >> ");
                    String nacionalidad = sc.nextLine();
                    c.directoresSetNacionalidad(indice, nacionalidad); 
                    continuar();
                    break;
                case "4": 
                    out.printf("\n Introduce la OCUPACIÓN del director >> ");
                    String ocupacion = sc.nextLine();
                    c.directoresSetOcupacion(indice, ocupacion);  
                    continuar();
                    break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);  
        
        continuar();
        return 0;
    }

    private void actoresAltas() {
        out.printf("\n Introduce el NOMBRE del actor a añadir >> ");
        String nombre = sc.nextLine();
        out.printf("\n Introduce la FECHA DE NACIMIENTO del actor (dd-mm-aaaa) >> ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaDeNacimiento = LocalDate.parse(sc.nextLine(), formatter);
        out.printf("\n Introduce la NACIONALIDAD del actor >> ");
        String nacionalidad = sc.nextLine();
        out.printf("\n Introduce el AÑO DE DEBUT del actor >> ");
        int annioDeDebut = sc.nextInt();
        sc.nextLine();
        out.printf("\n Introduce las PELÍCULAS del actor >> ");
        out.printf("\n Introduce el NÚMERO DE PELÍCULAS del actor >> ");
        int numeroPeliculas = sc.nextInt();
        sc.nextLine();
        String[] peliculas = new String[numeroPeliculas];
        for (int i = 0; i < numeroPeliculas; i++){
            out.printf("\n Introduce la PELÍCULA NÚMERO %d del actor >> ", i + 1);
            peliculas[i] = sc.nextLine();
        }
        
        c.actoresAltas(nombre, fechaDeNacimiento, nacionalidad, annioDeDebut, peliculas);
        out.printf("\n\nDatos del actor %s introducidos con éxito", nombre);
        this.continuar();
    }

    private int actoresBajas() {
        String nombre = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl nombre %s no pertenece a ningún actor de la base de datos\n", nombre);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el NOMBRE del actor a dar de baja >> ");
            nombre = sc.nextLine();
            fallo = true;
            indice = c.actoresGetIndiceByNombre(nombre);
        } while (indice == -1);
        
        String[] peliculas = c.actoresComprobarPeliculas(indice);
        if (peliculas == null){
            c.actoresBorrarActor(indice);
            out.printf("\nEl actor %s ha sido borrado de la base de datos", nombre);
            continuar();
            return 0;
        }
        
        out.printf("\nEl actor %s no ha podido ser borrado de la base de datos porque las siguiente películas están todavía registradas:", nombre);
        for (String pelicula : peliculas){
            out.printf("\n > %s", pelicula);
        }
        
        continuar();
        return -1;
    }

    private int actoresModificaciones() {
        String nombre = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl nombre %s no pertenece a ningún actor de la base de datos\n", nombre);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el NOMBRE del actor a modificar >> ");
            nombre = sc.nextLine();
            fallo = true;
            indice = c.actoresGetIndiceByNombre(nombre);
        } while (indice == -1);
        
        boolean salir = false;
        
        String option;
        String[] availableOptions = {"1", "2", "3", "4", "q"};
        
        do {
            String menu = "\n=====================================\n"
                    + "||         MODIFICAR ACTOR         ||\n"
                    + "=====================================\n"
                    + "1.- Nombre:                   " + nombre + "\n"
                    + "2.- Fecha de nacimiento:      " + c.actoresGetFechaDeNacimiento(indice) + "\n"
                    + "3.- Nacionalidad:             " + c.actoresGetNacionalidad(indice) + "\n"
                    + "4.- Año de debut:             " + c.actoresGetAnnioDeDebut(indice) + "\n"
                    + "q.- Volver al menú anterior\n\n";
            borrarPantallaYMostrarTitulo();
            
            option = leerString(menu, availableOptions);
            switch (option){
                case "1": 
                    out.printf("\nEl NOMBRE del actor no se puede modificar\n");
                    continuar();
                    break;
                case "2": 
                    out.printf("\n Introduce la FECHA DE NACIMIENTO del actor (dd-mm-aaaa) >> ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaDeNacimiento = LocalDate.parse(sc.nextLine(), formatter);
                    c.actoresSetFechaDeNacimiento(indice, fechaDeNacimiento);
                    continuar();          
                    break;
                case "3": 
                    out.printf("\n Introduce la NACIONALIDAD del actor >> ");
                    String nacionalidad = sc.nextLine();
                    c.actoresSetNacionalidad(indice, nacionalidad); 
                    continuar();
                    break;
                case "4": 
                    out.printf("\n Introduce el AÑO DE DEBUT del actor >> ");
                    int annioDeDebut = sc.nextInt();
                    sc.nextLine();
                    c.actoresSetAnnioDeDebut(indice, annioDeDebut);  
                    continuar();
                    break;
                case "q":
                case "Q": salir = true;                                                 break;
                default: out.printf("%n%nOpción Incorrecta.");                          break;
            }
        } while(!salir);  
        
        continuar();
        return 0;
    }

    private int actoresPeliculasActor() {
        String nombre = "";
        boolean fallo = false;
        int indice;
        do {
            if (fallo){
                out.printf("\nEl nombre %s no pertenece a ningún actor de la base de datos\n", nombre);
                continuar();
                return -1;
            }
            out.printf("\n Introduce el NOMBRE del actor cuyas tabla de peliculas se desea visualizar >> ");
            nombre = sc.nextLine();
            fallo = true;
            indice = c.actoresGetIndiceByNombre(nombre);
        } while (indice == -1);
        
        String[] listadoPeliculas = c.obtenerListadoPeliculasActor(indice);
        if(listadoPeliculas == null){
            out.printf("\nEl actor %s no tienen ninguna película en la base de datos\n", nombre);
            this.continuar();
            return -1;
        }
        
        System.out.printf("%n+========================================================================================================================================+%n"
                         +"|                                                          LISTADO DE PELÍCULAS                                                          |%n"
                         +"+========================================================================================================================================+%n");
        String cabecera = "+----------------------------------------------------------+---------+----------+----------------------------------+---------------------+%n";
        System.out.printf("| TÍTULO                                                   | AÑO     | DURACIÓN | PAÍS                             | GÉNERO              |%n");
        Arrays.sort(listadoPeliculas);
        for(String p : listadoPeliculas){
            System.out.printf(cabecera);
            System.out.printf("%s", p);
        }
        System.out.printf(cabecera);
        this.continuar();
        
        return 0;
    }

    private void listadosPeliculas() {
        String[] listadoPeliculas = c.obtenerListadoPeliculas();
        if(listadoPeliculas == null){
            System.out.printf("ERROR: No fue posible obtener el listado de peliculas%n");
            this.continuar();
            return;
        }
        
        System.out.printf("%n+========================================================================================================================================+%n"
                         +"|                                                          LISTADO DE PELÍCULAS                                                          |%n"
                         +"+========================================================================================================================================+%n");
        String cabecera = "+----------------------------------------------------------+---------+----------+----------------------------------+---------------------+%n";
        System.out.printf("| TÍTULO                                                   | AÑO     | DURACIÓN | PAÍS                             | GÉNERO              |%n");
        Arrays.sort(listadoPeliculas);
        for(String p : listadoPeliculas){
            System.out.printf(cabecera);
            System.out.printf("%s", p);
        }
        System.out.printf(cabecera);
        this.continuar();
    }

    private void listadosDirectores() {
        String[] listadoDirectores = c.obtenerListadoDirectores();
        if(listadoDirectores == null){
            System.out.printf("ERROR: No fue posible obtener el listado de directores%n");
            this.continuar();
            return;
        }
        
        System.out.printf("%n+=================================================================================================================================================================+%n"
                         +"|                                                                      LISTADO DE DIRECTORES                                                                      |%n"
                         +"+=================================================================================================================================================================+%n");
        String cabecera = "+----------------------------------+---------------------+-------------------------+------------------------------------------------------------------------------+%n";
        System.out.printf("| NOMBRE                           | FECHA DE NACIMIENTO | NACIONALIDAD            | OCUPACIÓN                                                                    |%n");
        Arrays.sort(listadoDirectores);
        for(String p : listadoDirectores){
            System.out.printf(cabecera);
            System.out.printf("%s", p);
        }
        System.out.printf(cabecera);
        this.continuar();
    }

    private void listadosActores() {
        String[] listadoActores = c.obtenerListadoActores();
        if(listadoActores == null){
            System.out.printf("ERROR: No fue posible obtener el listado de actores%n");
            this.continuar();
            return;
        }

        System.out.printf("%n+==================================================================================================+%n"
                         +"|                                        LISTADO DE ACTORES                                        |%n"
                         +"+==================================================================================================+%n");
        String cabecera = "+----------------------------------+---------------------+-------------------------+---------------+%n";
        System.out.printf("| NOMBRE                           | FECHA DE NACIMIENTO | NACIONALIDAD            | AÑO DE DEBUT  |%n");
        Arrays.sort(listadoActores);
        for(String p : listadoActores){
            System.out.printf(cabecera);
            System.out.printf("%s", p);
        }
        System.out.printf(cabecera);
        this.continuar();
    }
    
    
    private void borrarPantallaYMostrarTitulo() {
        clear();
        
        out.printf(ANSI_BLUE + "     e    e                         ,e,                                                    \n" +
            "    d8b  d8b      e88~-_  Y88b    /  \"   e88~~8e                                           \n" +
            "   d888bdY88b    d888   i  Y88b  /  888 d888  88b                                          \n" +
            "  / Y88Y Y888b   8888   |   Y88b/   888 8888__888                                          \n" +
            " /   YY   Y888b  Y888   '    Y8/    888 Y888    ,                                          \n" +
            "/          Y888b  \"88_-~      Y     888  \"88___/                                           \n" +
            "                                                                                           \n" +
            "                  888~-_               d8             888                                  \n" +
            "                  888   \\    /~~~8e  _d88__   /~~~8e  888-~88e    /~~~8e   d88~\\  e88~~8e  \n" +
            "                  888    |       88b  888         88b 888  888b       88b C888   d888  88b \n" +
            "                  888    |  e88~-888  888    e88~-888 888  8888  e88~-888  Y88b  8888__888 \n" +
            "                  888   /  C888  888  888   C888  888 888  888P C888  888   888D Y888    , \n" +
            "                  888_-~    \"88_-888  \"88_/  \"88_-888 888-_88\"   \"88_-888 \\_88P   \"88___/ \n\n" + ANSI_RESET);
    }
    
    
    private String leerString(String prompt, String[] options) {
        Scanner SC = new Scanner(System.in);
        String temp = null;
        String listOfOptions = "( " + options[0];
        for (int i = 1; i < options.length; i++) {
            listOfOptions += ", " + options[i];
        }
        listOfOptions += " )";
        boolean badOption;
        boolean falladoUnaVez = false;
        do {
            badOption = false;
            borrarPantallaYMostrarTitulo();
            out.printf(prompt);
            if (falladoUnaVez){
                out.printf("%n%s no es correcto: Por favor, escriba una de las opciones permitidas", temp);
                falladoUnaVez = false;
            }
            out.printf("%n %s ? ", listOfOptions);
            temp = SC.nextLine();
            Arrays.sort(options);
            if (Arrays.binarySearch(options, temp) < 0) {
                badOption = true;
                falladoUnaVez = true;
            }
        } while (badOption);
        return temp;
    }

    private void continuar() {
        String a;
        a = readString("\n\n Pulse ENTER para continuar >> ");
    }

    private void salida() {
        c.salida();
        this.continuar();
        clear();
    }
}
