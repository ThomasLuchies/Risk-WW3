package Risk;

import Risk.States.NormalWeather;
import Risk.States.Weather;

import java.util.ArrayList;

public interface BordInterface
{
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Field> fields = new ArrayList<>();
    Weather weather = new NormalWeather(new Bord());
}
