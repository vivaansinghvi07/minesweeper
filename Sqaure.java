public class Sqaure {

    // variables for the location
    private int locationX;
    private int locationY;

    // variables for if its flagged or a mine
    private boolean flagged;
    private boolean mine;
    private boolean hidden;

    // constructor for a square
    public Sqaure(int x, int y) {
        // assigns location
        this.locationX = x;
        this.locationY = y;

        // assigns starter values
        this.flagged = false;
        this.mine = false;
        this.hidden = true;
    }
}
