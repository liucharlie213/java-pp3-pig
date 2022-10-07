/**
 * This class represents the Odd-Even game
 * 
 * 
 */

import java.util.Scanner;

public class Game{
   
    private Scanner input;
    private ComputerPlayer compPlayer;
    // declare instance variables for part 1

    private ComputerPlayer p1;
    private ComputerPlayer p2;
    // declare instance variables for part 2

/* this version of the game constructor is for Part 1
 * it takes no parameters */
    public Game(){
        compPlayer = new ComputerPlayer();
        input = new Scanner(System.in);
        // initialize instance variables for part 1     
    }
    
/* this version of the game constructor is for Part 2
 * It requires two doubles as parameters. You will use 
 * these to set the initial thresholds for you computer players */
    public Game (double t1, double t2){
        p1 = new ComputerPlayer(t1);
        p2 = new ComputerPlayer(t2);
        // initialize instance variables for part 2
    }
    
/* this version of the play method is for Part 1
 * It takes no parameters and should play the interactive
 * version of the game */
    public void play(){
            System.out.println("Do you want to be P1 or P2? (enter 1 or 2)");
            int player = input.nextInt();
            System.out.println("You are player " + player);
            // asks the human player which player they'd like to be

            int again = 1;
            // flag used in while loop so player can play continuously

            while (again == 1){
                if (player == 1){
                    humanP1();
                    // if player chooses player 1, run humanP1() helper method
                }
                else{
                    humanP2();
                    // if player chooses player 2, run humanP2() helper method
                }

            System.out.println("You have: " + (-1)*compPlayer.getTokens());
            System.out.println("Computer has: " + compPlayer.getTokens());
            // updates the number of tokens each player has 

            System.out.println("Do you wanna play again? (1 = yes)");
            again = input.nextInt();
            // asks player if they'd like to keep playing
            }
            System.out.println("BYE!\nYou: " + (-1)*compPlayer.getTokens());   
            System.out.println("Computer: " + compPlayer.getTokens());
            // prints cumulative final scores for both players

    }

    private void humanP1(){
    // helper method that plays the game where the human is player 1
        {
            System.out.println("Choose 1 or 2");
            int humanChoice = input.nextInt();
            int compChoice = compPlayer.compDeclare();
            // take input from user for human choice 
            // call compDeclare() method to determine the computer's play

            int sum = humanChoice + compChoice;

            if (sum%2 == 0){ 
            // if the sum is even then player 2 (aka computer) wins
                compPlayer.increaseTokens(sum);
                System.out.println("You just lost " + sum + " tokens!");
            }
            else{
            // else sum is odd and player 1 (aka human) wins
                compPlayer.decreaseTokens(sum);
                System.out.println("You just won " + sum + " tokens!");
            }
        }
    }

    private void humanP2(){
    // helper method that plays the game where the human is player 2
        {
            System.out.println("Choose 1 or 2");
            int humanChoice = input.nextInt();
            int compChoice = compPlayer.compDeclare();
            // take input from user for human choice 
            // call compDeclare() method to determine the computer's play
            
            int sum = humanChoice + compChoice;

            if (sum%2 == 0){ 
            // if the sum is even then player 2 (aka human) wins
                compPlayer.decreaseTokens(sum);
                System.out.println("You just won " + sum + " tokens!");
            }
            else{
            // else sum is odd and player 1 (aka computer) wins
                compPlayer.increaseTokens(sum);
                System.out.println("You just lost " + sum + " tokens!");
            }
        }
    }
    
/** this version of the play method is for Part 2
 * It takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played */
    public void play(int games){
        for (int i = 0; i < games; i++){
        // for loop that runs one round of the game, games, number of times
            int p1Choice = p1.compDeclare();
            int p2Choice = p2.compDeclare();
            // call compDeclare() method to determine both computers' plays

            int sum = p1Choice + p2Choice;

            if (sum%2 == 0){ 
            // sum is even so player 2 wins
                p1.decreaseTokens(sum);
                p2.increaseTokens(sum);
            }
            else{ 
            // else sum is odd so player 1 wins
                p1.increaseTokens(sum);
                p2.decreaseTokens(sum);
            }
        }
    }

/* this method should return the current score (number of tokens)
 * that player 1 has */
    public int getP1Score(){
    // accessor method that returns the number of tokens player 1 has
        return p1.getTokens();
    }
    
/* this method should return the current score (number of tokens)
 * that player 2 has */
    public int getP2Score(){
    // accessor method that returns the number of tokens player 2 has
        return p2.getTokens();  
    }  
}