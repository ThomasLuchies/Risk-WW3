import Risk.dice.Dice5;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    Dice5 DiceTest = new Dice5();
    @org.junit.jupiter.api.Test
    void getResult5(){
        int DiceRoll = DiceTest.roll();
        boolean within = false;
        if (DiceRoll <= 5 && DiceRoll >= 1)
        {
            within = true;
        };
        assertTrue(within);
    }

    @org.junit.jupiter.api.Test
    void roll() { //assertEquals();
    }
}