import java.util.Scanner;

class Game {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        char charAnswer = '.';

        System.out.println("Welcome to battleship game");
        System.out.println("Choose game mode\n" + "(1) Player vs Computer,\n" + "(2) Player vs Player \n"
                + "(3) Computer vs Computer");
        answer = scanner.nextInt();
        if (answer == 1) {

        } else if (answer == 2) {

            HumanPlayer gracz1 = new HumanPlayer();
            HumanPlayer gracz2 = new HumanPlayer();
            gracz1.chooseShipsLocation();
            gracz2.chooseShipsLocation();
            boolean active = true;
            boolean test = true;
            // gracz1.playerShipMap.checkShips() && gracz2.playerShipMap.checkShips()
            while (active) {
                while (test) {

                    player(gracz1, gracz2, charAnswer, test, active, answer);
                    player(gracz2, gracz1, charAnswer, test, active, answer);

                }

            }
        } else if (answer == 3) {
            ComputerPlayer cp1 = new ComputerPlayer(1);
            ComputerPlayer cp2 = new ComputerPlayer(2);
            cp1.placeShips();
            cp2.placeShips();
            boolean active = true;
            boolean test = true;
            while (active) {
                
                    computerPlayer(cp1, cp2, test, active);
                    if (!active == cp1.mapWithPlayerShips.checkShips())
                        break;
                    computerPlayer(cp2, cp1, test, active);
                    if (!active == cp1.mapWithPlayerShips.checkShips())
                        break;
                
            }

        }

    }

    private static void player(HumanPlayer gracz1, HumanPlayer gracz2, char charAnswer, boolean test, boolean active,
            int answer) {
        System.out.print("\033[H\033[2J");

        System.out.println("Your hits!");
        gracz1.playerCleanMap.printMap();
        System.out.println("\nYour map!");
        gracz1.playerShipMap.printMap();
        System.out.println("\nEnemy map(tests)");
        gracz2.playerShipMap.printMap();
        System.out.println("Player one choose coordinates");
        System.out.println("Char: ");
        // charAnswer = Common.getChar();
        System.out.println("Integer: ");
        answer = Common.getInt();

        try {
            gracz1.attackSquare(gracz2.playerShipMap, gracz1.playerCleanMap, charAnswer, answer);
            test = false;
        } catch (NullPointerException e) {
            System.out.println("You selected wrong coordinates!");
        }

        test = true;
        gracz1.playerCleanMap.printMap();
        active = gracz1.playerShipMap.checkShips();
        System.out.println("Enter button (int) to continue");
        answer = Common.getInt();
        System.out.print("\033[H\033[2J");
    }

    private static void computerPlayer(ComputerPlayer gracz1, ComputerPlayer gracz2, boolean test, boolean active) {
        System.out.print("\033[H\033[2J");

        System.out.println("Computer 1 hits!");
        gracz1.mapToGuess.printMap();
        System.out.println("\nComputer1 map!");
        gracz1.mapWithPlayerShips.printMap();
        System.out.println("\nEnemy map(tests)");
        gracz2.mapWithPlayerShips.printMap();
        System.out.println("Player1 one choose coordinates");
        System.out.println("Char: ");
        char charAnswer = ComputerPlayer.randomVerCoordinate();
        System.out.println("Integer: ");
        int answer = ComputerPlayer.randomHorCoordinate();

        try {
            // gracz1.attackSquare(gracz2.mapWithPlayerShips, gracz1.mapToGuess, charAnswer,
            // answer);
            // gracz2.attackSquare(enemy, emptyMap, answer, answer2);
            // gracz1.attackSquare(gracz2.mapWithPlayerShips, gracz1.mapToGuess, charAnswer,
            // answer);
            // gracz2.mapWithPlayerShips.getSquare(charAnswer, answer).done = true;
            // gracz1.mapToGuess.getSquare(charAnswer, answer).done = true;

            gracz1.attackSquare(gracz2.mapWithPlayerShips, gracz1.mapToGuess, charAnswer, answer);

            test = false;
        } catch (NullPointerException e) {
            System.out.println("You selected wrong coordinates!");
        }

        test = true;
        gracz1.mapToGuess.printMap();
        active = gracz1.mapWithPlayerShips.checkShips();
        System.out.println("Enter button to continue");
        Common.getInput();
        System.out.print("\033[H\033[2J");
    }

}