import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        if (n==1) {
            computerMove = HandSign.ROCK;
        }
        if(n==2) {
            computerMove = HandSign.PAPER;
        }
        if(n==3) {
            computerMove = HandSign.SCISSORS;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = true;
        HandSign playerHandSign = null;
        do {// repeat until valid input

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("Enter r/R, p/P or s/S (rock, paper or scissors).");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);
            
            switch (inChar) {
                case 'r':
                    playerHandSign = HandSign.ROCK;
                    break;
                case 'p':
                    playerHandSign = HandSign.PAPER;
                    break;
                case 's':
                    playerHandSign = HandSign.SCISSORS;
                    break;
            }
        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2){
         if ((h1==HandSign.ROCK && h2==HandSign.SCISSORS) || 
         (h1==HandSign.PAPER && h2==HandSign.ROCK) || 
         (h1==HandSign.SCISSORS && h2==HandSign.PAPER)) {
            return 1;
         }
         if ((h2==HandSign.ROCK && h1==HandSign.SCISSORS) || 
         (h2==HandSign.PAPER && h1==HandSign.ROCK) || 
         (h2==HandSign.SCISSORS && h1==HandSign.PAPER)){
            return -1;
         }
        return 0;
    }
    
    /**
 * The main method
 */
public static void main(String[] args) {
    int playerScore = 0;
    int computerScore = 0;

    HandSign playerMove;     // player’s sign from keyboard
    HandSign computerMove;   // computer’s random sign

    int checkwin;
    boolean gameOver = false;

    while (!gameOver) {

        // Step 1: Get the player move
        playerMove = getPlayerMove();

        // Optional: allow quitting if your getPlayerMove supports it
        if (playerMove == null) {
            gameOver = true;
            break;
        }

        // Step 2: Get computer move
        computerMove = getComputerMove();

        // Step 3: Check who wins
        checkwin = whoWins(playerMove, computerMove);
        // Assume: 0 = draw, 1 = player wins, 2 = computer wins

        // Step 4: Output round result
        System.out.println("Player move: " + playerMove);
        System.out.println("Computer move: " + computerMove);

        if (checkwin == 0) {
            System.out.println("It's a draw!");
        } else if (checkwin == 1) {
            System.out.println("Player wins this round!");
            playerScore++;
        } else {
            System.out.println("Computer wins this round!");
            computerScore++;
        }

        // Step 5: Print scores
        System.out.println("Score -> Player: " + playerScore +
                           " | Computer: " + computerScore);

        System.out.println("----------------------------------");
    }

    System.out.println("Game Over!");
    System.out.println("Final Score -> Player: " + playerScore +
                       " | Computer: " + computerScore);
}
    }
