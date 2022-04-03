package Risk.Core;

import Risk.Core.States.NormalWeather;
import Risk.Core.States.Weather;

import java.util.ArrayList;

public interface BordInterface
{
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Field> fields = new ArrayList<>();
    Weather weather = new NormalWeather(new Bord(), null);

    void receiveAttack(int value, Player player, Field field);
    void receiveDefend(int value, Player player, Field field);

    void receiveWinner(Field lostField, Field fieldWon);

    void changeState(Weather weather);
}
