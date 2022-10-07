/**
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that adavantage.
 * 
 * 
 */

public class Simulation{
    
    public static void main(String[] args){

        final int GAMES = 100000; 
        // make the number of games played a constant

        double maxMin = GAMES*(-4);
        // maxMin represents the best possible worst case
        // initialized to the max no. of tokens player 1 can lose

        double bestT = -1.0;
        // represents the best threshold, aka the strategy
        // set to -1 for debugging purposes
        
        System.out.print("pending");
        // fun progress bar set up!

        for (double i = 0.0 ; i <= 1.0; i += 0.02){
        // outer for loop that iterates through player 1's threshold
        
            double min = GAMES*4;
            // min represents the worst possible outcome for player 1
            // initialized to the negative of the max no. of tokens 
            // player 1 can take 

            for(double j = 0.0; j <= 1.0; j+= 0.02){  
            // nested for loop that iterates through player 2's threshold

                Game g = new Game (i, j); 
                //i is threshold for player 1, j is threshold for player 2 

                g.play(GAMES);
                // run the game at thresholds p1 = i, p2 = j 
                // for GAMES number of times

                int p1Score = g.getP1Score();

                if (p1Score < min){
                    min = p1Score;
                    // if p1 score is ever smaller than the curent local min
                    // the minimum is overwritten
                }
            }
            System.out.print(".");
            // a progress bar, indicates an iteration of the outer for-loop
            // fun to watch run!

            if (min > maxMin){
                maxMin = min;
                // if the local min is greater than the current max minimum
                // the maximum minimum is overwritten 

                bestT = i; 
                // the best threshold for player 1 is the one where the 
                // losses are minimized --> aka the threshold where the 
                // maximum minimum is the result for player 1
            }
        }
        System.out.println();
        System.out.println("Best threshold for player 1: " + bestT);
        System.out.println("Average no. of tokens expected if player 1 plays"+
                           " its best threshold: " + maxMin/(double)GAMES);
        // if the average is positive, then player 1 has an advantage
    }
}
