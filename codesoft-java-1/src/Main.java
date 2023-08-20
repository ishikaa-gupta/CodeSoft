//Task 1- Number Game

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + (attempts + 1) + " attempts.");
                    score++;
                    break;
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);

    }
}