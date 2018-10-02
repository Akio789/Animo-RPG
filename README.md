# Animo-RPG
This is turn-based RPG being developed by Akio Olvera, Itztani Villaseñor and Oscar Contreras.
It is being developed using OOP in Java.
It's main themes are psychology and philosophy, so it contains Game Based Learning aspects.
Hope you enjoy!

v1.1
- Created packages for characters and items.
- From Hero, added and implemented methods:
	. addItemToBackpack
	. removeItemFromBackpack
	. equipItem,using instanceof to know which stat to increase and Arrays.asList(arr).indexOf(elem) to get the index of an element
	. unequipItem
	. printBackpack
	. printEquipment
	. printStats
- Created and implemented:
	. AttackItem
	. DefenseItem
- NEXT VERSION OBJECTIVES:
	. Create and implement EtherFlask and HpFlask

v1.2
- Created class Enemy, added method:
	. attack
- Created class OrderMinion (extends Enemy).
- Created class WildMinion (extends Enemy).
¿WHAT'S THE DIFFERENCE (programming wise) BETWEEN ORDERMINION AND WILDMINION?
- Class Hero, added:
	. attribute maxHp (so that max hp is not exceded when using hpFlask.
	. attribute maxEther (so that max ether is not exceded when using etherFlask.
	. method useItem to use an HpFlask or EtherFlask.
- Created and implemented:
	. HpFlask.
	. EtherFlask.