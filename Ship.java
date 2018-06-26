public class Ship {
    Square[] ship;
    int length;
    String arrangment;
    char vertCoordinate;
    int horCoordinate;
    

    public Ship(int length, String arrangment) {
        this.ship = new Square[length];
        this.length = length;
        this.arrangment = arrangment;
    }
    
    public createShip(String arrangment, char vertCoordinate, int horCoordinate, int length) {
        if (checkCoordinates(ocean, arrangment, vertCoordinate, horCoordinate, length)) {
            
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