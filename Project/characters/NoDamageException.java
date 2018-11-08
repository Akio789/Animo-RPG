package characters;

public class NoDamageException extends Exception {
    public NoDamageException() {
        super("Attack was too weak, it dealed no damage");
    }
}