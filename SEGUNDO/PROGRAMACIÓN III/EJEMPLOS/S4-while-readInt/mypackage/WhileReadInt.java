package mypackage;

import java.util.Scanner;

public class WhileReadInt {
	static Scanner sc = new Scanner(System.in);
    static public int readInt(String prompt) {
        int tempNumber = 0;
        String temp;
        boolean numberOkay = true;
        do {
            numberOkay = false;
            do {
                System.out.printf("%s ", prompt);
                temp = sc.nextLine();

            } while (temp.isEmpty());
            try {
                tempNumber = Integer.parseInt(temp);
                numberOkay = true;
            } catch (Exception e) {
                System.out.printf("%nPerdón, ese número no es correcto. Pruebe de nuevo.%n");
                numberOkay = false;
            }
        } while (!numberOkay);
        return tempNumber;
    } // End of readInt()
} // End of WhileReadInt
