/* 
 *
 * Notes, ideas:
 * 
 * Represent un-stepped squares with a -1, everything else with a 0
 * Have a class for each square and see if its flagged or uncovered or a bomb
 * When making the game, check each square and see how many bombs it borders - if there is an error, simply continue the nested loop - should be around 5000 iterations so not too challenging
 * Get the first player click - there we can determine which squares will be mines and stuff
 * 
 * 
 */


public class Game {

    // the minefield itself
    private Square[][] field;

    // chance of there being a mine on a certain square
    private double mineChance;

    // the sizes of the game
    private int gameSizeX;
    private int gameSizeY;

    /*
     * 0 1 2 3 4 5 6 7 8 9
     * 1 X X X X X X X X X
     * 2 X X X X X X X X X
     * 3 X X X X X X X X X
     * 4 X X X X X X X X X
     * 5 X X X X X X X X X
     * 6 X X X X X X X X X
     */

    /*
     * The game will somewhat look like that - the origin will be at the top, each row is represented by a y-value, and each column has an x-value
     * Therefore, the array will be indexed [y][x] rather than [x][y]
     */

    public Game(int frequency, int size) {
        // declares the size of the game (might change logic later)
        this.gameSizeX = size * 5 + 5;
        this.gameSizeY = size * 5;

        // creates a new field of squares
        this.field = new Square[this.gameSizeY][this.gameSizeX];

        // assigns a chance of a mine based on what the difficulty is
        this.mineChance = (frequency == 1) ? 0.10 : 0.25; 

        // fills the board in with squares
        for (int i = 0; i < gameSizeY; i++) {
            for (int j = 0; j < gameSizeX; j++) {
                this.field[i][j] = new Square(i, j);
            }
        }
    }
}
