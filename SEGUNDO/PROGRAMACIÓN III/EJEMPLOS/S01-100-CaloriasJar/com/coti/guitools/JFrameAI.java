package com.coti.guitools;

import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;

/*
12/12/11 17:13
27 de febrero de 2016, 9:41:30 CET
*/
public class JFrameAI extends JFrame {

    public static final int CENTER = 0;
    public static final int PLATFORM = 1;
    public static final int NONE = 2;
    private double scale = 4.0 / 5.0;
    private int placement;

    public JFrameAI(String title, int placement) {
        super(title);
        this.placement = placement;
        prepare();
    }

    public JFrameAI(String title,
            int placement,
            double scale) {
        super(title);
        this.placement = placement;
        this.scale = scale;
        prepare();
    }

    private void errMess(String message, String title) {
        JOptionPane.showMessageDialog(this,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void errMess(Component owner,
            String message,
            String title) {
        JOptionPane.showMessageDialog(owner,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    public static void pws(SpringLayout d,
            Component comp,
            int xPos,
            int yPos,
            int width,
            int height) {
        Dimension dim = new Dimension(width, height);
        comp.setPreferredSize(dim);
        comp.setMaximumSize(dim);

        SpringLayout.Constraints cons = d.getConstraints(comp);
        cons.setX(Spring.constant(xPos));
        cons.setY(Spring.constant(yPos));
    }

    public void setLocationByPlatformFix(ArrayList<JFrameAI> lista) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (JFrameAI frame : lista) {
            if (frame.isShowing()) {
                minX = Math.min(minX, frame.getX());
                minY = Math.min(minY, frame.getY());
                maxX = Math.max(maxX, frame.getX());
                maxY = Math.max(maxY, frame.getY());
            }
        }
        int x, y;
        if (minX == Integer.MAX_VALUE || minX >= 50) {
            x = 0;
        } else {
            x = maxX + 50;
        }
        if (minY == Integer.MAX_VALUE || minY >= 50) {
            y = 0;
        } else {
            y = maxY + 50;
        }
        // Set the location of the new frame
        this.setLocation(x, y);
    }

    private void prepare() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension scSz = Toolkit.getDefaultToolkit().getScreenSize();
        double newWidth = scSz.getWidth() * scale;
        double newHeight = scSz.getHeight() * scale;
        Dimension newDimension = new Dimension();
        newDimension.setSize(newWidth, newHeight);
        this.setResizable(false);
        if (0.0 != scale) {
            this.setSize(newDimension);
        }
        if (CENTER == placement) {
            this.setLocationRelativeTo(null);
        } else if (PLATFORM == placement) {
            this.setLocationByPlatform(true);
        } else if (NONE == placement)
            ; // Do nothing;
    }

}
