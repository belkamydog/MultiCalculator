package Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcAppTest {
    @Test
    void test1(){
        Calculator calculator = new Calculator("1 1 +", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals(2, calculator.getResult());
    }
    @Test
    void test2(){
        Calculator calculator = new Calculator("2 5 + 3 4 + * 1 -", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals(48, calculator.getResult());
    }
    @Test
    void test3(){
        Calculator calculator = new Calculator("2 5 + 3 4 + * 1 +", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals(50, calculator.getResult());
    }
    @Test
    void test4(){
        Calculator calculator = new Calculator("25.5 25.5 +", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals(51, calculator.getResult());
    }
    @Test
    void test5(){
        Calculator calculator = new Calculator("0", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals(0, calculator.getResult());
    }
    @Test
    void crashNotUseZero(){
        Calculator calculator = new Calculator("22 3 +", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals("25", calculator.getResultString());
    }
    @Test
    void unaryTest1(){
        Calculator calculator = new Calculator("2 ~ 3 +", "deg");
        calculator.calculateExpression();
        Assertions.assertEquals("1", calculator.getResultString());
    }

}
