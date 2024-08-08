package Engineer.Validation;

import Engineer.ValidationAndPreparing.ValidationAndPreparing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тесты валидации инфиксного выражения проверка первого символа
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */
public class FirstSymbolValidationAndPreparingTests {
    @Test
    void validExpressionFirstCharacterDigitTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5+5");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterUnaryMinusTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("-5+5");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterLeftBracketTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(5+5)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterSinTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("sin(30)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterCosTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("cos(30)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterTanTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("tan(30)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterAsinTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("asin(1)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterLogTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("log(1)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    void validExpressionFirstCharacterXTest() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("x-1");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    /**
     * Invalid first character tests in expression
     **/
    @Test
    void invalidExpressionFirstCharacterTestMultiply() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("*5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestDivision() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("/5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestSum() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("+5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestDot() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(".5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRightBracket() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(")5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRandomSymbol1() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("^5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRandomSymbol2() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("J5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    void invalidExpressionFirstCharacterTestRandomSymbol3() {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("@5+5");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
}
