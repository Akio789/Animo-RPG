package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Naturae extends Ability implements Serializable {
	//del yo

	public void specialAbility(Enemy enemy, Hero hero) {

		System.out.println("");
		System.out.println("You activated the special abilitie Naturae");
		// valor puede cambiar
		enemy.setDefense( (enemy.getDefense() - .75));
		System.out.println("The enemy defense was reduced to " + enemy.getDefense());
		System.out.println(hero.getName() + " consumed 65 of ether");
		hero.setEther(hero.getEther() - 65);
		System.out.println("");
	}// fin reducir defensa

}// fin clase