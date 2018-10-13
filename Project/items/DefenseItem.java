package items;
import characters.*;

public class DefenseItem extends EquipmentItem{
	//CONSTRUCTOR
	public DefenseItem(String name, double points, String description){
		super(name, points, description);
	}
	public double modifyStat(double defense){
		return defense + getPoints();
	}
}