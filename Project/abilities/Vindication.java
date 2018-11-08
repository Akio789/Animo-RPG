package abilities;

import characters.*;
import items.*;
import map.*;

public class Vindication extends Ability {

	public void specialAbility(Enemy enemy, Hero hero) {

		System.out.println("");
		enemy.setAttack(enemy.getAttack() - (enemy.getAttack() * .10));
		enemy.setDefense(enemy.getDefense() - (enemy.getDefense() * .10));
		enemy.setEther(enemy.getEther() - 10);
		System.out.println("You activated the special abilitie Vindication");
		System.out.println("All the stats of the enemy are lowered");
		System.out.println(hero.getName() + " consumed 10 of ether");
		hero.setEther(hero.getEther() - 15);
		System.out.println("");

	}// fin reducir stats

}// fin Vindication