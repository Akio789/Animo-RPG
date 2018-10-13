package items;
import characters.*;

public abstract class Item{
	//ATTRIBUTES
	private String name;
	private double points;
	private String description;

	//CONSTRUCTOR
	public Item(String name, double points, String description){
		this.name = name;
		this.points = points;
		this.description = description;
	}

	//GETTERS AND SETTERS
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getPoints(){
		return points;
	}
	public void setPoints(int points){
		this.points = points;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
}