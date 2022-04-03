package Risk.Core.States;

import Risk.Core.Bord;
import Risk.Core.Country;
import Risk.Core.dice.Dice;
import Risk.Core.dice.DiceAdvantage;
import Risk.Core.dice.DiceDisadvantage;
import Risk.Core.dice.DiceNormal;

public class ColdWeather extends Weather
{

    public ColdWeather(Bord bord, Weather previousWeather)
    {
        super(bord, "ColdWeather", previousWeather);
    }


    @Override
    public Dice getCorrectDice(Country country)
    {
        switch(country)
        {
            case COLDCOUNTRY:
                return new DiceAdvantage();
            case NORMALCOUNTRY:
                return new DiceNormal();
            case WARMCOUNTRY:
                return new DiceDisadvantage();
        }

        return null;
    }
}
