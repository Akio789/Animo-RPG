package abilitiesboss;

import characters.*;
import items.*;
import map.*;
import java.io.*;

public class AntiRush extends AntiAbilityHurt implements Serializable {
	// Rafaga

	public void stacking(Enemy enemy, Hero hero) {

		System.out.println("");
		enemy.setAttack(enemy.getAttack() * .12);
		System.out.println("The special abilitie rush was activate");
		hero.setHp(hero.getHp() - enemy.getAttack());
		System.out.println("The enemy dealed " + enemy.getAttack() + " of damage");
		hero.setHp(hero.getHp() - enemy.getAttack());
		System.out.println("The enemy dealed " + enemy.getAttack() + " of damage");
		hero.setHp(hero.getHp() - enemy.getAttack());
		System.out.println("The enemy dealed " + enemy.getAttack() + " of damage");
		hero.setHp(hero.getHp() - enemy.getAttack());
		enemy.setEther(enemy.getEther() - 10);
		// valor temporal
		hero.setDefense(hero.getDefense() - (hero.getDefense() * .10));
		System.out.println("");
		enemy.setAttack(enemy.getAttack() * 8.3);

	}// fin stacking

}// fin rafaga