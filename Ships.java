package battleship;

public enum Ships {
    AIRCRAFT_CARRIER("Aircraft Carrier", 5), 
    BATTLESHIP("Battleship", 4), 
    SUBMARINE("Submarine", 3), 
    CRUISER("Cruiser", 3), 
    DESTROYER("Destroyer", 2);

    String ships;
    int pieces;

    Ships(String ships, int pieces) {
        this.ships = ships;
        this.pieces = pieces;
    }

    public String getShips() {
        return ships;
    }

    public int getPieces() {
        return pieces;
    }
}
