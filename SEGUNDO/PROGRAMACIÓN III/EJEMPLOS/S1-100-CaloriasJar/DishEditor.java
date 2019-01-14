

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class DishEditor extends JPanel implements ActionListener {

    private String nombreDelArchivo;
    private Properties lista;
    private JTextField nombre;
    private JTextField calorias;
    private Dishes platos;
    private JButton agregarAlista, guardarArchivo, borrarLista;
    private final JTable tabla;
    private final TableModel modeloDeDatos;

    public DishEditor(Dishes platos) {
        this.platos = platos;
        lista = platos.getLista();
        SpringLayout disp = new SpringLayout();

        setLayout(disp);
        Dimension dim = new Dimension(150, 20);
        nombre = new JTextField(20);
        nombre.setMaximumSize(dim);
        nombre.setPreferredSize(dim);
        SpringLayout.Constraints restriccionesNombre = disp.getConstraints(nombre);
        restriccionesNombre.setX(Spring.constant(150));
        restriccionesNombre.setY(Spring.constant(6));

        JLabel rotuloDeNombre = new JLabel("Nombre del plato: ",
                JLabel.TRAILING);
        rotuloDeNombre.setLabelFor(nombre);
        SpringLayout.Constraints restriccionesRotNombre
                = disp.getConstraints(rotuloDeNombre);
        restriccionesRotNombre.setX(Spring.constant(6));
        restriccionesRotNombre.setY(Spring.constant(6));

        add(rotuloDeNombre);
        add(nombre);

        calorias = new JTextField(20);
        calorias.setMaximumSize(dim);
        calorias.setPreferredSize(dim);
        SpringLayout.Constraints restriccionesCalorias
                = disp.getConstraints(calorias);
        restriccionesCalorias.setX(Spring.constant(150));
        restriccionesCalorias.setY(Spring.constant(40));

        JLabel rotuloDeCalorias = new JLabel("Calorías/100g:  ",
                JLabel.TRAILING);
        rotuloDeCalorias.setLabelFor(calorias);
        SpringLayout.Constraints restriccionesRotCal
                = disp.getConstraints(rotuloDeCalorias);
        restriccionesRotCal.setX(Spring.constant(6));
        restriccionesRotCal.setY(Spring.constant(40));

        add(rotuloDeCalorias);
        add(calorias);

        agregarAlista = new JButton("Añadir");
        agregarAlista.addActionListener(this);
        add(agregarAlista);
        SpringLayout.Constraints restriccionesAgregar
                = disp.getConstraints(agregarAlista);
        restriccionesAgregar.setX(Spring.constant(6));
        restriccionesAgregar.setY(Spring.constant(60));

        guardarArchivo = new JButton("Guardar lista");
        guardarArchivo.addActionListener(this);
        SpringLayout.Constraints restriccionesGuardar
                = disp.getConstraints(guardarArchivo);
        restriccionesGuardar.setX(Spring.constant(150));
        restriccionesGuardar.setY(Spring.constant(60));
        add(guardarArchivo);

        borrarLista = new JButton("Borrar lista");
        borrarLista.addActionListener(this);
        SpringLayout.Constraints restriccionesBorrar
                = disp.getConstraints(borrarLista);
        restriccionesBorrar.setX(Spring.constant(300));
        restriccionesBorrar.setY(Spring.constant(60));
        add(borrarLista);

        modeloDeDatos = new AbstractTableModel() {

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public String getColumnName(int col) {
                if (0 == col) {
                    return "Nombre del plato";
                } else {
                    return "Calorías/100g";
                }
            }

            @Override
            public int getRowCount() {
                return lista.size() / 2;
            }

            @Override
            public Object getValueAt(int row, int col) {
                return lista.getProperty(row + "*" + col);
            }

            @Override
            public void setValueAt(Object value, int row, int col) {
                String temp = value.toString();
                String claveFilaYcolumna = row + "*" + col;
                lista.setProperty(claveFilaYcolumna, temp);
                fireTableCellUpdated(row, col);
            }
        ;
        };
		tabla = new JTable(modeloDeDatos);
        JScrollPane laminaConDesplazamiento = new JScrollPane(tabla);
        laminaConDesplazamiento.setPreferredSize(new Dimension(450, 470));
        laminaConDesplazamiento.setMaximumSize(new Dimension(450, 470));
        add(laminaConDesplazamiento);
        SpringLayout.Constraints restriccionesTabla
                = disp.getConstraints(laminaConDesplazamiento);
        restriccionesTabla.setX(Spring.constant(6));
        restriccionesTabla.setY(Spring.constant(100));
    }

    public TableModel getDataModel() {
        return modeloDeDatos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileOutputStream fos;
        int filaSiguiente = lista.size() / 2;
        Object origen = e.getSource();
        if (origen == agregarAlista) {
            if (nombre.getText().length() == 0
                    || calorias.getText().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                return;
            }
            modeloDeDatos.setValueAt(nombre.getText(), filaSiguiente, 0);
            modeloDeDatos.setValueAt(calorias.getText(), filaSiguiente, 1);
            tabla.setVisible(false);
            tabla.setVisible(true);
            return;
        }
        if (origen == guardarArchivo) {
            try {
                fos = new FileOutputStream(platos.getArchivo());
                lista.storeToXML(fos, "Platos");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        if (origen == borrarLista) {
            lista.clear();
            tabla.repaint();
        }
    }
}
