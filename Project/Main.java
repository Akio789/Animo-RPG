import characters.*;
import items.*;
import map.*;
import abilities.*;
import abilitiesboss.*;


public class Main{
	public static void main(String[] args){
		WildMinion foe = new WildMinion(5, 5, 100, 3, false);
		HealingFlask healingFlask = new HealingFlask("Healing Flask", 10, "Heals hp and ether.");
		EquipmentItem sword = new AttackItem("Sword", 5, "Normal sword.");
		EquipmentItem shield = new DefenseItem("Shield", 5, "Normal shield.");
		Hero hero = new Bestia("Akio", 100, 100, 100, 100, 100, 100, false, healingFlask);
		Boss antiBestia = new AntiBestia(100, 100, 100, 100, false);
		

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
		
		
		/*
		//Pruebas Oscar

		
		//positivas
		//Rush
		Rush rush= new Rush();
		rush.stacking(antiBestia, hero);
		//hero.ataque(antiBestia, hero);
		
		//Thump
		Thump thump= new Thump();
		thump.strongAtack(antiBestia, hero);

		//Naturae
		Naturae naturae= new Naturae();
		naturae.reduceDefense(antiBestia,hero);

		//Reason
		Reason reason= new Reason();
		reason.reduceDamage(antiBestia, hero);


		//Vindication
		Vindication vindication= new Vindication();
		vindication.reduceStats(antiBestia, hero);

		//Restrain
		Restrain restrain= new Restrain();
		restrain.paralize(antiBestia, hero);

		//negativas


		
		//Rush
		AntiRush antiRush= new AntiRush();
		antiRush.stacking(antiBestia, hero);
		
		//Thump
		AntiThump antiThump= new AntiThump();
		antiThump.strongAtack(antiBestia, hero);

		//Naturae
		AntiNaturae antiNaturae= new AntiNaturae();
		antiNaturae.reduceDefense( hero);

		//Reason
		AntiReason antiReason= new AntiReason();
		antiReason.reduceDamage(antiBestia, hero);


		//Vindication
		AntiVindication antiVindication= new AntiVindication();
		antiVindication.reduceStats(antiBestia, hero);

		//Restrain
		AntiRestrain antiRestrain= new AntiRestrain();
		antiRestrain.paralize( hero);

		hero.printStats();
		Thump thump= new Thump();
		thump.strongAtack(antiBestia, hero);
   		*/

   		
		//hero.printStats();
	}
}