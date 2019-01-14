/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// V2.0

package mainpackage;

import actions.AccionImportar;
import actions.Accion;
import actions.AccionBajas;
import actions.AccionListado;
import actions.AccionModificaciones;
import actions.AccionAltas;
import actions.AccionAbrir;
import actions.AccionGuardar;
import actions.AccionExportar;
import actions.AccionInformes;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author coti
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String[] options = {
            "Abrir",
            "Guardar",
            "Importar",
            "Exportar",
            "Altas",
            "Bajas",
            "Informes",
            "Modificaciones",
            "Listado"
        };
        Accion[] classes = {
            new AccionAbrir(),
            new AccionGuardar(),
            new AccionImportar(),
            new AccionExportar(),
            new AccionAltas(),
            new AccionBajas(),
            new AccionInformes(),
            new AccionModificaciones(),
            new AccionListado()
        };

        RGBApplication app = new RGBApplication(options, classes);
        app.run();
        app.theEnd();
        System.out.printf("%nTerminación normal a las ");
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
}
