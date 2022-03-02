package battleship;

import java.util.Scanner;

import static battleship.Checks.*;
import static battleship.Main.*;
import static battleship.Output.*;
import static battleship.PrintGame.print;

public class Input {

    protected static void locationInput(Ships ships, int player) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = scanner.nextLine().replace(" ", "").split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int l1 = coordinates[0].toUpperCase().charAt(0) - 65;
        int l2 = coordinates[2].toUpperCase().charAt(0) - 65;
        int c1 = Integer.parseInt(coordinates[1]) - 1;
        int c2 = Integer.parseInt(coordinates[3]) - 1;
        if (l1 == l2) {
            checkPlaceLocation(true, player == 1 ? unavailableLocation1 : unavailableLocation2, Math.abs(c2 - c1), ships, Math.min(l1, l2), Math.max(l1, l2), Math.min(c1, c2), Math.max(c1, c2), player);
        } else if (c1 == c2) {
            checkPlaceLocation(false, player == 1 ? unavailableLocation1 : unavailableLocation2, Math.abs(l2 - l1), ships, Math.min(l1, l2), Math.max(l1, l2), Math.min(c1, c2), Math.max(c1, c2), player);
        } else {
            wrongShipLocationMessage();
            locationInput(ships, player);
        }
    }
    protected static void startGame(){
        while (!(rightShots1 == AMOUNT_PIECES) || !(rightShots2 == AMOUNT_PIECES)) {
            print(true, playerTurn);
            playerTurnMessage(playerTurn);
            moves();
        }
    }

    private static void moves() {
        Scanner sc = new Scanner(System.in);
        String[] coordinates = sc.nextLine().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int l1 = coordinates[0].toUpperCase().charAt(0) - 65;
        int c1 = Integer.parseInt(coordinates[1]) - 1;
        if (!(l1 < 0) && !(l1 > 9) && !(c1 < 0) && !(c1 > 9)) {
            checkShot(l1, c1, playerTurn);
        } else {
            wrongCoordinatesMessage();
            moves();
        }
    }
}
