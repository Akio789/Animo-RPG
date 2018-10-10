import characters.*;
import items.*;

public class Main {
    public static void main(String[] args) {
        Enemy e = new WildMinion(1,10,10,5,5,false);
        Hero hero = new Hero("Akio", 1, 0, 10, 10, 5, 5, false, healingFlask);

    }
    
}