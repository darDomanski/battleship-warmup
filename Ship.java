import java.util.ArrayList;

public class Ship {
    ArrayList<Square> shipSquares;
    int length;
    String arrangment;
    char vertCoordinate;
    int horCoordinate;

    public static void main(String[] args) {
        System.out.p;
    }
    

    public Ship(int length, String arrangment, ArrayList<Square> squaresOfShip) {
        this.shipSquares = squaresOfShip;
        this.length = length;
        this.arrangment = arrangment;
    }
    
    public Ship createShip(String arrangment, char vertCoordinate, int horCoordinate, int length) {
        if (checkCoordinates(ocean, arrangment, vertCoordinate, horCoordinate, length)) {
            Ship ship = new Ship(length, arrangment);
            
            for (Square sqr: ship.shipSquares) {
                ocean.
            }
        }
    } 



    public boolean checkCoordinates(Ocean ocean, String arrangment, char vertCoordinate, int horCoordinate, int length) {
        Square sqr = ocean.getSquare(vertCoordinate, horCoordinate);
        boolean coordinatesOK = false;
        if (arrangment.equals("horizontal")) {
            if (ocean.ocean.get(vertCoordinate).indexOf(sqr) + length < ocean.ocean.get(vertCoordinate).size()) {
                coordinatesOK = true;
            } else {
                coordinatesOK = false;
            }
        } else if (arrangment.equals("vertical")) {
            if (vertCoordinate + length < 'k') {
                coordinatesOK = true;
            } else {
                coordinatesOK = false;
            }
        }
        return coordinatesOK;
    }

    public putShipInTheOcean(Ocean ocean) {

    }



}