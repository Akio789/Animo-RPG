package characters;

public class AntiSuperYo extends Boss{
    //CONSTRUCTOR
    public AntiSuperYo(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.4);;
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
    public void attackHeroWithAbility(Hero hero){
        
    }
}