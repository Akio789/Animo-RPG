package characters;

import items.*;
import abilities.*;
import java.util.*;
import java.io.Serializable;
import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public abstract class Hero extends Character implements Serializable {
	// ATTRIBUTES
	private static String name;
	private static int xp;
	private static double maxHp;
	private static double maxEther;
	private static HealingFlask healingFlask;
	private static EquipmentItem[] backpack;
	private static EquipmentItem[] equipment;
	private static int level;
	private static int posX, posY;

	// CONSTRUCTOR
	public Hero(String name, int level, int xp, double hp, double ether, double attack, double defense,
			boolean statusParalysis, HealingFlask healingFlask) {
		super(hp, ether, attack, defense, statusParalysis);
		this.level = level;
		this.name = name;
		this.xp = xp;
		this.maxHp = hp;
		this.maxEther = ether;
		this.healingFlask = healingFlask;
		backpack = new EquipmentItem[4];
		equipment = new EquipmentItem[3];
	}

	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public double getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(double maxHp) {
		this.maxHp = maxHp;
	}

	public double getMaxEther() {
		return maxEther;
	}

	public void setMaxEther(double maxEther) {
		this.maxEther = maxEther;
	}

	public HealingFlask getHealingFlask() {
		return healingFlask;
	}

	public void setHealingFlask(HealingFlask healingFlask) {
		this.healingFlask = healingFlask;
	}

	public static EquipmentItem[] getBackpack() {
		return backpack;
	}

	public static void setBackpack(EquipmentItem[] backpack) {
		Hero.backpack = backpack;
	}

	public static EquipmentItem[] getEquipment() {
		return equipment;
	}

	public static void setEquipment(EquipmentItem[] equipment) {
		Hero.equipment = equipment;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	// METHODS
	/// Adds item to desired slot
	public void addItemToBackpack(int index, EquipmentItem item) throws SlotFullException {
		if (backpack[index] != null) {
			throw new SlotFullException();
		} else {
			backpack[index] = item;
		}
	}

	/// Removes item in desired slot.
	public void removeItemFromBackpack(int index) {
		backpack[index] = null;
	}

	/// Moves item from backpack to equipment.
	public void equipItem(int equipmentIndex, int backpackIndex) throws SlotFullException {
		if (equipment[equipmentIndex] != null) {
			throw new SlotFullException();
		} else {
			equipment[equipmentIndex] = backpack[backpackIndex];
			removeItemFromBackpack(backpackIndex);
			equipment[equipmentIndex].modifyStatEquip(this);
		}
	}

	/// Moves item from equipment to backpack.
	public void unequipItem(int equipmentIndex, int backpackIndex) throws SlotFullException {
		if (backpack[backpackIndex] != null) {
			throw new SlotFullException();
		} else {
			equipment[equipmentIndex].modifyStatUnequip(this);
			backpack[backpackIndex] = equipment[equipmentIndex];
			equipment[equipmentIndex] = null;
		}
	}

	/// Print stats.
	public String[] printStats() {
		String[] stats = { getName() + "  ", "Lvl: " + getLevel(), "Exp: " + getXp(), "Hp: " + ((int) getHp()),
				"Ether: " + ((int) getEther()), "Att: " + ((int) getAttack()), "Def: " + ((int) getDefense()) };
		return stats;
	}

	/// Drink flask.
	public void drinkFlask() throws EmptyFlaskException {
		if (getHealingFlask().getCharges() == 0) {
			throw new EmptyFlaskException();
		} else {
			healingFlask.setCharges(healingFlask.getCharges() - 1);
			if (getMaxHp() >= (getHp() + healingFlask.getPoints())) {
				setHp(getHp() + healingFlask.getPoints());
			} else if (getMaxHp() < (getHp() + healingFlask.getPoints())) {
				setHp(getMaxHp());
			}
			if (getMaxEther() >= (getEther() + healingFlask.getPoints())) {
				setEther(getEther() + healingFlask.getPoints());
			} else if (getMaxEther() < (getEther() + healingFlask.getPoints())) {
				setEther(getMaxEther());
			}
		}
	}

	/// Die.
	public boolean die() {
		if (getHp() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/// Escape from battle.
	public boolean escapeFromBattle() {
		Random rand = new Random();
		double escape = rand.nextDouble();
		if (escape > 0.8) {
			return true;
		} else {
			return false;
		}
	}

	/// Level up.
	public abstract void levelUp();

	/// Attack enemy with a regular attack.
	public void attackEnemy(Enemy enemy) throws NoDamageException {
		double damageDone = getAttack() - ((enemy.getDefense() * .06) * getAttack());
		if ((enemy.getDefense() * .06) < 1) {
			System.out.println(getName() + " dealed " + damageDone);
			if ((enemy.getHp() - damageDone) <= 0) {
				enemy.setHp(0);
			} else {
				enemy.setHp(enemy.getHp() - damageDone);
			}
		} else {
			throw new NoDamageException();
		}
	}

	/// Attack enemy with ability.
	public void attackEnemyWithAbility(Enemy enemy, Hero hero, int index) throws NotEnoughEtherException {
		if (hero.getEther() >= 10 && hero.getEther() > 0) {
			hero.getAbilities()[index].specialAbility(enemy, hero);
		} // fin if

		else {
			throw new NotEnoughEtherException();
		} // fin else

	}
}