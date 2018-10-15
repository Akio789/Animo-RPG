package characters;

public abstract class Enemy extends Character{
    
    //CONTSTRUCTOR
    public Enemy(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
    }
    
    //METHODS
    public void displayHp(){
        System.out.println("Enemy hp: " + getHp());
    }
    public abstract void regularAttack(Hero hero);
    
}