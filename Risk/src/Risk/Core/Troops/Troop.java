package Risk.Core.Troops;

import Risk.Core.Player;

public abstract class Troop
{
    private int value;
    private Player player;

    public Troop(int value, Player player)
    {
        this.value = value;
        this.player = player;
    }

    public int getValue()
    {
        return this.value;
    }
}
