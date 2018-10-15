package abilities;

import characters.*;
import items.*;
import map.*;


public abstract class AbilityBuffDeffub extends Ability{
    
    private double percentage;
    
    public void setPercentage(double percentage){
        this.percentage=percentage;	
    }//fin set porcentaje
    
    public double getPercentage(){
        return percentage;
    }//fin get porcentaje
    
    
    
    
    
}//fin 