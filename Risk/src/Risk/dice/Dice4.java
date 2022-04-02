package Risk.dice;

public class Dice4 implements Dice {
    @Override
    public int roll() {
        return (int)(Math.random()*3) + 1;
    }
}
