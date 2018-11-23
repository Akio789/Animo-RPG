package characters;

import abilitiesboss.*;

import java.io.Serializable;
import java.util.*;

import javax.swing.JLabel;

public class AntiBestia extends Boss implements Serializable {
    // CONSTRUCTOR
    public AntiBestia(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.5);
    }

    // METHODS
    public void attack(Hero hero) throws NoDamageException {
        double dmgMult = 1.4*getAttack();
        double rawDefense = hero.getDefense()*.06;
        double damageDone = (dmgMult) - (dmgMult*rawDefense);
        if (rawDefense < 1) {
            System.out.println("Your instincts used pulsions and  dealed " + damageDone + " damage.");
            if ((hero.getHp() + damageDone) <= 0) {
                hero.setHp(0);
            } else {
                hero.setHp(hero.getHp() + damageDone);
            }
        } else {
            throw new NoDamageException();
        }
    }
    public void heavyAttack(Hero hero) throws NoDamageException {
        double dmgMult = 1.8*getAttack();
        double rawDefense = hero.getDefense()*.06;
        double damageDone = (dmgMult) - (dmgMult*rawDefense);
        if (rawDefense < 1) {
            System.out.println("Your reason  used moral chains and dealed " + damageDone + " damage.");
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