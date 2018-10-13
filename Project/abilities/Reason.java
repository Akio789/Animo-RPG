package abilities;

import characters.*;
import items.*;
import map.*;

public class Reason extends AbilityBuffDeffub{
//Razon


	public void reduceDamage(Enemy enemy,  Hero hero){

		System.out.println("");
		//puede cambiar el valor
		enemy.setAttack(enemy.getAttack()-(enemy.getAttack()/2));
		System.out.println("You activated the special abilitie Reason");
		System.out.println("You reduced de damage of the enemy to "+  enemy.getAttack() );
		System.out.println(hero.getName()+" consumed 10 of ether");
		hero.setEther(hero.getEther()-10);
		System.out.println("");
			}//fin reducir danio


}//fin razon