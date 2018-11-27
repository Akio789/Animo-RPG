package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Thump extends Ability implements Serializable {
	// golpe fuerte
	// ello
	public void specialAbility(Enemy enemy, Hero hero) {
		double initialAttack = hero.getAttack();
		System.out.println("");
		System.out.println("You activated the special ability Thump");
		hero.setAttack(hero.getAttack() * 1.85);
		double damageDone = hero.getAttack() - ((enemy.getDefense() * .06) * hero.getAttack());
		System.out.println("You dealed " + damageDone + " of damage");
		if ((enemy.getHp() - damageDone <= 0)) {
			enemy.setHp(0);
		} else {
			enemy.setHp(enemy.getHp() - damageDone);
		}
		System.out.println(hero.getName() + " consumed 65 of ether");
		hero.setEther(hero.getEther() - 65);
		System.out.println("End of spcecial ability.");
		System.out.println("");
		hero.setAttack(initialAttack);
	}// fin ataque fuerte

}// fin habilidad danio