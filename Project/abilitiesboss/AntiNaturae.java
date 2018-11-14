package abilitiesboss;

import java.io.*;
import characters.*;
import items.*;
import map.*;

public class AntiNaturae extends AntiAbilityBuffDeffub implements Serializable {

	public void reduceDefense(Hero hero) {

		System.out.println("");
		System.out.println("The enemy activated the special abilitie Naturae");
		// valor puede cambiar
		hero.setDefense(hero.getDefense() - (hero.getDefense() * .10));
		System.out.println("Your defense is now " + hero.getDefense());
		System.out.println("");

	}// fin reducir defensa

}// fin clase