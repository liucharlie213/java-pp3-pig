Name: Charlie Liu
UNI: CRL2157

Discussed project with:
- William groger
- Anna reis
- Noa Seigel
- multiple TAs

Part 1 (Human vs Computer game):

1) ComputerPlayer Class

For this problem, I started with the ComputerPlayer class 
where each object of the class represents a computer player 
and has the characteristics (aka instance variables) of a 
threshold (t) and a token balance (token balance). 

The threshold instance variables is initialized to 0.5 so that 
the computer declares either 1 or 2 a balanced amount of time. 
The token balance instance variable is initialized to 0 to start
the game. From this, I assume that the human player will also
start at 0, meaning at any point the amount of tokens either 
player has is the opposite (+/-) of the other

The compDeclare() method generates a random number to compare 
to the threshold (0.5). This method determines what the computer 
player plays (aka whether it plays 1 or 2) in each round 

The increaseTokens() and decreaseTokens() methods change the
amount of tokens the computer player has. The getTokens() method 
returns the number of tokens that the computer player has at any time

2) Game Class

From here, I was able to move to the Game class. For this class,
I know that I need to ask for the input from the human player
so I declare a Scanner variable and I also declare the compPlayer
object of the ComputerPlayer class which will act as the computer 
player during the game

For the play() method I take input from the user on which player 
they would like to play. I also declare and initialize a variable
to act as a flag, in order to run the game as many times as the 
user wants to play. Depending on if the user chooses to be player 1 
or player 2, helper methods humanP1() or humanP2() are called, respectively

The helper method humanP1() plays one round of the game where the
human is player 1, by asking the user for their choice (1 or 2), 
then calling the compDeclare() method on the compPlayer object to 
determine the computer's choice. Then, the sum of their choices is 
taken. If the sum is even, then the human loses, the computer wins, 
and the increaseTokens() method is called to increase the number of 
tokens that the computer has. Otherwise, the sum is odd and the human 
wins, the computer loses, and the increaseTokens() method is called to
decrease the number of tokens the computer has

The helper method humanP2() plays one round of the game where the human
is player 2, by asking the user for their choice, then calling the 
compDeclare() method on the compPlayer object to determine the computer's 
choice. Then, the sum of their choices is taken. If the sum is even, then
the human wins, the computer loses, and the decreaseTokens() method is called
to decrease the number of tokens the computer has. Otherwise, the sum is odd
and the human loses, the computer wins, and the increaseTokens() method is 
called to increase the number of tokens the computer has

Finally, thorugh the flag, the user can play as many round as they want,
and when they no longer want to play the game terminates and the final
cumulative scores of each player is printed.

All throughout, there is no need to keep track of the human players tokens
because by the nature of the game as well as the setting up of both players
to 0 initial tokens, the token balance of the players is oppposite of each 
other (+/-). Thus, when the token balance of the computer is kept track of,
the token balance of the human player is also kept track of

I tried to make the names of variables, objects, instance variables, and 
methods as relevant to what they represent as possible. For example, 
compPlayer is an object of the ComputerPlayer class tht represents the
computer player in the game

I decided to create helper methods humanP1() and humanP2() in order to 
prevent the play() method from becoming extremely long, and maintain 
good design features 


Part 2 (Computer vs Computer Simulation)

1) ComputerPlayer Class

For this problem, I also started with the ComputerPlayer Class through
overloading.

The constructor for part 2 was already written, but it initializes
the attributes of the threshold and tokenBalance similarly to part 1. 
All the other methods used in Part 1 from the ComputerPlayer Class 
stay the same and are reused in Part 2

2) Game Class

From there, I moved on to the Game class where overloading was also 
used. Again, the overloaded constructor Game(double t1, double t2) was 
already written, but it initializes two objects of the ComputerPlayer class 
that represent the two computer players that will pay each other in 
the simulation 

The Game class is also overloaded it with another method named play, 
aka play(int games). This play(int games) method runs one round of the
game, games (the parameter), number of times using a for loop. Within 
the for loop, one round of the game is played between two computer players.
compDeclare() method is called on both p1 and p2 to determine the play for 
both computers. Just like in part 1, if the sum of their plays is even, 
player 2 wins and the methods increaseTokens() and decreaseTokens() are called
to change the number of tokens each player has. Otherwise, their sum is odd
and player 1 wins, and likewise increaseTokens() and decreaseTokens() are called.

Finally, there are two accessor methods getP1Score() and getP2Score() that each
return the number of tokens for player 1 and player 2 respectively

3) Simulation Class 

From there the I moved onto the Simulation Class which draws upon the 
ComputerPlayer and Game classes. First, the number of simulations is 
set to a constant so I don't have to remember the exact number for the rest 
of the code. 

In the nested for loop, the inner for loop iterates through entirely for 
every one iteration of the outer for loop. This means for each threshold 
value of player 1, every threshold value from 0.0 to 1.0 for player 2 is run.
As the nested for loops run, there is a variable (min) that keeps track of the 
lowest outcome for player 1 in the inner for loop, and if that lowest outcome 
is larger than the current, global maximum minimum, then the variable that 
keeps track of the global maximum miminim (maxMin) is reassigned to that new
maximum minimum. Also, everytime the maxMin value is updated, the threshold that
player 1 played in that game is stored in variable bestT. This continues until 
the nested for loop finished all 2500 of its iterations, and the threshold 
that player 1 uses which matches up to the final maximum minimum value turns out
to be the best strategy for player 1 to play, since that maximum minimum value 
is positive. This best threshold value is thus the strategy that player 1 has, 
where if it plays with this threshold player 2 will never win in the long run

Thus, this game is inherently unfair because player 1 has a strategy
that it can play where player 2 can never win in the long run.

I also print the average number of tokens that player 1 is expected to win
in the long run if it plays its optimal threshold strategy. The fact that
it is positive in the long run shows that this game is inherently unfair

Similar to part 1, I made the names of my variables and methods as related 
to what they represent as possible. For example, the variable bestT represents
the best threshold for player 1 to play. Or, maxMin which represents the 
maximum minimum outcome for the scores of player 1 at different thresholds 




