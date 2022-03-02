package battleship;

import static battleship.Main.*;

public class PrintGame {
    public static void print(boolean isShot, int player) {
        System.out.println();
        if (isShot) {
            printEspecial(player, false);
            System.out.println("---------------------");
            printEspecial(player, true);
        } else {
            System.out.println("  1 2 3 4 5 6 7 8 9 10");
            char character =  'A';
            for (int i = 0; i < 10; i++) {
                System.out.print(character + " ");
                for (int j = 0; j < 10; j++) {
                    System.out.print(((player == 1) ? plain1[i][j] : plain2[i][j]) + " ");
                }
                character++;
                System.out.println();
            }
        }
    }

    private static void printEspecial(int player, boolean isOwnTable) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char character =  'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(character + " ");
            for (int j = 0; j < 10; j++) {
                if (isOwnTable) {
                    System.out.print(((player == 1) ? plain1[i][j] : plain2[i][j]) + " ");
                } else {
                    System.out.print(((player == 1) ? shots1[i][j] : shots2[i][j]) + " ");
                }
            }
            character++;
            System.out.println();
        }
    }

}
