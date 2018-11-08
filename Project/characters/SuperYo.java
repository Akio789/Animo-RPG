package characters;

import items.*;
import abilities.*;

public class SuperYo extends Hero {
    // ATTRIBUTES
    private Restrain restrain;
    private Vindication vindication;

    // CONSTRUCTOR
    public SuperYo(String name, int level, int xp, double hp, double ether, double attack, double defense,
            boolean statusParalysis, HealingFlask healingFlask) {
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        restrain = new Restrain();
        vindication = new Vindication();
    }

    // GETTERS AND SETTERS
    public Restrain getRestrain() {
        return restrain;
    }

    public void setRestrain(Restrain restrain) {
        this.restrain = restrain;
    }

    public Vindication getVindication() {
        return vindication;
    }

    public void setVindication(Vindication vindication) {
        this.vindication = vindication;
    }

    // METHODS
    public void attackEnemy(Enemy enemy) throws NoDamageException {
        double dmgMult = 1;
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
        setMaxEther(getMaxEther() + 5);
        setAttack(getAttack() + 2);
        setDefense(getDefense() + 2);
    }

    @Override
    public void attackEnemyWithAbility(Enemy enemy, Hero hero, int index) {
        if (hero.getMaxEther() > 10) {
            if (index == 0) {
                restrain.paralize(enemy, hero);
            }
            if (index == 1) {
                vindication.reduceStats(enemy, hero);
            }
        } // fin if

        else {
            System.out.println("There's not enough ether to use any abilitie");
        } // fin else

    }
}