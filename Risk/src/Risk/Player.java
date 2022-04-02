package Risk;

import Risk.TroopFactory.TroopCreator;
import Risk.Troops.Troop;

import java.util.ArrayList;

public class Player {
    private Country country;
    private ArrayList<Field> kingdom;
    private TroopCreator troopCreator;
    private ArrayList<Troop> troops;

    public Player(Country country) {
        this.country = country;
        this.kingdom = new ArrayList<>();
        this.troopCreator = new TroopCreator();
        this.troops = new ArrayList<>();
    }

    public boolean attack()
    {
        return false;
    }

    public boolean defend()
    {
        return false;
    }

    public void placeTroop ()
    {

    }

    public Country getCountry()
    {
        return country;
    }

    public ArrayList<Field> getKingdom()
    {
        return kingdom;
    }

    public TroopCreator getTroopCreator()
    {
        return troopCreator;
    }

    public ArrayList<Troop> getTroops()
    {
        return troops;
    }
}
