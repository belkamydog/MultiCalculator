package Validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationMainTests {
    @Test
    public void simple2Numbers1(){
        Validation validation = new Validation("1+1");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    public void simple2Numbers2(){
        Validation validation = new Validation("-1+1");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void simple2Numbers3(){
        Validation validation = new Validation("(-1+1)");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void simple2Numbers4(){
        Validation validation = new Validation("(-1+1)");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void simple2Numbers5(){
        Validation validation = new Validation("x-1");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void simple2Numbers6(){
        String [] trigonometry = {"sin", "cos", "tan", "asin", "atan", "acos", "log", "ln", "sqrt"};
        for (String i : trigonometry) {
            Validation validation = new Validation(i+"(30)");
            Assertions.assertTrue(validation.isValid());
        }
    }
    @Test
    public void simple2NumbersFirstSymbol(){
        String [] first = {"^", ".", ")", "%", "*", "/", "+"};
        for (String i : first) {
            Validation validation = new Validation(i+"1+1");
            Assertions.assertFalse(validation.isValid());
        }
    }
    @Test
    public void simple2NumbersFirstSymbolExceptValid(){
        char first = (char) 0;
        while (first < (char) 256) {
            if ("0123456789(sctSCTQGxX- ".indexOf(first) == -1) {
                Validation validation = new Validation(first +"+1+1");
                Assertions.assertFalse(validation.isValid());
            }
            first++;
        }
    }
    @Test
    public void simpleFindBug1(){
        Validation validation = new Validation("san(30)");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void simpleFindBug2(){
        Validation validation = new Validation("1-sIn(30)");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void simpleFindBug3(){
        Validation validation = new Validation("1-cis(30)");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void simpleFindBug4(){
        Validation validation = new Validation("lm(30)");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void simpleFindBug5(){
        Validation validation = new Validation("ln(30)");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void simpleFindBug6(){
        Validation validation = new Validation("atun(20)");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void percent1(){
        Validation validation = new Validation("100%");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidPercent2(){
        Validation validation = new Validation("1+%-100%");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidPercent3(){
        Validation validation = new Validation("1%%-1");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidPercent4(){
        Validation validation = new Validation("1-1%1%");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidPercent5(){
        Validation validation = new Validation("(1%-1%-1%)%");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    public void invalidOperators1(){
        Validation validation = new Validation("5--3");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void validOperators1(){
        Validation validation = new Validation("5-3");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidOperators2(){
        Validation validation = new Validation("5(-3");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidOperators3(){
        Validation validation = new Validation("(5-3))");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidOperators4(){
        Validation validation = new Validation("(5-3)");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidOperators5(){
        Validation validation = new Validation("sin30*20");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidOperators6(){
        Validation validation = new Validation("5mod3");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidOperators7(){
        Validation validation = new Validation("mod3");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidOperators8(){
        Validation validation = new Validation("1mid3");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidOperators9(){
        Validation validation = new Validation("1mod1mod3");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidOperators10(){
        Validation validation = new Validation("5*x");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void invalidOnlyButtons1(){
        Validation validation = new Validation("()");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidOnlyButtons2(){
        Validation validation = new Validation("(())(())");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidOnlyButtonsSin(){
        Validation validation = new Validation("sin()");
        Assertions.assertFalse(validation.isValid());
    }
}
