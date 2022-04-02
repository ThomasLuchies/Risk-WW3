package Risk.States;

import Risk.Bord;

public class WarmWeather extends Weather
{
    public WarmWeather(Bord bord, Weather previousWeather)
    {
        super(bord, "WarmWeather", previousWeather);
    }

    @Override
    public void nextState()
    {

    }

    @Override
    public void previousState()
    {

    }
}
