package characters;
import items.Item;
import items.AttackItem;
import items.DefenseItem;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Hero extends Character{
	//ATTRIBUTES
	private String name;
	private int xp;
	private Item[] backpack = new Item[2];		
	private Item[] equipment = new Item[2];	
	
	//CONSTRUCTOR
	public Hero(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis){
		super(level, hp, ether, attack, defense, statusParalysis);
		this.name = name;
		this.xp = xp;
	}
	
	//GETTERS AND SETTERS
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
	public Item[] getEquipment(){
		return equipment;
	}
	public void setEquipment(Item[] equipment){
		this.equipment = equipment;
	}
	
	//METHODS
	///Adds item to slot, only if it's empty.
	public void addItemToBackpack(int index, Item item){
		if (backpack[index] == null) {						
			backpack[index] = item;	
		}
		else {
			System.out.println("Slot in backpack is full.");
		}
	}	
	///Removes item in desired slot.
	public void removeItemFromBackpack(int index){ 
		backpack[index] = null;									
	}
	///Moves item from backpack to equipment.
	public void equipItem(int index, Item item){
		if (equipment[index] != null) {
			System.out.println("Slot in equipment is full");
		}
		else {
			equipment[index] = item;
			removeItemFromBackpack(Arrays.asList(getBackpack()).indexOf(item)); //Arrays.asList() finds out the index of a certain element in an array
			//Find out what type of item it is (attack, defense, etc)
			if (equipment[index] instanceof AttackItem) { //If its an attack item, increase attack
				setAttack(getAttack() + equipment[index].getPoints());
			}
			else if(equipment[index] instanceof DefenseItem) { //If its a defense item, increase defense
				setDefense(getDefense() + equipment[index].getPoints());
			}
		}
	}
	///Moves item from equipment to backpack.
	public void unequipItem(int equipmentIndex, int backpackIndex){
		if (backpack[backpackIndex] != null) {
			System.out.println("Slot in backpack is full.");			
		}
		else {
			if (equipment[equipmentIndex] instanceof AttackItem) { // If its an attack item, decrease attack
				setAttack(getAttack() - equipment[equipmentIndex].getPoints());
			}
			else if (equipment[equipmentIndex] instanceof DefenseItem) { // If its a defense item, decrease defense
				setDefense(getDefense() - equipment[equipmentIndex].getPoints());
			}
			backpack[backpackIndex] = equipment[equipmentIndex];
			equipment[equipmentIndex] = null;
		}
	}
	///Shows backpack contents.
	public void printBackpack(){
		System.out.println("BACKPACK: ");
		for (int i = 0; i < backpack.length; i++) {
			if (backpack[i] == null) {
				System.out.println((i + 1) + ".- Empty.");
			}
			else{
				System.out.println((i + 1) + ".- " + backpack[i].getName() + ", " + backpack[i].getPoints() 
				+ ", " + backpack[i].getDescription() + ".");
			}
		}
	}
	///Shows equipped items.
	public void printEquipment(){
		System.out.println("EQUIPMENT: ");
		for (int i = 0; i < equipment.length; i++) {
			if (equipment[i] == null) {
				System.out.println((i + 1) + ".- Empty.");
			}
			else{
				System.out.println((i + 1) + ".- " + equipment[i].getName() + ", " + equipment[i].getPoints() 
				+ ", " + equipment[i].getDescription() + ".");
			}
		}
	}
	///Print stats.
	public void printStats(){
		System.out.println(getName() + " STATS"
		+ "\nLevel: " + getLevel()
		+ "\nExperience: " + getXp()
		+ "\nHealth: " + getHp()
		+ "\nEther: " + getEther()
		+ "\nAttack: " + getAttack()
		+ "\nDefense: " + getDefense()
		);
	}
}