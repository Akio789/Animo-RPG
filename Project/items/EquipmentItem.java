package items;
import characters.*;

public abstract class EquipmentItem extends Item{
    //CONSTRUCTOR
    public EquipmentItem(String name, double points, String description){
        super(name, points, description);
    }
    //METHODS
    public abstract double modifyStat(double stat);
}   
