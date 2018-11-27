package characters;

import items.*;
import java.io.Serializable;
import javax.swing.*;
import java.util.*;
import abilities.*;

public class Bestia extends Hero implements Serializable {
    // CONSTRUCTOR
    public Bestia(String name, int level, int xp, double hp, double ether, double attack, double defense,
            boolean statusParalysis, HealingFlask healingFlask) {
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        getAbilities()[0] = new Thump();
        getAbilities()[1] = new Rush();
    }

    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 50);
        setMaxEther(getMaxEther() + 60);
        setAttack(getAttack() + 7);
        setDefense(getDefense() + 1);
        setHp(getMaxHp());
        setEther(getMaxEther());
    }
}