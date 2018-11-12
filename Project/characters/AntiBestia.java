package characters;

import abilitiesboss.*;

import java.io.Serializable;
import java.util.*;

import javax.swing.JLabel;

public class AntiBestia extends Boss implements Serializable {
    // ATTRIBUTES
    private AntiRush rush;
    private AntiThump thump;

    // CONSTRUCTOR
    public AntiBestia(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.5);
        rush = new AntiRush();
        thump = new AntiThump();
    }

    // GETTERS AND SETTERS
    public AntiRush getRush() {
        return rush;
    }

    public void setRush(AntiRush rush) {
        this.rush = rush;
    }

    public AntiThump getThump() {
        return thump;
    }

    public void setThump(AntiThump thump) {
        this.thump = thump;
    }

    // METHODS
    public void attack(Hero hero) throws NoDamageException {
        double dmgMult = 1.4;
        double damageDone = hero.getDefense() - (dmgMult * getAttack() * getCritic());
        if (hero.getDefense() < (dmgMult * getAttack())) {
            System.out.println("Wild minion dealed " + (dmgMult * getAttack() - (hero.getDefense())) + " damage.");
            if ((hero.getHp() + damageDone) <= 0) {
                hero.setHp(0);
            } else {
                hero.setHp(hero.getHp() + damageDone);
            }
        } else {
            throw new NoDamageException();
        }
    }
}