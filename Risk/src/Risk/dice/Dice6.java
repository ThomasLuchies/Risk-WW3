package Risk.dice;

public class Dice6 implements Dice {
    @Override
    public int roll() {
        return (int)(Math.random()*5) + 1;
    }
}