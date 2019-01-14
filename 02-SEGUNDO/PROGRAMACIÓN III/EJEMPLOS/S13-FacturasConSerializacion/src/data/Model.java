/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package data;

import com.coti.tools.Rutas;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coti
 */
public class Model {

    private final String nameOfFile = "facturas.bin";
    private final String nameOfFolder = "datos";

    private Factura[] lista = new Factura[10];

    public Factura[] getLista() {
        return lista;
    }

    public void giveRandomValuesToList() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = Factura.instanceWithRandomAttributes();
        }
    }

    public void save() {
        Path p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, nameOfFile);
        try {
            FileOutputStream fos = new FileOutputStream(p.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(lista);
            oos.close();
        } catch (IOException ex) {
            System.out.println("No fue posible guardar el archivo");
            System.out.println(ex.toString());
        }

    }

    public void load() {
        Path p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, nameOfFile);
        try {
            FileInputStream fis = new FileInputStream(p.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            lista = (Factura[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No fue posible leer el archivo");
            System.out.println(ex.toString());
        }
    }

} // End of Model
