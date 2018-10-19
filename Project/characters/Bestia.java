package characters;
import items.*;
import abilities.*;
public class Bestia extends Hero{
    //ATTRIBUTES
    private Thump thump;
    private Rush rush;

    //CONSTRUCTOR
    public Bestia(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis, HealingFlask healingFlask){
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        thump = new Thump();
        rush = new Rush(); 
    }

    //GETTERS AND SETTERS
    public Thump getThump(){
        return thump;
    }
    public void setThump(Thump thump){
        this.thump = thump;
    }
    public Rush getRush() {
        return rush;
    }
    public void setRush(Rush rush) {
        this.rush = rush;
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
    
    @Override
    public void attackEnemyWithAbility(Enemy enemy, Hero hero, int index){
        if (hero.getMaxEther()>10) {
            if (index == 0) {
                thump.strongAttack(enemy, hero);
            }
            if (index == 1) {
                rush.stacking(enemy, hero);
            }
        }//fin if
        
        else {
            System.out.println("There's not enough ether to use any abilitie");
        }//fin else
        
    }
}