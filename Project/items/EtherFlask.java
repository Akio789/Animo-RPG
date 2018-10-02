package items;
import characters.Hero;

public class EtherFlask extends Item{
  //ATTRIBUTES   
  private static int charges;
  
  //CONSTRUCTOR
  public EtherFlask(String name, double points, String description){
    super(name, points, description);
    charges = 2;
  }
  
  //GETTERS AND SETTERS 
  public static int getCharges(){
    return charges;
  }
  public static void setCharges(int charges){
    EtherFlask.charges = charges;
  }
}