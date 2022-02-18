package battleship;

import static battleship.Input.locationInput;
import static battleship.PrintGame.print;
import static battleship.Write.placeShip;
import static battleship.Main.plain;
import static battleship.Output.*;

public class Checks {

    protected static void checkLocation(boolean isHorizontal, char[][] unavailableLocation, int range, Ships ships, int l1, int l2, int c1, int c2) {
        boolean isClose = false;
        if (isHorizontal) {
            for (int j = c1; j < c2 + 1; j++) {
                if (unavailableLocation[l1][j] == 'O') {
                    isClose = true;
                    break;
                }
            }
        } else {
            for (int i = l1; i < l2 + 1; i++) {
                if (unavailableLocation[i][c1] == 'O') {
                    isClose = true;
                    break;
                }
            }
        }

        if (isClose) {
            tooCloseMessage();
            locationInput(ships);
        } else {
            checkSize(isHorizontal, range, ships, l1, l2, c1, c2);
        }
    }

    protected static void checkSize(boolean isHorizontal, int range, Ships ships, int l1, int l2, int c1, int c2) {
        if (range + 1 == ships.getPieces()) {
            placeShip(isHorizontal, l1, l2, c1, c2);
        } else {
            wrongLengthMessage(ships.getShips());
            locationInput(ships);
        }
    }
    protected static void checkShot(int l1, int c1) {
        if (plain[l1][c1] == 'O') {
            plain[l1][c1] = 'X';
            print(true, l1, c1);
            hitShipMessage();
            print(false, -1, -1);
        } else if (plain[l1][c1] == '~') {
            plain[l1][c1] = 'M';
            print(true, l1, c1);
            missedShipMessage();
            print(false, -1, -1);
        }
    }
}
