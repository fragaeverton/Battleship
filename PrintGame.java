package battleship;
import static battleship.Main.plain;

public class PrintGame {
    public static void print(boolean isShot, int l1, int c1) {
        System.out.println();
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char character =  'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(character + " ");
            for (int j = 0; j < 10; j++) {
                if (isShot) {
                    if (i == l1 && j == c1) {
                        if (plain[i][j] == '~') {
                            System.out.print("M ");
                        } else {
                            System.out.print("X ");
                        }
                    } else {
                        System.out.print("~ ");
                    }
                } else {
                    System.out.print(plain[i][j] + " ");
                }
            }
            character++;
            System.out.println();
        }
    }

}
