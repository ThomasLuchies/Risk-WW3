package Risk.Core.TroopFactory;

import Risk.Core.Player;
import Risk.Core.Troops.Infantry;

public class InfantryFactory
{
    public Infantry createInfantry(Player player)
    {
        return new Infantry(player);
    }
}
