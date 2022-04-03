package Risk.Core;

import Risk.Core.Troops.Troop;

import java.util.ArrayList;
import java.util.Random;

public class Field
{
    private Player owner;
    private ArrayList<Troop> troops;
    private int soldiersAllowed; // allowed soldier the user can place per turn on this field
    private Coords coords;

    public Field(Player owner, Coords coords)
    {
        this.owner = owner;
        this.troops = new ArrayList<>();
        this.soldiersAllowed = new Random().nextInt(3) + 1;
        this.coords = coords;
    }

    public Player getOwner()
    {
        return owner;
    }

    public ArrayList<Troop> getTroops()
    {
        return troops;
    }

    public void setTroops(ArrayList<Troop> troops)
    {
        this.troops = troops;
    }

    public int getSoldiersAllowed()
    {
        return soldiersAllowed;
    }

    public void placeTroop(Troop troop)
    {
        this.troops.add(troop);
    }

    public void removeTroop(Troop troop)
    {
        this.troops.remove(troop);
    }

    public void Invaded(Player player)
    {
        this.owner = player;
        this.troops.clear();
    }

    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    public void setSoldiersAllowed(int soldiersAllowed)
    {
        this.soldiersAllowed = soldiersAllowed;
    }

    public Coords getCoords()
    {
        return coords;
    }

    public void setCoords(Coords coords)
    {
        this.coords = coords;
    }
}
