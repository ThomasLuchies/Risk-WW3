package Risk.Core.States;

import Risk.Core.Bord;
import Risk.Core.Country;
import Risk.Core.dice.Dice;
import Risk.Core.dice.DiceNormal;

public class NormalWeather extends Weather
{
    public NormalWeather(Bord bord, Weather previousWeather)
    {
        super(bord, "NormalWeather", previousWeather);
    }

    @Override
    public Dice getCorrectDice(Country country)
    {
        switch(country)
        {
            case COLDCOUNTRY:
                return new DiceNormal();
            case NORMALCOUNTRY:
                return new DiceNormal();
            case WARMCOUNTRY:
                return new DiceNormal();
        }

        return null;
    }
}
