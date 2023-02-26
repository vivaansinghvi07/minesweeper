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

            // checks bounds
            if (out >= lower && out <= upper) {
                return out;
            }
            
            // prints warning and recursively runs the program
            Text.smoothPrint("Your input must be within the bounds " + lower + " and " + upper + "!" + "\n");
            return boundedInt(lower, upper);
        }
        catch (Exception e) {

            // prints a prompt and recursively runs the program
            Text.smoothPrint("Please enter an integer number!\n");
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
    
}
