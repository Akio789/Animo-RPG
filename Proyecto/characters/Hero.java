package characters;
import items.*;
import java.util.Arrays;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public abstract class Hero extends Character{
    //ATTRIBUTES
	private String name;
	private int xp;
	private double maxHp;
	private double maxEther;
	private HealingFlask healingFlask;
	private Item[] backpack;		
	private Item[] equipment;	
	
	//CONSTRUCTOR
	public Hero(String name, int level, int xp, double hp, double ether, double attack, double defense, boolean statusParalysis, HealingFlask healingFlask){
		super(level, hp, ether, attack, defense, statusParalysis);
		this.name = name;
		this.xp = xp;
		this.maxHp = hp;
		this.maxEther = ether;
		this.healingFlask = healingFlask;
		backpack = new Item[4];
		equipment = new Item[4];
		backpack[0] = healingFlask;
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
	public HealingFlask healingFlask(){
		return healingFlask;
	}
	public void setHpFlask(HealingFlask healingFlask){
		this.healingFlask = healingFlask;
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
	public void addItemToBackpack(int index, AttackItem attackItem){
		if (backpack[index] == null) {						
			backpack[index] = attackItem;	
		}
		else {
			System.out.println("Slot in backpack is full.");
		}
	}
	public void addItemToBackpack(int index, DefenseItem defenseItem){
		if (backpack[index] == null) {						
			backpack[index] = defenseItem;	
		}
		else {
			System.out.println("Slot in backpack is full.");
		}
	}
	///Removes item in desired slot.
	public void removeItemFromBackpack(int index){ 
		backpack[index] = null;									
	}
	///Moves item from backpack to equipment. NEED TO OVERLOAD FOR EVERY TYPE OF ITEM
	public void equipItem(int index, AttackItem attackItem){
		if (equipment[index] != null) {
			System.out.println("Slot in equipment is full");
		}
		else {
			equipment[index] = attackItem;
			removeItemFromBackpack(Arrays.asList(getBackpack()).indexOf(attackItem));
			this.setAttack(this.getAttack() + attackItem.getPoints());
		}
	}
	public void equipItem(int index, DefenseItem defenseItem){
		if (equipment[index] != null) {
			System.out.println("Slot in equipment is full");
		}
		else {
			equipment[index] = defenseItem;
			removeItemFromBackpack(Arrays.asList(getBackpack()).indexOf(defenseItem));
			this.setDefense(this.getDefense() + defenseItem.getPoints());
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
		System.out.println("1.- Healing flask, charges: " + healingFlask.getCharges());
		for (int i = 1; i < backpack.length; i++) {
			if (backpack[i] == null) {
				System.out.println((i + 1) + ".- Empty.");
			}
			else{
				if (backpack[i] instanceof AttackItem) {
					System.out.println((i + 1) + ".- " + backpack[i].getName() + ", " + backpack[i].getPoints() 
					+ " attack points, " + backpack[i].getDescription());	
				}
				if (backpack[i] instanceof DefenseItem) {
					System.out.println((i + 1) + ".- " + backpack[i].getName() + ", attack: " + backpack[i].getPoints() 
					+ " defense points, " + backpack[i].getDescription());
				}
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
				if (equipment[i] instanceof AttackItem) {
					System.out.println((i + 1) + ".- " + equipment[i].getName() + ", " + equipment[i].getPoints() 
					+ " attack points, " + equipment[i].getDescription());	
				}
				if (equipment[i] instanceof DefenseItem) {
					System.out.println((i + 1) + ".- " + equipment[i].getName() + ", attack: " + equipment[i].getPoints() 
					+ " defense points, " + equipment[i].getDescription());
				}
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
		if (index != 0) {
			System.out.println("Not an usable item.");
		}
		if ((index == 0) && (healingFlask.getCharges() > 0)){
			healingFlask.setCharges(healingFlask.getCharges() - 1);
			if (getMaxHp() >= (getHp() + healingFlask.getPoints())) {
				setHp(getHp() + healingFlask.getPoints());  
				System.out.print(getName() + " healed " + healingFlask.getPoints() + " hp and ");          
			}
			else if (getMaxHp() < (getHp() + healingFlask.getPoints())) {
				System.out.print(getName() + " healed " + (getMaxHp() - getHp()) + " hp and ");     
				setHp(getMaxHp());
			}
			if (getMaxEther() >= (getEther() + healingFlask.getPoints())) {
				setEther(getEther() + healingFlask.getPoints());
				System.out.println(healingFlask.getPoints() + " ether.");
			}
			else if (getMaxEther()  < (getEther() + healingFlask.getPoints())) {
				System.out.println((getMaxEther() - getEther()) + " ether");
			}
		}
	}
}