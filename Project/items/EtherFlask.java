package items;
import characters.Hero;

public class EtherFlask extends Item{
  //ATTRIBUTES   
  private int charges;
  
  //CONSTRUCTOR
  public EtherFlask(String name, double points, String description){
    super(name, points, description);
    this.charges = 2;
  }
  
  //GETTERS AND SETTERS 
  public int getCharges(){
    return charges;
  }
  public void setCharges(int charges){
    this.charges = charges;
  }
}