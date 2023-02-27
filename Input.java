import java.util.Scanner;

public class Input {

    // the scanner which gets player input
    private Scanner scan;

    // constructor
    public Input() {
        scan = new Scanner(System.in);
    }

    // gets the next line
    public String nextLine() {
        return scan.nextLine();
    }

    // gets the next integer but given that it is within certain bounds
    public int boundedInt(int lower, int upper) {
        try {

            // tries to get the next number - if error then its caught
            int out = scan.nextInt();

            // skips the line
            this.nextLine();

            // checks bounds
            if (out >= lower && out <= upper) {
                return out;
            }
            
            // prints warning and recursively runs the program
            Text.smoothPrint("Your input must be within the bounds " + lower + " and " + upper + ": ");
            return boundedInt(lower, upper);
        }
        catch (Exception e) {
            // skips the line
            this.nextLine();

            // prints a prompt and recursively runs the program
            Text.smoothPrint("Please enter an integer number: ");
            return boundedInt(lower, upper);

        }
    }

    // method to close Scanner
    public void close() {
        this.scan.close();
    }

    // method to obtain the settings
    public int[] getSettings() {
        // clears the console
        Text.clear();

        // prints introduction sequence
        Display.printIntro();

        // asks user when ready and then continues after they press enter
        Text.smoothPrint("\nPress enter when you are ready.\n");
        this.nextLine();

        // clears the console
        Text.clear();

        // prints the prompt to get difficulty
        Display.printFrequency();

        // gets the difficulty
        int frequency = this.boundedInt(1, 2);

        // clears the console
        Text.clear();

        // prints the prompt to get the size
        Display.printSize();

        // gets the size
        int size = this.boundedInt(1, 3);

        // outputs the two numbers
        int[] out = {frequency, size};
        return out;
    }
    
    // gets the player's move using the bounds
    public String getMove(int gameSizeX, int gameSizeY) {
        // gets output and converts it to a character array
        String output = this.nextLine();
        char[] input = output.toCharArray();

        // makes sure length of the move is either 2 or 3 
        if (input.length != 2 && input.length != 3) {
            Text.smoothPrint("Please enter a proper move: ");
            return this.getMove(gameSizeX, gameSizeY);
        }
        // check if third character is not f, if there is a third character present
        else if (input.length == 3 && (input[2] != 'f' && input[2] != 'F')) {
            Text.smoothPrint("Please enter a proper move (if you want to flag, add an \"f\" to the end of the move): ");
            return this.getMove(gameSizeX, gameSizeY);
        }
        // check if the move is out of bounds given the game sizes
        else if (input[0] - 'a' >= gameSizeX || input[1] - 'A' >= gameSizeY) {
            Text.smoothPrint("Your move is out of bounds! Please enter a proper move: ");
            return this.getMove(gameSizeX, gameSizeY);
        }
        // check if an uppercase was done when it should have been lowercase
        else if (!Character.isUpperCase(input[1]) || Character.isUpperCase(input[0])) {
            Text.smoothPrint("Enter coordinates in the correct form - the first one is the x, and the second is the y: ");
            return this.getMove(gameSizeX, gameSizeY);
        }
        // if everything is good, return the output
        else {
            return output;
        }
    }
}
