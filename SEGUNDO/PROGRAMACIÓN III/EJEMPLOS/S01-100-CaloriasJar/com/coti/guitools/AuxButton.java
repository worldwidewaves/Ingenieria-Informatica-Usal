package com.coti.guitools;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/*
	Latest change: 12/12/11 17:10
*/
public class AuxButton {
    
    
    public static void errMess(Component owner, String message, String title) {
        JOptionPane.showMessageDialog(	owner,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }
    
    
    public static ArrayList<JButton> createButtonList(ArrayList<String>names,
            ArrayList<ActionListener>listeners,
            ArrayList<Integer> keyEvents,
            ArrayList<String> actionCommands,
            ArrayList<ImageIcon> icons) {
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        if (null == names) {
            errMess(null,   "There are no names for buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        JButton temp;
        buttonList = new ArrayList<JButton>();
        for(int i=0;i<number;i++) {
            temp = new JButton(names.get(i));
            if (null != listeners)
                temp.addActionListener(listeners.get(i));
            if (null != keyEvents)
                temp.setMnemonic(keyEvents.get(i));
            if (null != actionCommands)
                temp.setActionCommand(actionCommands.get(i));
            if (null != icons)
                temp.setIcon(icons.get(i));
            buttonList.add(temp);
        }
        return buttonList;
    }
    
    public static ArrayList<JButton> createButtonList(ArrayList<String>names,
            ArrayList<ActionListener>listeners) {
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        if (null == names) {
            errMess(null,   "There are no names for buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        JButton temp;
        buttonList = new ArrayList<JButton>();
        for(int i=0;i<number;i++) {
            temp = new JButton(names.get(i));
            if (null != listeners)
                temp.addActionListener(listeners.get(i));
            buttonList.add(temp);
        }
        return buttonList;
    }
    
    public static ArrayList<JButton> createButtonList(ArrayList<String>names,
            ActionListener oyente) {
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        if (null == names) {
            errMess(null,   "There are no names for buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        if (null == oyente) {
            errMess(null,   "There is no listener for buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        JButton temp;
        buttonList = new ArrayList<JButton>();
        for(int i=0;i<number;i++) {
            temp = new JButton(names.get(i));
            temp.addActionListener(oyente);
            buttonList.add(temp);
        }
        return buttonList;
    }
    
    
    public static  ArrayList<JRadioButton> createRBList(ArrayList<String> names,
            ArrayList<ActionListener> listeners,
            int selected) {
        if (null == names) {
            errMess( null,"There are no names for radio buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        ButtonGroup bg = new ButtonGroup();
        JRadioButton temp;
        ArrayList<JRadioButton> listaBr = new ArrayList<JRadioButton>();
        for(int i=0;i<number;i++) {
            temp = new JRadioButton(names.get(i));
            if (null != listeners)
                temp.addActionListener(listeners.get(i));
            temp.setSelected(selected == i ? true:false);
            listaBr.add(temp);
            bg.add(temp);
        }
        return listaBr;
    }
    
    
    public static  ArrayList<JRadioButton> createRBList(ArrayList<String> names,
            ActionListener oyente,
            int selected) {
        if (null == names) {
            errMess( null,  "There are no names for radio buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        if (null == oyente) {
            errMess(null,   "There is no listener for radio buttons",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        ButtonGroup bg = new ButtonGroup();
        JRadioButton temp;
        ArrayList<JRadioButton> listaBr = new ArrayList<JRadioButton>();
        for(int i=0;i<number;i++) {
            temp = new JRadioButton(names.get(i));
            if (null != oyente)
                temp.addActionListener(oyente);
            temp.setSelected(selected == i ? true : false);
            listaBr.add(temp);
            bg.add(temp);
        }
        return listaBr;
    }
    
    public static  ArrayList<JCheckBox> createCBList(ArrayList<String> names,
            ArrayList<ActionListener> listeners,
            ArrayList<Boolean> seleccionados) {
        if (null == names) {
            errMess(null,   "There are no names for checkboxes",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        JCheckBox temp;
        ArrayList<JCheckBox> listaCv = new ArrayList<JCheckBox>();
        for(int i=0;i<number;i++) {
            temp = new JCheckBox(names.get(i));
            if (null != listeners)
                temp.addActionListener(listeners.get(i));
            if (null != seleccionados)
                temp.setSelected(seleccionados.get(i));
            listaCv.add(temp);
        }
        return listaCv;
    }
    
    
    public static  ArrayList<JCheckBox> createCBList(ArrayList<String> names,
            ActionListener oyente,
            ArrayList<Boolean> seleccionados) {
        if (null == names) {
            errMess(null,   "There are no names for checkboxes",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        if (null == oyente) {
            errMess(null,   "There is no listener for checkboxes",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        JCheckBox temp;
        ArrayList<JCheckBox> listaCv = new ArrayList<JCheckBox>();
        for(int i=0;i<number;i++) {
            temp = new JCheckBox(names.get(i));
            if (null != oyente)
                temp.addActionListener(oyente);
            if (null != seleccionados)
                temp.setSelected(seleccionados.get(i));
            listaCv.add(temp);
        }
        return listaCv;
    }
    
    public static  ArrayList<JCheckBox> createCBList(ArrayList<String> names,
            ArrayList<Boolean> seleccionados) {
        if (null == names) {
            errMess(null,   "There are no names for checkboxes",
                    "AuxButton - fatal error");
            System.exit(1);
        }
        int number = names.size();
        JCheckBox temp;
        ArrayList<JCheckBox> listaCv = new ArrayList<JCheckBox>();
        for(int i=0;i<number;i++) {
            temp = new JCheckBox(names.get(i));
            if (null != seleccionados)
                temp.setSelected(seleccionados.get(i));
            listaCv.add(temp);
        }
        return listaCv;
    }
    
    
    private static void pws(	SpringLayout d,
								Component comp,
								int posX,
								int posY,
								int width,
								int height) {
        Dimension dim = new Dimension(width, height);
        comp.setPreferredSize(dim);
        comp.setMaximumSize(dim);
        
        SpringLayout.Constraints cons = d.getConstraints(comp);
        cons.setX(Spring.constant(posX));
        cons.setY(Spring.constant(posY));
    }
    
    
    public static JPanel panelWithButtons(	String panelName,
                                            ArrayList<JButton> buttonList) {
        if (null == panelName) {
            JOptionPane.showMessageDialog(	null,
                                                "null panelName",
                                                "AuxButton - fatal error",
                                                JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if (null == buttonList) {
            JOptionPane.showMessageDialog(	null,
                                                "null buttonList",												"AuxButton - fatal error",
                                                JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        int numberOfRows = buttonList.size();
        final int leftMargin = 5;
        final int rightMargin = 5;
        final int topMargin = 5;
        final int bottomMargin = 5;
        final int hGap = 5;
        final int vGap = 10;
        JButton tempB = null;
        JPanel jp = new JPanel();
        SpringLayout sl = new SpringLayout();
        JButton longestButton = null;
        jp.setLayout(sl);
        jp.setBorder(BorderFactory.createTitledBorder(panelName));
        /* Max size of buttons */
        int maxButtonWidth = 0;
        for(JButton a : buttonList){
            jp.add(a);
            if (a.getPreferredSize().width > maxButtonWidth) {
                maxButtonWidth = a.getPreferredSize().width;
                longestButton = a;
            }
        }
        
        tempB = buttonList.get(0);
        
        sl.putConstraint(SpringLayout.WEST, tempB,
                leftMargin,
                SpringLayout.WEST, jp);
        sl.putConstraint(SpringLayout.EAST, tempB,
                leftMargin+maxButtonWidth,
                SpringLayout.WEST, jp);
        sl.putConstraint(SpringLayout.NORTH, tempB,
                topMargin,
                SpringLayout.NORTH, jp);
        
        for(int i=1;i<numberOfRows;i++) {
            tempB = buttonList.get(i);
            sl.putConstraint(SpringLayout.EAST, tempB,
                    leftMargin+maxButtonWidth,
                    SpringLayout.WEST, jp);
            sl.putConstraint(SpringLayout.NORTH, tempB,
                    vGap,
                    SpringLayout.SOUTH, buttonList.get(i-1));
        }
        sl.putConstraint(SpringLayout.EAST, jp,
                rightMargin,
                SpringLayout.EAST, longestButton);
        sl.putConstraint(SpringLayout.SOUTH, jp,
                bottomMargin,
                SpringLayout.SOUTH, tempB);
        return jp;
    }
    
    
    public static JPanel panelWithIconButtons(ArrayList<JButton> buttonList) {
        JPanel panelB = new JPanel();
        SpringLayout sl = new SpringLayout();
        panelB.setLayout(sl);
        JButton b        = null;
        int posY         = 6;
        int alturaBoton = 0;
        int anchuraBoton = 0;
        FontMetrics fm = null;
        int anchuraMin = 0;
        int alturaMin = 0;
        b = buttonList.get(0);
        fm = b.getFontMetrics(b.getFont());
        
        for(int i=0;i<buttonList.size();i++) {
            b = buttonList.get(i);
            alturaBoton = b.getIcon().getIconHeight() + 10;
            anchuraBoton = fm.stringWidth(b.getText())+ b.getIcon().getIconWidth();
            if (anchuraBoton > anchuraMin) anchuraMin=anchuraBoton;
        }
        for(int i=0;i<buttonList.size();i++) {
            b = buttonList.get(i);
            alturaBoton = b.getIcon().getIconHeight() + 10;
            pws(sl,b, 6, posY, anchuraMin+20, alturaBoton);
            posY += alturaBoton+10;
            panelB.add(b);
        }
        alturaMin = posY + alturaBoton + 5;
        Dimension dim = new Dimension(anchuraMin,alturaMin);
        panelB.setPreferredSize(dim);
        panelB.setSize(dim);
        panelB.setMaximumSize(dim);
        return panelB;
    }
    
    
    public static JPanel panelWithRadioButtons(ArrayList<JRadioButton> buttonList) {
        JPanel panelB = new JPanel();
        SpringLayout sl = new SpringLayout();
        panelB.setLayout(sl);
        JRadioButton b        =  null;
        int posY         =     6;
        int alturaBoton =    18;
        int anchuraBoton  =     0;
        FontMetrics fm = null;
        int anchuraMin = 200;
        int alturaMin = 0;
        
        b = buttonList.get(0);
        fm = b.getFontMetrics(b.getFont());
        
        for(int i=0;i<buttonList.size();i++) {
            b = buttonList.get(i);
            
            anchuraBoton = fm.stringWidth(b.getText())+50;
            pws(sl,b, 6, posY, anchuraBoton, alturaBoton);
            posY += alturaBoton+10;
            panelB.add(b);
            if (anchuraBoton > anchuraMin)
                anchuraMin=anchuraBoton;
        }
        alturaMin = posY + alturaBoton + 5;
        Dimension dim = new Dimension(anchuraMin,alturaMin);
        panelB.setPreferredSize(dim);
        panelB.setSize(dim);
        panelB.setMaximumSize(dim);
        return panelB;
    }
    
    
    public static JPanel panelWithCheckBoxes(ArrayList<JCheckBox> buttonList) {
        JPanel panelB = new JPanel();
        SpringLayout sl = new SpringLayout();
        panelB.setLayout(sl);
        JCheckBox b        =  null;
        int posY         =     6;
        int alturaBoton =    18;
        int anchuraBoton  =     0;
        FontMetrics fm = null;
        int anchuraMin = 200;
        int alturaMin = 0;
        b = buttonList.get(0);
        fm = b.getFontMetrics(b.getFont());
        
        for(int i=0;i<buttonList.size();i++) {
            b = buttonList.get(i);
            anchuraBoton = fm.stringWidth(b.getText())+50;
            pws(sl,b, 6, posY, anchuraBoton, alturaBoton);
            posY += alturaBoton+10;
            panelB.add(b);
            if (anchuraBoton > anchuraMin)
                anchuraMin=anchuraBoton;
        }
        alturaMin = posY + alturaBoton + 5;
        Dimension dim = new Dimension(anchuraMin,alturaMin);
        panelB.setPreferredSize(dim);
        panelB.setSize(dim);
        panelB.setMaximumSize(dim);
        return panelB;
    }
    
    
    public static boolean[] getSelectedCheckBoxes(ArrayList<JCheckBox> cb) {
        int dim = cb.size();
        if (0 == dim) {
            errMess(null, "There are no checkboxes in the list","Empty list");
            return null;
        }
        boolean[] r = new boolean[cb.size()];
        for(int i=0;i<dim;i++)
            r[i] = cb.get(i).isSelected();
        return r;
    }
    
    
    public static int getSelectedRadioButtons(ArrayList<JRadioButton> rb) {
        int selectedButton = -1;
        int dim = rb.size();
        if (0 == dim) {
            errMess(null, "There are no radio buttons in the list","Empty list");
            return selectedButton;
        }
        for(int i=0;i<dim;i++)
            if(rb.get(i).isSelected()) {
            selectedButton = i;
            break;
            }
        return selectedButton;
    }
}
