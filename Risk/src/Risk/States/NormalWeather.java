package Risk.States;

import Risk.Bord;

public class NormalWeather extends Weather
{
    public NormalWeather(Bord bord, Weather previousWeather)
    {
        super(bord, "NormalWeather", previousWeather);
    }
}
