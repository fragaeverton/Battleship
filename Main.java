package battleship;


import static battleship.Input.locationInput;
import static battleship.Input.shot;
import static battleship.Output.*;
import static battleship.PrintGame.*;
import static battleship.Write.fillGame;

public class Main {

    public static char[][] plain = new char[10][10];
    public static char[][] shots = new char[10][10];
    public static char[][] unavailableLocation = new char[10][10];

    public static void main(String[] args) {
        fillGame();
        print(true);
        startGame();
    }

    private static void startGame() {
        for (Ships ship : Ships.values()) {
            enterCoordinatesMessage(ship);
            locationInput(ship);
        }
        gameStartsMessage();
        print(true);
        takeAShotMessage();
        shot();
    }


}
