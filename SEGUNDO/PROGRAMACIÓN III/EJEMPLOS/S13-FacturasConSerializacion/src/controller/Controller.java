/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package controller;

import data.Factura;
import data.Model;

/**
 *
 * @author coti
 */
public class Controller {

    private final Model m = new Model();

    public void darValores() {
        m.giveRandomValuesToList();
    }

    public String[] obtenerListado() {
        if (null == m.getLista()[0]) {
            return null;
        }
        String[] temp = new String[m.getLista().length];
        for (int i = 0; i < temp.length; i++) {
            Factura[] listaFacturas = m.getLista();
            temp[i] = listaFacturas[i].exportStateAsColumns();
        }
        return temp;
    }

    public int getNumValores() {
        return m.getLista().length;
    }

    public void save() {
        m.save();
    }

    public void load() {
        m.load();
    }

} // End of Controller
