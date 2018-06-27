import java.util.ArrayList;

public class Ship {
    ArrayList<Square> shipSquares;
    String name;
    int length;
    String arrangment;
    char vertCoordinate;
    int horCoordinate;

    public Ship(String name, int length) {
        this.shipSquares = new  ArrayList<Square>();
        this.length = length;
        //this.arrangment = arrangment;
        this.name = name;
    }
    

}