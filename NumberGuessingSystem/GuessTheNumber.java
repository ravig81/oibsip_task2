import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10; // Maximum Number of attempts
    private static final int ROUNDS = 3; // Maximum number of rounds to play
    private static final int MAX_SCORE = 100; // Maximum Score if Guessing Number is correct in first attempt
    private static final int POINTS_PER_ATTEMPT = 10; // Points per attempt

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
         
        System.out.println("***************NUMBER GUESSING GAME*******************");
        System.out.println("Total Number Of Rounds : 3");
        System.out.println("No. of Attempts To Guess Number In Each Round : 10\n");
        for (int round = 1; round <= ROUNDS; round++) {
            int min = 1;
            int max = 100;
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean correctlyGuessed = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("I have chosen a number between " + min + " and " + max + ". Try to guess it!");

            while (!correctlyGuessed && attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", userGuess,
                            MAX_ATTEMPTS - attempts);
                } else if (userGuess > numberToGuess) {
                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", userGuess,
                    MAX_ATTEMPTS - attempts);
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    int points = Math.max(0, MAX_SCORE - (attempts - 1) * POINTS_PER_ATTEMPT);
                    totalScore += points;
                    System.out.println("You earned " + points + " points this round.");
                    correctlyGuessed = true;
                }
            }

            if (!correctlyGuessed) {
                System.out.println("Sorry, you didn't guess the number. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is " + totalScore + ".");
        scanner.close();
    }
}
