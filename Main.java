package battleship;

import java.util.Scanner;

import static battleship.Output.*;
import static battleship.Checks.*;

public class Main {

    public static char[][] plain = new char[10][10];
    public static char[][] unavailableLocation = new char[10][10];

    public static void main(String[] args) {
        fillGame();
        PrintGame.print(plain);
        startGame();
    }

    private static void startGame() {
        for (Ships ship : Ships.values()) {
            enterCoordinatesMessage(ship);
            locationInput(ship);
        }
    }

    protected static void locationInput(Ships ships) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = scanner.nextLine().replace(" ", "").split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int l1 = coordinates[0].toUpperCase().charAt(0) - 65;
        int l2 = coordinates[2].toUpperCase().charAt(0) - 65;
        int c1 = Integer.parseInt(coordinates[1]) - 1;
        int c2 = Integer.parseInt(coordinates[3]) - 1;
        int range = 0;
        if (l1 == l2) {
            range = c2 - c1;
            checkLocation(true, unavailableLocation, Math.abs(range), ships, Math.min(l1, l2), Math.max(l1, l2), Math.min(c1, c2), Math.max(c1, c2));
        } else if (c1 == c2) {
            range = l2 - l1;
            checkLocation(false, unavailableLocation, Math.abs(range), ships, Math.min(l1, l2), Math.max(l1, l2), Math.min(c1, c2), Math.max(c1, c2));
        } else {
            wrongShipLocationMessage();
            locationInput(ships);
        }

    }


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
        PrintGame.print(plain);
    }

    private static void fillGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plain[i][j] = '~';
            }
        }
    }

}
