package battleship;

public class Output {
    protected static void enterCoordinatesMessage(Ships ship) {
        StringBuilder sb = new StringBuilder("\nEnter the coordinates of the ");
        switch (ship) {
            case AIRCRAFT_CARRIER:
                sb.append("Aircraft Carrier (5 cells):");
                break;
            case BATTLESHIP:
                sb.append("Battleship (4 cells):");
                break;
            case SUBMARINE:
                sb.append("Submarine (3 cells):");
                break;
            case CRUISER:
                sb.append("Cruiser (3 cells):");
                break;
            case DESTROYER:
                sb.append("Destroyer (2 cells):");
                break;
        }
        System.out.println(sb + "\n");
    }
    protected static void tooCloseMessage() {
        System.out.println("\nError! You placed it too close to another one. Try again:\n");
    }
    protected static void wrongLengthMessage(String ship) {
        System.out.printf("\nError! Wrong length of the %s! Try again:\n\n", ship);
    }
    protected static void wrongShipLocationMessage() {
        System.out.println("\nError! Wrong ship location! Try again:\n");
    }
    protected static void gameStartsMessage() {
        System.out.println("\nThe game starts!");
    }
    protected static void takeAShotMessage() {
        System.out.println("\nTake a shot!\n");
    }
    protected static void wrongCoordinatesMessage() {
        System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
    }
    protected static void hitShipMessage() {
        System.out.println("\nYou hit a ship!\n");
    }
    protected static void missedShipMessage() {
        System.out.println("\nYou missed!\n");
    }
}
