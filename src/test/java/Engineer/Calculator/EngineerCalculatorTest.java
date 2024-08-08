package Engineer.Calculator;

import Engineer.PolskayaCalculator.PolskayaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineerCalculatorTest {
    @Test
    void test1(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("1 1 +", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals(2, polskayaCalculator.getResult());
    }
    @Test
    void test2(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("2 5 + 3 4 + * 1 -", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals(48, polskayaCalculator.getResult());
    }
    @Test
    void test3(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("2 5 + 3 4 + * 1 +", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals(50, polskayaCalculator.getResult());
    }
    @Test
    void test4(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("25.5 25.5 +", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals(51, polskayaCalculator.getResult());
    }
    @Test
    void test5(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("0", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals(0, polskayaCalculator.getResult());
    }
    @Test
    void crashNotUseZero(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("22 3 +", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals("25", polskayaCalculator.getResultString());
    }
    @Test
    void unaryTest1(){
        PolskayaCalculator polskayaCalculator = new PolskayaCalculator("2 ~ 3 +", PolskayaCalculator.degreeOrRadian.deg);
        polskayaCalculator.calculateExpression();
        Assertions.assertEquals("1", polskayaCalculator.getResultString());
    }

}
