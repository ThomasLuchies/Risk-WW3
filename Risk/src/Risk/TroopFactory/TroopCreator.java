package Risk.TroopFactory;

import Risk.Troops.Artillery;
import Risk.Troops.Cavalry;
import Risk.Troops.Infantry;

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

    public Artillery createArtillery()
    {
        return this.artilleryFactory.createArtillery();
    }

    public Infantry createInfantry()
    {
        return this.infantryFactory.createInfantry();
    }

    public Cavalry createCavalry()
    {
        return this.cavalryFactory.createCavalry();
    }
}
