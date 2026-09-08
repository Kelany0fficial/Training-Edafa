import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Create Random to generate a random number
        Random random = new Random();

        // Generate a number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;

        // Variables
        int guess;
        int attempts = 0;

        System.out.println("========== NUMBER GUESS GAME ==========");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Try to guess it!");

        // Game loop
        do {

            System.out.print("Guess the number: ");
            guess = scanner.nextInt();

            // Increase attempts
            attempts++;

            // Check the guess
            if (guess > secretNumber) {

                System.out.println("Too high!");

            } else if (guess < secretNumber) {

                System.out.println("Too low!");

            } else {

                System.out.println("Correct");
                System.out.println(
                        "You guessed the number in "
                                + attempts
                                + " attempts."
                );
            }

        } while (guess != secretNumber);

        System.out.println("Game Over!");

        scanner.close();
    }
}