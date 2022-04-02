package Risk;

import Risk.States.ColdWeather;
import Risk.States.NormalWeather;
import Risk.States.WarmWeather;
import Risk.States.Weather;
import Risk.Troops.Troop;

import java.util.ArrayList;
import java.util.Random;

public class Bord implements BordInterface
{
    ArrayList<Player> players;
    ArrayList<Field> fields;
    Weather weather;

    public void changeState()
    {
        this.players = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.weather = randWeather();
    }

    public Weather randWeather()
    {
        Random rand = new Random();
        int randInt = (rand.nextInt(3) + 1);
        return randInt == 1 ? new NormalWeather(this, null) : randInt == 2 ? new ColdWeather(this, null) : new WarmWeather(this, null);
    }

    @Override
    public void turn(boolean attack)
    {

    }

    public void nextState()
    {
        this.weather.nextState();
    }

    public void previousState()
    {
        this.weather.previousState();
    }

    public void changeState(Weather weather)
    {
        this.weather = weather;
    }

    public boolean placeTroop(ArrayList<Troop> troops, Field field, Player player)
    {
        int troopsValue = 0;
        for(Troop troop : troops)
        {
            troopsValue += troop.getValue();
        }

        if(field.getSoldiersAllowed() + (int)Math.floor(player.getKingdom().size() / 3) <= troopsValue)
        {
            for(Troop troop : troops)
            {
                field.placeTroop(troop);
            }

            return true;
        }

        return false;
    }
}
