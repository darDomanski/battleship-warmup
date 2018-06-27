import java.util.ArrayList;

public class Ship {
    ArrayList<Square> shipSquares;
    int length;
    String arrangment;
    char vertCoordinate;
    int horCoordinate;

    public static void main(String[] args) {
        //System.out.p;
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


    public putShipInTheOcean(Ocean ocean) {

    }



}