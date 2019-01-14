/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package ejemploherencia;

/**
 *
 * @author bruegel
 */
public class ClaseBase {
   public String atributoPublico = "Atributo público";
   protected String atributoProtegido = "Atributo protegido";
   String atributoDePaquete = "Atributo con visibilidad de paquete";
   private String atributoPrivate = "Atributo private";
   
   public ClaseBase() {
       System.out.println("Se ha ejecutado el constructor de ClaseBase");
   }
   
}
