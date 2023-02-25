import java.util.Scanner;

public class Input {

    // the scanner which gets player input
    private Scanner scan;

    // constructor
    public Input() {
        scan = new Scanner(System.in);
    }

    // gets the next line
    public String nextLine() {
        return scan.nextLine();
    }

    // method to close Scanner
    public void close() {
        this.scan.close();
    }
}
