package characters;

public class NotEnoughEtherException extends Exception {
    public NotEnoughEtherException() {
        super("You don't have enough ether to use that ability");
    }
}