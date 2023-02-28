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

    // declares constant strings that will be used within the toString method
    private static final String FLAG = "⚑ ";
    private static final String BLOCK = "# ";
    private static final String MINE = "@ ";
    private static final String ALPHABETLOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABETUPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // colors for the numbers
    private static final String[] NUMBERCOLORS = {Colors.GREEN_BOLD_BRIGHT, Colors.BLUE_BOLD_BRIGHT, Colors.YELLOW_BOLD_BRIGHT, Colors.PURPLE_BOLD, Colors.BLUE_BOLD, Colors.RED_BOLD, Colors.YELLOW_BOLD, Colors.CYAN_BOLD, Colors.RED_BOLD_BRIGHT,};

    // the minefield itself
    private Square[][] field;

    // keeps track of if the opening needs to be done
    private boolean opening;

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
        this.gameSizeX = size * 5 + 7;
        this.gameSizeY = size * 5 + 2;

        // creates a new field of squares
        this.field = new Square[this.gameSizeY][this.gameSizeX];

        // assigns a chance of a mine based on what the difficulty is
        this.mineChance = (frequency == 1) ? 0.10 : 0.25; 

        // fills the board in with squares
        for (int i = 0; i < gameSizeY; i++) {
            for (int j = 0; j < gameSizeX; j++) {
                this.field[i][j] = new Square();
            }
        }

        // sets to true so that next move is the opening
        this.opening = true;
    }

    public String toString() {

        // updates the display based on presence of empty squares
        updateDisplay();
        
        // initializes the output of the string
        String output = new String("");
        output += getXAxis();

        // gets all the following rows
        for (int y = 0; y < gameSizeY; y++) {
            output += getRow(y);
        }
        return output;
    }

    private String getRow(int y) {
        // initializes the row with the coordinate label AND COLORS
        String output = new String(Colors.PURPLE_BOLD_BRIGHT + Game.ALPHABETUPPER.charAt(y) + " " + Colors.WHITE_BOLD_BRIGHT);

        // gets an array which represents the row being analyzed
        Square[] row = this.field[y];
        for (int x = 0; x < this.gameSizeX; x++) {
            // gets the square
            Square temp = row[x];
            
            // checks if the square is hidden or flagged
            if (temp.isHidden()) {
                if (temp.isFlagged()) {
                    output += Colors.PURPLE_BOLD_BRIGHT + Game.FLAG;
                }
                else {
                    output += Colors.RESET + Game.BLOCK;
                }
                continue;
            }
            else if (temp.isMine()) {
                output += Colors.RED_BOLD + Game.MINE;
                continue;
            }

            // gets the number of mines bordered
            int bordered = temp.getBordered();

            // if it borders zero it needs to be empty space
            if (bordered == 0) { 
                output += "  ";
                continue;
            }

            // otherwise prints the number
            output += Game.NUMBERCOLORS[bordered - 1] + bordered + " ";

        }

        // returns the row with a new line added to it
        return output + "\n";

    }
    
    private String getXAxis() {
        // makes a new string for the x axis and makes it all cyan
        String xCords = new String("  " + Colors.CYAN_BOLD_BRIGHT);

        // goes by how big the game is
        for (int x = 0; x < this.gameSizeX; x++) {

            // adds the (x+1)-th letter in the alphabet
            xCords += Game.ALPHABETLOWER.charAt(x) + " ";

        }

        // adds a new line and resets the color
        xCords += "\n" + Colors.RESET;
        return xCords;
    }

    public boolean controlInput(Input in) {
        // prompts user for move
        System.out.print(Colors.RESET);
        Text.smoothPrint("Enter your move: ");

        // gets the move using the input method
        char[] move = in.getMove(this.gameSizeX, this.gameSizeY).toCharArray();

        // checks for flag
        if (move.length == 3) {
            flag(move);
            return true;
        }
        else {
            // checks if the opening needs to be done
            if (this.opening) {
                opening(move);
                return true;
            }
            else {
                // returns the output of a guess - if it's a mine it will return false
                return guess(move);
            }
        }
    }

    private void updateDisplay() {
        // goes through every square on the field and updates it if its shown and not bordering anything
        for (int y = 0; y < this.gameSizeY; y++) {
            for (int x = 0; x < this.gameSizeX; x++) {
                if (this.field[y][x].getBordered() == 0 && !this.field[y][x].isHidden()) {
                    // method to clear a 3x3
                    revealSquare(y, x);
                }
            }
        }
    }

    // shows a 3x3 box around a square that has no mines bordered
    private void revealSquare(int y, int x) {
        // loop goes in a 3x3 box centered around the inputted square
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // unhides the square (if desnt exist, just continue)
                try {
                    this.field[y + i][x + j].show();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
    }

    // does the opening sequence
    private void opening(char[] move) {
        // gets the place where the player moved
        int yTarget = move[1] - 'A';
        int xTarget = move[0] - 'a';

        // goes through a 3x3 area around the place that was clicked and clears it regardless of the presence of mines
        iterateAndAssign(0.0, 3, xTarget, yTarget);

        // goes through a 5x5 area and may or may not assign mines
        iterateAndAssign(this.mineChance / 4, 5, xTarget, yTarget);

        // finally, go through a 7x7 area with a greater chance of mines
        iterateAndAssign(this.mineChance / 2, 7, xTarget, yTarget);

        // loads the mines and the bordered counts
        loadMines();
        loadBordered();

        // shows all the blank ones in the opening
        showOpening();
        
        // sets opening to be false and continues
        this.opening = false;
        return;

    }

    private void showOpening() {
        // goes through every square, and if it is part of the opening sequence and the square borders nothing, reveal a square
        for (int y = 0; y < this.gameSizeY; y++) {
            for (int x = 0; x < this.gameSizeX; x++) {
                if (this.field[y][x].isOpening() && this.field[y][x].getBordered() == 0) {
                    // method to reveal a 3x3 box around a square
                    revealSquare(y, x);
                }
            }
        }
    }

    // assigns mines to the whole board
    private void loadMines() {
        for (int y = 0; y < this.gameSizeY; y++) {
            for (int x = 0; x < this.gameSizeX; x++) {
                // assigns it a mine if the mineChance is met
                this.field[y][x].assign(Math.random() < this.mineChance);
            }
        }
    }

    // assigns the bordered counts for each square
    private void loadBordered() {
        for (int y = 0; y < this.gameSizeY; y++) {
            for (int x = 0; x < this.gameSizeX; x++) {
                // counts the number the square borders and assigns it to the square object
                this.field[y][x].setBordered(getBordered(y, x));
            }
        }
    }

    // counts the number of mines bordered by a square
    private int getBordered(int y, int x) {
        // intializes the count of mines
        int mineCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // if the square is a mine, incremement the count - if an error happens, just move on
                try {
                    if (this.field[y + i][x + j].isMine()) {
                        mineCount++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        // returns count
        return mineCount;
    }
    
    // goes in a square with a certain side length and assigns values within that square depending on the mine chance
    private void iterateAndAssign(double mineChance, int length, int x, int y) {
        // goes through a square with side length <length>
        for (int i = - (length / 2); i < length / 2 + 1; i++) {
            for (int j = - (length / 2); j < length / 2 + 1; j++) {
                // randomly assigns the square to be a mine depending on the entered chance
                try {
                    this.field[y + i][x + j].assign(Math.random() < mineChance);
                    this.field[y + i][x + j].setOpening();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
    }

    private boolean guess(char[] move) {
        // gets the square being analyzed
        Square target = this.field[move[1] - 'A'][move[0] - 'a'];

        // checks if the target is a mine
        if (target.isMine()) {
            showAllMines();
            return false;
        }
        
        // shows the place that was moved on
        target.show();
        return true;
    }

    // upon a loss, shows all the mines 
    private void showAllMines() {
        for (int y = 0; y < this.gameSizeY; y++) {
            for (int x = 0; x < this.gameSizeX; x++) {
                // assigns a temporary Square that is being analyzed
                Square temp = this.field[y][x];
                // reveals all mines
                if (temp.isMine()) {
                    temp.show();
                }
                else if (temp.isFlagged()) {
                    // removes the flag from flagged mines
                    temp.flag();
                }
            }
        }
    }

    // controls input for player flag
    private void flag(char[] move) {
        // gets the square being analyzed
        Square target = this.field[move[1] - 'A'][move[0] - 'a'];

        // toggles the flag (if on, turn off, if off, turn on)
        target.flag();
    }

    // gets if the game is won
    public boolean isWon() {
        // checks every square to see if is not a mine and hidden - if every non mine is not hidden then its a win
        for (int y = 0; y < this.gameSizeY; y++) {
            for (int x = 0; x < this.gameSizeX; x++) {
                if (!this.field[y][x].isMine() && this.field[y][x].isHidden()) {
                    return false;
                }
            }
        }
        return true;
    }
}
