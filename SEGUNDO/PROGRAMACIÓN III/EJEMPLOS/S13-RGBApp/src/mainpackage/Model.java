/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coti
 */
public class Model {

    private ArrayList<BaseRecord> records;
    private File theFile;

    public Model() {
        this.records = new ArrayList<>();
        this.theFile = null;
    }

    public Model(File selectedFile) {
        this.records = new ArrayList<>();

        if (!this.loadFrom(selectedFile)) {
            System.out.printf("%nSe ha creado una base de datos vacía%n%n");
        } else {
            this.theFile = selectedFile;
        }
    }

    public boolean saveTo(File selectedFile) {
        try {
            OutputStream os = Files.newOutputStream(selectedFile.toPath());
            BufferedOutputStream bos = new BufferedOutputStream(os);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(records);
            oos.close();
            this.theFile = selectedFile;
        } catch (Exception ex) {
            System.out.println("Model:saveToDisk" + ex);
            return false;
        }
        return true;
    }

    public final boolean loadFrom(File selectedFile) {
        if (!selectedFile.exists()) {
            return false;
        }
        ObjectInputStream ois;
        try {
            InputStream is = Files.newInputStream(selectedFile.toPath());
            BufferedInputStream bis = new BufferedInputStream(is);
            ois = new ObjectInputStream(bis);
            Object datos = ois.readObject();

            records = (ArrayList<BaseRecord>) datos;

            ois.close();
            this.theFile = selectedFile;
        } catch (Exception ex) {
            System.out.println("Model:loadFromDisk" + ex);
            return false;
        }

        return true;
    }

    public boolean exportToDisk(File f, String delimiter) {
        // Este archivo no forma parte del modelo
        OutputStream os;
        PrintWriter pw;
        try {
            os = Files.newOutputStream(f.toPath());
            BufferedOutputStream bos = new BufferedOutputStream(os);
            pw = new PrintWriter(bos);
            for (BaseRecord p : records) {
                pw.println(p.toDelimitedString(delimiter));
            }
            pw.close();
        } catch (Exception ex) {
            System.out.println("Model:exportToDisk: failed to export " + ex);
        }
        return true;
    }

    public boolean importFromDisk(File f, String delimiter) {
        // Este archivo no forma parte del modelo
        if (!f.exists()) {
            System.out.println("Model:importFromDisk: el archivo no existe" );
            return false;
        }
        try {
            List<String> tempRecords = Files.readAllLines(f.toPath(),
                    Charset.forName("UTF-8"));
            records.clear();
            for (String s : tempRecords) {
                BaseRecord p = new BaseRecord(s, delimiter);
                records.add(p);
            }
        } catch (Exception ex) {
            System.out.println("Model:importFromDisk: - failed to import" + ex);
            return false;
        }
        return true;
    }

    public void add(BaseRecord p) {
        records.add(p);
    }

    public void showContents() {
        if (records.isEmpty()) {
            return;
        }
        System.out.println("\n\nContenido de la base de datos\n\n");
        for (int i = 0; i < records.size(); i++) {
            System.out.printf("%d.- %s%n", i, records.get(i).toDelimitedString("\t"));
        }
        System.out.println("\n\nFin del listado\n\n");
    }

    public void remove(int n) {
        records.remove(n);
    }

    public void replace(int n, BaseRecord p) {
        records.set(n, p);
    }

    public BaseRecord get(int i) {
        return records.get(i);
    }

    public int size() {
        return records.size();
    }

    /**
     * @return the theFile
     */
    public File getTheFile() {
        return theFile;
    }

  

}
