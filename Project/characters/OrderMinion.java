package characters;

public class OrderMinion extends Enemy{
    
    //CONSTRUCTOR
    public OrderMinion(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
    }
    //METHODS
    public void regularAttack(Hero hero){
		if (hero.getDefense() < (1.5 * getAttack())){
            System.out.println("Order minion dealed " + (1.5 * getAttack() - (hero.getDefense())) + " damage.");
			hero.setHp((hero.getHp() + hero.getDefense()) - (1.5 * getAttack()));   
        }
        else{
            System.out.println("Order minion is too weak, he dealed no damage!");
        }
	}
}