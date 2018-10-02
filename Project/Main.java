import characters.*;
import items.*;

public class Main{
	public static void main(String[] args){
		Hero hero = new Hero("Akio", 1, 0, 10, 10, 5, 5, false);
		WildMinion foe = new WildMinion(1, 5, 5, 10, 3, false);
		HpFlask hpFlask = new HpFlask("Hp Flask", 5, "Heals hp.");
		AttackItem sword = new AttackItem("Sword", 5, "Normal sword.");
		hero.addItemToBackpack(1, sword);
		hero.addItemToBackpack(0, hpFlask);

		hero.printBackpack();
		hero.printStats();
		System.out.println();
		foe.regularAttack(hero);
		System.out.println();
		hero.printStats();
		hero.useItem(0);
		System.out.println();
		hero.printStats();


	}
}