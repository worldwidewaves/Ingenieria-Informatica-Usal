/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumannum;

import view.View;

/**
 *
 * @author pgina37
 */
public class SumanNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        View v = new View();
       v.runMenu("1.- Leer dos números "
               + "2.- Calcular Suma "
               + "3.- Mostrar resultado "
               + "q.- Salir");
    }
    }
    

