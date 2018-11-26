package characters;

import items.*;
import java.io.Serializable;
import javax.swing.*;
import java.util.*;
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
        setMaxHp(getMaxHp() + 65);
        setMaxEther(getMaxEther() + 60);
        setAttack(getAttack() + 5);
        setDefense(getDefense() + 1);
        setHp(getMaxHp());
        setEther(getMaxEther());
    }
}