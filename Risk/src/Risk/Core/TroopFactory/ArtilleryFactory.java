package Risk.Core.TroopFactory;

import Risk.Core.Player;
import Risk.Core.Troops.Artillery;

public class ArtilleryFactory
{
    public Artillery createArtillery(Player player)
    {
        return new Artillery(player);
    }
}
