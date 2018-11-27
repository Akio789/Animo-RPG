package characters;

import java.io.Serializable;
import javax.swing.*;

public abstract class Boss extends Enemy implements Serializable {
    // CONSTRUCTOR
    public Boss(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
    }
}
