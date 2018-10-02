import characters.*;
import items.*;

public class Main{
	public static void main(String[] args){
		WildMinion foe = new WildMinion(1, 5, 5, 10, 3, false);
		HpFlask hpFlask = new HpFlask("Hp Flask", 5, "Heals hp.");
		EtherFlask etherFlask = new EtherFlask("Ether Flask", 5, "Heals ether.");
		AttackItem sword = new AttackItem("Sword", 5, "Normal sword.");
		Hero hero = new Hero("Akio", 1, 0, 10, 10, 5, 5, false, hpFlask, etherFlask);
		hero.addItemToBackpack(2, sword);

		hero.printStats();
		System.out.println();
		hero.printBackpack();
		hero.equipItem(0, sword);
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


	}
}