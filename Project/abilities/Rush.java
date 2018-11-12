package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Rush extends Ability implements Serializable {
	// Rafaga

	public void specialAbility(Enemy enemy, Hero hero) {

		System.out.println("");
		hero.setAttack(hero.getAttack() * .12);
		System.out.println("The special ability rush was activated");
		enemy.setHp(enemy.getHp() - hero.getAttack());
		System.out.println("You dealed " + hero.getAttack() + " of damage");
		enemy.setHp(enemy.getHp() - hero.getAttack());
		System.out.println("You dealed " + hero.getAttack() + " of damage");
		enemy.setHp(enemy.getHp() - hero.getAttack());
		System.out.println("You dealed " + hero.getAttack() + " of damage");
		enemy.setHp(enemy.getHp() - hero.getAttack());
		System.out.println(hero.getName() + " consumed 10 of ether");
		hero.setEther(hero.getEther() - 10);
		// valor temporal
		enemy.setDefense(enemy.getDefense() - (enemy.getDefense() * .10));
		hero.setAttack(hero.getAttack() * 8.3);
		System.out.println("");

	}// fin stacking

}// fin rafaga