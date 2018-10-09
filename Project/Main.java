import characters.*;
import items.*;

public class Main{
	public static void main(String[] args){
		WildMinion foe = new WildMinion(1, 5, 5, 15, 3, false);
		HealingFlask healingFlask = new HealingFlask("Healing Flask", 5, "Heals hp and ether.");
		AttackItem sword = new AttackItem("Sword", 5, "Normal sword.");
		DefenseItem shield = new DefenseItem("Shield", 5, "Normal shield.");
		Hero hero = new Hero("Akio", 1, 0, 10, 10, 5, 5, false, healingFlask);
		hero.addItemToBackpack(2, sword);
		hero.addItemToBackpack(3, shield);

		hero.printStats();
		System.out.println();
		hero.printBackpack();
		hero.equipItem(0, sword);
		hero.equipItem(1, shield);
		System.out.println();
		hero.printStats();
		System.out.println();
		hero.printBackpack();
		System.out.println();
		hero.printEquipment();
		System.out.println();
		foe.regularAttack(hero);
		System.out.println();
		hero.printStats();
		System.out.println();
		hero.printBackpack();
		System.out.println();
		hero.useItem(0);
		System.out.println();
		hero.printBackpack();
		System.out.println();
		hero.printStats();
		hero.unequipItem(0, 2);
		hero.unequipItem(1, 3);
		System.out.println();
		hero.printStats();
		hero.printEquipment();
		hero.printBackpack();


	}
}