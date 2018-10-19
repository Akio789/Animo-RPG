package characters;
import items.*;
import abilities.*;

public class Yo extends Hero{
    //ATTRIBUTES
    private Reason reason;
    private Naturae naturae;

    //CONSTRUCTOR
    public Yo(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis, HealingFlask healingFlask){
        super(name, level, xp, hp, ether, attack, defense, statusParalysis, healingFlask);
        reason = new Reason();
        naturae= new Naturae();
    }

    //GETTERS AND SETTERS
    public Reason getReason() {
        return reason;
    }
    public void setReason(Reason reason) {
        this.reason = reason;
    }
    public Naturae getNaturae() {
        return naturae;
    }
    public void setNaturae(Naturae naturae) {
        this.naturae = naturae;
    }

    //METHODS
    public void attackEnemy(Enemy enemy){
		if (enemy.getDefense() < (1.2 * getAttack())){
		System.out.println(getName() + " dealed " + (1.2 * getAttack() - ( enemy.getDefense())) + " damage.");
			enemy.setHp((enemy.getHp() + enemy.getDefense()) - (1.2 * getAttack()));   
        }
        else{
            System.out.println(getName() + " is too weak, he dealed no damage!");
        }
    }
    public void levelUp(){
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() + 5);
        setMaxEther(getMaxEther() + 4);
        setAttack(getAttack() + 2);
        setDefense(getDefense() +3);
    }
    @Override
    public void attackEnemyWithAbility(Enemy enemy, Hero hero, int index){
        if (hero.getMaxEther()>10) {
            if (index == 0) {
                reason.reduceDamage(enemy, hero);
            }
            if (index == 1) {
                naturae.reduceDefense(enemy, hero);
            }
        }//fin if
        
        else {
            System.out.println("There's not enough ether to use any abilitie");
        }//fin else
        
    }
}