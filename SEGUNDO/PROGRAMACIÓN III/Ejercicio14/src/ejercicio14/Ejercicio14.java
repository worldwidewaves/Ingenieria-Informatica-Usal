package ejercicio14;

import com.coti.tools.Rutas;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 14:
 * Se dispone de un fichero CSV formado por las notas de 3425 alumnos; de cada
 * alumno se conoce el nombre, primer apellido, segundo apellido, año de nacimiento y
 * tres calificaciones. Se pide buscar aquellos alumnos que hayan nacido en el año
 * 2000, cuyo primer apellido tenga 6 letras y cuya suma de calificaciones supere el
 * valor 25 (las calificaciones son de 0 a 10).
 * @author Daniel García González
 */

public class Ejercicio14 {
    
    public static boolean isValid(String[] row){
        //Propiedades de la persona/s que se busca/n
        boolean r = row[3].equalsIgnoreCase("2000") && row[1].length() >= 6;
        float cal_1 = Float.parseFloat(row[4]);
        float cal_2 = Float.parseFloat(row[5]);
        float cal_3 = Float.parseFloat(row[6]);
        boolean r2 = (cal_1 + cal_2 + cal_3) >= 25.0;
        return r && r2;
}

    public static void main(String[] args) {
        //Leer archivo
        String nombreArchivo = "outputrows.csv";
        Path path = Rutas.pathToFileOnDesktop(nombreArchivo);
        List <String> filas;
        try {
            filas = Files.readAllLines(path);
        } catch (IOException ex){
            System.err.println("Problema al leer el archivo " + "'" +  ex.getLocalizedMessage() + "'");
            return;
        }
        
        //Mostrar nº de filas
        System.out.println("El numero de filas es: " + filas.size());
        
        //Mostrar persona/s buscada/s (si se encuentra/n)
        for (String st : filas){
            String[] r = st.split("\t");
            if (isValid(r)){
                System.out.printf("{%20s %20s %20s %5s %5s %5s %5s}\n",
                        r[0], r[1], r[2], r[3], r[4], r[5], r[6]);
            }
        }
        
        showFinalTime();
    }
    
}
