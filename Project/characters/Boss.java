package characters;

import abilitiesboss.*;

import java.io.Serializable;

import javax.swing.*;

public abstract class Boss extends Enemy implements Serializable {
    // ATTRIBUTES
    private double critic;

    // CONSTRUCTOR
    public Boss(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
    }

    // GETTETS AND SETTERS
    public double getCritic() {
        return critic;
    }

    public void setCritic(double critic) {
        this.critic = critic;
    }

    // METHODS
    public void criticAttack(Hero hero) {
        hero.setHp(hero.getHp() - (getAttack() * critic));
    }
}
