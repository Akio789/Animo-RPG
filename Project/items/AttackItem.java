package items;

import characters.*;

public class AttackItem extends EquipmentItem {
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