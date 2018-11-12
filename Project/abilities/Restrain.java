package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Restrain extends Ability implements Serializable {

	public void specialAbility(Enemy enemy, Hero hero) {
		hero.setEther(hero.getEther() - 10);
		enemy.setStatusParalysis(true);
	}// fin paralizar

}// fin restrain