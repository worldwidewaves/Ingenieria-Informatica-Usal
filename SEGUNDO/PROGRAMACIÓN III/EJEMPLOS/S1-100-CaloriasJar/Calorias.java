

import java.io.File;
import javax.swing.JTabbedPane;
import com.coti.guitools.JFrameAI;
import java.awt.Dimension;

/**
 *
 * @author coti
 */
public class Calorias {

    private final Dishes platos;
    private final DishEditor editorDePlatos;

    public Dishes getDishes() {
        return platos;
    }

    public DishEditor getEditorDePlatos() {
        return editorDePlatos;
    }

    public Calorias() {
        
        platos = new Dishes(new File("datos.xml"));
        editorDePlatos = new DishEditor(platos);
        CaloryAdder sumadorDeCalorias = new CaloryAdder(platos, editorDePlatos);
        JTabbedPane jtp = new JTabbedPane();
        jtp.add("Editor", editorDePlatos);
        jtp.add("Selector de platos", platos);
        jtp.add("Cálculo de calorías", sumadorDeCalorias);
        JFrameAI jf = new JFrameAI("Carta", JFrameAI.PLATFORM);
        jf.getContentPane().add(jtp);
        jf.setSize(new Dimension(480, 650));
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Calorias m = new Calorias();
        });
    }
}
