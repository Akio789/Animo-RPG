package characters;
import abilitiesboss.*;

public abstract class Boss extends Enemy{
    //ATTRIBUTES
    private double critic;
    private AntiAbility[] bossAbilities;
    
    //CONSTRUCTOR
    public Boss(double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(hp, ether, attack, defense, statusParalysis);
    }
    
    //GETTETS AND SETTERS
    public double getCritic() {
        return critic;
    }
    public void setCritic(double critic) {
        this.critic = critic;
    }
    public AntiAbility[] getBossAbilities() {
        return bossAbilities;
    }
    public void setBossAbilities(AntiAbility[] bossAbilities) {
        this.bossAbilities = bossAbilities;
    }
    
    //METHODS
    public abstract void criticAttack(Hero hero);
    public abstract void attackHeroWithAbility(Hero hero);
}