import java.util.*;

public class Deck
{
    private String[][] playground = new String[3][3];
    
    public Deck()
    {
        // give me an array of spaces
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                playground[i][j] = " ";
            }
        }
    }
    
    public void print()
    {
        System.out.println();
        System.out.println("     A    B    C");
        System.out.println();
        for (int i = 0; i < 3; i++)
        {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(playground[i][j]);
                if (j < 2)
                {
                    System.out.print("   | ");
                }
                
            }
            System.out.println();
            if (i != 2)
            {
                System.out.println("    —————————————");
            }
        }
        System.out.println();
    }
    
    public String checkForWin()
    {
        String[] two = {"O", "X"};
        
        for (int i = 0; i < 2; i++)
        {
            // row
            for (int j = 0; j < 3; j++)
            {
                if (playground[j][0].equals(two[i]) && playground[j][1].equals(two[i]) && playground[j][2].equals(two[i]))
                {
                    return two[i];
                }
            }
            
            // column
            for (int k = 0; k < 3; k++)
            {
                if (playground[0][k].equals(two[i]) && playground[1][k].equals(two[i]) && playground[2][k].equals(two[i]))
                {
                    return two[i];
                }
            }
            
            // side
            if (playground[0][0].equals(two[i]) && playground[1][1].equals(two[i]) && playground[2][2].equals(two[i]))
            {
                return two[i];
            }
            if (playground[0][2].equals(two[i]) && playground[1][1].equals(two[i]) && playground[2][0].equals(two[i]))
            {
                return two[i];
            }
        }
        boolean isFull = true;
        for (int b = 0; b < 3; b++)
        {
            for (int c = 0; c < 3; c++)
            {
                if (playground[b][c].equals(" "))
                {
                    isFull = false;
                }
            }
        }
        if (isFull)
        {
            return "TIE";
        }
        else
        {
            return " ";
        }
    }
    
    public String[][] returnArray()
    {
        return playground;
    }
}