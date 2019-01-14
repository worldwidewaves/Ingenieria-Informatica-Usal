public class ForAndWhileNumbers {
    public static void main(String[] args) {
        System.out.printf("%nEscribir 10 números%n%n");
        for(int number=1 ;  number <= 10; number++) {
            System.out.printf("%3d", number);
        }
        System.out.println();
        int number=1;
        while(number <= 10) {
            System.out.printf("%3d", number);
            number++;
        }
        System.out.printf("%n%n");
    } // End of main()
} // End of ForAndWhileNumbers
