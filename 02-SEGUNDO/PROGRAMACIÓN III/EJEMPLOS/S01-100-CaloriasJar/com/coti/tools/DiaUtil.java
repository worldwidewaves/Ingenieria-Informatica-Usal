package com.coti.tools;

// Now added package and git

import java.time.LocalTime;

public class DiaUtil {
  static long startingTime;
  static long stoppingTime;

  public static void startTimer() {
    startingTime = System.currentTimeMillis();      
  }
  
  public static void stopTimerAndPrintElapsedTimeMillis() {
    stoppingTime = System.currentTimeMillis();
    String theCoverForThisPrint = "+---------------------------------+";
    System.out.printf("%s%n", theCoverForThisPrint);
    System.out.printf("| Elapsed time (ms): %-12s |%n", (stoppingTime-startingTime) + "");
    System.out.printf("%s%n", theCoverForThisPrint);
   
  }
	public static void showFinalTime() {
		String nameOfUserAsKnownToJava = System.getProperty("user.name");
		String nameCutToSize = nameOfUserAsKnownToJava.length() <= 10 ? nameOfUserAsKnownToJava : nameOfUserAsKnownToJava.substring(0, 10);
		String time_at_exit = LocalTime.now().toString();
		String theCoverForThisPrint = "+---------------------------------+";
		System.out.printf("%n%s%n", theCoverForThisPrint);
		System.out.printf("| User             : %-12s |%n", nameCutToSize);
		System.out.printf("%s%n", theCoverForThisPrint);
		System.out.printf("| Task finished at : %s |%n", time_at_exit);
		System.out.printf("%s%n", theCoverForThisPrint);
	}
  
  public static void clear() {
    final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
    
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        System.out.print(ANSI_CLS + ANSI_HOME);
    } catch (Exception ex) {}
  }
}
