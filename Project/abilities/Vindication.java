package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Vindication extends Ability implements Serializable {
	// super yo
	public void specialAbility(Enemy enemy, Hero hero) {

		System.out.println("");
		System.out.println("You activated the special ability Vindication");
		double attackModifier = (enemy.getAttack() * .23);
		double defenseModifier = (enemy.getDefense() * .18);
		enemy.setAttack(enemy.getAttack() - attackModifier);
		enemy.setDefense(enemy.getDefense() - defenseModifier);
		enemy.setEther(enemy.getEther() - 10);
		// sube el AD del heroe


		System.out.println("All the stats of the enemy are lowered, and you gained part of them as damage: ");
		System.out.println("You reduced enemy stats to " +enemy.getAttack() + " points of Attack." + enemy.getDefense()+" points of defense");
		System.out.println(hero.getName() + " consumed 65 of ether.");
		hero.setEther(hero.getEther() - 65);

		System.out.println("");

	}// fin reducir stats

}// fin Vindication