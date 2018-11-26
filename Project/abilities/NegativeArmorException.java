package abilities;

public class NegativeArmorException extends Exception {
    public NegativeArmorException() {
        super("You don't have enough ether to use that ability");
    }
}