package Engineer.Validation;

import Engineer.ValidationAndPreparing.ValidationAndPreparing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тесты валидации инфиксного выражения общие тесты
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class ValidationAndPreparingMainTests {
    @Test
    public void simple2Numbers1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1+1");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    public void simple2Numbers2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("-1+1");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void simple2Numbers3(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(-1+1)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void simple2Numbers4(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(-1+1)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void simple2Numbers5(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("x-1");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void simple2Numbers6(){
        String [] trigonometry = {"sin", "cos", "tan", "asin", "atan", "acos", "log", "ln", "sqrt"};
        for (String i : trigonometry) {
            ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(i+"(30)");
            Assertions.assertTrue(validationAndPreparing.isValid());
        }
    }
    @Test
    public void simple2NumbersFirstSymbol(){
        String [] first = {"^", ".", ")", "%", "*", "/", "+"};
        for (String i : first) {
            ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(i+"1+1");
            Assertions.assertFalse(validationAndPreparing.isValid());
        }
    }
    @Test
    public void simple2NumbersFirstSymbolExceptValid(){
        char first = (char) 0;
        while (first < (char) 256) {
            if ("0123456789(sctSCTQGxX- ".indexOf(first) == -1) {
                ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(first +"+1+1");
                Assertions.assertFalse(validationAndPreparing.isValid());
            }
            first++;
        }
    }
    @Test
    public void simpleFindBug1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("san(30)");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void simpleFindBug2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1-sIn(30)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void simpleFindBug3(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1-cis(30)");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void simpleFindBug4(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("lm(30)");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void simpleFindBug5(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("ln(30)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void simpleFindBug6(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("atun(20)");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void percent1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("100%");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidPercent2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1+%-100%");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidPercent3(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1%%-1");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidPercent4(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1-1%1%");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidPercent5(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(1%-1%-1%)%");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    public void invalidOperators1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5--3");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void validOperators1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5-3");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5(-3");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators3(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(5-3))");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators4(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(5-3)");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators5(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("sin30*20");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators6(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5mod3");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators7(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("mod3");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators8(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1mid3");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators9(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("1mod1mod3");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOperators10(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5*x");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOnlyButtons1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("()");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOnlyButtons2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("(())(())");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidOnlyButtonsSin(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("sin()");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
}
