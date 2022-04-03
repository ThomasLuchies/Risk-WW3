package Risk.Core;

import Risk.Core.States.ColdWeather;
import Risk.Core.States.NormalWeather;
import Risk.Core.States.WarmWeather;
import Risk.Core.States.Weather;
import Risk.Core.Troops.Troop;

import java.util.ArrayList;
import java.util.Random;

public class Bord implements BordInterface
{
    private ArrayList<Player> players;
    private ArrayList<Field> fields;
    private Weather weather;
    private Turn turn;
    private final int AMOUNT_OF_FIELDS_X = 7;
    private final int AMOUNT_OF_FIELDS_Y = 5;

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

    public void addPlayer()
    {

    }

    public void createFields()
    {
        for(int x = 0; x < AMOUNT_OF_FIELDS_Y; x++)
        {
            for(int y = 0; y < AMOUNT_OF_FIELDS_X; y++)
            {
                fields.add(new Field(null, new Coords(x, y)));
            }
        }
    }

    public void divideFields()
    {
        int fieldsPerPlayer = (((AMOUNT_OF_FIELDS_X * AMOUNT_OF_FIELDS_Y) / 2) / this.players.size()); // Calculates the fields every players gets at the start of the game
        Field curField = null;

        // Give fields to all players
        for(int i = 0; i < this.players.size(); i++)
        {
            int counter = 0;
            // Keep adding fields until the players has enough fields.
            while(counter >= fieldsPerPlayer)
            {
                // get a random field
                curField = this.fields.get(new Random().nextInt(this.fields.size()));

                // If the field does not have an owner set it the owner to the current player.
                if(curField.getOwner() == null)
                {
                    curField.setOwner(this.players.get(i));
                    counter++;
                }
            }
        }
    }

    @Override
    public void receiveAttack(int value, Player player, Field field)
    {
        this.turn = new Turn(this.weather);
        this.turn.setAttackValue(value);
        this.turn.setAttacker(player);
        this.turn.setAttackingField(field);
    }

    @Override
    public void receiveDefend(int value, Player player, Field field)
    {
        this.turn.setDefendValue(value);
        this.turn.setDefender(player);
        this.turn.setDefenderField(field);
        this.turn.turn();
    }

    public Player checkForWin()
    {
        for(Player player : this.players)
        {
            if(player.getKingdom().size() == (AMOUNT_OF_FIELDS_Y * AMOUNT_OF_FIELDS_X))
            {
                return player;
            }
        }

        return null;
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
