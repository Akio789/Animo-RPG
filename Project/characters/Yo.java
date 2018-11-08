package characters;

import items.*;
import abilities.*;

public class Yo extends Hero {
    // ATTRIBUTES
    private Reason reason;
    private Naturae naturae;

    // CONSTRUCTOR
    public Yo(String name, int level, int xp, double hp, double ether, double attack, double defense,
            boolean statusParalysis, HealingFlask healingFlask) {
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        reason = new Reason();
        naturae = new Naturae();
    }

    // GETTERS AND SETTERS
    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public Naturae getNaturae() {
        return naturae;
    }

    public void setNaturae(Naturae naturae) {
        this.naturae = naturae;
    }

    // METHODS
    public void attackEnemy(Enemy enemy) throws NoDamageException {
        double dmgMult = 1.2;
        double damageDone = enemy.getDefense() - (dmgMult * getAttack());
        if (enemy.getDefense() < (dmgMult * getAttack())) {
            System.out.println(getName() + " dealed " + (dmgMult * getAttack() - (enemy.getDefense())) + " damage.");
            if ((enemy.getHp() + damageDone) <= 0) {
                enemy.setHp(0);
            } else {
                enemy.setHp(enemy.getHp() + damageDone);
            }
        } else {
            throw new NoDamageException();
        }
    }

    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 5);
        setMaxEther(getMaxEther() + 4);
        setAttack(getAttack() + 2);
        setDefense(getDefense() + 3);
    }

    @Override
    public void attackEnemyWithAbility(Enemy enemy, Hero hero, int index) {
        if (hero.getMaxEther() > 10) {
            if (index == 0) {
                reason.reduceDamage(enemy, hero);
            }
            if (index == 1) {
                naturae.reduceDefense(enemy, hero);
            }
        } // fin if

        else {
            System.out.println("There's not enough ether to use any abilitie");
        } // fin else

    }
}