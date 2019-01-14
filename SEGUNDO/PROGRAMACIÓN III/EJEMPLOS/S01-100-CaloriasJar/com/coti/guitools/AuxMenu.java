package com.coti.guitools;

/**
 *
 * @author coti
 */
import javax.swing.*;
import java.awt.event.*;

/*
12/12/11 17:14
*/
public class AuxMenu {

    /**
     * 
     * @param name The name of the menu item. It must not be null.
     * @param action The listener to be registered with this menu item. It must not be null.
     * @return A menu option with the given name and listener.
     */
    public static JMenuItem makeOpt(String name, ActionListener action) {
        JMenuItem jmi = null;
        if (null == name || null == action) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null name or action not valid.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            jmi = new JMenuItem(name);
            jmi.addActionListener(action);
        }
        return jmi;
    }

    /**
     * 
     * @param name The name of the menu item.
     * @param action The listender to be registered with this menu item. It must not be null.
     * @param command The action command to be associated with this menu item. It must not be null.
     * @return A menu option with te given name, listener and action command.
     */
    public static JMenuItem makeOpt(String name, ActionListener action, String command) {
        JMenuItem jmi = null;
        if (null == action || null == command) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null action or command.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            jmi = new JMenuItem(name);
            jmi.setActionCommand(command);
            jmi.addActionListener(action);
        }
        return jmi;
    }

    /**
     * 
     * @param names The list of names for the menu items in this list. It must not be null.
     * @param listener The listener to be registered with all of the menu items. It must not be null.
     * @param ac The list of action commands to be associated with each menu item.  It must not be null.
     * @return  A list of JMenuItems with the given names, listener and action commands.
     */
    public static JMenuItem[] makeOptList(String[] names, ActionListener listener, String[] ac) {
        int numberOfItems = 0;
        JMenuItem[] menuItems = null;
        if (null == names || null == listener || null == ac) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null names, action or commands.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            numberOfItems = names.length;
            menuItems = new JMenuItem[numberOfItems];
            for (int i = 0; i < numberOfItems; i++) {
                menuItems[i] = makeOpt(names[i], listener, ac[i]);
            }
        }
        return menuItems;
    }

    /**
     * 
     * @param names The  list of names for the menu items in this list.  It must not be null.
     * @param listener The listener to be registered with all of the menu items in the list.  It must not be null.
     * @param ac The list of action commands (Strings) to be associated with the various menu items. It must not be null.
     * @param vKeys The list of virtual keys to be associated with each menu option. The modifier is always Control.
     * @return A list of JMenuItems with the given names, listener, action commands and keyboard equivalent (the modifier key is Control for all menu items).
     */
    public static JMenuItem[] makeCtrlOptList(String[] names, ActionListener listener, String[] ac, int[] vKeys) {
        int numberOfItems = 0;
        JMenuItem[] menuItems = null;
        if (null == names || null == listener || null == ac) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null names, action or commands.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            numberOfItems = names.length;
            menuItems = new JMenuItem[numberOfItems];
            for (int i = 0; i < numberOfItems; i++) {
                menuItems[i] = ctrlOpt(names[i], listener, vKeys[i]);
                menuItems[i].setActionCommand(ac[i]);
            }
        }
        return menuItems;
    }
    /*
     * Remember, the mask can be:
    java.awt.event.InputEvent.SHIFT_DOWN_MASK
    java.awt.event.InputEvent.CTRL_DOWN_MASK
    java.awt.event.InputEvent.META_DOWN_MASK
    java.awt.event.InputEvent.ALT_DOWN_MASK
    java.awt.event.InputEvent.ALT_GRAPH_DOWN_MASK
     */

    /**
     * 
     * @param name The name of this menu itm.
     * @param action The action command (String) to be associated with this menu item.  It must not be null.
     * @param vKey The virtual key to be associated with this menu item.
     * @param mask The modifier to be associated with this menu item. The list of possible masks is: java.awt.event.InputEvent.SHIFT_DOWN_MASK<br>
    java.awt.event.InputEvent.CTRL_DOWN_MASK<br>
    java.awt.event.InputEvent.META_DOWN_MASK<br>
    java.awt.event.InputEvent.ALT_DOWN_MASK<br>
    java.awt.event.InputEvent.ALT_GRAPH_DOWN_MASK<br>
     * @return A menu item with the given name, listener and keyboard equivalent
     */
    public static JMenuItem makeOpt(String name, ActionListener action, int vKey, int mask) {
        JMenuItem jmi = null;
        if (null == action) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null action not valid.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            jmi = new JMenuItem(name);
            jmi.addActionListener(action);
            KeyStroke k = KeyStroke.getKeyStroke(vKey, mask);
            jmi.setAccelerator(k);
        }
        return jmi;
    }

    /**
     * 
     * @param name The name of the menu item.
     * @param action The action command. It must not be null.
     * @param vKey The virtual key for the keyboard equivalent.
     * @return A menu item with the given name and action command. The keyboard equivalent has the Control modifier.
     */
    public static JMenuItem ctrlOpt(String name, ActionListener action, int vKey) {
        JMenuItem jmi = null;
        if (null == action) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null action not valid.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            jmi = new JMenuItem(name);
            jmi.addActionListener(action);
            KeyStroke k = KeyStroke.getKeyStroke(vKey, InputEvent.CTRL_MASK);
            jmi.setAccelerator(k);
        }
        return jmi;
    }

    /**
     * 
     * @param name The name of the menu item.
     * @param action The action command to be associated with this menu item.
     * @param vKey The virtual key to be asociated with this menu item.
     * @return A menu item with the given name and action command. The keyboard equivalent has the Meta (Command on a Macintosh) modifier.
     */
    public static JMenuItem metaOpt(String name, ActionListener action, int vKey) {
        JMenuItem jmi = null;
        if (null == action) {
            JOptionPane.showMessageDialog(null,
                    "JMenuItem: null action not valid.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            jmi = new JMenuItem(name);
            jmi.addActionListener(action);
            KeyStroke k = KeyStroke.getKeyStroke(vKey, InputEvent.META_MASK);
            jmi.setAccelerator(k);
        }
        return jmi;
    }

    /**
     * 
     * @param nameOfMenu
     * @param listOfJMenuItems
     * @return A JMenu instance with the given menu name and list of menu items.
     */
    public static JMenu makeMenu(String nameOfMenu, JMenuItem[] listOfJMenuItems) {
        if (null == nameOfMenu || null == listOfJMenuItems) {
            JOptionPane.showMessageDialog(null,
                    "JMenu: Null name or list of items.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(2);
        }
        JMenu jm = new JMenu(nameOfMenu);
        for (JMenuItem option : listOfJMenuItems) {
            jm.add(option);
        }
        return jm;
    }

    /**
     * 
     * @param listOfJMenus
     * @return An instance of JMenuBar with the given list of JMenus.
     */
    public static JMenuBar makeMenuBar(JMenu[] listOfJMenus) {
        if (null == listOfJMenus) {
            JOptionPane.showMessageDialog(null,
                    "JMenubar: Null list of menus.",
                    "Fatal error...exiting.",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(3);
        }
        JMenuBar jmb = new JMenuBar();
        for (JMenu menu : listOfJMenus) {
            jmb.add(menu);
        }
        return jmb;

    }
}
