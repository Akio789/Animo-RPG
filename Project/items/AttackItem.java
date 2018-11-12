package items;

import java.io.Serializable;

import characters.*;

public class AttackItem extends EquipmentItem implements Serializable {
	// CONSTRUCTOR
	public AttackItem(String name, double points, String description) {
		super(name, points, description);
	}

	public void modifyStatEquip(Hero hero) {
		hero.setAttack(hero.getAttack() + getPoints());
	}

	public void modifyStatUnequip(Hero hero) {
		hero.setAttack(hero.getAttack() - getPoints());
	}
}