package abilities;
import characters.*;
import items.*;
import map.*;

public class Restrain extends Ability{


	public void paralize(Enemy enemy, Hero hero){

	System.out.println("");

		if (enemy.getStatusParalysis()==false ) {
	
			System.out.println("The enemy can´t move, you froze it");
			enemy.setStatusParalysis(true);
				
				}//fin if

		else {
			
			System.out.println("The enemy was already frozen");
				
				}//fin else

	System.out.println(hero.getName()+" consumed 10 of ether");
	hero.setEther(hero.getEther()-10);

	System.out.println("");			

					}//fin paralizar


}//fin restrain