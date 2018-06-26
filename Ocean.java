import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Ocean
{
    Map <Character, LinkedList<Square>> ocean;
    Ocean()
    {
        ocean = new HashMap<Character, LinkedList<Square>>();
        makeMap();
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


}

