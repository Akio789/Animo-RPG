package characters;

public abstract class Boss extends Enemy{
    //ATTRIBUTES
    private double critic;
    
    //CONSTRUCTOR
    public Boss(int level, double hp, double ether, double attack, double defense, boolean statusParalysis){
        super(level, hp, ether, attack, defense, statusParalysis);
    }

    //GETTETS AND SETTERS
    public double getCritic() {
        return critic;
    }
    public void setCritic(double critic) {
        this.critic = critic;
    }

    //METHODS
    public abstract void criticAttack(Hero hero);
}