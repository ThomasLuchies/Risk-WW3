import Risk.dice.DiceDisadvantage;
import Risk.dice.DiceNormal;
import Risk.dice.DiceAdvantage;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    DiceDisadvantage DiceTest4 = new DiceDisadvantage();
    DiceNormal DiceTest5 = new DiceNormal();
    DiceAdvantage DiceTest6 = new DiceAdvantage();

    @org.junit.jupiter.api.Test
    void getResult4(){
        int DiceRoll = DiceTest4.roll();
        boolean within = false;
        if (DiceRoll <= 4 && DiceRoll >= 1)
        {
            within = true;
        };
        assertTrue(within);
    }

    @org.junit.jupiter.api.Test
    void getResult5(){
        int DiceRoll = DiceTest5.roll();
        boolean within = false;
        if (DiceRoll <= 5 && DiceRoll >= 1)
        {
            within = true;
        };
        assertTrue(within);
    }

    @org.junit.jupiter.api.Test
    void getResult6(){
        int DiceRoll = DiceTest6.roll();
        boolean within = false;
        if (DiceRoll <= 6 && DiceRoll >= 1)
        {
            within = true;
        };
        assertTrue(within);
    }


    @org.junit.jupiter.api.Test
    void roll() { //assertEquals();
    }
}