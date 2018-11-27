package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Rush extends Ability implements Serializable {
	// Rafaga
	// ello
	public void specialAbility(Enemy enemy, Hero hero) {
		double initialAttack = hero.getAttack();
		System.out.println("");
		hero.setAttack(hero.getAttack() * 1.12);
		System.out.println("The special ability rush was activated");
		double initialDamageDone = hero.getAttack() - ((enemy.getDefense() * .06) * hero.getAttack());
		enemy.setHp(enemy.getHp() - initialDamageDone);
		System.out.println("Initial damage done is " + initialDamageDone);
		hero.setAttack(hero.getAttack() * .2);
		double damageDone = hero.getAttack() - ((enemy.getDefense() * .06) * hero.getAttack());
		if ((enemy.getHp() - (3 * damageDone) <= 0)) {
			enemy.setHp(0);
		} else {
			enemy.setHp(enemy.getHp() - damageDone);
			System.out.println("You dealed " + damageDone + " of damage");
			enemy.setHp(enemy.getHp() - damageDone);
			System.out.println("You dealed " + damageDone + " of damage");
			enemy.setHp(enemy.getHp() - damageDone);
			System.out.println("You dealed " + damageDone + " of damage");
			enemy.setHp(enemy.getHp() - damageDone);
		}
		System.out.println(hero.getName() + " consumed 65 of ether");
		hero.setEther(hero.getEther() - 65);
		// valor temporal
		System.out.println("End of spcecial ability.");
		enemy.setDefense(enemy.getDefense() - (enemy.getDefense() - .5));
		hero.setAttack(initialAttack);
		System.out.println("");

	}// fin stacking

}// fin rafaga