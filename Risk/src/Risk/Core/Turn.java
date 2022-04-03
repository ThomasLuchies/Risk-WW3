package Risk.Core;

import Risk.Core.States.Weather;
import Risk.Core.Troops.Troop;

import java.util.ArrayList;

public class Turn
{
    private int attackValue;
    private int defendValue;
    private ArrayList<Troop> attackingTroops;
    private ArrayList<Troop> defendingTroops;
    private Field attackingField;
    private Field defenderField;
    private Country attackingCountry;
    private Country defendingCountry;
    private BordInterface bord;

    private Weather currentWeather;

    public Turn(BordInterface bord, Weather currentWeather)
    {
        this.bord = bord;
        this.currentWeather = currentWeather;
    }

    public int getAttackValue()
    {
        return attackValue;
    }

    public void setAttackValue(int attackValue)
    {
        this.attackValue = attackValue;
    }

    public int getDefendValue()
    {
        return defendValue;
    }

    public void setDefendValue(int defendValue)
    {
        this.defendValue = defendValue;
    }

    public ArrayList<Troop> getAttackingTroops()
    {
        return attackingTroops;
    }

    public void setAttackingTroops(ArrayList<Troop> attackingTroops)
    {
        this.attackingTroops = attackingTroops;
    }

    public ArrayList<Troop> getDefendingTroops()
    {
        return defendingTroops;
    }

    public void setDefendingTroops(ArrayList<Troop> defendingTroops)
    {
        this.defendingTroops = defendingTroops;
    }

    public Field getAttackingField()
    {
        return attackingField;
    }

    public void setAttackingField(Field attackingField)
    {
        this.attackingField = attackingField;
    }

    public Field getDefenderField()
    {
        return defenderField;
    }

    public void setDefenderField(Field defenderField)
    {
        this.defenderField = defenderField;
    }

    public Country getAttackingCountry()
    {
        return attackingCountry;
    }

    public void setAttackingCountry(Country attackingCountry)
    {
        this.attackingCountry = attackingCountry;
    }

    public Country getDefendingCountry()
    {
        return defendingCountry;
    }

    public void setDefendingCountry(Country defendingCountry)
    {
        this.defendingCountry = defendingCountry;
    }

    public Weather getCurrentWeather()
    {
        return currentWeather;
    }

    public void setCurrentWeather(Weather currentWeather)
    {
        this.currentWeather = currentWeather;
    }

    public void turn()
    {
        int attackerDiceRolls = 0;
        int defenderDiceRolls = 0;

        for(int i = 0; i < this.attackingTroops.size(); i++)
        {
            attackerDiceRolls += this.currentWeather.getCorrectDice(attackingCountry).roll();
        }

        for(int i = 0; i < this.attackingTroops.size(); i++)
        {
            defenderDiceRolls += this.currentWeather.getCorrectDice(defendingCountry).roll();
        }

        if(attackerDiceRolls > defenderDiceRolls)
            this.bord.receiveWinner(defenderField, attackingField);

        this.bord.receiveWinner(attackingField, defenderField);

    }
}
