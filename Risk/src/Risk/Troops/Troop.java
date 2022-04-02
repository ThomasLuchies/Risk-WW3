package Risk.Troops;

public abstract class Troop
{
    private int value;

    public Troop(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }
}
