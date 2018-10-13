package abilities;

import characters.*;
import items.*;
import map.*;

public class Rush extends AbilityHurt{
//Rafaga

	public void stacking(Enemy enemy, Hero hero){

		System.out.println("");
		hero.setAttack(hero.getAttack()/8);
		System.out.println("The special abilitie rush was activated");
		enemy.setHp(enemy.getHp()-hero.getAttack() );
		System.out.println("You dealed "+ hero.getAttack() +" of damage");
		enemy.setHp(enemy.getHp()-hero.getAttack() );
		System.out.println("You dealed "+ hero.getAttack() +" of damage");
		enemy.setHp(enemy.getHp()-hero.getAttack() );
		System.out.println("You dealed "+ hero.getAttack() +" of damage");
		enemy.setHp(enemy.getHp()-hero.getAttack() );
		System.out.println(hero.getName()+" consumed 10 of ether");
		hero.setEther(hero.getEther()-10);
		//valor temporal
		enemy.setDefense(enemy.getDefense()-10);
		System.out.println("");
		
			
			}//fin stacking



}//fin rafaga