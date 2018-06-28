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

            if(this.done)
            {
                this.representation = 'O';
            }

        }else if (this.squareShip)
        {
            this.representation = 'S';
            if (this.done)
            {
                this.representation = 'X';

            }
        }
    }
    public void squares(Ocean enemyEmptyMap, char key, int value, boolean computer)
    {
        if (this.squareBoard)
        {
            this.representation = '.';

            if(this.done)
            {
                this.representation = 'O';
                enemyEmptyMap.getSquare(key, value).representation = 'O';

            }

        }else if (this.squareShip)
        {
            this.representation = 'S';
            if (this.done)
            {
                this.representation = 'X';
                enemyEmptyMap.getSquare(key, value).representation = 'X';

            }
        }
    }



}