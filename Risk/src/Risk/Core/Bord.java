package Risk.Core;

import Risk.Core.States.ColdWeather;
import Risk.Core.States.NormalWeather;
import Risk.Core.States.WarmWeather;
import Risk.Core.States.Weather;
import Risk.Core.TroopFactory.TroopCreator;
import Risk.Core.Troops.Artillery;
import Risk.Core.Troops.Cavalry;
import Risk.Core.Troops.Infantry;
import Risk.Core.Troops.Troop;

import java.util.ArrayList;
import java.util.Random;

public class Bord implements BordInterface
{
    private ArrayList<Player> players;
    private ArrayList<Field> fields;
    private Weather weather;
    private Turn turn;
    private TroopCreator troopCreator;
    private final int AMOUNT_OF_FIELDS_X = 7;
    private final int AMOUNT_OF_FIELDS_Y = 5;

    public void changeState()
    {
        this.players = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.weather = randWeather();
        this.troopCreator = new TroopCreator();
    }

    public Weather randWeather()
    {
        Random rand = new Random();
        int randInt = (rand.nextInt(3) + 1);
        return randInt == 1 ? new NormalWeather(this, null) : randInt == 2 ? new ColdWeather(this, null) : new WarmWeather(this, null);
    }

    public void addPlayer(Player player)
    {
        this.players.add(player);
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
        this.turn = new Turn(this, this.weather);
        this.turn.setAttackValue(value);
        this.turn.setAttackingTroops(field.getTroops());
        this.turn.setAttackingField(field);
        this.turn.setAttackingCountry(player.getCountry());
    }

    @Override
    public void receiveDefend(int value, Player player, Field field)
    {
        this.turn.setDefendValue(value);
        this.turn.setDefendingTroops(field.getTroops());
        this.turn.setDefenderField(field);
        this.turn.setDefendingCountry(player.getCountry());

        this.turn.turn();
    }

    @Override
    public void receiveWinner(Field fieldLost, Field fieldWon)
    {
        boolean troopRemoved = false;
        Player playerLost = fieldLost.getOwner();

        if(playerLost == null)
            troopRemoved = true;

        removeOneTroopFromField(fieldLost, playerLost);


        playerLost.removeTroop();

        Player playerWon = fieldWon.getOwner();

        if(fieldLost.getTroops().size() == 0)
        {
            fieldLost.setOwner(playerWon);
            fieldLost.placeTroop(this.troopCreator.createInfantry(playerWon));
            removeOneTroopFromField(fieldWon, playerWon);
        }
    }

    private void removeOneTroopFromField(Field field, Player player)
    {
        int infantryToAdd = 0;

        for(Troop troop : field.getTroops())
        {
            if(troop instanceof Infantry)
            {
                field.removeTroop(troop);
            }
            else if(troop instanceof Cavalry)
            {
                field.removeTroop(troop);
                infantryToAdd = 4;
            }
            else if(troop instanceof Artillery)
            {
                field.removeTroop(troop);
                field.placeTroop(this.troopCreator.createCavalry(player));
                infantryToAdd = 4;
            }
        }

        for(int i = 0; i < infantryToAdd; i++)
        {
            field.placeTroop(this.troopCreator.createInfantry(player));
        }
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
