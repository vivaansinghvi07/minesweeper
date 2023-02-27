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
        Text.clear();

        // initializes the game
        Game game = new Game(frequency, size);
        System.out.println(game);

        // control input returns false if the game is lost
        while (game.controlInput(in)) {
            if (game.isWon()) {
                break;
            }
            Text.clearNoWait();
            System.out.println(game);
        }

        Text.clearNoWait();
        System.out.println(game + "\n");

        if (game.isWon()) {
            Text.smoothPrint("Congratulations! You won! Thanks for playing!\n\n");
        }

        else {
            Text.smoothPrint("You lost. Thanks for playing!\n\n");
        }

        
        // closes scanner
        in.close();


    }
}
