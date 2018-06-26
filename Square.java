class Square
{
    boolean squareBoard, squareShip, done = false;
    char representation;


    
    Square(boolean squareType, boolean shipType)
    {
        this.squareBoard = squareType;
        this.squareShip = shipType;



    }

    public void squares()
    {
        if (this.squareBoard)
        {
            this.representation = '.';

        }else if (this.squareShip)
        {
            this.representation = 'S';
            if (this.done)
            {
                this.representation = 'X';
            }
        }
    }



}