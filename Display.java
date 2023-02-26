public class Display {
    public static void printIntro() {
        System.out.print(Colors.WHITE_BOLD_BRIGHT);
        Text.smoothPrint("Welcome to Minesweeper!\n\n");
        System.out.print(Colors.RESET);
        Text.wait(200);
        Text.smoothPrint("The objective of this game is to clear the minefield by guessing places until you lose!\n");
        Text.wait(200);
        Text.smoothPrint("If you enter the spot on which a mine stands, you lose!\n");
        Text.wait(200);
        Text.smoothPrint("To reveal a square, simply type in the coordinate of your intended spot, in an <xy> form. An example input would be \"dF\" (the coordinates are either uppercase or lowercase letters)\n");
        Text.smoothPrint("If you want to flag a location, simply enter the letter \"f\" at the end of your move. If you want to flag the bK square, you would type \"bKf\"\n");
        Text.wait(200);
        Text.smoothPrint("\nThe y-axis is represented by uppercase letters and the x-axis is represented by lowercase letters. Labels are present\n");
        Text.wait(800);
    }
    public static void printFrequency() {
        Text.smoothPrint("How often should mines occur?\n\n");
        Text.wait(200);
        Text.smoothPrint("  1. Rare\n");
        Text.smoothPrint("  2. Often\n");
        Text.wait(400);
        Text.smoothPrint("\nEnter your choice as a number, 1 or 2: ");
    }
    public static void printSize() {
        Text.smoothPrint("What game size do you want to play on?\n\n");
        Text.wait(200);
        Text.smoothPrint("  1. Small\n");
        Text.smoothPrint("  2. Medium\n");
        Text.smoothPrint("  3. Large\n");
        Text.wait(400);
        Text.smoothPrint("\nEnter your choice as an integer, between 1 and 3: ");
    }
}
