package CIS210M.jenks.com;
/*Matthew Jenks
4.22.2021
getHired game to show employers what I know how to do.
This class is meant to be the parent for showing inheritance
I realize all classes extend object implicitly, this was the best way I thought of to show explicit inheritance
small update to change abstract function from string to list for child class*/


import java.util.List;

public abstract class Treasure {
    public abstract List generateTreasure(Character evilCreature);
    public abstract String sellTreasure();
    public abstract String buyTreasure();
    public abstract String pickUpLoot();
    public abstract String craftTreasure();
    public abstract String salvageTreasure();

}
