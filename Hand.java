import java.util.*;

public class Hand
{
    private boolean goesFirst;
    public static int turns = 0;
    
    public Hand(boolean goesFirst)
    {
        this.goesFirst = goesFirst;
    }
    
    // setter
    public void goesSecond(boolean what)
    {
        goesFirst = what;
    }
    
    public String checkWin(String[][] playground)
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

    private int minimax(String[][] Playground, boolean isMaximizing)
    {
        String result = checkWin(Playground);
        int score;
        if (!result.equals(" "))
        {
            if (result.equals("O"))
            {
                return 1;
            }
            else if (result.equals("X"))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        
        if (isMaximizing)
        {
            int bestScore = - 2;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (Playground[i][j].equals(" ")) 
                    {
                      Playground[i][j] = "O";
                      score = minimax(Playground, false);
                      Playground[i][j] = " ";
                      if (score > bestScore)
                      {
                            bestScore = score;
                      }
                    }
                }
            }
            return bestScore;
        }
        else
        {
            int bestScore = 2;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (Playground[i][j].equals(" ")) 
                    {
                      Playground[i][j] = "X";
                      score = minimax(Playground, true);
                      Playground[i][j] = " ";
                      if (score < bestScore)
                      {
                            bestScore = score;
                      }
                    }
                }
            }
            return bestScore;
        }
    }
    
    public void put(Deck playgroundf)
    {
        String[][] Playground = playgroundf.returnArray();
        if (goesFirst)
        {
            System.out.println("Please indicate where you want to put your X");
            while (true)
            {
                Scanner a = new Scanner(System.in);
                System.out.print("row(0,1,2): ");
                int row = a.nextInt();
                while (row != 0 && row != 1 && row != 2) {
                    System.out.println("That is not a valid address, try again");
                    System.out.print("row(0,1,2): ");
                    row = a.nextInt();
                }
                System.out.print("column(A,B,C): ");
                char colc = a.next().charAt(0);
                int col;
                if (colc == 'A')
                {
                    col = 0;
                }
                else if (colc == 'B')
                {
                    col = 1;
                }
                else if (colc == 'F')
                {
                    System.out.println("accessing the father portal...");
                    System.out.println("Hello, Ryan, you created me, you are my beloved father");
                    System.out.println("Thank you so much. I will always lose to you, my father");
                    for (int i = 0; i < 3; i++)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            Playground[i][j] = "X";
                        }
                    }
                    
                    break;
                }
                else
                {
                    System.out.println("That is not a valid address. By Default you put in Column C");
                    col = 2;
                }
                
                if (Playground[row][col].equals(" "))
                {
                    Playground[row][col] = "X";
                    break;
                }
                else
                {
                    System.out.println("Invalid address. Please obey the law you naughty user.");
                }
            }
        }
        
        else
        {
            // if (turns == 1)
            // {
            //     if (Playground[2][2].equals(" "))
            //     {
            //         Playground[2][2] = "O";
            //     }
            // }
            // else
            // {
                // minimax algorithm
                // idea from https://www.youtube.com/watch?v=trKjYdBASyQ, implemented in JS
                System.out.println("\nComputer Putting...");
                int bestScore = -214748;
                int[] bestMove = new int[2];
                int score;
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (Playground[i][j].equals(" "))
                        {
                            // System.out.println(bestMove[0]);
                            // System.out.println(bestMove[1]);
                            // compute best score and best move
                            Playground[i][j] = "O";
                            score = minimax(Playground, false);
                            // System.out.println("Returns " + score);
                            // System.out.println("Now " + bestScore);
                            Playground[i][j] = " ";
                            if (score > bestScore)
                            {
                                // System.out.println("Replace " + score);
                                bestScore = score;
                                bestMove[0] = i;
                                bestMove[1] = j;
                            }
                        }
                    }
                }
                // System.out.println("c" +bestMove[0]);
                // System.out.println("d" +bestMove[1]);
                Playground[bestMove[0]][bestMove[1]] = "O";
            // }
        }
        // turns++;
    }
}