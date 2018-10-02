package characters;
import items.*;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Hero extends Character{
	//ATTRIBUTES
	private String name;
	private int xp;
	private double maxHp;
	private double maxEther;
	private Item[] backpack = new Item[3];		
	private Item[] equipment = new Item[3];	
	
	//CONSTRUCTOR
	public Hero(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis){
		super(level, hp, ether, attack, defense, statusParalysis);
		this.name = name;
		this.xp = xp;
		this.maxHp = hp;
		this.maxEther = ether;
		backpack[0] = HpFlask;
		backpack[1] = EtherFlask;
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
	public double getMaxHp(){
		return maxHp;
	}
	public void setMaxHp(double maxHp){
		this.maxHp = maxHp;
	}
	public double getMaxEther(){
		return maxEther;
	}
	public void setMaxEther(double maxEther){
		this.maxEther = maxEther;
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
		System.out.println("Hp flask charges: " + backpack[0].getCharges());
		System.out.println("Ether flask charges: " + backpack[1].getCharges());
		for (int i = 2; i < backpack.length; i++) {
			if (backpack[i] == null) {
				System.out.println((i + 1) + ".- Empty.");
			}
			else{
				System.out.println((i + 1) + ".- " + backpack[i].getName() + ", " + backpack[i].getPoints() 
				+ ", " + backpack[i].getDescription());
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
				+ ", " + equipment[i].getDescription());
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
	///Use item
	public void useItem(int index){
		if (backpack[index] instanceof HpFlask && (backpack[index].getCharges() > 0)){
			backpack[index].setCharges(backpack[index].getCharges() - 1);
			if (getMaxHp() >= getHp() + backpack[index].getPoints()) {
				setHp(getHp() + backpack[index].getPoints());  
				System.out.println(getName() + " healed " + backpack[index].getPoints() + " hp.");          
			}
			else if (getMaxHp() < getHp() + backpack[index].getPoints()) {
				System.out.println(getName() + " healed " + (getMaxHp() - getHp()) + " hp.");
				setHp(getMaxHp());
			}
		}
		if (backpack[index] instanceof EtherFlask && (backpack[index].getCharges() > 0)){
			backpack[index].setCharges(backpack[index].getCharges() - 1);
			if (getMaxEther() >= getEther() + backpack[index].getPoints()) {
				setEther(getEther() + backpack[index].getPoints());            
				System.out.println(getName() + " healed " + backpack[index].getPoints() + " ether.");          
				
			}
			else if (getMaxEther() < getEther() + backpack[index].getPoints()) {
				System.out.println(getName() + " healed " + (getMaxEther() - getEther()) + " ether.");				
				setEther(getMaxEther());
			}
		}
	}
}