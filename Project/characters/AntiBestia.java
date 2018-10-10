package characters;

public class AntiBestia extends Boss{
    //CONSTRUCTOR
    public AntiBestia(int level, double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(level, hp, ether, attack, defense, statusParalysis);
        setCritic(1.5);
    }
    
    //METHODS
    public void criticAttack(Hero hero){
        if (hero.getDefense() < (1.5 * getAttack() * getCritic())){
            System.out.println("¡Critic attack! Anti Bestia dealed " + (1.5 * getAttack() * getCritic() - (hero.getDefense())) + " damage.");
            hero.setHp((hero.getHp() + hero.getDefense()) - (1.5 * getAttack()) * getCritic());   
        }
        else{
            System.out.println("Anti Bestia is too weak, he dealed no damage!");
        }
    }
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1.5 * getAttack())){
            System.out.println("Anti Bestia dealed " + (1.5 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1.5 * getAttack()));   
        }
        else{
            System.out.println("Anti Bestia is too weak, he dealed no damage!");
        }
    }
}