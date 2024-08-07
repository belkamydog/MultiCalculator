package Validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstSymbolValidationTests {
    /**
     * Valid first character tests in expression
     **/

    @Test
    void validExpressionFirstCharacterDigitTest() {
        Validation validation = new Validation("5+5");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterUnaryMinusTest() {
        Validation validation = new Validation("-5+5");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterLeftBracketTest() {
        Validation validation = new Validation("(5+5)");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterSinTest() {
        Validation validation = new Validation("sin(30)");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterCosTest() {
        Validation validation = new Validation("cos(30)");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterTanTest() {
        Validation validation = new Validation("tan(30)");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterAsinTest() {
        Validation validation = new Validation("asin(1)");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterLogTest() {
        Validation validation = new Validation("log(1)");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    void validExpressionFirstCharacterXTest() {
        Validation validation = new Validation("x-1");
        Assertions.assertTrue(validation.isValid());
    }

    /**
     * Invalid first character tests in expression
     **/
    @Test
    void invalidExpressionFirstCharacterTestMultiply() {
        Validation validation = new Validation("*5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestDivision() {
        Validation validation = new Validation("/5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestSum() {
        Validation validation = new Validation("+5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestDot() {
        Validation validation = new Validation(".5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRightBracket() {
        Validation validation = new Validation(")5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRandomSymbol1() {
        Validation validation = new Validation("^5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRandomSymbol2() {
        Validation validation = new Validation("J5+5");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRandomSymbol3() {
        Validation validation = new Validation("@5+5");
        Assertions.assertFalse(validation.isValid());
    }
}
