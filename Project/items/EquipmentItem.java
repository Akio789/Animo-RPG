package items;

import java.io.Serializable;

import characters.*;

public abstract class EquipmentItem extends Item implements Serializable {
    // CONSTRUCTOR
    public EquipmentItem(String name, double points, String description) {
        super(name, points, description);
    }

    // METHODS
    public abstract void modifyStatEquip(Hero hero);

    public abstract void modifyStatUnequip(Hero hero);
}
