package characters;

public abstract class Character{
	private double hp;
	private double attack;
	private double defense;
	private boolean statusParalysis; //Both the hero and the enemies can get paralized	//ATTRIBUTES
	private double ether;	

	//CONSTRUCTOR
	public Character(double hp, double ether, double attack, double defense, boolean statusParalysis){
		this.hp = hp;
		this.ether = ether;
		this.attack = attack;
		this.defense = defense;
		this.statusParalysis = statusParalysis;
	}

	//GETTERS AND SETTERS
	public double getHp(){
		return hp;
	}
	public void setHp(double hp){
		this.hp = hp;
	}
	public double getAttack(){
		return attack;
	}
	public void setAttack(double attack){
		this.attack = attack;
	}
	public double getDefense(){
		return defense;
	}
	public void setDefense(double defense){
		this.defense = defense;
	}
	public double getEther(){
		return ether;
	}
	public void setEther(double ether){
		this.ether = ether;
	}
	public boolean getStatusParalysis(){
		return statusParalysis;
	}
	public void setStatusParalysis(boolean statusParalysis){
		this.statusParalysis = statusParalysis;
	}
}