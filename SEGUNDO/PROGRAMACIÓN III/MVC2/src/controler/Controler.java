/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Model;

/**
 *
 * @author pgina17
 */
public class Controler {
    Model m= new Model();
    public void setDatos (int dato1 , int dato2){
        m.setDato1(dato1);
        m.setDato2(dato2);
        
    }
    
    public void sumarValores(){
        m.setResultado(m.getDato1()+m.getDato2());
    }
    public int getDato1(){
        return m.getDato1();
    }
     public int getDato2(){
        return m.getDato2();
    }
     public int getResu(){
        return m.getResultado();
    }
}
