package characters;

public class SlotFullException extends Exception {
    public SlotFullException() {
        super("Slot is full");
    }
}