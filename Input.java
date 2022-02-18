package battleship;

import java.util.Scanner;

import static battleship.Checks.*;
import static battleship.Main.unavailableLocation;
import static battleship.Output.wrongCoordinatesMessage;
import static battleship.Output.wrongShipLocationMessage;

public class Input {

    protected static void locationInput(Ships ships) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = scanner.nextLine().replace(" ", "").split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int l1 = coordinates[0].toUpperCase().charAt(0) - 65;
        int l2 = coordinates[2].toUpperCase().charAt(0) - 65;
        int c1 = Integer.parseInt(coordinates[1]) - 1;
        int c2 = Integer.parseInt(coordinates[3]) - 1;
        if (l1 == l2) {
            checkLocation(true, unavailableLocation, Math.abs(c2 - c1), ships, Math.min(l1, l2), Math.max(l1, l2), Math.min(c1, c2), Math.max(c1, c2));
        } else if (c1 == c2) {
            checkLocation(false, unavailableLocation, Math.abs(l2 - l1), ships, Math.min(l1, l2), Math.max(l1, l2), Math.min(c1, c2), Math.max(c1, c2));
        } else {
            wrongShipLocationMessage();
            locationInput(ships);
        }
    }
    protected static void shot(){
        while (rightShots < AMOUNT_PIECES) {
            Scanner sc = new Scanner(System.in);
            String[] coordinates = sc.nextLine().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            int l1 = coordinates[0].toUpperCase().charAt(0) - 65;
            int c1 = Integer.parseInt(coordinates[1]) - 1;
            if (!(l1 < 0) && !(l1 > 9) && !(c1 < 0) && !(c1 > 9)) {
                checkShot(l1, c1);
            } else {
                wrongCoordinatesMessage();
                shot();
            }
        }
    }
}
