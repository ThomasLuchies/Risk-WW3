package Risk.Core.States;
import Risk.Core.Bord;
import Risk.Core.Country;
import Risk.Core.dice.Dice;

import java.util.Random;

public abstract class Weather
{
    private Bord bord;
    private String name;
    private Weather previousWeather;

    public Weather(Bord bord, String name, Weather previousWeather)
    {
        this.bord = bord;
        this.name = name;
        this.previousWeather = previousWeather;
    }

    public void nextState()
    {
        Weather randomWeather = getRandWeather(this);

        if(this.name.contentEquals(this.getClass().getName()))
            nextState();

        this.bord.changeState(randomWeather);
    }

    public void previousState()
    {
        if(this.previousWeather == null)
           return;

        this.bord.changeState(previousWeather);
    }

    public Weather getRandWeather(Weather currentWeather)
    {
        Weather[] weatherStates = new Weather[] { new NormalWeather(this.bord,this), new ColdWeather(this.bord, this), new WarmWeather(this.bord, this) };
        Random random = new Random();
        int randInt = random.nextInt(3) + 1;

        return weatherStates[randInt];
    }

    public abstract Dice getCorrectDice(Country country);
}
