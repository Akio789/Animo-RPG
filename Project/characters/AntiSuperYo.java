package characters;

import abilitiesboss.*;
import java.util.*;

public class AntiSuperYo extends Boss{
    //ATTRIBUTES
    private AntiVindication vindication;
    private AntiRestrain restrain;

    //CONSTRUCTOR
    public AntiSuperYo(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.4);;
        vindication = new AntiVindication();
        restrain = new AntiRestrain();
    }
    
    //GETTERS AND SETTERS
    public AntiVindication getVindication() {
        return vindication;
    }
    public void setVindication(AntiVindication vindication) {
        this.vindication = vindication;
    }
    public AntiRestrain getRestrain() {
        return restrain;
    }
    public void setRestrain(AntiRestrain restrain) {
        this.restrain = restrain;
    }

    //METHODS
    public void criticAttack(Hero hero){
        if (hero.getDefense() < (1 * getAttack() * getCritic())){
            System.out.println("¡Critic attack! Anti Super Yo dealed " + (1 * getAttack() * getCritic() - (hero.getDefense())) + " damage.");
            hero.setHp((hero.getHp() + hero.getDefense()) - (1 * getAttack()) * getCritic());   
        }
        else{
            System.out.println("Anti Super Yo is too weak, he dealed no damage!");
        }
    }
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1.2 * getAttack())){
            System.out.println("Anti Super Yo dealed " + (1.2 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1.2 * getAttack()));   
        }
        else{
            System.out.println("Anti Super Yo is too weak, he dealed no damage!");
        }
    }
    public void attackHeroWithAbility(Enemy enemy, Hero hero){
        Random r = new Random();
        double rand = r.nextDouble();
        if (hero.getMaxEther()>10) {
            if (rand < 0.5) {
                restrain.paralize(hero);
            }
            if (rand >= 0.5) {
                vindication.reduceStats(enemy, hero);
            }
        }//fin if
        
        else {
            System.out.println("There's not enough ether to use any abilitie");
        }//fin else
    }
}