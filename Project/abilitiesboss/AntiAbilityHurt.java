package abilitiesboss;
import characters.*;
import items.*;
import map.*;

public abstract class AntiAbilityHurt extends AntiAbility{

private double hurt;

public void setHurt(double hurt){
this.hurt=hurt;	
}//fin set porcentaje

public double getHurt(){
return hurt;
}//fin get porcentaje




}//fin habilidad