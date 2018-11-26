package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Restrain extends Ability implements Serializable {
	// super yo
	public void specialAbility(Enemy enemy, Hero hero) {
		hero.setEther(hero.getEther() - 50);
		enemy.setStatusParalysis(true);
		// Y cura al heroe
		hero.setHp(hero.getHp() + hero.getHp() * .15 + 25);
	}// fin paralizar

}// fin restrain