package awad_gebrewahid;

import java.util.Scanner;
import java.util.Random;

public class Awad_gebrewahid1 {
    // Constants for colors
    public static final String RED = "RED";
    public static final String GREEN = "GREEN";
    public static final String BLUE = "BLUE";
    public static final String ORANGE = "ORANGE";
    public static final String YELLOW = "YELLOW";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables declaration
        int correctGuesses = 0;
        int rounds = 11;
        String userName, userDescription, dueDate;
        
        // Get user information
        System.out.println("Enter your name:");
        userName = scanner.nextLine();
        System.out.println("Describe yourself:");
        userDescription = scanner.nextLine();
        System.out.println("Enter due date:");
        dueDate = scanner.nextLine();
        
        // Start the game loop
        for (int round = 1; round <= rounds; round++) {
            Random random = new Random();
            int randomNumber = random.nextInt(5) + 1;
            String selectedColor = getColor(randomNumber);
            
            System.out.println("\nRound " + round);
            System.out.println("Guess the color (RED, GREEN, BLUE, ORANGE, YELLOW):");
            String userGuess = scanner.nextLine().toUpperCase();
            
            // Keep prompting until a valid color is entered
            while (!isValidColor(userGuess)) {
                System.out.println("Invalid color. Please enter a valid color:");
                userGuess = scanner.nextLine().toUpperCase();
            }
            
            // Check if the guess is correct
            if (userGuess.equals(selectedColor)) {
                System.out.println("Correct!");
                correctGuesses++;
            } else {
                System.out.println("Incorrect. The correct color was: " + selectedColor);
            }
        }
        
        // Display results
        System.out.println("\nGame Over");
        System.out.println("Total correct guesses out of " + rounds + ": " + correctGuesses);
        System.out.println("User: " + userName);
        System.out.println("Description: " + userDescription);
        System.out.println("Due Date: " + dueDate);
        
        scanner.close();
    }
    
    // Method to check if the entered color is valid
    public static boolean isValidColor(String color) {
        return color.equals(RED) || color.equals(GREEN) || color.equals(BLUE) ||
               color.equals(ORANGE) || color.equals(YELLOW);
    }
    
    // Method to get color based on random number
    public static String getColor(int randomNumber) {
        switch (randomNumber) {
            case 1:
                return RED;
            case 2:
                return GREEN;
            case 3:
                return BLUE;
            case 4:
                return ORANGE;
            case 5:
                return YELLOW;
            default:
                return null; // Should not happen
        }
    }
}