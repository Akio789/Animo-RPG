import java.util.Random;

public class Hero extends Character{
	//Attributes
	private String name;
	private int xp;
	private Item[] backpack //= new Item[2];		//Class Item still not created
	//private Ability[] abilities;	//Class Ability still not created
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
	/*public Ability[] getAbilities(){
		return abilities;
	}
	public void setAbilities(Ability[] abilities){
		this.abilities = abilities;
	}*/
	public Item[] getEquipment(){
		return equipment;
	}
	public void setEquipment(Item[] equipment){
		this.equipment = equipment;
	}

	//Methods
	/*public void attack(Enemy enemy){
		enemy.setHp(enemy.getHp() - getAttack());
	}*/
	public void addItemToBackpack(Item item, int index){	//Adds item to desired slot
		if (backpack[index] == null) {							//Only can place item in backpack if slot is empty
			backpack[index] = item;	
		}
		else {
			System.out.println("Slot is full.");				//If slot is not free, let user know
		}
	}	
	public void removeItemFromBackpack(int index){ 			//Deletes the object in derised slot
		backpack[index] = null;									
	}
	public void equipItem(Item item, int index){			//MAKE SURE IT WORKS
		equipment[index] = item;
	}
	public void unequipItem(int index, Item item){			//MAKE SURE IT WORKS
		if (backpack[index] == null) {							//Only can place item in backpack if slot is empty
			backpack[index] = item;	
		}
		else {
			System.out.println("Slot is full.");				//If slot is not free, let user know
		}
	}
	public void useItem(){									//Don't know how to do this yet
	}
	/*public void attackWithAbility(Enemy enemy, int index){	//Don't know how to do this yet
	}*/
	public boolean scapeAttempt(){							//Won't do this yet until probabilities table is defined
		Random rand = new Random();
		return false;
	}
}