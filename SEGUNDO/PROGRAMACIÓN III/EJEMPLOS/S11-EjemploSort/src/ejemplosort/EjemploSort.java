/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bruegel
 */
public class EjemploSort {

    public static void main(String[] args) {
        List<String> palabras = Arrays.asList(args);
        Collections.sort(palabras);
        System.out.println(palabras);
    }
}
