import java.util.*;

public class Tictactoe extends ConsoleProgram
{
    public void run()
    {
        System.out.println("X - User    O - Computer");
        System.out.println("\nComputer: You Can NEVER win! Puny human! \n");
        // first of all, give me a deck
        Deck playground = new Deck();
        
        System.out.println("Do you want to go first or second? (type 1 for first and arbitrary integer otherwise) ");
        Scanner a = new Scanner(System.in);
        int c = a.nextInt();
        Hand player = new Hand(true);
        Hand computer = new Hand(false);
        if (c != 1)
        {
            player.goesSecond(false);
            computer.goesSecond(true);
        }
        
        
        playground.print();
        
        while (true)
        {
            player.put(playground);
            playground.print();
            
            // System.out.println(!playground.checkForWin().equals(" "));
            // if that is " ", then there is no win, move on, don't go in to the loop
            // !playground.checkForWin().equals("TIE"), 
            // returns a "O", it is not "TIE", statement without ! becomes false
            // false with ! becomes true, thus break
            
            // !playground.checkForWin().equals(" "), 
            // returns a "O". it is not " ", statement without ! becomes false
            // false with ! becomes true, thus break
            if (!playground.checkForWin().equals(" "))
            {
                break;
            }
            
            computer.put(playground);
            playground.print();
            
            if (!playground.checkForWin().equals(" "))
            {
                break;
            }
        }
        if (playground.checkForWin().equals("TIE"))
        {
            System.out.println(playground.checkForWin());
        }
        else
        {
            System.out.println(playground.checkForWin() + " Wins!");
        }
    }
}