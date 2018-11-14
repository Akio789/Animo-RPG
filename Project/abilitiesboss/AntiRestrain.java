package abilitiesboss;

import characters.*;
import items.*;
import map.*;
import java.io.*;

public class AntiRestrain extends AntiAbility implements Serializable {

	public void paralize(Hero hero) {

		System.out.println("");
		if (hero.getStatusParalysis() == false) {

			System.out.println("You  can´t move, you are frozen");
			hero.setStatusParalysis(true);

		} // fin if

		else {

			System.out.println("You were already frozen");

		} // fin else

		System.out.println("");

	}// fin paralizar

}// fin restrain