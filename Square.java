public class Square {

    // variables for the location
    private int locationX;
    private int locationY;

    // variables for if its flagged or a mine
    private boolean flagged;
    private boolean mine;
    private boolean hidden;

    // stores how many mines it borders
    private int minesBordered;

    // constructor for a square - y goes first for this project
    public Square(int y, int x) {
        // assigns location
        this.locationX = x;
        this.locationY = y;

        // assigns starter values
        this.flagged = false;
        this.mine = false;
        this.hidden = true;

        // defaults to 0 mines bordered - will be assigned later
        this.minesBordered = 0;
    }

    // getter methods
    public boolean isHidden() {
        return this.hidden;
    }
    public boolean isFlagged() {
        return this.flagged;
    }
    public boolean isMine() {
        return this.mine;
    }
    public int getBordered() {
        return this.minesBordered;
    }

    // toggles the flag
    public void flag() {
        this.flagged = !this.flagged;
        return;
    }
}
