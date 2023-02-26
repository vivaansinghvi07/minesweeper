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


        
        // closes scanner
        in.close();


    }
}
