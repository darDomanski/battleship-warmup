import java.util.*;
import java.io.*;

class Ocean
{
    Map <Integer, LinkedList<Square>> ocean;
    Ocean()
    {
        ocean = new HashMap<Integer, LinkedList<Square>>();
        makeMap();
    }


    public void makeMap()
    {
        for(int i = 0; i<10; i++)
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
        for(int i = 0; i < 10; i ++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.print(this.ocean.get(i).get(j).representation);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void attackSquare(Integer i, int j)
    {
        this.ocean.get(i).get(j).done = true;
        this.ocean.get(i).get(j).squares();
        printMap();
    }


    
    public void squareShip(Integer i, int j)
    {
        this.ocean.get(i).get(j).squareBoard = false;
        this.ocean.get(i).get(j).squareShip = true;
        this.ocean.get(i).get(j).squares();
        printMap();

    }

    
    public Square getSquare(Integer key, int value)
    {
        return this.ocean.get(key).get(value);
    }


}

