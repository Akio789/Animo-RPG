package characters;

import java.io.Serializable;

import javax.swing.*;

public abstract class Enemy extends Character implements Serializable {

    // CONTSTRUCTOR
    public Enemy(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
    }

    // METHODS
    public abstract void attack(Hero hero) throws NoDamageException;
}