package items;

import java.io.Serializable;

import characters.*;

public class DefenseItem extends EquipmentItem implements Serializable {
	// CONSTRUCTOR
	public DefenseItem(String name, double points, String description) {
		super(name, points, description);
	}

	public void modifyStatEquip(Hero hero) {
		hero.setDefense(hero.getDefense() + getPoints());
	}

	public void modifyStatUnequip(Hero hero) {
		hero.setDefense(hero.getDefense() - getPoints());
	}
}