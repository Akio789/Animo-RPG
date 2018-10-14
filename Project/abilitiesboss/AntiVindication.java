package abilitiesboss;

import characters.*;
import items.*;
import map.*;

public class AntiVindication extends AntiAbilityBuffDeffub{

	public void reduceStats(Enemy enemy, Hero hero){

		System.out.println("");
		hero.setAttack(hero.getAttack()-(hero.getAttack()*.10));
		hero.setDefense(hero.getDefense()-(hero.getDefense()*.10));
		hero.setEther(hero.getEther()-10);
		System.out.println("The enemy activated the special abilitie Vindication");
		System.out.println("All your stats are lowered");
		System.out.println("");	
			}//fin reducir stats



}//fin Vindication