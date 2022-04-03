package Risk.Core.TroopFactory;

import Risk.Core.Player;
import Risk.Core.Troops.Artillery;
import Risk.Core.Troops.Cavalry;
import Risk.Core.Troops.Infantry;

public class TroopCreator
{
    private ArtilleryFactory artilleryFactory;
    private InfantryFactory infantryFactory;
    private CavalryFactory cavalryFactory;

    public TroopCreator()
    {
        this.artilleryFactory = new ArtilleryFactory();
        this.infantryFactory = new InfantryFactory();
        this.cavalryFactory = new CavalryFactory();
    }

    public Artillery createArtillery(Player player)
    {
        return this.artilleryFactory.createArtillery(player);
    }

    public Infantry createInfantry(Player player)
    {
        return this.infantryFactory.createInfantry(player);
    }

    public Cavalry createCavalry(Player player)
    {
        return this.cavalryFactory.createCavalry(player);
    }
}
