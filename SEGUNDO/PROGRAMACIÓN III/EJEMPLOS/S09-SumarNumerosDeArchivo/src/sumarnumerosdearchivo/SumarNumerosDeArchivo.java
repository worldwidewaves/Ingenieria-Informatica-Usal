/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package sumarnumerosdearchivo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author bruegel
 */
public class SumarNumerosDeArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String route = System.getProperty("user.home")
                + File.separator
                + "Desktop"
                + File.separator
                + "numeros.txt";
        Path p = FileSystems.getDefault().getPath(route);
        List<String> lines = Files.readAllLines(p, Charset.defaultCharset());
        int suma = 0;
//        suma = lines.stream().map((s) -> Integer.parseInt(s)).reduce(suma, Integer::sum);
        for(int i=0; i<lines.size(); i++) {
            suma += Integer.parseInt(lines.get(i));
        } // End of for
        System.out.println("La suma de todos los números del archivo es " + suma);
    } // End of main
    
} // End of SumarNumerosDeArchivo
