package characters;

import java.io.Serializable;

import javax.swing.*;

public class StrongWildMinion extends Enemy implements Serializable {

    // CONSTRUCTOR
    public StrongWildMinion(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
    }

    // METHODS
    public void attack(Hero hero) throws NoDamageException {
        double dmgMult = 1.1*getAttack();
        double rawDefense = hero.getDefense()*.06;
        double damageDone = (dmgMult) - (dmgMult*rawDefense);
        if (rawDefense < 1) {
            System.out.println("Strong wild minion made a normal attack and  dealed " + damageDone + " damage.");
            if ((hero.getHp() - damageDone) <= 0) {
                hero.setHp(0);
            } else {
                hero.setHp(hero.getHp() - damageDone);
            }
        } else {
            throw new NoDamageException();
        }
    }
    public void heavyAttack(Hero hero) throws NoDamageException {
        double dmgMult = 2*getAttack();
        double rawDefense = hero.getDefense()*.06;
        double damageDone = (dmgMult) - (dmgMult*rawDefense);
        if (rawDefense < 1) {
            System.out.println("Strong wild minion made a heavy attack and dealed " + damageDone + " damage.");
            if ((hero.getHp() - damageDone) <= 0) {
                hero.setHp(0);
            } else {
                hero.setHp(hero.getHp() - damageDone);
            }
        } else {
            throw new NoDamageException();
        }
    }
}