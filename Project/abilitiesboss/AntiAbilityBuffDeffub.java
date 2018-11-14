package abilitiesboss;

import characters.*;
import items.*;
import map.*;
import java.io.*;

public abstract class AntiAbilityBuffDeffub extends AntiAbility implements Serializable {

    private double percentage;

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }// fin set porcentaje

    public double getPercentage() {
        return percentage;
    }// fin get porcentaje

}// fin