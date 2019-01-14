package datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import logica.ComparadorPorEdades;
import logica.ComparadorPorNombres;
import java.util.Comparator;
import datos.MiniPersona;
import logica.ComparadorPorPeso;

/**
 *
 * @author bruegel
 */
public class Modelo {

    private MiniPersona[] miniLista;
    private Comparator<MiniPersona> comparadorPorNombres;
    private Comparator<MiniPersona> comparadorPorEdades;
    private Comparator<MiniPersona> comparadorPorPesos;

    public Modelo() {
        this.comparadorPorEdades = new ComparadorPorEdades();
        this.comparadorPorNombres = new ComparadorPorNombres();
        this.comparadorPorPesos = new ComparadorPorPeso();
        this.miniLista = new MiniPersona[4];
    }

    public void crearListaAleatoria() {
        for (int i = 0; i < getMiniLista().length; i++) {
            getMiniLista()[i] = new MiniPersona();
            getMiniLista()[i].miniSetRandomAttributes();
        }
    }

    /**
     * @return the miniLista
     */
    public MiniPersona[] getMiniLista() {
        return miniLista;
    }

    /**
     * @param miniLista the miniLista to set
     */
    public void setMiniLista(MiniPersona[] miniLista) {
        this.miniLista = miniLista;
    }

    /**
     * @return the comparadorPorNombres
     */
    public Comparator<MiniPersona> getComparadorPorNombres() {
        return comparadorPorNombres;
    }

    /**
     * @return the comparadorPorEdades
     */
    public Comparator<MiniPersona> getComparadorPorEdades() {
        return comparadorPorEdades;
    }

    /**
     * @return the comparadorPoPesos
     */
    public Comparator<MiniPersona> getComparadorPorPesos() {
        return comparadorPorPesos;
    }
}
