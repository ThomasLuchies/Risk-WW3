package Risk.Core;

import Risk.Core.States.Weather;

public class Turn
{
    private int attackValue;
    private int defendValue;
    private Player attacker;
    private Player defender;
    private Field attackingField;
    private Field defenderField;
    private Weather currentWeather;

    public Turn(Weather currentWeather)
    {
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

    public Player getAttacker()
    {
        return attacker;
    }

    public void setAttacker(Player attacker)
    {
        this.attacker = attacker;
    }

    public Player getDefender()
    {
        return defender;
    }

    public void setDefender(Player defender)
    {
        this.defender = defender;
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

    public void turn()
    {

    }
}
