package com.coti.guitools;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/*
	Nota:
	
	This constraint will cause the assignment

     value(e1, c1) = value(e2, c2) + pad

to take place during all subsequent layout operations.
*/
public class AuxTextField {
    
    public static JPanel labelAndFieldTable(	String panelName,
    	String[] labelText,
    	ArrayList<JTextField> jt) {
    	if (null == panelName)
    		{
    			JOptionPane.showMessageDialog(	null,
    																			"null panelName",
    																			"AuxTextField - fatal error",
    																			JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
			if (null == labelText || 0 == labelText.length)
    		{
    			JOptionPane.showMessageDialog(	null,
    																			"null labelText",
    																			"AuxTextField - fatal error",
    																			JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
			if (null == jt || 0 != jt.size())
    		{
    			JOptionPane.showMessageDialog(	null,
    																			"null or non-empty jt",
    																			"AuxTextField - fatal error",
    																			JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
    	ArrayList<JLabel> jl = new ArrayList<JLabel>();
    	jt.clear();
    	for(String s:labelText)
    		{
	    		jl.add(new JLabel(s));
	    		jt.add(new JTextField(10));
	    	}
    	return labelAndFieldTable( panelName,jl,jt);
    }
    
    public static JPanel labelAndFieldTable(    String panelName,
            ArrayList<JLabel> jl,
            ArrayList<JTextField> jt) {
    	if (null == panelName)
    		{
    			JOptionPane.showMessageDialog(	null,
    																			"null panelName",
    																			"AuxTextField - fatal error",
    																			JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
			if (null == jl || 0 == jl.size())
    		{
    			JOptionPane.showMessageDialog(	null,
    																			"null jl or empty label list",
    																			"AuxTextField - fatal error",
    																			JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
			if (null == jt || 0 == jt.size())
    		{
    			JOptionPane.showMessageDialog(	null,
    																			"null or empty text field list",
    																			"AuxTextField - fatal error",
    																			JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
        int numberOfRows = jl.size();
        final int leftMargin = 5;
        final int rightMargin = 5;
        final int topMargin = 5;
        final int bottomMargin = 5;
        final int hGap = 5;
        final int vGap = 10;
        JLabel tempL = null;
        JTextField tempT = null;
        JPanel jp = new JPanel();
        SpringLayout sl = new SpringLayout();
        jp.setLayout(sl);
        jp.setBorder(BorderFactory.createTitledBorder(panelName));
        /* Max size of labels */
        int maxLabelWidth = 0;
        int maxFieldWidth = 0;
        for(JLabel a : jl){
            jp.add(a);
            if (a.getPreferredSize().width > maxLabelWidth)
                maxLabelWidth = a.getPreferredSize().width;
        }
        JTextField longestField = null;
        for(int i=0;i<jt.size();i++){
        		tempT = jt.get(i);
            jp.add(tempT);
            if (tempT.getPreferredSize().width > maxFieldWidth){
                maxFieldWidth = tempT.getPreferredSize().width;
                longestField = tempT;
            }
        }
        tempL = jl.get(0);

        sl.putConstraint(SpringLayout.EAST, tempL,
                    leftMargin+maxLabelWidth,
                SpringLayout.WEST, jp);
        sl.putConstraint(SpringLayout.NORTH, tempL,
                topMargin,
                SpringLayout.NORTH, jp);
        tempT = jt.get(0);
        SpringLayout.Constraints res = sl.getConstraints(tempT);
        res.setX(Spring.constant(leftMargin+maxLabelWidth+hGap));
        sl.putConstraint(SpringLayout.VERTICAL_CENTER,tempT,
                0,SpringLayout.VERTICAL_CENTER,tempL);
        for(int i=1;i<numberOfRows;i++) {
            tempL = jl.get(i);
            sl.putConstraint(SpringLayout.EAST, tempL,
                    leftMargin+maxLabelWidth,
                    SpringLayout.WEST, jp);
            sl.putConstraint(SpringLayout.NORTH, tempL,
                    vGap,
                    SpringLayout.SOUTH, jl.get(i-1));
            tempT = jt.get(i);
            res = sl.getConstraints(tempT);
            res.setX(Spring.constant(leftMargin+maxLabelWidth+hGap));
            sl.putConstraint(SpringLayout.VERTICAL_CENTER,tempT,
                    0,
                    SpringLayout.VERTICAL_CENTER,tempL);
            sl.putConstraint(SpringLayout.EAST,tempT,
            -rightMargin,
            SpringLayout.EAST,jp);
        }
        sl.putConstraint(SpringLayout.EAST, jp,
                rightMargin,
                SpringLayout.EAST, longestField);
        sl.putConstraint(SpringLayout.SOUTH, jp,
                bottomMargin,
                SpringLayout.SOUTH, tempT);
        return jp;
    }
}

