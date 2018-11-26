package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Naturae extends Ability implements Serializable {
	//del yo

	public void specialAbility(Enemy enemy, Hero hero) {

		if (hero.getEther()>=50) {
		System.out.println("");
		System.out.println("You activated the special abilitie Naturae");
		// valor puede cambiar
		enemy.setDefense((int) (enemy.getDefense() - (enemy.getDefense() * .40)));
		//hara daño
		double damageDone = 15 + (hero.getAttack() - ((enemy.getDefense()*.06)*hero.getAttack()));
		enemy.setHp(enemy.getHp()-damageDone);
		System.out.println("The enemy defense was reduced to " + enemy.getDefense() + " and lost "+ damageDone +" health points.");
		System.out.println(hero.getName() + " consumed 50 of ether");
		hero.setEther(hero.getEther() - 50);
		System.out.println("");
		} else {
			throw new NotEnoughEtherException();
		}

	}// fin reducir defensa

}// fin clase