package characters;

import abilitiesboss.*;

import java.io.Serializable;
import java.util.*;

public class AntiYo extends Boss implements Serializable {
    // ATTRIBUTES
    private AntiReason reason;
    private AntiNaturae naturae;

    // CONSTRUCTOR
    public AntiYo(double hp, double ether, double attack, double defense, boolean statusParalysis) {
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.2);
        reason = new AntiReason();
        naturae = new AntiNaturae();
    }

    // GETTERS AND SETTERS
    public AntiReason getReason() {
        return reason;
    }

    public void setReason(AntiReason reason) {
        this.reason = reason;
    }

    public AntiNaturae getNaturae() {
        return naturae;
    }

    public void setNaturae(AntiNaturae naturae) {
        this.naturae = naturae;
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