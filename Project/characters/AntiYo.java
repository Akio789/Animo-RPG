package characters;

import abilitiesboss.*;

import java.io.Serializable;
import java.util.*;

public class AntiYo extends Boss implements Serializable {
    // CONSTRUCTOR
    public AntiYo(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.2);
    }

    // METHODS
    public void attack(Hero hero) throws NoDamageException {
        double dmgMult = 1.1*getAttack();
        double rawDefense = hero.getDefense()*.06;
        double damageDone = (dmgMult) - (dmgMult*rawDefense);
        if (rawDefense < 1) {
            System.out.println("Your conscience is gaining ground and  dealed " + damageDone + " damage.");
            if ((hero.getHp() + damageDone) <= 0) {
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
            System.out.println("Your conscience obliterated you and dealed " + damageDone + " damage.");
            if ((hero.getHp() + damageDone) <= 0) {
                hero.setHp(0);
            } else {
                hero.setHp(hero.getHp() - damageDone);
            }
        } else {
            throw new NoDamageException();
        }
    }
}