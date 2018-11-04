package characters;

public class EmptyFlaskException extends Exception {
    public EmptyFlaskException() {
        super("Flask is empty");
    }
}