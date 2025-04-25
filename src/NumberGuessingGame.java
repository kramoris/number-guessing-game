import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have 10 attempts to guess it.");

            do {
                System.out.print("Enter your guess: ");

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    attempts++;
                } else {
                    System.out.println("Please enter a number.");
                    scanner.next();
                    continue;
                }

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempts + " tries.");
                    break;
                }

                if (attempts == 10) {
                    System.out.println("Out of attempts! The number was " + secretNumber);
                    break;
                }

            } while (true);

            System.out.print("Play again? (y/n): ");
            scanner.nextLine(); // consume leftover newline
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("y");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}