package characters;

import java.io.Serializable;

import javax.swing.*;

public class OrderMinion extends Enemy implements Serializable {

    // CONSTRUCTOR
    public OrderMinion(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
    }

    // METHODS
    public void attack(Hero hero) throws NoDamageException {
        double dmgMult = 1.1;
        double damageDone = hero.getDefense() - (dmgMult * getAttack());
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