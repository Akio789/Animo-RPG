package characters;

import abilitiesboss.*;

import java.io.Serializable;
import java.util.*;
import javax.swing.*;

public class AntiSuperYo extends Boss implements Serializable {
    // CONSTRUCTOR
    public AntiSuperYo(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(2);
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