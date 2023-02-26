public class Main {
    public static void main(String[] args) {

        // clears the console
        Text.clear();

        // creates a scanner used to get player input
        Input in = new Input();

        // asks for smooth text preference
        Text.smoothPrint("Disable smooth text? (y/n): ");
        String ans = in.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            Text.waitTime = 0;
        }

        // gets the settings and assigns them to variables
        int[] settings = in.getSettings();
        int frequency = settings[0], size = settings[1];

        // TODO: begin the game



        
        // closes scanner
        in.close();


    }
}
