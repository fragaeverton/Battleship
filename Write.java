package battleship;

import static battleship.Main.plain;
import static battleship.Main.unavailableLocation;
import static battleship.PrintGame.print;

public class Write {

    protected static void placeShip(boolean isHorizontal, int l1, int l2, int c1, int c2) {
        if (isHorizontal) {
            for (int j = c1; j < c2 + 1; j++) {
                plain[l1][j] = 'O';
                unavailableLocation[l1][j] = 'O';
                if (l1 > 0) {
                    unavailableLocation[l1-1][j] = 'O';
                }
                if (l1 < 9) {
                    unavailableLocation[l1+1][j] = 'O';
                }
            }
            if (c1 > 0) {
                unavailableLocation[l1][c1 - 1] = 'O';
            }
            if (c2 < 9) {
                unavailableLocation[l1][c2 + 1] = 'O';
            }
        } else {
            for (int i = l1; i < l2 + 1; i++) {
                plain[i][c1] = 'O';
                unavailableLocation[i][c1] = 'O';
                if (c1 > 0) {
                    unavailableLocation[i][c1 - 1] = 'O';
                }
                if (c1 < 9) {
                    unavailableLocation[i][c1 + 1] = 'O';
                }
            }
            if (l1 > 0) {
                unavailableLocation[l1 - 1][c1] = 'O';
            }
            if (l2 < 9) {
                unavailableLocation[l2 + 1][c1] = 'O';
            }
        }
        print(false,0, 0);
    }

    protected static void fillGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plain[i][j] = '~';
            }
        }
    }
}
