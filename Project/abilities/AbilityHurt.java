package abilities;
import characters.*;
import items.*;
import map.*;

public abstract class AbilityHurt extends Ability{
    
    private double hurt;
    
    public void setHurt(double hurt){
        this.hurt=hurt;	
    }//fin set porcentaje
    
    public double getHurt(){
        return hurt;
    }//fin get porcentaje
    
    
    
    
}//fin habilidad