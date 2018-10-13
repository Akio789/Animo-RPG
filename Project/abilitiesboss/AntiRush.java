package abilitiesboss;

import characters.*;
import items.*;
import map.*;

public class AntiRush extends AntiAbilityHurt{
//Rafaga

	public void stacking(Enemy enemy, Hero hero){
		
		System.out.println("");
		enemy.setAttack(enemy.getAttack()/8);
		System.out.println("The special abilitie rush was activate");
		hero.setHp(hero.getHp()-enemy.getAttack() );
		System.out.println("The enemy dealed "+enemy.getAttack() );
		hero.setHp(hero.getHp()-enemy.getAttack() );
		System.out.println("The enemy dealed "+enemy.getAttack() );
		hero.setHp(hero.getHp()-enemy.getAttack() );
		System.out.println("The enemy dealed "+enemy.getAttack() );
		hero.setHp(hero.getHp()-enemy.getAttack() );
		enemy.setEther(enemy.getEther()-10);
		//valor temporal
		hero.setDefense(hero.getDefense()-10);
		System.out.println("");
		enemy.setAttack(enemy.setAttack()*8);
			
			}//fin stacking



}//fin rafaga