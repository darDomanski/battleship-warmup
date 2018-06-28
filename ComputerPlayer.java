import java.util.Random;

public class ComputerPlayer {
    int aiLevel;
    Ocean mapToGuess;
    Ocean mapWithPlayerShips;

    public static void main(String[] args) {
        ComputerPlayer cpplayer = new ComputerPlayer(3);
        System.out.println(cpplayer.randomVerCoordinate());
        System.out.println(cpplayer.randomHorCoordinate());
        System.out.println(cpplayer.randomArrangment());
        cpplayer.placeShips();
        cpplayer.mapWithPlayerShips.printMap();

    }

    ComputerPlayer(int aiLevel) {
        this.aiLevel = aiLevel;
        this.mapToGuess = new Ocean();
        this.mapWithPlayerShips = new Ocean();
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
                    if (mapWithPlayerShips.spaceCheck(arrangment, vertCoordinate, horCoordinate, shipLenght)) {
                        if (mapWithPlayerShips.neighbourSquareCheck(arrangment, vertCoordinate, horCoordinate,
                                shipLenght)) {

                            mapWithPlayerShips.placeShip(arrangment, vertCoordinate, horCoordinate, shipLenght);
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

    public void hit() {
        char vertCoordinate = randomVerCoordinate();
        int horCoordinate = randomHorCoordinate();
        this.mapToGuess.attackSquare(vertCoordinate, horCoordinate);
        this.mapToGuess.getSquare(vertCoordinate, horCoordinate).squares();
    }

}