

import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.Dimension;

public class Dishes extends JPanel {

    private JCheckBox[] p;
    private Properties lista;
    private FileInputStream in;
    private File archivoDatosPlatos;
    private DishEditor de;
    private final ArrayList<JCheckBox> jc;

    public Dishes(File archivoDatosPlatos) {
        this.archivoDatosPlatos = archivoDatosPlatos;
        lista = new Properties();
        if (archivoDatosPlatos.exists()) {
            try {
                in = new FileInputStream(archivoDatosPlatos);
                lista.loadFromXML(in);
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(0, 2));
        String resultado = null;
        jc = new ArrayList<>();
        for (int i = 0; i < lista.size() / 2; i++) {
            resultado = lista.getProperty(i + "*0");
            jc.add(new JCheckBox(resultado));
        }
        jc.forEach((j) -> {
            jp.add(j);
        });
        JScrollPane jsp = new JScrollPane(jp);
        jsp.setPreferredSize(new Dimension(450, 570));
        jsp.setMaximumSize(new Dimension(450, 570));
        add(jsp);
    }

    ;
	
	public Properties getLista() {
        return lista;
    }

    public File getArchivo() {
        return archivoDatosPlatos;
    }

    public ArrayList<JCheckBox> getJc() {
        return jc;
    }
}
