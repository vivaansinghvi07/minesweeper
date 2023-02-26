public class Text {
    // gets how long smoothprint waits
    public static int waitTime = 30;

    // method that waits <time> milliseconds
    public static void wait(int time) {
        try {
            // sleeps for the amount of time allocated
            Thread.sleep(time);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method to print text smoothly
    public static void smoothPrint(String prompt) {

        // converts input to a character array
        char[] message = prompt.toCharArray();

        // goes through each character and prints it, waiting after each one
        for (char c : message) {
            System.out.print(c);
            wait(waitTime);
        }

    }

    // method to clear the console
    public static void clear() {
        System.out.println("\033[H\033[2J"); 
        System.out.flush();
        wait(200);
    }
}
