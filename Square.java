public class Square {

    // variables for the location
    private int locationX;
    private int locationY;

    // variables for if its flagged or a mine
    private boolean flagged;
    private boolean mine;
    private boolean hidden;

    // constructor for a square - y goes first for this project
    public Square(int y, int x) {
        // assigns location
        this.locationX = x;
        this.locationY = y;

        // assigns starter values
        this.flagged = false;
        this.mine = false;
        this.hidden = true;
    }
}
