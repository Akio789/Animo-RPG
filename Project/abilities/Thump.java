package abilities;

import characters.*;
import items.*;
import map.*;

public class Thump extends AbilityHurt{
	//golpe fuerte 
	
	public void strongAttack(Enemy enemy,  Hero hero ){
		System.out.println("");
		System.out.println("You activated the special ability Thump");
		hero.setAttack(hero.getAttack()*2 );
		System.out.println("You dealed "+ hero.getAttack() + " of damage");
		enemy.setHp(enemy.getHp() -hero.getAttack() );
		System.out.println(hero.getName()+" consumed 10 of ether");
		hero.setEther(hero.getEther()-10);
		System.out.println("");
		hero.setAttack(hero.getAttack()/2);
	}//fin ataque fuerte
	
	
	
}//fin habilidad danio