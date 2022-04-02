package Risk.dice;

public abstract class Dice {
    int min = 1;
    public int roll() {
        int result = (int)(Math.random()*getMax()) + min;
        System.out.println(result);
        return result;
    };
    public abstract int getMax();
}
