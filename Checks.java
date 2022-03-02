package battleship;

import java.util.ArrayList;

import static battleship.Input.locationInput;
import static battleship.Main.*;
import static battleship.Write.placeShip;
import static battleship.Output.*;

public class Checks {
    public static int rightShots1 = 0;
    public static int rightShots2 = 0;
    public final static int AMOUNT_PIECES = 17;

    protected static void checkPlaceLocation(boolean isHorizontal, char[][] unavailableLocation, int range, Ships ships, int l1, int l2, int c1, int c2, int player) {
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
            locationInput(ships, player);
        } else {
            checkSize(isHorizontal, range, ships, l1, l2, c1, c2, player);
        }
    }

    protected static void checkSize(boolean isHorizontal, int range, Ships ships, int l1, int l2, int c1, int c2, int player) {
        if (range + 1 == ships.getPieces()) {
            placeShip(isHorizontal, l1, l2, c1, c2, player);
        } else {
            wrongLengthMessage(ships.getShips());
            locationInput(ships, player);
        }
    }
    protected static void checkShot(int l1, int c1, int player) {
        if (player == 1) {
            if (plain2[l1][c1] == 'O') {
                shots1[l1][c1] = 'X';
                plain2[l1][c1] = 'X';
                rightShots1++;
                analiseNextShipPiece(l1, c1, player);
            } else if (plain2[l1][c1] == '~') {
                shots1[l1][c1] = 'M';
                plain2[l1][c1] = 'M';
                missedShipMessage();
            } else if (plain2[l1][c1] == 'X') {
                hitShipMessage();
            }
        } else {
            if (plain1[l1][c1] == 'O') {
                shots2[l1][c1] = 'X';
                plain1[l1][c1] = 'X';
                rightShots2++;
                analiseNextShipPiece(l1, c1, player);
            } else if (plain1[l1][c1] == '~') {
                shots2[l1][c1] = 'M';
                plain1[l1][c1] = 'M';
                missedShipMessage();
            } else if (plain1[l1][c1] == 'X') {
                hitShipMessage();
            }

        }
        promptEnterKey();
        playerTurn = playerTurn == 1 ? 2 : 1;
    }

    private static void analiseNextShipPiece(int l1, int c1, int player) {
        ArrayList<Character> myChar = new ArrayList<>();
        if (player == 2) {
            if (l1 > 0) {
                myChar.add(plain1[l1-1][c1]);
            }
            if (l1 < 9) {
                myChar.add(plain1[l1+1][c1]);
            }
            if (c1 > 0) {
                myChar.add(plain1[l1][c1-1]);
            }
            if (c1 < 9) {
                myChar.add(plain1[l1][c1+1]);
            }

            if (AMOUNT_PIECES == rightShots2) {
                sankLastShipMessage();
            } else if (!myChar.contains('O')) {
                sankShipMessage();
            } else {
                hitShipMessage();
            }
        } else {
            if (l1 > 0) {
                myChar.add(plain2[l1-1][c1]);
            }
            if (l1 < 9) {
                myChar.add(plain2[l1+1][c1]);
            }
            if (c1 > 0) {
                myChar.add(plain2[l1][c1-1]);
            }
            if (c1 < 9) {
                myChar.add(plain2[l1][c1+1]);
            }

            if (AMOUNT_PIECES == rightShots1) {
                sankLastShipMessage();
            } else if (!myChar.contains('O')) {
                sankShipMessage();
            } else {
                hitShipMessage();
            }
        }
    }
}
