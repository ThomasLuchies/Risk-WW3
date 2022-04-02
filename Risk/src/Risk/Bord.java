package Risk;

import Risk.States.NormalWeather;
import Risk.States.Weather;

import java.util.ArrayList;

public class Bord implements BordInterface
{
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Field> fields = new ArrayList<>();
    Weather weather = new NormalWeather(this);

    public void changeState(Weather weather)
    {
        this.weather = weather;
    }

    @Override
    public void turn(boolean attack)
    {

    }
}
