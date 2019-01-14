/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package ejemplo4derivadas;
import otropaquete.*;
/**
 *
 * @author bruegel
 */
public class Ejemplo4Derivadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClaseBase cb = new ClaseBase();
        cb.visibles();
        
        D1IgualPaquete d1igual = new D1IgualPaquete();
        d1igual.visibles();
        
        D2IgualPaquete d2igual = new D2IgualPaquete();
        d2igual.visibles();
        
        D3IgualPaquete d3igual = new D3IgualPaquete();
        d3igual.visibles();
        
        D4IgualPaquete d4igual = new D4IgualPaquete();
        d4igual.visibles();
        
        var d1otroPaquete = new D1OtroPaquete();
        d1otroPaquete.visibles();
        
        var d2otroPaquete = new D2OtroPaquete();
        d2otroPaquete.visibles();
        
        var d3OtroPaquete = new D3OtroPaquete();
        d3OtroPaquete.visibles();
        
        var d4OtroPaquete = new D4OtroPaquete();
        d4OtroPaquete.visibles();
        
        var igualNoHereda = new IgualPaqueteNoHereda();
        igualNoHereda.visibles();
        
        var otroNoHereda = new OtroPaqueteNoHereda();
        otroNoHereda.visibles();
    }
    
}
