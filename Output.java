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
}
