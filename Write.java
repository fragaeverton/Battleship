package battleship;

import static battleship.Main.*;
import static battleship.PrintGame.print;

public class Write {

    protected static void placeShip(boolean isHorizontal, int l1, int l2, int c1, int c2, int player) {
        if (player == 1) {
            if (isHorizontal) {
                for (int j = c1; j < c2 + 1; j++) {
                    plain1[l1][j] = 'O';
                    unavailableLocation1[l1][j] = 'O';
                    if (l1 > 0) {
                        unavailableLocation1[l1-1][j] = 'O';
                    }
                    if (l1 < 9) {
                        unavailableLocation1[l1+1][j] = 'O';
                    }
                }
                if (c1 > 0) {
                    unavailableLocation1[l1][c1 - 1] = 'O';
                }
                if (c2 < 9) {
                    unavailableLocation1[l1][c2 + 1] = 'O';
                }
            } else {
                for (int i = l1; i < l2 + 1; i++) {
                    plain1[i][c1] = 'O';
                    unavailableLocation1[i][c1] = 'O';
                    if (c1 > 0) {
                        unavailableLocation1[i][c1 - 1] = 'O';
                    }
                    if (c1 < 9) {
                        unavailableLocation1[i][c1 + 1] = 'O';
                    }
                }
                if (l1 > 0) {
                    unavailableLocation1[l1 - 1][c1] = 'O';
                }
                if (l2 < 9) {
                    unavailableLocation1[l2 + 1][c1] = 'O';
                }
            }

        } else {
            if (isHorizontal) {
                for (int j = c1; j < c2 + 1; j++) {
                    plain2[l1][j] = 'O';
                    unavailableLocation2[l1][j] = 'O';
                    if (l1 > 0) {
                        unavailableLocation2[l1-1][j] = 'O';
                    }
                    if (l1 < 9) {
                        unavailableLocation2[l1+1][j] = 'O';
                    }
                }
                if (c1 > 0) {
                    unavailableLocation2[l1][c1 - 1] = 'O';
                }
                if (c2 < 9) {
                    unavailableLocation2[l1][c2 + 1] = 'O';
                }
            } else {
                for (int i = l1; i < l2 + 1; i++) {
                    plain2[i][c1] = 'O';
                    unavailableLocation2[i][c1] = 'O';
                    if (c1 > 0) {
                        unavailableLocation2[i][c1 - 1] = 'O';
                    }
                    if (c1 < 9) {
                        unavailableLocation2[i][c1 + 1] = 'O';
                    }
                }
                if (l1 > 0) {
                    unavailableLocation2[l1 - 1][c1] = 'O';
                }
                if (l2 < 9) {
                    unavailableLocation2[l2 + 1][c1] = 'O';
                }
            }
        }
        print(false, player);
    }

    protected static void fillGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plain1[i][j] = '~';
                shots1[i][j] = '~';
                plain2[i][j] = '~';
                shots2[i][j] = '~';
            }
        }
    }
}
