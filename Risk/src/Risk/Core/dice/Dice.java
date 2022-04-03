package Risk.Core.dice;

public abstract class Dice {
    public int roll() {
        int result = (int)(Math.random()*getMax()) + 1;
        System.out.println(result);
        return result;
    };
    public abstract int getMax();
}
