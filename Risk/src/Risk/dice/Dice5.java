package Risk.dice;

public class Dice5 implements Dice {
    @Override
    public int roll() {
        int result = (int)(Math.random()*4) + 1;
        System.out.println(result);
        return result;
    }
}