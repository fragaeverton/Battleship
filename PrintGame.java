package battleship;
import static battleship.Main.plain;

public class PrintGame {
    public static void print() {
        System.out.println();
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char character =  'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(character + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(plain[i][j] + " ");
            }
            character++;
            System.out.println();
        }
    }

}
