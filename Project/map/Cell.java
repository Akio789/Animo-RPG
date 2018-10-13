package map;

import characters.*;
import items.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell extends JPanel{
    //ATTRIBUTES
    private EquipmentItem item;
    private Enemy enemy;
    private boolean restore;
    
    //CONSTRUCTOR 
    //Empty cell
    public Cell(){
        this.item = null;
        this.enemy = null;
        this.restore = false;
    }
    //Cell with an item
    public Cell(Item item){
        this.item = item;
        this.enemy = null;
        this.restore = false;
    }
    //Cell with an enemy
    public Cell(Enemy enemy){
        this.enemy = enemy;
        this.item = null;
        this.restore = false;
    }
    //Cell that restores
    public Cell(boolean restore){
        this.restore = restore;
        this.item = null;
        this.enemy = null;
    }

    //GETTERS AND SETTERS
    public Item getItem() {
        return item;
    }
    public void setItem(EqupmentItem item) {
        this.item = item;
    }
    public Enemy getEnemy() {
        return enemy;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    public boolean getRestore(){
        return restore;
    }
    public void setRestore(boolean restore){
        this.restore = restore;
    }

    //METHODS
    public void restore(Hero hero){
        hero.getHealingFlask().setCharges(hero.getHealingFlask().getMaxCharges());
        hero.setHp(hero.getMaxHp());
        hero.setEther(hero.getMaxEther());
    }
    public void startFight(Hero hero){}
}