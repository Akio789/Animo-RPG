package abilitiesboss;

import characters.*;
import items.*;
import map.*;

public class AntiReason extends AntiAbilityBuffDeffub{
//Razon


	public void reduceDamage(Enemy enemy,  Hero hero){

		System.out.println("");
		//puede cambiar el valor
		hero.setAttack(hero.getAttack()-(hero.getAttack()*.50));
		System.out.println("The enemie activated the special abilitie Reason");
		System.out.println("The enemy reduced your damage to"+  hero.getAttack() );
		System.out.println("");
		
			}//fin reducir danio


}//fin razon