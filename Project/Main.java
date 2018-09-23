import characters.Character;
import characters.Hero;
import items.Item;
import items.AttackItem;
import items.DefenseItem;

public class Main{
	public static void main(String[] args){
		Hero hero = new Hero("Akio", 1, 0, 10, 10, 5, 5, false);
		System.out.println();

		///TEST
		//No items equipped
		System.out.println("Starting stats");
		hero.printStats();
		AttackItem sword1 = new AttackItem("Dragonslayer", 100, "It is a Legendary Sword");
		hero.addItemToBackpack(0, sword1);
		hero.equipItem(0, sword1);
		System.out.println();

		//Dragonslayer equipped
		System.out.println("Dragonslayer equipped");
		hero.printStats();
		hero.printBackpack();
		hero.printEquipment();

		DefenseItem shield1 = new DefenseItem("Rose shield", 100, "It is a Legendary Shield");
		hero.addItemToBackpack(0, shield1);
		hero.equipItem(1, shield1);
		System.out.println();

		//Rose shield equipped
		System.out.println("Rose shield equipped");
		hero.printStats();
		hero.printBackpack();
		hero.printEquipment();
		System.out.println();

		//Unequip Dragonslayer
		hero.unequipItem(0, 0);
		System.out.println("Dragonslayer unequipped");
		hero.printStats();
		hero.printBackpack();
		hero.printEquipment();
		System.out.println();

		//Unequip Rose shield
		hero.unequipItem(1, 1);
		System.out.println("Rose shield unequipped");
		hero.printStats();
		hero.printBackpack();
		hero.printEquipment();

	}
}