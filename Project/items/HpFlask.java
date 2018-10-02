package items;
import characters.Hero;

public class HpFlask extends Item{
  //ATTRIBUTES
  private static int charges;
  
  //CONSTRUCTOR
  public HpFlask(String name, double points, String description){
    super(name, points, description);
    charges = 2;
  }

  //GETTERS AND SETTERS 
  public static int getCharges(){
    return charges;
  }
  public static void setCharges(int charges){
    HpFlask.charges = charges;
  }
}