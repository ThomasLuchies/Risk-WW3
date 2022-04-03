package Risk.Core.dice;

public abstract class Dice {
    /**
     * gets result van math.rand which create a random value between 1 and getmax()
     * @return result of dice
     */
    public int roll() {
        //int result = (int)(Math.random()*getMax()) + 1;
        //System.out.println(result);
        return (int)(Math.random()*getMax()) + 1;
    };

    /**
     * get value declared of the implemented function in extended class
     * @return max value declared in extended class (4/5/6)
     */
    public abstract int getMax();
}
