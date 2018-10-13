package abilitiesboss;

import characters.*;
import items.*;
import map.*;

public class AntiThump extends AntiAbilityHurt{
 //golpe fuerte 

	public void strongAtack(Enemy enemy,  Hero hero ){
		
		System.out.println("");

		System.out.println("The enemy activated the special abilitie thump");
		enemy.setAttack(enemy.getAttack()+enemy.getAttack() );
		hero.setHp(hero.getHp() -enemy.getAttack() );
		System.out.println("The enemy dealed "+enemy.getAttack()+" of damage");
		enemy.setEther(enemy.getEther()-10);
		
		System.out.println("");

			}//fin ataque fuerte



}//fin habilidad danio