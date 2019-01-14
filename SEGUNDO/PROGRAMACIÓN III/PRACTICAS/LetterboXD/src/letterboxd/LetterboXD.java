package letterboxd;

import view.View;

public class LetterboXD {

    public static void main(String[] args) throws Exception {
        View v = new View();
        v.runMenu("\n====================================\n" 
                + "||         MENÚ PRINCIPAL         ||\n"
                + "====================================\n"
                + "1.- Archivos\n"
                + "2.- Películas\n"
                + "3.- Directores\n"
                + "4.- Actores\n"
                + "5.- Listados\n"
                + "q.- Salir\n");
        }
   
}
