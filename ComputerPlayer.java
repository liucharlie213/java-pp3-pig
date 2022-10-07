/**
 * This class represents a computer
 * player in the Odd-Even game
 * 
 *  
 */

public class ComputerPlayer{
    private double t;
    private int tokenBalance;
    // declare instance variables

    public ComputerPlayer(){
        t = 0.5;
        tokenBalance = 0;
        // initialize instance variables for part 1
    }
    
    public ComputerPlayer(double threshold){ 
        t=threshold;
        tokenBalance=0;
        // initialize instance variables for part 2
    }
    
    public int compDeclare(){
        double number = Math.random();
        if (number > t){
            return 2; 
        }
        else{
            return 1;
        }
        // method generates a random number to compare to the threshold
        // determines what the computer plays in each round
    }

    public void increaseTokens(int sum){
        tokenBalance += sum;
        // mutator method that increases token balance
    }

    public void decreaseTokens(int sum){
        tokenBalance -= sum;
        // mutator method that decreases token balance
    }

    public int getTokens(){
        return tokenBalance;
        // accessor method that returns the token balance
    }
    
}