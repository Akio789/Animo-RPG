package characters;

import items.*;

import java.io.Serializable;

import abilities.*;

public class Yo extends Hero implements Serializable {
    // CONSTRUCTOR
    public Yo(String name, int level, int xp, double hp, double ether, double attack, double defense,
            boolean statusParalysis, HealingFlask healingFlask) {
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        getAbilities()[0] = new Naturae();
        getAbilities()[1] = new Reason();
    }

    // METHODS
    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 5);
        setMaxEther(getMaxEther() + 4);
        setAttack(getAttack() + 2);
        setDefense(getDefense() + 3);
    }
}