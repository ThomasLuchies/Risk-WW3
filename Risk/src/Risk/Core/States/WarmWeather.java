package Risk.Core.States;

import Risk.Core.Bord;
import Risk.Core.Country;
import Risk.Core.dice.Dice;
import Risk.Core.dice.DiceAdvantage;
import Risk.Core.dice.DiceDisadvantage;
import Risk.Core.dice.DiceNormal;

public class WarmWeather extends Weather
{
    public WarmWeather(Bord bord, Weather previousWeather)
    {
        super(bord, "WarmWeather", previousWeather);
    }

    @Override
    public Dice getCorrectDice(Country country)
    {
        switch (country)
        {
            case COLDCOUNTRY:
                return new DiceDisadvantage();
            case NORMALCOUNTRY:
                return new DiceNormal();
            case WARMCOUNTRY:
                return new DiceAdvantage();
        }

        return null;
    }
}


