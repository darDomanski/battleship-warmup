class Game{
    public static void main(String args[])
    {
        Ocean gra = new Ocean();
        gra.squareShip('e', 3);
        gra.squareShip('e', 4);
        gra.squareShip('e', 5);
        //gra.attackSquare('d', 5);
        //System.out.println(gra.neighbourSquareCheck("vertical", 'b', 1, 3));

        gra.placeShip("vertical", 'b', 3, 2);
        System.out.println(gra.ships.get(4).shipSquares);

        gra.squareShip('b', 1); //gra.getSquare('b', 0)
        gra.printMap();
        
    

    }
}