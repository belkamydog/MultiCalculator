package Engineer.Calculator;

import Engineer.PolskayaCalculator.PolskayaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IfOperandTest {
    @Test
    void test1(){
        Assertions.assertTrue(PolskayaCalculator.isOperand("21"));
    }
    @Test
    void test2(){
        Assertions.assertFalse(PolskayaCalculator.isOperand("+"));
    }
}
