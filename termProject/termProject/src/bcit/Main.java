package bcit;


import bcit.MyGame.ColorMatcher;
import bcit.NumberGame.NumberGameVisuals;
import bcit.WordGame.WordGame;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class serves as the entry point to the game menu.
 * It allows the user to choose between different games (Word game, Number game, Color Matching Rush game)
 * and launches the selected game accordingly.
 * @author Evan Vink
 * @version 1.0
 */
public class Main {

    /**
     * The main method displays the main menu to the user, receives their input, and launches the appropriate game.
     * It will continue to prompt the user for a valid input if they provide an invalid one.
     * The program will recursively call itself after a game ends, allowing the user to play again or choose a new game.
     * If the user chooses to quit, the program will exit.
     *
     * @param args Command line arguments (unused in this implementation).
     * @throws IOException If an I/O error occurs while starting a game.
     */
    public static void main(String[] args) throws IOException {

        Scanner input;
        String choice;

        input = new Scanner(System.in);


        System.out.println("Welcome to The Main Menu!\n" +
                "Select the following:\n" +
                "Press W to play the Word game.\n" +
                "Press N to play the Number game.\n" +
                "Press M to play the Color Matching Rush game.\n" +
                "Press Q to quit.");

        choice = input.nextLine();

        while(!choice.equalsIgnoreCase("W") && !choice.equalsIgnoreCase("N")
                && !choice.equalsIgnoreCase("M") && !choice.equalsIgnoreCase("Q")){
            System.out.println("Invalid Input Try Again!");
            choice = input.nextLine();
        }

        if(choice.equalsIgnoreCase("w")){
            WordGame wordGame = new WordGame();
            wordGame.playGame();
            main(args);
        } else if(choice.equalsIgnoreCase("n")){
            NumberGameVisuals.main(args);
            main(args);
        } else if(choice.equalsIgnoreCase("M")){
            ColorMatcher.main(args);
            main(args);
        } else if (choice.equalsIgnoreCase("q")) {
            System.out.println("Bye!");
            System.exit(0);
        }





    }
}
