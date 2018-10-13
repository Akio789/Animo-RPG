package characters;
import items.*;

public class Bestia extends Hero{
    //CONSTRUCTOR
    public Bestia(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis, HealingFlask healingFlask){
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
    }
    //METHODS
    public void attackEnemy(Enemy enemy){
		if (enemy.getDefense() < (1.5 * getAttack())){
		System.out.println(getName() + " dealed " + (1.5 * getAttack() - ( enemy.getDefense())) + " damage.");
			enemy.setHp((enemy.getHp() + enemy.getDefense()) - (1.5 * getAttack()));   
        }
        else{
            System.out.println(getName() + " is too weak, he dealed no damage!");
        }
    }
    public void levelUp(){
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 3);
        setMaxEther(getMaxEther() + 5);
        setAttack(getAttack() + 4);
        setDefense(getDefense() +2);
    }
}