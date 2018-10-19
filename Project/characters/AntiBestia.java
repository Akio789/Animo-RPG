package characters;

import abilitiesboss.*;
import java.util.*;

public class AntiBestia extends Boss{
    //ATTRIBUTES
    private AntiRush rush;
    private AntiThump thump;
    
    //CONSTRUCTOR
    public AntiBestia(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.5);
        rush = new AntiRush();
        thump = new AntiThump();
    }
    
    //GETTERS AND SETTERS
    public AntiRush getRush() {
        return rush;
    }
    public void setRush(AntiRush rush) {
        this.rush = rush;
    }
    public AntiThump getThump() {
        return thump;
    }
    public void setThump(AntiThump thump) {
        this.thump = thump;
    }

    //METHODS
    public void criticAttack(Hero hero){
        if (hero.getDefense() < (1.5 * getAttack() * getCritic())){
            System.out.println("¡Critic attack! Anti Bestia dealed " + (1.5 * getAttack() * getCritic() - (hero.getDefense())) + " damage.");
            hero.setHp((hero.getHp() + hero.getDefense()) - (1.5 * getAttack()) * getCritic());   
        }
        else{
            System.out.println("Anti Bestia is too weak, he dealed no damage!");
        }
    }
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1.5 * getAttack())){
            System.out.println("Anti Bestia dealed " + (1.5 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1.5 * getAttack()));   
        }
        else{
            System.out.println("Anti Bestia is too weak, he dealed no damage!");
        }
    }
    public void attackHeroWithAbility(Enemy enemy, Hero hero){
        Random r = new Random();
        double rand = r.nextDouble();
        if (hero.getMaxEther()>10) {
            if (rand < 0.5) {
                thump.strongAttack(enemy, hero);
            }
            if (rand >= 0.5) {
                rush.stacking(enemy, hero);
            }
        }//fin if
        
        else {
            System.out.println("There's not enough ether to use any abilitie");
        }//fin else
    }
}