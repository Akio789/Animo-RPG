package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Restrain extends Ability implements Serializable {

	//super yo
	public void specialAbility(Enemy enemy, Hero hero) {

		if (hero.getEther()>=70 || hero.getMaxHp()<=(hero.getHp() + hero.getHp()*.15 + 25)) {
			hero.setEther(hero.getEther() - 70);
			enemy.setStatusParalysis(true);
			// Y cura al heroe
			hero.setHp(hero.getHp() + hero.getHp()*.15 + 25);
		} else {
			throw new NotEnoughEtherException();
			if(hero.getMaxHp()<=(hero.getHp() + hero.getHp()*.15 + 25)){
				throw new MaxLifeException();
			}
		}
	}// fin paralizar

}// fin restrain