package abilities;

import characters.*;
import map.*;
import items.*;
import java.io.Serializable;

public abstract class Ability implements Serializable {
    public abstract void specialAbility(Enemy enemy, Hero hero);
}// fin habilidad