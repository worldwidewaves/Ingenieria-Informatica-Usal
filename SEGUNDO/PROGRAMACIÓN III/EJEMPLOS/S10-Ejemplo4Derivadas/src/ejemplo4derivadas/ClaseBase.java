/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package ejemplo4derivadas;

/**
 *
 * @author bruegel
 */
public class ClaseBase {
    public String publico = "Atributo público";
    private String privado = "Atributo privado";
    protected String protegido = "Atributo protegido";
    String dePaquete = "Atributo package";
       
    void visibles() {
        System.out.printf("\nDesde la misma clase, ClaseBase\n\n");
        System.out.println(this.privado);
        System.out.println(this.dePaquete);
        System.out.println(this.protegido);
        System.out.println(this.publico);
    }

}
