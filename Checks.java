package battleship;

import static battleship.Main.locationInput;
import static battleship.Main.placeShip;
import static battleship.Output.tooCloseMessage;
import static battleship.Output.wrongLengthMessage;

public class Checks {

    protected static void checkLocation(boolean isHorizontal, char[][] unavailableLocation, int range, Ships ships, int l1, int l2, int c1, int c2) {
        boolean isClose = false;
        if (isHorizontal) {
            for (int j = c1; j < c2 + 1; j++) {
                if (unavailableLocation[l1][j] == 'O') {
                    isClose = true;
                }
            }
        } else {
            for (int i = l1; i < l2 + 1; i++) {
                if (unavailableLocation[i][c1] == 'O') {
                    isClose = true;
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
}
