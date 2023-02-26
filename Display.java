public class Display {
    public static void printIntro() {
        Text.smoothPrint("Welcome to Minesweeper!\n\n");
        Text.wait(200);
        Text.smoothPrint("The objective of this game is to clear the minefield by guessing places until you lose!\n");
        Text.wait(200);
        Text.smoothPrint("If you enter the spot on which a mine stands, you lose!\n");
        Text.wait(200);
        Text.smoothPrint("To enter a move, simply type in the coordinate of your intended spot, in an <xy> form. An example input would be \"dF\" (the coordinates are either uppercase or lowercase letters)\n");
        Text.smoothPrint("If you want to flag a location, simply enter the letter \"f\" at the end of your move. If you want to flag the b7 square, you would type \"b3f\"\n");
        Text.wait(200);
        Text.smoothPrint("\nNote: each square is represented by two characters on the x-axis in order to make them look more like a square and less like a rectangle.\n");
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
