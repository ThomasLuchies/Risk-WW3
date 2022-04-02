package Risk.States;

import Risk.Bord;

public class ColdWeather extends Weather
{

    public ColdWeather(Bord bord, Weather previousWeather)
    {
        super(bord, "ColdWeather", previousWeather);
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
