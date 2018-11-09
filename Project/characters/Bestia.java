package characters;

import items.*;
import abilities.*;

public class Bestia extends Hero {
    // CONSTRUCTOR
    public Bestia(String name, int level, int xp, double hp, double ether, double attack, double defense,
            boolean statusParalysis, HealingFlask healingFlask) {
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        getAbilities()[0] = new Thump();
        getAbilities()[1] = new Rush();
    }

    // METHODS
    public void attackEnemy(Enemy enemy) throws NoDamageException {
        double dmgMult = 1.4;
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
        setMaxHp(getMaxHp() + 3);
        setMaxEther(getMaxEther() + 5);
        setAttack(getAttack() + 4);
        setDefense(getDefense() + 2);
    }

    @Override
    public void attackEnemyWithAbility(Enemy enemy, Hero hero, int index) {
        if (hero.getEther() >= 10 && hero.getEther() > 0) {
            hero.getAbilities()[index].specialAbility(enemy, hero);
        } // fin if
        else {
            System.out.println("There's not enough ether to use that ability.");
        } // fin else
        if ((enemy.getHp() <= 0)) {
            enemy.setHp(0);
        }
    }
}