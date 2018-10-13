package items;
import characters.*;

public class AttackItem extends EquipmentItem{
	//CONSTRUCTOR
	public AttackItem(String name, double points, String description){
		super(name, points, description);
	}
	public double modifyStat(double attack){
		return attack + getPoints();
	}
}