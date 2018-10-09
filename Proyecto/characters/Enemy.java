public abstract class Enemy extends Character{
    //CONTSTRUCTOR
    public Enemy(int level, double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(level, hp, ether, attack, defense, statusParalysis);
    }
    
    //METHODS
    public void regularAttack(Hero hero){
        System.out.println(hero.getName() + " was attacked and lost " + (getAttack() - hero.getDefense()) + " health points.");
        if (hero.getDefense() < getAttack()){
            hero.setHp((hero.getHp() + hero.getDefense()) - getAttack());   
        }
    }
}