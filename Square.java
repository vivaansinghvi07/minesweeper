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

    // keeps track of it the thing has already been assigned a value
    private boolean assignedValue;
    private boolean isOpening;

    // constructor for a square - y goes first for this project
    public Square(int y, int x) {
        // assigns location
        this.locationX = x;
        this.locationY = y;

        // assigns starter values
        this.flagged = false;
        this.mine = false;
        this.hidden = true;
        this.assignedValue = false;
        this.isOpening = false;

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
    public boolean isOpening() {
        return this.isOpening;
    }

    // toggles the flag
    public void flag() {
        this.flagged = !this.flagged;
        return;
    }

    // makes it part of the opening
    public void setOpening() {
        this.isOpening = true;
    }

    // checks if assigned
    public boolean isAssigned() {
        return this.assignedValue;
    }

    // shows the square
    public void show() {
        this.hidden = false;
    }

    // sets the number of mines bordered
    public void setBordered(int x) {
        this.minesBordered = x;
    }

    // assigns a square to be a mine or not
    public void assign (boolean isMine) {
        // returns if already assigned a value
        if (this.assignedValue) return;

        // otherwise, assign a value
        this.mine = isMine ? true : false;
        this.assignedValue = true;
    }
}
