package Risk.Core.TroopFactory;

import Risk.Core.Player;
import Risk.Core.Troops.Cavalry;

public class CavalryFactory
{
    public Cavalry createCavalry(Player player)
    {
        return new Cavalry(player);
    }
}
