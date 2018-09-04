import java.util.Random;

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

	//Methods
	public void attack(Enemy enemy){
		enemy.setHp(enemy.getHp() - getAttack());
	}
	public void addItemToBackpack(Item item, int index){	//MAKE SURE IT WORKS
		backpack[index] = item;
	}	
	public void removeItemFromBackpack(int index){ 			//MAKE SURE IT WORKS
		backpack[index] = null;									//Deletes the object in derised index
	}
	public void equipItem(Item item, int index){
		equipment[index] = item;
	}
	public void unequipItem(int index){						//MAKE SURE IT WORKS
		//Only if backpack isn't full
		for (int i = 0; i > backpack.length; i++) {			//Go through every slot in the backpack
			if (backpack[i] == null) { 							//If it finds an empty slot
				backpack[i] = equipment[i];							//Copy the item from equipment to backback
				equipment[i] = null;								//Delete item from equipment
			}
			if (i == (equipment.length - 1)) {					//If it checks the last slot and is still doesn't find a space to unequip, then show message
				System.out.println("Backpack is full.");
			}
		}
	}
	public void useItem(){									//Don't know how to do this yet
	}
	public void attackWithAbility(Enemy	enemy, int index){	//Don't know how to do this yet
	}
	public boolean scapeAttempt(){							//Won't do this yet until enemies are programmed and probabilities table is defined
		Random rand = new Random();
	}
}