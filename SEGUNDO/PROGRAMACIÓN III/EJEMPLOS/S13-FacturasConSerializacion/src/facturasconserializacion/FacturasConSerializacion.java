package facturasconserializacion;

/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
/**
 *
 * @author coti
 */
import view.View;
import static com.coti.tools.DiaUtil.*;

public class FacturasConSerializacion {

  public static void main(String[] args) {

    clear();
    System.out.printf("FACTURAS%n%n");
    View v = new View();
    v.runMenu("1.- Dar valores 2.- Mostrar lista 3.- Save 4.- Load q.- Salir ");
    
  } // End of method main()
    
} // End of FacturasConSerializacion
