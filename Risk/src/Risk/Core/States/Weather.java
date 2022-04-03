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

    /**
     * changes the state of weather to the next random state
     */
    public void nextState()
    {
        Weather randomWeather = getRandWeather(this);

        if(this.name.contentEquals(randomWeather.getName()))
            nextState();

        this.bord.changeState(randomWeather);
    }

    /**
     * changes the state of weather to the previous state
     * if there is no previous state it will remain the same state
     */
    public void previousState()
    {
        if(this.previousWeather == null)
           return;

        this.bord.changeState(previousWeather);
    }

    /**
     * gets weather and changes this to a random weather state
     * @param currentWeather the current value
     * @return a random weather state
     */
    public Weather getRandWeather(Weather currentWeather)
    {
        Weather[] weatherStates = new Weather[] { new NormalWeather(this.bord,this), new ColdWeather(this.bord, this), new WarmWeather(this.bord, this) };
        Random random = new Random();
        //int randInt = random.nextInt(3);

        return weatherStates[random.nextInt(3)];
    }

    public String getName()
    {
        return name;
    }

    /**
     * checks what type of country the supplied country is and uses the corresponding dice
     * @param country
     * @return correct dice funtion DiceNormal()/DiceAdvantage()/DiceDisdvantage()
     */
    public abstract Dice getCorrectDice(Country country);
}
