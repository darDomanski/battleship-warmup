import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class HumanPlayer {
    Ocean playerShipMap;
    Ocean playerCleanMap;
    ArrayList<String> ships;
    int answer;
    char charAnswer;
    String stringAnswer;
    boolean choose;
    Scanner scanner = new Scanner(System.in);

    HumanPlayer() {
        playerShipMap = new Ocean();
        playerCleanMap = new Ocean();
        ships = new ArrayList<String>();
        answer = 0;
        charAnswer = 'c';
        stringAnswer = "";
        choose = false;
        ships.add("Destroyer");
        ships.add("Submarine");
        ships.add("Cruiser");
        ships.add("Battleship");
        ships.add("Carrier");
    }

    public void chooseShipsLocation() {
        System.out.println("Place ships automaticly? Y/N");

        String automatic = Common.getInput();
        if (automatic.equals("Y")) {
            placeShips();
        } else {

            System.out.println("It's time for first player to choose location of ships!");
            this.playerCleanMap.printMap();
            for (int i = 5; i > 0; i--) {
                this.choose = false;
                while (!choose) {
                    System.out.println("Choose location of " + ships.get(i - 1));
                    System.out.println("1-10");
                    this.answer = scanner.nextInt();
                    System.out.println("a - j");
                    this.charAnswer = scanner.next().charAt(0);
                    System.out.println("horizontal or vertical?");
                    this.scanner.nextLine();
                    this.stringAnswer = scanner.nextLine();
                    if (i == 2) {
    
                        this.playerShipMap.placeShip(stringAnswer, charAnswer, answer, 3);
                        this.playerShipMap.printMap();
                    } else if (i == 1) {
                        this.playerShipMap.placeShip(stringAnswer, charAnswer, answer, 2);
                        this.playerShipMap.printMap();
                    } else {
                        this.playerShipMap.placeShip(stringAnswer, charAnswer, answer, i);
                        this.playerShipMap.printMap();
                    }
                    if (playerShipMap.getSquare(charAnswer, answer).squareShip) {
                        this.choose = true;
                    } else {
                        System.out.println("You have to choose other location!");
                    }
                }
    
            }
        }



    }

    public void attackSquare(Ocean enemy, Ocean emptyMap, char answer, int answer2)
    {
        enemy.getSquare(answer, answer2).done = true;
        enemy.getSquare(answer, answer2).squares(emptyMap, answer, answer2, true); //emptyMap, answer, answer2, true


    }

    public void placeShips() {
        int[] shipsLenghts = { 5, 4, 3, 3, 2 };
        boolean coordinatesCorrect = false;
        for (int shipLenght : shipsLenghts) {
            coordinatesCorrect = false;

            while (!coordinatesCorrect) {
                try {
                    char vertCoordinate = randomVerCoordinate();
                    int horCoordinate = randomHorCoordinate();
                    String arrangment = randomArrangment();
                    if (playerShipMap.spaceCheck(arrangment, vertCoordinate, horCoordinate, shipLenght)) {
                        if (playerShipMap.neighbourSquareCheck(arrangment, vertCoordinate, horCoordinate,
                                shipLenght)) {

                            playerShipMap.placeShip(arrangment, vertCoordinate, horCoordinate, shipLenght);
                            coordinatesCorrect = true;
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    coordinatesCorrect = false;
                }
            }
        }
    }

    public char randomVerCoordinate() {
        String verCoordinates = "bcdefghi";
        Random rd = new Random();
        return verCoordinates.charAt(rd.nextInt(verCoordinates.length()));
    }

    public int randomHorCoordinate() {
        Random rd = new Random();
        int[] coordinates = { 2, 3, 4, 5, 6, 7, 8, 9 };
        return coordinates[rd.nextInt(coordinates.length)];
    }

    public String randomArrangment() {
        String[] arrangments = { "vertical", "horizontal" };
        Random rd = new Random();
        return arrangments[rd.nextInt(2)];
    }


}