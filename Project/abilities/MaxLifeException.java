package abilities;

public class MaxLifeException extends Exception {
    public MaxLifeException() {
        super("You don't have enough ether to use that ability");
    }
}