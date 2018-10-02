package characters;
import characters.Hero;

public class Enemy extends Character{
    
    //CONTSTRUCTOR
    public Enemy(int level, double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(level, hp, ether, attack, defense, statusParalysis);
    }
    
    //METHODS
    public void regularAttack(Hero hero){
        if (hero.getDefense() < getAttack()){
            hero.setHp((hero.getHp() + hero.getDefense()) - getAttack());   
        }
    }
    
}