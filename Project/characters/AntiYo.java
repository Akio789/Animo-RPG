package characters;

public class AntiYo extends Boss{
    //CONSTRUCTOR
    public AntiYo(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
        setCritic(1.2);
    }
    
    //METHODS
    public void criticAttack(Hero hero){
        if (hero.getDefense() < (1 * getAttack() * getCritic())){
            System.out.println("¡Critic attack! Anti Yo dealed " + (1 * getAttack() * getCritic() - (hero.getDefense())) + " damage.");
            hero.setHp((hero.getHp() + hero.getDefense()) - (1 * getAttack()) * getCritic());   
        }
        else{
            System.out.println("Anti Yo is too weak, he dealed no damage!");
        }
    }
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1 * getAttack())){
            System.out.println("Anti Yo dealed " + (1 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1 * getAttack()));   
        }
        else{
            System.out.println("Anti Yo is too weak, he dealed no damage!");
        }
    }
    public void attackHeroWithAbility(Hero hero){
        
    }
}