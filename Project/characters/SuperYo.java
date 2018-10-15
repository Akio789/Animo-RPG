package characters;
import items.*;
import abilities;
import abilities.Vindication;

public class SuperYo extends Hero{
    //CONSTRUCTOR
    public SuperYo(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis, HealingFlask healingFlask){
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        Ability vindication = new Vindication();
        Ability restrain = new Restrain();
        Ability[] abilities = {vindication, restrain};
        this.setAbilities(abilities);
    }

    //METHODS
    public void attackEnemy(Enemy enemy){
		if (enemy.getDefense() < (1 * getAttack())){
		System.out.println(getName() + " dealed " + (1 * getAttack() - ( enemy.getDefense())) + " damage.");
			enemy.setHp((enemy.getHp() + enemy.getDefense()) - (1 * getAttack()));   
        }
        else{
            System.out.println(getName() + " is too weak, he dealed no damage!");
        }
    }
    public void levelUp(){
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 5);
        setMaxEther(getMaxEther() + 5);
        setAttack(getAttack() + 2);
        setDefense(getDefense() +2);
    }
    public void attackEnemyWithAbility(Enemy enemy, int index){

    }
}