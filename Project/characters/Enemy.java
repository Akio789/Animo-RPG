package characters;

public abstract class Enemy extends Character{
    
    //CONTSTRUCTOR
    public Enemy(int level, double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(level, hp, ether, attack, defense, statusParalysis);
    }
    
    //METHODS
    public void displayHp(){
        System.out.println("Enemy hp: " + getHp());
    }
    public abstract void regularAttack(Hero hero);
    
}