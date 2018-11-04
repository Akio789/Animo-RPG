package items;

import characters.*;

public class HealingFlask extends Item {
  // ATTRIBUTES
  private int charges, maxCharges;

  // CONSTRUCTOR
  public HealingFlask(String name, double points, String description) {
    super(name, points, description);
    this.charges = 5;
    this.maxCharges = 5;
  }

  // GETTERS AND SETTERS
  public int getCharges() {
    return charges;
  }

  public void setCharges(int charges) {
    this.charges = charges;
  }

  public int getMaxCharges() {
    return maxCharges;
  }

  public void setMaxCharges(int maxCharges) {
    this.maxCharges = maxCharges;
  }
}