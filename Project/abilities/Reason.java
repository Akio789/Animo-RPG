package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Reason extends Ability implements Serializable {
	// Razon
	// del yo

	public void specialAbility(Enemy enemy, Hero hero) {

		System.out.println("");
		// puede cambiar el valor
		enemy.setAttack(enemy.getAttack() - 5);
		System.out.println("You activated the special abilitie Reason");
		System.out.println("You reduced the attack points of the enemy to " + enemy.getAttack());
		System.out.println(hero.getName() + " consumed 65 of ether");
		hero.setEther(hero.getEther() - 65);
		System.out.println("");
	}// fin reducir danio

}// fin razon