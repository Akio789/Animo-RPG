package characters;

import items.*;

import java.io.Serializable;

import abilities.*;

public class SuperYo extends Hero implements Serializable {
    // CONSTRUCTOR
    public SuperYo(String name, int level, int xp, double hp, double ether, double attack, double defense,
            boolean statusParalysis, HealingFlask healingFlask) {
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        getAbilities()[0] = new Vindication();
        getAbilities()[1] = new Restrain();
    }

    public void levelUp() {
        setXp(getXp()-100);
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 70);
        setMaxEther(getMaxEther() + 60);
        setAttack(getAttack() + 5.5);
        setDefense(getDefense() + 1);
    
        System.out.println("xp is =  " + getXp());
    }
}