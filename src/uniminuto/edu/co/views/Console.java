package uniminuto.edu.co.views;

import uniminuto.edu.co.models.Client;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Represents a Console utility class for interacting with the user.
 * Provides methods for reading input and displaying messages in the console.
 */
public class Console {

    // Scanner object for reading user input from the console
    private final Scanner scanner;

    /**
     * Constructor to initialize the Console with a new Scanner instance.
     */
    public Console() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads a line of text input from the user.
     * @return The input string entered by the user.
     */
    public String readString() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer input from the user.
     * Converts the input string to an integer.
     * @return The integer value entered by the user.
     * @throws NumberFormatException if the input cannot be parsed as an integer.
     */
    public int readInt() {
        return Integer.parseInt(readString());
    }

    /**
     * Prints a message to the console.
     * @param message The message to display.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Closes the Scanner instance to release resources.
     * Should be called when the Console is no longer needed.
     */
    public void destroy() {
        scanner.close();
    }
}