import java.util.Scanner;
class Game{

    public  static void main(String args[])
    {  
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        char charAnswer = '.';


        System.out.println("Welcome to battleship game");
        System.out.println("Choose game mode\n" + "(1) Player vs Computer,\n" + "(2) Player vs Player \n" + "(3) Computer vs Computer");
        answer = scanner.nextInt();
        if (answer == 1){

        }else if (answer == 2)
        {
            
            HumanPlayer gracz1 = new HumanPlayer();
            HumanPlayer gracz2 = new HumanPlayer();
            gracz1.chooseShipsLocation();
            gracz2.chooseShipsLocation();
            boolean active = true;
            //gracz1.playerShipMap.checkShips() && gracz2.playerShipMap.checkShips()
            while(active)
            {
                System.out.println("Player one choose coordinates");
                System.out.println("Char: ");
                charAnswer = Common.getChar();
                answer = Common.getInt();
                gracz1.attackSquare(gracz2.playerShipMap, gracz1.playerCleanMap, charAnswer, answer);
                gracz1.playerCleanMap.printMap();
                System.out.println("Cos");
                active = gracz1.playerShipMap.checkShips();
                System.out.println("cos");
                
                // if(gracz1.playerShipMap.checkShips())
                //     break;
            }

            

            
        }else if (answer == 3){

        }



    }


    
}