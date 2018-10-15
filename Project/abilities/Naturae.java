package abilities;

import characters.*;
import items.*;
import map.*;

public class Naturae extends AbilityBuffDeffub{
	
	
	public void reduceDefense(Enemy enemy, Hero hero){
		
		System.out.println("");
		System.out.println("You activated the special abilitie Naturae");
		//valor puede cambiar
		enemy.setDefense(enemy.getDefense()-(enemy.getDefense()*.10 ));
		System.out.println("The enemy defense was reduced to "+enemy.getDefense() );
		System.out.println(hero.getName()+" consumed 10 of ether");
		hero.setEther(hero.getEther()-10);
		System.out.println("");
	}//fin reducir defensa
	
	
	
	
	
}//fin clase