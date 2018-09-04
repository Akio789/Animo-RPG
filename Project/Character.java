public class Character{
	//Attributes
	private double hp;
	private double attack;
	private double defense;
	private double ether;		
	private int level;
	private boolean statusParalysis; //Both the hero and the enemies can get paralized

	//Getters and setters
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
	public int getLevel(){
		return level;
	}
	public void setLevel(){
		this.level = level;
	}
	public boolean getStatusParalysis(){
		return statusParalysis;
	}
	public void setStatusParalysis(boolean statusParalysis){
		this.statusParalysis = statusParalysis;
	}
}