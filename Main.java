package battleship;


import java.io.IOException;

import static battleship.Input.locationInput;
import static battleship.Input.startGame;
import static battleship.Output.*;
import static battleship.PrintGame.*;
import static battleship.Write.fillGame;

public class Main {

    public static char[][] plain1 = new char[10][10];
    public static char[][] shots1 = new char[10][10];
    public static char[][] unavailableLocation1 = new char[10][10];
    public static char[][] plain2 = new char[10][10];
    public static char[][] shots2 = new char[10][10];
    public static char[][] unavailableLocation2 = new char[10][10];
    public static int[] players = {1, 2};
    public static int playerTurn = 1;

    public static void main(String[] args) {
        fillGame();
        for (int i : players) {
            playerPlaceShipMessage(i);
            print(false, i);
            placeShips(i);
        }
        startGame();
    }

    private static void placeShips(int player) {
        for (Ships ship : Ships.values()) {
            enterCoordinatesMessage(ship);
            locationInput(ship, player);
        }
        promptEnterKey();
    }
    public static void promptEnterKey() {
        swapPlayerMessage();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
