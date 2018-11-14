package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Thump extends Ability implements Serializable {
	// golpe fuerte

	public void specialAbility(Enemy enemy, Hero hero) {
		System.out.println("");
		System.out.println("You activated the special ability Thump");
		hero.setAttack(hero.getAttack() * 2);
		System.out.println("You dealed " + hero.getAttack() + " of damage");
		if ((enemy.getHp() - hero.getAttack()) <= 0) {
			enemy.setHp(0);
		} else {
			enemy.setHp(enemy.getHp() - hero.getAttack());
		}
		System.out.println(hero.getName() + " consumed 10 of ether");
		hero.setEther(hero.getEther() - 10);
		System.out.println("");
		hero.setAttack(hero.getAttack() / 2);
	}// fin ataque fuerte

}// fin habilidad danio