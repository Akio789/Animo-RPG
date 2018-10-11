import characters.*;
import items.*;
import map.*;
import abilities.*;

public class Main{
	public static void main(String[] args){
		WildMinion foe = new WildMinion(1, 5, 5, 15, 3, false);
		HealingFlask healingFlask = new HealingFlask("Healing Flask", 5, "Heals hp and ether.");
		Item sword = new AttackItem("Sword", 5, "Normal sword.");
		Item shield = new DefenseItem("Shield", 5, "Normal shield.");
		Hero hero = new Bestia("Akio", 1, 0, 15, 10, 10, 5, false, healingFlask);
		Boss antiBestia = new AntiBestia(1, 100, 100, 5, 10, false);
		Pulsion p = new Pulsion();

		/*
		antiBestia.displayHp();
		hero.addItemToBackpack(1, sword);
		hero.addItemToBackpack(2, shield);
		hero.equipItem(0, sword);
		hero.equipItem(1, shield);
		hero.printStats();
		hero.attackEnemy(antiBestia);
		antiBestia.displayHp();
		antiBestia.regularAttack(hero);
		antiBestia.criticAttack(hero);
		hero.printStats();
		*/

		hero.addItemToBackpack(1, sword);
		hero.addItemToBackpack(2, shield);
		hero.printStats();
		System.out.println();
		hero.printBackpack();
		hero.equipItem(0, sword);
		hero.equipItem(1, shield);
		System.out.println();
		hero.printStats();
		System.out.println();
		hero.printBackpack();
		System.out.println();
		hero.printEquipment();
		System.out.println();
		foe.regularAttack(hero);
		System.out.println();
		hero.printStats();
		System.out.println();
		hero.printBackpack();
		System.out.println();
		hero.useItem(0);
		System.out.println();
		hero.printBackpack();
		System.out.println();
		hero.printStats();
		hero.unequipItem(0, 2);
		hero.unequipItem(1, 3);
		System.out.println();
		hero.printStats();
		hero.printEquipment();
		hero.printBackpack();


		new Map();

			//Pruebas Oscar
/*
		Burst b= new Burst();
		Drive a= new Drive ();
		Naturae c= new Naturae();
		Reason d= new Reason();
		Restrain e= new Restrain();
		Vindication f= new Vindication();	

		*/	
	}
}