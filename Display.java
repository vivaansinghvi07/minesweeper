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
}
