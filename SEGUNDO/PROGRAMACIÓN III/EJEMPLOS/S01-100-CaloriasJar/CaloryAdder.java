

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;
import java.util.*;

public class CaloryAdder extends JPanel implements ActionListener {

    private final Dishes platos;
    private final DishEditor editorDePlatos;
    private float caloriasTotales;
    private final JButton calcular;
    private JTextField total;
    private final Properties lista;

    public CaloryAdder(Dishes platos, DishEditor editorDePlatos) {
        this.platos = platos;
        this.editorDePlatos = editorDePlatos;
        lista = platos.getLista();
        caloriasTotales = 0;

        SpringLayout disp = new SpringLayout();
        setLayout(disp);

        Dimension dim = new Dimension(150, 20);

        /* Colocaci√≥n del r√≥tulo */
        JLabel rotuloDelTotal = new JLabel("Calorías totales: ",
                JLabel.TRAILING);
        rotuloDelTotal.setLabelFor(total);
        SpringLayout.Constraints restriccionesRotTotal = disp.getConstraints(
                rotuloDelTotal);
        restriccionesRotTotal.setX(Spring.constant(6));
        restriccionesRotTotal.setY(Spring.constant(6));

        /* Colocaci√≥n del campo de texto */
        total = new JTextField(20);
        total.setEditable(false);
        total.setMaximumSize(dim);
        total.setPreferredSize(dim);
        SpringLayout.Constraints restriccionesTotal
                = disp.getConstraints(total);
        restriccionesTotal.setX(Spring.constant(150));
        restriccionesTotal.setY(Spring.constant(6));

        /* Colocaci√≥n del bot√≥n */
        calcular = new JButton("Calcular calorías");
        calcular.addActionListener(this);
        calcular.setMaximumSize(dim);
        calcular.setPreferredSize(dim);
        SpringLayout.Constraints restriccionesCalcular
                = disp.getConstraints(calcular);
        restriccionesCalcular.setX(Spring.constant(150));
        restriccionesCalcular.setY(Spring.constant(50));

        add(rotuloDelTotal);
        add(total);
        add(calcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<JCheckBox> jc = platos.getJc();
        caloriasTotales = 0.0f;
        for (int i = 0; i < jc.size(); i++) {
            if (jc.get(i).isSelected()) {
                caloriasTotales += Float.parseFloat(lista.getProperty(i + "*1"));
            }
        }
        total.setText(caloriasTotales + "");
    }
}
