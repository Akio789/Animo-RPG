package characters;

import abilitiesboss.*;
import java.util.*;

public class AntiYo extends Boss{
    //ATTRIBUTES
    private AntiReason reason;
    private AntiNaturae naturae;

    //CONSTRUCTOR
    public AntiYo(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.2);
        reason = new AntiReason();
        naturae = new AntiNaturae();
    }
    
    //GETTERS AND SETTERS
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

    //METHODS
    public void criticAttack(Hero hero){
        if (hero.getDefense() < (1 * getAttack() * getCritic())){
            System.out.println("¡Critic attack! Anti Yo dealed " + (1 * getAttack() * getCritic() - (hero.getDefense())) + " damage.");
            hero.setHp((hero.getHp() + hero.getDefense()) - (1 * getAttack()) * getCritic());   
        }
        else{
            System.out.println("Anti Yo is too weak, he dealed no damage!");
        }
    }
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1 * getAttack())){
            System.out.println("Anti Yo dealed " + (1 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1 * getAttack()));   
        }
        else{
            System.out.println("Anti Yo is too weak, he dealed no damage!");
        }
    }
    public void attackHeroWithAbility(Enemy enemy, Hero hero){
        Random r = new Random();
        double rand = r.nextDouble();
        if (hero.getMaxEther()>10) {
            if (rand < 0.5) {
                naturae.reduceDefense(hero);
            }
            if (rand >= 0.5) {
                reason.reduceDamage(enemy, hero);
            }
        }//fin if
        
        else {
            System.out.println("There's not enough ether to use any abilitie");
        }//fin else
    }
}