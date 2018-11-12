package map;

public class NoRiverException extends Exception {
    public NoRiverException() {
        super("You are not in the river.");
    }
}