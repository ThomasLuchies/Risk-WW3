package Risk;

import Risk.Troops.Troop;

import java.util.ArrayList;
import java.util.Random;

public class Field
{
    private Player owner;
    private ArrayList<Troop> troops;
    private int soldiersAllowed; // allowed soldier the user can place per turn on this field

    public Field(Player owner)
    {
        this.owner = owner;
        this.troops = new ArrayList<>();
        this.soldiersAllowed = new Random().nextInt(3) + 1;
    }

    public Player getOwner()
    {
        return owner;
    }

    public ArrayList<Troop> getTroops()
    {
        return troops;
    }

    public int getSoldiersAllowed()
    {
        return soldiersAllowed;
    }

    public void placeTroop(Troop troop)
    {
        this.troops.add(troop);
    }

    public void Invaded(Player player)
    {
        this.owner = player;
        this.troops.clear();
    }
}
