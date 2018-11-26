package abilities;

import characters.*;
import items.*;
import map.*;
import java.io.Serializable;

public class Reason extends Ability implements Serializable {
	// Razon
	//del yo

	public void specialAbility(Enemy enemy, Hero hero) {

		if (hero.getEther()>=45) {
			System.out.println("");
			// puede cambiar el valor Reduce puntos ataque enemigo
			enemy.setAttack(enemy.getAttack() * .50);
			System.out.println("You activated the special abilitie Reason");
			System.out.println("You reduced the attack points of the enemy to " + enemy.getAttack());
			//va a subir la defensa
			double newDefense= 2+hero.getDefense()+hero.getDefense()*.25;
			hero.setDefense(newDefense);
			double diferential = hero.getDefense() - newDefense;
			System.out.println("You gained " + diferential + " your defense now is: " + hero.getDefense() + " and it protects for " + hero.getDefense()*.06 +" of enemy damage (1=100%)." );
			System.out.println(hero.getName() + " consumed 45 of ether");
			hero.setEther(hero.getEther() - 45);
			System.out.println("");
		} else {
			throw new NotEnoughEtherException();
		}



	}// fin reducir danio

}// fin razon