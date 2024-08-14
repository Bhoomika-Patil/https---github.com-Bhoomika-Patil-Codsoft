import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        int totalRounds = 0;
        boolean playAgain;

        do {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 5;
            boolean hasWon = false;

            System.out.println("Round " + totalRounds + ":");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Enter your guess (between 1 and 100): ");
                int userGuess = scanner.nextInt();

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasWon = true;
                    roundsWon++;
                    break;
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        
    }
}
