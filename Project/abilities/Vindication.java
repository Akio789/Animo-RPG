package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Vindication extends Ability implements Serializable {
	// super yo
	public void specialAbility(Enemy enemy, Hero hero) {

		if (hero.getEther()>=80) {
			// reduccion stats todo
			System.out.println("");
			System.out.println("You activated the special ability Vindication");
			double attackModifier = (enemy.getAttack() * .23);
			double defenseModifier = (enemy.getDefense() * .18);
			double initialAttack = hero.getAttack();
			enemy.setAttack(enemy.getAttack() - attackModifier);
			enemy.setDefense(enemy.getDefense() - defenseModifier);
			//sube el AD del heroe
			hero.setAttack(hero.getAttack()+(hero.getAttack()*.115)+ 3.5 + attackModifier + defenseModifier);
			
			System.out.println("All the stats of the enemy are lowered, and you gained part of them as damage: ");
			System.out.println("You gained " + (hero.getAttack()-initialAttack) + " points of Attack.");
			System.out.println(hero.getName() + " consumed 80 of ether.");
			hero.setEther(hero.getEther() - 80);
			System.out.println("");
		} else {
			throw new NotEnoughEtherException();
		}

	}// fin reducir stats

}// fin Vindication