import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Ocean
{
    Map <Character, LinkedList<Square>> ocean;
    ArrayList<Ship> ships;

    Ocean()
    {
        ocean = new HashMap<Character, LinkedList<Square>>();
        ships = new ArrayList<Ship>();
        makeMap();
        addShips();
    }


    public void makeMap()
    {
        for(char i = 'a'; i< 'k'; i++)
        { 
            this.ocean.put(i, new LinkedList<Square>());

            for(int j = 0; j < 10; j++)
            {
                this.ocean.get(i).add(new Square(true, false));
                this.ocean.get(i).get(j).squares();


            }
        }
    }

    public void addShips() {
        String[] shipsNames = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        int[] lengthsOfShips = {5, 4, 3, 3, 2};
        for (int i = 0; i < shipsNames.length; i++) {
            this.ships.add(new Ship(shipsNames[i], lengthsOfShips[i]));
        }
    }

    public void assignSquaresToShip(char vertCoordinate, int horCoordinate, int length) {
        this.ships.get(checkShipIndex(length)).shipSquares.add(getSquare(vertCoordinate, horCoordinate));
    }

    public int checkShipIndex(int length) {
        int shipIndex = -1;
        switch (length) {
            case 5:
            shipIndex = 0;
            break;
            case 4:
            shipIndex = 1;
            case 3:
            if (ships.get(2).shipSquares.isEmpty()) shipIndex = 2;
            else shipIndex = 3;
            break;
            case 2:
            shipIndex = 4;
            break;
            default:
            System.out.println("Ships length must be from 5 to 2!");
        }
        return shipIndex;
    }


    public void printMap()
    {
        for(char i = 'a'; i < 'k'; i ++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.print(this.ocean.get(i).get(j).representation);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void attackSquare(char i, int j)
    {
        this.ocean.get(i).get(j).done = true;
        this.ocean.get(i).get(j).squares();
        printMap();
    }


    
    public void squareShip(char i, int j)
    {
        this.ocean.get(i).get(j).squareBoard = false;
        this.ocean.get(i).get(j).squareShip = true;
        this.ocean.get(i).get(j).squares();
        printMap();

    }

    
    public Square getSquare(char key, int value)
    {
        return this.ocean.get(key).get(value);
    }

    public void placeShip(String arrangment, char vertCoordinate, int horCoordinate, int length) {
        horCoordinate -= 1;
        if (spaceCheck(arrangment, vertCoordinate, horCoordinate, length)) {
            if (neighbourSquareCheck(arrangment, vertCoordinate, horCoordinate, length)) {
                for (int i = 0; i < length; i++) {
                    if (arrangment.equals("horizontal")) {
                        squareShip(vertCoordinate, horCoordinate + i);
                        assignSquaresToShip(vertCoordinate, horCoordinate + i, length);
                    } else if (arrangment.equals("vertical")) {
                        squareShip((char)(vertCoordinate + i), horCoordinate);
                        assignSquaresToShip((char)(vertCoordinate + i), horCoordinate, length);
                    }
                }
            }
        }
    }

    public boolean spaceCheck(String arrangment, char vertCoordinate, int horCoordinate, int length) {
        Square sqr = getSquare(vertCoordinate, horCoordinate);
        boolean enoughSpace = false;
        if (arrangment.equals("horizontal")) {
            if (this.ocean.get(vertCoordinate).indexOf(sqr) + length < this.ocean.get(vertCoordinate).size() - 1 && this.ocean.get(vertCoordinate).indexOf(sqr) > 0 ) {
                enoughSpace = true;
            } else {
                enoughSpace = false;
            }
        } else if (arrangment.equals("vertical")) {
            if (vertCoordinate + (length - 1) < 'j' && vertCoordinate != 'a') {
                enoughSpace = true;
            } else {
                enoughSpace = false;
            }
        }
        return enoughSpace;
    }

    public boolean neighbourSquareCheck(String arrangment, char vertCoordinate, int horCoordinate, int length) {
        boolean neighbourSquaresEmpty = false;
        if (arrangment.equals("horizontal")) {
            for (int i = 0; i < length; i++) {
                if (getSquare((char)(vertCoordinate + 1), horCoordinate + i).squareShip || getSquare((char)(vertCoordinate - 1), horCoordinate + i).squareShip) {
                    neighbourSquaresEmpty = false;
                    break;
                } else {
                    neighbourSquaresEmpty = true;
                }
            }
            if (getSquare(vertCoordinate, horCoordinate - 1).squareShip || getSquare(vertCoordinate, horCoordinate + length).squareShip ) {
                neighbourSquaresEmpty = false;
            }
        } else if (arrangment.equals("vertical")) {
            for (int i = 0; i < length; i++) {
                if (getSquare((char)(vertCoordinate + i), horCoordinate - 1).squareShip || getSquare((char)(vertCoordinate + i), horCoordinate + 1).squareShip) {
                    neighbourSquaresEmpty = false;
                    break;
                } else {
                    neighbourSquaresEmpty = true;
                }
            }
            if (getSquare((char)(vertCoordinate -1), horCoordinate).squareShip || getSquare((char)(vertCoordinate + length), horCoordinate).squareShip) {
                neighbourSquaresEmpty = false;
            }
        }
        return neighbourSquaresEmpty;
    }
    
    

}

