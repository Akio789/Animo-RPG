public class Hero extends Character{
	//Attributes
	private String name;
	private int xp;
	private Item[] backpack;		//Class Item still not created
	private Ability[] abilities;	//Class Ability still not created
	private Item[] equipment;		//Class Item still not created

	//Getters and setters
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getXp(){
		return xp;
	}
	public void setXp(int xp){
		this.xp = xp;
	}
	public Item[] getBackpack(){
		return backpack;
	}
	public void setBackpack(Item[] backpack){
		this.backpack = backpack;
	}
	public Ability[] getAbilities(){
		return abilities;
	}
	public void setAbilities(Ability[] abilities){
		this.abilities = abilities;
	}
	public Item[] getEquipment(){
		return equipment;
	}
	public void setEquipment(Item[] equipment){
		this.equipment = equipment;
	}
}