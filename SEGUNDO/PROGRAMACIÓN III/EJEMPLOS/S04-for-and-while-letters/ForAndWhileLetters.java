public class ForAndWhileLetters {
    public static void main(String[] args) {
        System.out.printf("%nEscribir 10 letras%n%n");
        for(char letter='a' ;  letter <= 'j'; letter++) {
            System.out.printf("%c", letter);
        }
        System.out.println();
        char letter='a';
        while(letter <= 'j') {
            System.out.printf("%c", letter);
            letter++;
        }
        System.out.printf("%n%n");
    } // End of main()
} // End of ForAndWhileLetters
