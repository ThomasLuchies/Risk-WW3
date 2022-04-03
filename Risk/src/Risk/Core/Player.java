package Risk.Core;

import Risk.Core.TroopFactory.TroopCreator;
import Risk.Core.Troops.Troop;

import java.util.ArrayList;

public class Player
{
    private Country country;
    private ArrayList<Field> kingdom;
    private int troops;
    private BordInterface bordInterface;
    private int playerNumber;

    public Player(Country country, int playerNumber)
    {
        this.country = country;
        this.kingdom = new ArrayList<>();
        this.troops = 0;
        this.bordInterface = new Bord();
        this.playerNumber = playerNumber;
    }

    public Country getCountry()
    {
        return country;
    }

    public void attack(Field field, Player player)
    {
        bordInterface.receiveAttack(getAttackValue(field), player, field);
    }

    public void defend(Field field, Player player)
    {
        bordInterface.receiveDefend((getAttackValue(field) + 4), player, field);
    }

    public int getAttackValue(Field field)
    {
        int value = 0;
        for (Troop troop : field.getTroops())
        {
            value += troop.getValue();
        }

        return value;
    }

    public void addTroop()
    {
        this.troops += 1;
    }

    public void removeTroop()
    {
        this.troops -= 1;
    }

    public ArrayList<Field> getKingdom()
    {
        return kingdom;
    }

    public int getTroops()
    {
        return troops;
    }

    public int getPlayerNumber()
    {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber)
    {
        this.playerNumber = playerNumber;
    }
}
