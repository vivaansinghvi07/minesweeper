public class Display {
    public static void printIntro() {
        Text.smoothPrint("Welcome to Minesweeper!\n\n");
        Text.wait(200);
        Text.smoothPrint("The objective of this game is to clear the minefield by guessing places until you lose!\n");
        Text.wait(200);
        Text.smoothPrint("If you enter the spot on which a mine stands, you lose!\n");
        Text.wait(200);
        Text.smoothPrint("To enter a move, simply type in the coordinate of your intended spot, in an <xy> form. An example input would be \"d3\"\n");
        Text.wait(800);
    }
    public static void printDifficulty() {
        Text.smoothPrint("What difficulty would you like to play on?\n");
        Text.wait(200);
        Text.smoothPrint("\t1. Easy Mode\n");
        Text.smoothPrint("\t2. Hard Mode\n");
        Text.wait(400);
        Text.smoothPrint("\nEnter your choice as a number, 1 or 2: ");
    }
    public static void printSize() {
        Text.smoothPrint("What game size do you want to play on?\n");
        Text.wait(200);
        Text.smoothPrint("\t1. Small\n");
        Text.smoothPrint("\t2. Medium\n");
        Text.smoothPrint("\t3. Large\n");
        Text.wait(400);
        Text.smoothPrint("\nEnter your choice as an integer, between 1 and 3: ");
    }
    public static int[] getSettings(Input in) {
        // clears the console
        Text.clear();

        // prints introduction sequence
        printIntro();

        // asks user when ready and then continues after they press enter
        Text.smoothPrint("\nPress enter when you are ready.\n");
        in.nextLine();

        // clears the console
        Text.clear();

        // prints the prompt to get difficulty
        printDifficulty();

        // gets the difficulty
        int difficulty = in.boundedInt(1, 2);

        // clears the console
        Text.clear();

        // prints the prompt to get the size
        printSize();

        // gets the size
        int size = in.boundedInt(1, 3);

        // outputs the two numbers
        int[] out = {difficulty, size};
        return out;
    }
}
